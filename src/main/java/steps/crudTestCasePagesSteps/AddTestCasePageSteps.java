package steps.crudTestCasePagesSteps;

import core.BrowserService;
import pages.crudTestCasePages.AddTestCasePage;
import steps.commonSteps.CommonHeaderSteps;

public class AddTestCasePageSteps extends CommonHeaderSteps<AddTestCasePage> {

    public AddTestCasePageSteps(BrowserService browserService) {
        super(browserService, AddTestCasePage.class);
    }

    @Override
    public AddTestCasePageSteps openPage() {
        this.page.open();
        return this;
    }

    public AddTestCasePageSteps selectTemplateByOptionValue(String optionTextValue){
        this.page.getSelectByName("Template").selectOptionByTextValue(optionTextValue);
        return this;
    }
}
