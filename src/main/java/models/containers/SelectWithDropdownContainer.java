package models.containers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import wrappers.Element;

import java.util.List;

@Getter
@AllArgsConstructor
public class SelectWithDropdownContainer {
    private final Element label;
    private final Element select;
    private final Element search;
    private final List<Element> values;
}
