package models;

import wrappers.UIElement;

import java.util.List;

public class SelectWithDropdownContainer {
    private final UIElement label;
    private final UIElement select;
    private final UIElement search;
    private final List<UIElement> values;

    public SelectWithDropdownContainer(UIElement label, UIElement select, UIElement search, List<UIElement> values) {
        this.label = label;
        this.select = select;
        this.search = search;
        this.values = values;
    }

    public UIElement getLabel() {
        return label;
    }

    public UIElement getSelect() {
        return select;
    }

    public UIElement getSearch() {
        return search;
    }

    public List<UIElement> getValues() {
        return values;
    }
}
