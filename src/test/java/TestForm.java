
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = ("https://demoqa.com");
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Rishad");
        $("#lastName").setValue("Geyushov");
        $("#userEmail").setValue("rishad@kk.com");
        $("#userNumber").setValue("9261937876");
        $("[for='gender-radio-2']").click();
        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").clear();
        $(".react-datepicker__year-select").selectOption("1999"); // Выбрать год
        $(".react-datepicker__month-select").selectOption("August"); // Выбрать месяц
        $(".react-datepicker__day--021").click();
        $(".subjects-auto-complete__value-container input").setValue("Math").pressEnter();
        $(".subjects-auto-complete__value-container input").setValue("physics").pressEnter();
        $("[for='hobbies-checkbox-2']").click();








//        $("#output #name").shouldHave(text("Alex"));
//        $("#output #email").shouldHave(text("alex@egorov.com"));
//        $("#output #currentAddress").shouldHave(text("Some street 1"));
//        $("#output #permanentAddress").shouldHave(text("Another street 1"));
    }
}