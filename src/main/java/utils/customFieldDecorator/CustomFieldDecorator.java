package utils.customFieldDecorator;

import java.lang.reflect.*;
import java.util.List;

import core.BrowserService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import wrappers.IElement;
import wrappers.WrapperFactory;

public class CustomFieldDecorator extends DefaultFieldDecorator {
    private final BrowserService browserService;

    public CustomFieldDecorator(BrowserService browserService) {
        super(new DefaultElementLocatorFactory(browserService.getDriver()));
        this.browserService = browserService;
    }

    /**
     * Метод вызывается фабрикой для каждого поля в классе
     */
    @Override
    public Object decorate(ClassLoader loader, Field field) {
        Class<IElement> decoratableClass = decoratableClass(field);
        // если класс поля декорируемый
        if (decoratableClass != null) {
            ElementLocator locator = factory.createLocator(field);
            if (locator == null) {
                return null;
            }

            if (List.class.isAssignableFrom(field.getType())) {
                return createList(loader, locator, decoratableClass);
            }
            // элемент
            return createElement(loader, locator, decoratableClass);
        }
        return null;
    }

    /**
     * Возвращает декорируемый класс поля, либо null если класс не подходит для декоратора
     */
    @SuppressWarnings("unchecked")
    private Class<IElement> decoratableClass(Field field) {

        Class<?> clazz = field.getType();

        if (List.class.isAssignableFrom(clazz)) {

            // для списка обязательно должна быть задана аннотация
            if (field.getAnnotation(FindBy.class) == null &&
                    field.getAnnotation(FindBys.class) == null &&
                    field.getAnnotation(FindAll.class) == null) {
                return null;
            }

            // Список должен быть параметризирован
            Type genericType = field.getGenericType();
            if (!(genericType instanceof ParameterizedType)) {
                return null;
            }
            // получаем класс для элементов списка
            clazz = (Class<?>) ((ParameterizedType) genericType).
                    getActualTypeArguments()[0];
        }

        if (IElement.class.isAssignableFrom(clazz)) {
            return (Class<IElement>) clazz;
        }
        else {
            return null;
        }
    }

    /**
     * Создание элемента. Находит WebElement и передает его в кастомный класс
     */
    protected IElement createElement(ClassLoader loader,
                                     ElementLocator locator,
                                     Class<IElement> clazz) {
        WebElement proxy = proxyForLocator(loader, locator);
        return WrapperFactory.createInstance(clazz, this.browserService, proxy);
    }

    @SuppressWarnings("unchecked")
    protected List<IElement> createList(ClassLoader loader,
                                        ElementLocator locator,
                                        Class<IElement> clazz) {

        InvocationHandler handler =
                new LocatingCustomElementListHandler(locator, this.browserService, clazz);

        return (List<IElement>) Proxy.newProxyInstance(
                loader, new Class[] {List.class}, handler);
    }
}