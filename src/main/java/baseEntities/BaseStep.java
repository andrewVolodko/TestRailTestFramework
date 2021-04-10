package baseEntities;

import core.BrowserService;

public abstract class BaseStep {
    protected BrowserService browserService;

    public BaseStep(BrowserService browserService) {
        this.browserService = browserService;
    }

    public abstract BasePage getPageInstance(boolean openByUrl);
}
