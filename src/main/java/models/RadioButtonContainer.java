package models;

import wrappers.UIElement;

public class RadioButtonContainer {
    private final UIElement label;
    private final UIElement input;
    private final UIElement description;

    public RadioButtonContainer(UIElement label, UIElement input, UIElement description) {
        this.label = label;
        this.input = input;
        this.description = description;
    }

    public UIElement getLabel() {
        return label;
    }

    public UIElement getInput() {
        return input;
    }

    public UIElement getDescription() {
        return description;
    }
}
