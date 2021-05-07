package models;

import wrappers.Element;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RadioButtonContainer {
    private final Element label;
    private final Element input;
    private final Element description;
}
