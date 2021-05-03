package models;

import wrappers.Element;

public class AdminPageProjectRowContainer {
    private final Element projectNameLink;
    private final Element projectEditBtn;
    private final Element projectDeleteBtn;

    public AdminPageProjectRowContainer(Element projectNameLink, Element projectEditBtn, Element projectDeleteBtn) {
        this.projectNameLink = projectNameLink;
        this.projectEditBtn = projectEditBtn;
        this.projectDeleteBtn = projectDeleteBtn;
    }

    public Element getProjectNameLink() {
        return this.projectNameLink;
    }

    public Element getProjectEditBtn() {
        return this.projectEditBtn;
    }

    public Element getProjectDeleteBtn() {
        return this.projectDeleteBtn;
    }
}
