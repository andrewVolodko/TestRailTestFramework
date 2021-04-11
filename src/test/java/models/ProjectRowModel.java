package models;

import org.openqa.selenium.WebElement;

public class ProjectRowModel {
    private final WebElement projectNameLink;
    private final WebElement projectEditBtn;
    private final WebElement projectDeleteBtn;

    public ProjectRowModel(WebElement projectNameLink, WebElement projectEditBtn, WebElement projectDeleteBtn) {
        this.projectNameLink = projectNameLink;
        this.projectEditBtn = projectEditBtn;
        this.projectDeleteBtn = projectDeleteBtn;
    }

    public WebElement getProjectNameLink() {
        return projectNameLink;
    }

    public WebElement getProjectEditBtn() {
        return projectEditBtn;
    }

    public WebElement getProjectDeleteBtn() {
        return projectDeleteBtn;
    }
}
