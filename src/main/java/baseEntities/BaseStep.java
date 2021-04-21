package baseEntities;

import core.BrowserService;

import java.lang.reflect.InvocationTargetException;

public abstract class BaseStep<T extends BasePage> {
    protected BrowserService browserService;
    protected T page;
    private final Class<T> pageClass;

    public BaseStep(BrowserService browserService, Class<T> pageClass) {
        this.browserService = browserService;
        this.pageClass = pageClass;
        this.page = getPageInstance();
    }

    public abstract BaseStep<T> openPage();

    public T getPageInstance() {
        if (pageClass == null) throw new NoClassDefFoundError("Page class was not defined.");
        T page = null;
        try {
            page = pageClass.getConstructor(BrowserService.class).newInstance(browserService);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return page;
    }
}
