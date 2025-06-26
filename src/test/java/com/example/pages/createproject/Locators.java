package com.example.pages.createproject;

import org.openqa.selenium.By;

public class Locators {
    // Form 1 Locators
    public static final By CREATE_NEW_PROJECT_BUTTON = By.id("createNewProjectBtn");
    public static final By PROJECT_NAME_INPUT = By.id("projectNameInput");
    public static final By DESCRIPTION_TEXTAREA = By.id("projectDescriptionTextarea");
    public static final By PROJECT_KEYWORDS_INPUT = By.id("projectKeywordsInput");
    public static final By EVENTS_DROPDOWN = By.id("eventsDropdown");
    public static final By PROJECT_END_DATE_INPUT = By.id("projectEndDateInput");
    public static final By PROJECT_COVER_UPLOAD = By.id("projectCoverUpload");
    public static final By NEXT_BUTTON = By.id("nextButton");

    // Form 2 Locators
    public static final By BACK_BUTTON = By.id("backButton");
    public static final By CREATE_PROJECT_BUTTON = By.id("createProjectButton");

    // Error message locators
    public static final By ERROR_MESSAGE = By.className("error-message");
}