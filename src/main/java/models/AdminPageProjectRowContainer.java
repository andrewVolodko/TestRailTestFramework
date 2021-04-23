package models;

import wrappers.UIElement;

public class AdminPageProjectRowContainer {
    private final UIElement projectNameLink;
    private final UIElement projectEditBtn;
    private final UIElement projectDeleteBtn;

    public AdminPageProjectRowContainer(UIElement projectNameLink, UIElement projectEditBtn, UIElement projectDeleteBtn) {
        this.projectNameLink = projectNameLink;
        this.projectEditBtn = projectEditBtn;
        this.projectDeleteBtn = projectDeleteBtn;
    }

    public UIElement getProjectNameLink() {
        return this.projectNameLink;
    }

    public UIElement getProjectEditBtn() {
        return this.projectEditBtn;
    }

    public UIElement getProjectDeleteBtn() {
        return this.projectDeleteBtn;
    }
}
