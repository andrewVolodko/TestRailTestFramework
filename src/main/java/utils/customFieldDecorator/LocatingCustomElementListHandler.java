package utils.customFieldDecorator;

import core.BrowserService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import wrappers.IElement;
import wrappers.WrapperFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

public class LocatingCustomElementListHandler implements InvocationHandler {

    private final ElementLocator locator;
    private final BrowserService browserService;
    private final Class<IElement> clazz;

    public LocatingCustomElementListHandler(ElementLocator locator, BrowserService browserService,  Class<IElement> clazz) {
        this.locator = locator;
        this.browserService = browserService;
        this.clazz = clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {
        // Находит список WebElement и обрабатывает каждый его элемент,
        // возвращает новый список с элементами кастомного класса
        List<WebElement> elements = locator.findElements();
        List<IElement> customs = elements.stream()
                .map(element -> WrapperFactory.createInstance(clazz, this.browserService, element))
                .collect(Collectors.toList());

        try {
            return method.invoke(customs, objects);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }
}
