package steps.crudTestCasePagesSteps;

import core.BrowserService;
import io.qameta.allure.Step;
import pages.crudTestCasePages.AddTestCasePage;
import steps.commonSteps.CommonHeaderSteps;

public class AddTestCasePageSteps extends CommonHeaderSteps<AddTestCasePage> {

    public AddTestCasePageSteps(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    public AddTestCasePageSteps openPage() {
        this.page.open();
        return this;
    }

    @Step("Select Test Case Template By Value: '{optionTextValue}'")
    public AddTestCasePageSteps selectTemplateByOptionValue(String optionTextValue){
        this.page.getSelectByName("Template").selectOptionByTextValue(optionTextValue);
        return this;
    }
}
