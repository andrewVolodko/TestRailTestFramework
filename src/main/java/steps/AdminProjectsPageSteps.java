package steps;

import core.BrowserService;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import pages.AdminProjectsPage;
import pages.dialogs.ConfirmationDeleteDialog;
import steps.commonSteps.CommonHeaderSteps;
import steps.crudProjectPagesSteps.EditProjectPageSteps;

public class AdminProjectsPageSteps extends CommonHeaderSteps<AdminProjectsPage> {

    public AdminProjectsPageSteps(BrowserService browserService) {
        super(browserService);
    }

    @Override
    public AdminProjectsPageSteps openPage() {
        this.page.open();
        return this;
    }

    @Step("Open Edit Project Page By Project Name")
    public EditProjectPageSteps openEditProjectPageByName(String projectName) {
        this.page.getProjectRowByName(projectName).getProjectEditBtn().click();
        return new EditProjectPageSteps(this.browserService);
    }

    @Step("Delete Project By Name")
    public AdminProjectsPageSteps deleteProjectByName(String projectName) {
        this.page.getProjectRowByName(projectName).getProjectDeleteBtn().click();
        ConfirmationDeleteDialog confirmationDeleteDialog = new ConfirmationDeleteDialog(browserService);
        confirmationDeleteDialog.getDeleteCheckbox().changeState(true);
        confirmationDeleteDialog.getOkBtn().click();
        return this;
    }

    @Step("Verify Project Existence")
    public boolean isProjectExisted(String projectName) {
        try {
            this.page.getProjectRowByName(projectName);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }
}