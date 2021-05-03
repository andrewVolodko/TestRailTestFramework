package wrappers;

import core.BrowserService;
import models.RadioButtonContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;
import java.util.stream.Collectors;

public class RadioButtonInterface {
    private final List<RadioButtonContainer> radioBtnContainers;

    public RadioButtonInterface(BrowserService browserService, By radioBtnInputLocator) {
        this.radioBtnContainers = getRadioBtnContainersList(Element.findUIElements(browserService, radioBtnInputLocator));
    }

    public RadioButtonInterface(Element radioBtnsContainer, By radioBtnInputBy) {
        this.radioBtnContainers = getRadioBtnContainersList(radioBtnsContainer.findUIElements(radioBtnInputBy));
    }

    private List<RadioButtonContainer> getRadioBtnContainersList(List<Element> radioBtnContainerEls) {
        return radioBtnContainerEls.stream()
                .map(Element::getParent)
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

    public void click(String value) {
        this.radioBtnContainers.stream()
                .filter(el -> el.getInput().getAttribute("value").equals(value))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("No radio button found with provided value"))
                .getInput()
                .click();
    }
}
