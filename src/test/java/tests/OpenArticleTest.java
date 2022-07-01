package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class OpenArticleTest extends TestBase {

    @Test
    @DisplayName("Open Article")
    public void searchArticle() {
        back();
        step("Type search", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("HTTP");
            $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).click();
        });
        step("Verify content found", () ->
                $(AppiumBy.className("android.widget.TextView")).shouldHave(Condition.text("HyperText Transfer Protocol ")));
    }
}
