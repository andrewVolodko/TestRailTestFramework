package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import wrappers.UIElement;

@Getter
@AllArgsConstructor
public class RadioButtonContainer {
    private final UIElement label;
    private final UIElement input;
    private final UIElement description;
}
