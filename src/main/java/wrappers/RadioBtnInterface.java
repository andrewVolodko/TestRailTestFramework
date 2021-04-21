package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class RadioBtnInterface {
    private final List<UIElement> radioBtnContainers;

    public RadioBtnInterface(WebDriver driver, By radioBtnInputLocator) {
        this.radioBtnContainers = driver.findElements(radioBtnInputLocator)
                .stream()
                .map(el -> new UIElement(driver, el).getParent())
                .collect(Collectors.toList());
    }

    public RadioBtnInterface(UIElement radioBtnsContainer, By radioBtnInputLocator){
        this.radioBtnContainers = radioBtnsContainer.findUIElements(radioBtnInputLocator);
    }
//    public List<String> getTextValues() {
//
//    }

    public void click(int value){
        this.radioBtnContainers.stream()
                .filter(el -> Integer.parseInt(el.findElement(By.tagName("input")).getAttribute("value")) == value)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("No radio button found with provided value"))
        .click();
    }
}
