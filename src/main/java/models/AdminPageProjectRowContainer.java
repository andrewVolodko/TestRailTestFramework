package models;

import wrappers.Element;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdminPageProjectRowContainer {
    private final Element projectNameLink;
    private final Element projectEditBtn;
    private final Element projectDeleteBtn;
}
