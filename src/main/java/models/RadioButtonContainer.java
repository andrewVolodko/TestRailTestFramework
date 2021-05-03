package models;

import wrappers.Element;

public class RadioButtonContainer {
    private final Element label;
    private final Element input;
    private final Element description;

    public RadioButtonContainer(Element label, Element input, Element description) {
        this.label = label;
        this.input = input;
        this.description = description;
    }

    public Element getLabel() {
        return label;
    }

    public Element getInput() {
        return input;
    }

    public Element getDescription() {
        return description;
    }
}
