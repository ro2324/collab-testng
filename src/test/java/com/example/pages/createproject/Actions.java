package com.example.pages.createproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Actions {
    private WebDriver driver;
    private WebDriverWait wait;

    public Actions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickCreateNewProject() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.CREATE_NEW_PROJECT_BUTTON)).click();
    }

    public void fillForm1(String projectName, String description, String keywords, String event, String endDate) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.PROJECT_NAME_INPUT)).sendKeys(projectName);
        driver.findElement(Locators.DESCRIPTION_TEXTAREA).sendKeys(description);
        driver.findElement(Locators.PROJECT_KEYWORDS_INPUT).sendKeys(keywords);
        
        Select eventsDropdown = new Select(driver.findElement(Locators.EVENTS_DROPDOWN));
        eventsDropdown.selectByVisibleText(event);
        
        driver.findElement(Locators.PROJECT_END_DATE_INPUT).sendKeys(endDate);
    }

    public void uploadProjectCover(String filePath) {
        driver.findElement(Locators.PROJECT_COVER_UPLOAD).sendKeys(filePath);
    }

    public void navigateToForm2() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.NEXT_BUTTON)).click();
    }

    public void navigateBackToForm1() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BACK_BUTTON)).click();
    }

    public void fillForm2(String additionalInfo) {
        // Implement form 2 fields here
        // For this example, we'll assume there's just one field to fill
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("additionalInfoInput"))).sendKeys(additionalInfo);
    }

    public void createProject() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.CREATE_PROJECT_BUTTON)).click();
    }

    public boolean verifyErrorMessage(String expectedError) {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.ERROR_MESSAGE));
        return errorElement.getText().contains(expectedError);
    }

    public boolean isForm1Visible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.PROJECT_NAME_INPUT)).isDisplayed();
    }

    public boolean isForm2Visible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.CREATE_PROJECT_BUTTON)).isDisplayed();
    }
}