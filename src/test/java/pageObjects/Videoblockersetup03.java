package pageObjects;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class Videoblockersetup03 {
	
	AndroidDriver driver;

    public Videoblockersetup03(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @AndroidFindBy(id = "free.rm.skytube.extra:id/menu_badge_icon")
    WebElement hamburgerIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Video blocker']")
    WebElement videoBlockerOption;

    @AndroidFindBy(xpath = "//android.view.ViewGroup")
    WebElement videoBlockerMessageBox;

    @AndroidFindBy(id = "free.rm.skytube.extra:id/md_buttonDefaultPositive")
    WebElement setButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Video Blocker\"]") // Example setup option
    WebElement videoblockerOption;

    public void clickHamburgerMenu() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(hamburgerIcon))
            .click();
    }

    public boolean isVideoBlockerMessageVisible() {
        try {
            return videoBlockerMessageBox.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickSetOnVideoBlockerMessage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(setButton))
            .click();
    }

    public boolean isSetupOptionVisible() {
        try {
            return videoblockerOption.isDisplayed(); // or any valid setup UI element
        } catch (Exception e) {
            return false;
        }
    }
}
