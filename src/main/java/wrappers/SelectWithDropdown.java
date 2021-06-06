package wrappers;

import core.BrowserService;
import models.containers.SelectWithDropdownContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class SelectWithDropdown {
    private final SelectWithDropdownContainer selectWithDropdownContainer;

    /**
     *
     * @param browserService
     * @param selectWithDropdownContainerBy - locator of container element contains all elements of test case setting select
     *                                      e.g. Template on Add Test Case Page
     */
    public SelectWithDropdown(BrowserService browserService, By selectWithDropdownContainerBy) {
        this.selectWithDropdownContainer =
                getSelectWithDropdownContainer(new Element(browserService, selectWithDropdownContainerBy));
    }

    public SelectWithDropdown(BrowserService browserService, WebElement selectWithDropdownElement) {
        this.selectWithDropdownContainer =
                getSelectWithDropdownContainer(new Element(browserService, selectWithDropdownElement));
    }

    private SelectWithDropdownContainer getSelectWithDropdownContainer(Element selectWithDropdownContainerEl){
        return new SelectWithDropdownContainer(
                selectWithDropdownContainerEl.findElement(By.tagName("label")),
                selectWithDropdownContainerEl.findElement(By.className("chzn-container")),
                selectWithDropdownContainerEl.findElement(By.tagName("input")),
                selectWithDropdownContainerEl.findAllElements(By.tagName("li"))
        );
    }

    public SelectWithDropdown selectOptionByTextValue(String optionTextValue){
        this.selectWithDropdownContainer.getSelect().click();
        this.selectWithDropdownContainer.getValues()
                .stream()
                .filter(el -> el.getText().equals(optionTextValue))
                .reduce((el1, el2) -> {throw new IllegalStateException("More than one option found with provided text value");})
                .orElseThrow(() -> new NoSuchElementException("No option found with provided text value"))
                .click();

        return this;
    }
}
