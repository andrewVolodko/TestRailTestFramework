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
        this.radioBtnContainers = browserService.getDriver().findElements(radioBtnInputLocator)
                .stream()
                .map(el -> new UIElement(browserService, el).getParent())
                .map(this::getRadioButtonContainer)
                .collect(Collectors.toList());
    }

    public RadioButtonInterface(UIElement radioBtnsContainer, By radioBtnInputLocator) {
        this.radioBtnContainers = radioBtnsContainer.findUIElements(radioBtnInputLocator)
                .stream()
                .map(UIElement::getParent)
                .map(this::getRadioButtonContainer)
                .collect(Collectors.toList());
    }

    private RadioButtonContainer getRadioButtonContainer(UIElement radioBtnContainerEl){
        return new RadioButtonContainer(
                radioBtnContainerEl.findElement(By.tagName("strong")),
                radioBtnContainerEl.findElement(By.tagName("input")),
                radioBtnContainerEl.findElement(By.tagName("p")));
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
