package steps;

import core.BrowserService;
import org.openqa.selenium.NoSuchElementException;
import pages.AdminProjectsPage;
import pages.dialogs.ConfirmationDeleteDialog;
import steps.commonSteps.CommonHeaderSteps;
import steps.projectPagesSteps.EditProjectPageSteps;

public class AdminProjectsPageSteps extends CommonHeaderSteps<AdminProjectsPage> {

    public AdminProjectsPageSteps(BrowserService browserService) {
        super(browserService, AdminProjectsPage.class);
    }

    @Override
    public AdminProjectsPageSteps openPage() {
        this.page.open();
        return this;
    }

    public EditProjectPageSteps openEditProjectPageByName(String projectName) {
        this.page.getProjectRowByName(projectName).getProjectEditBtn().click();
        return new EditProjectPageSteps(this.browserService);
    }

    public AdminProjectsPageSteps deleteProjectByName(String projectName) {
        this.page.getProjectRowByName(projectName).getProjectDeleteBtn().click();
        ConfirmationDeleteDialog confirmationDeleteDialog = new ConfirmationDeleteDialog(browserService);
        confirmationDeleteDialog.getDeleteCheckbox().changeState(true);
        confirmationDeleteDialog.getOkBtn().click();
        return this;
    }

    public boolean isProjectExisted(String projectName) {
        try {
            this.page.getProjectRowByName(projectName);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }
}