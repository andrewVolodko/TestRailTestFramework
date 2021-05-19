package wrappers;

import core.BrowserService;
import models.containers.RadioButtonContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;
import java.util.stream.Collectors;

public class RadioButtonInterface {
    private final List<RadioButtonContainer> radioBtnContainers;

    public RadioButtonInterface(BrowserService browserService, By radioBtnInputLocator) {
        this.radioBtnContainers = getRadioBtnContainersList(UIElement.findUIElements(browserService, radioBtnInputLocator));
    }

    public RadioButtonInterface(UIElement radioBtnsContainer, By radioBtnInputBy) {
        this.radioBtnContainers = getRadioBtnContainersList(radioBtnsContainer.findUIElements(radioBtnInputBy));
    }

    private List<RadioButtonContainer> getRadioBtnContainersList(List<UIElement> radioBtnContainerEls) {
        return radioBtnContainerEls.stream()
                .map(UIElement::getParent)
                .map(el -> new RadioButtonContainer(
                        el.findElement(By.tagName("strong")),
                        el.findElement(By.tagName("input")),
                        el.findElement(By.tagName("p"))))
                .collect(Collectors.toList());
    }

    public RadioButtonContainer getSelectedRadioButton() {
        return this.radioBtnContainers
                .stream()
                .filter(el -> {
                    var attributeValue = el.getInput().getAttribute("checked");
                    return attributeValue != null && attributeValue.equals("true");
                })
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("No radio button selected"));
    }

    public void click(int value) {
        this.radioBtnContainers.stream()
                .filter(el -> el.getInput().getAttribute("value").equals(String.valueOf(value)))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("No radio button found with provided value"))
                .getInput()
                .click();
    }
}
