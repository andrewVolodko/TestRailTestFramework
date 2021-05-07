package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import wrappers.UIElement;

@Getter
@AllArgsConstructor
public class AdminPageProjectRowContainer {
    private final UIElement projectNameLink;
    private final UIElement projectEditBtn;
    private final UIElement projectDeleteBtn;
}
