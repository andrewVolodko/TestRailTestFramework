package models.containers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import wrappers.UIElement;

import java.util.List;

@Getter
@AllArgsConstructor
public class SelectWithDropdownContainer {
    private final UIElement label;
    private final UIElement select;
    private final UIElement search;
    private final List<UIElement> values;
}
