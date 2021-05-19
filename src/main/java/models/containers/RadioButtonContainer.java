package models.containers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import wrappers.Element;

@Getter
@AllArgsConstructor
public class RadioButtonContainer {
    private final Element label;
    private final Element input;
    private final Element description;
}
