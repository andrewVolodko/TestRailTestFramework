package wrappers;

import core.BrowserService;
import models.containers.RadioButtonContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RadioButtonInterface {
    private final List<RadioButtonContainer> radioBtnContainers;

    /**
     *
     * @param browserService
     * @param radioButtonsContainerElBy - locator of container with all radio buttons with its text etc. inside
     */
    public RadioButtonInterface(BrowserService browserService, By radioButtonsContainerElBy) {
        this.radioBtnContainers = getRadioBtnContainersList(new Element(browserService, radioButtonsContainerElBy));
    }

    public RadioButtonInterface(BrowserService browserService, WebElement radioButtonsContainerEl) {
        this.radioBtnContainers = getRadioBtnContainersList(new Element(browserService, radioButtonsContainerEl));
    }

    private List<RadioButtonContainer> getRadioBtnContainersList(Element radioButtonsContainerEl) {
        return radioButtonsContainerEl.findAllElements(By.tagName("label"))
                .stream()
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
                .reduce((el1, el2) -> {throw new IllegalStateException("More than one radio button selected");})
                .orElseThrow(() -> new NoSuchElementException("No radio button selected"));
    }

    public void click(int value) {
        this.radioBtnContainers
                .stream()
                .map(RadioButtonContainer::getInput)
                .filter(el -> el.getAttribute("value").equals(String.valueOf(value)))
                .reduce((el1, el2) -> {throw new IllegalStateException("More than one radio button found with provided value");})
                .orElseThrow(() -> new NoSuchElementException("No radio button found with provided value"))
                .click();
    }
}