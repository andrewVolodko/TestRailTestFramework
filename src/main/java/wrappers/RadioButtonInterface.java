package wrappers;

import core.BrowserService;
import models.containers.RadioButtonContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

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
//    public RadioButtonInterface(BrowserService browserService, By radioBtnInputLocator) {
//        this.radioBtnContainers = getRadioBtnContainersList(Element.findAllElements(browserService, radioBtnInputLocator));
//    }
//
//    public RadioButtonInterface(Element radioBtnsContainer, By radioBtnInputBy) {
//        this.radioBtnContainers = getRadioBtnContainersList(radioBtnsContainer.findAllElements(radioBtnInputBy));
//    }
//
//    private List<RadioButtonContainer> getRadioBtnContainersList(List<Element> radioBtnContainerEls) {
//        return radioBtnContainerEls.stream()
//                .map(Element::getParent)
//                .map(el -> new RadioButtonContainer(
//                        el.findElement(By.tagName("strong")),
//                        el.findElement(By.tagName("input")),
//                        el.findElement(By.tagName("p"))))
//                .collect(Collectors.toList());
//    }

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
