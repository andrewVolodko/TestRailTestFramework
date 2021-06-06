package models.containers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import wrappers.Element;

@Getter
@AllArgsConstructor
public class AdminPageProjectRowContainer {
    private final Element projectNameLink;
    private final Element projectEditBtn;
    private final Element projectDeleteBtn;
}
