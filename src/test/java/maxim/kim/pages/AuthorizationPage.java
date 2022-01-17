package maxim.kim.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationPage {
    //locators&elements
    private SelenideElement loginInput = $("#UserLogin_username"),
                            passwordInput = $("#UserLogin_password"),
                            titleURL = $(".ng-binding"),
                            submitBtn = $("[type = submit]");

    //actions
public AuthorizationPage autrorization(String login, String password){
    open("http://test-app.d6.dev.devcaz.com/admin/login");
    titleURL.shouldHave(Condition.text("Casino"));
    loginInput.sendKeys(login);
    passwordInput.sendKeys(password);
    submitBtn.click();
    return this;
}

}
