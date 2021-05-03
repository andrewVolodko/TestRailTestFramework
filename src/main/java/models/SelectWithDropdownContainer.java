package models;

import wrappers.Element;

import java.util.List;

public class SelectWithDropdownContainer {
    private final Element label;
    private final Element select;
    private final Element search;
    private final List<Element> values;

    public SelectWithDropdownContainer(Element label, Element select, Element search, List<Element> values) {
        this.label = label;
        this.select = select;
        this.search = search;
        this.values = values;
    }

    public Element getLabel() {
        return label;
    }

    public Element getSelect() {
        return select;
    }

    public Element getSearch() {
        return search;
    }

    public List<Element> getValues() {
        return values;
    }
}
