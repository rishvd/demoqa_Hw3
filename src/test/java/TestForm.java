
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestForm {

    static File file;

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = ("https://demoqa.com");
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        file = new File("src/test/resources/img.png");

    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Rishad");
        $("#lastName").setValue("Geyushov");
        $("#userEmail").setValue("rishad@kk.com");
        $("#userNumber").setValue("9261937876");
        $("[for='gender-radio-1']").click();
        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").clear();
        $(".react-datepicker__year-select").selectOption("1999"); // Выбрать год
        $(".react-datepicker__month-select").selectOption("August"); // Выбрать месяц
        $(".react-datepicker__day--021").click();
        $(".subjects-auto-complete__value-container input").setValue("Math").pressEnter();
        $(".subjects-auto-complete__value-container input").setValue("physics").pressEnter();
        $("[for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue("MeatGrinder street 13");
        $("#state").click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Delhi")).click();
        $("#submit").click();








        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Rishad Geyushov"));
        $(".table-responsive").shouldHave(text("rishad@kk.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("9261937876"));
        $(".table-responsive").shouldHave(text("21 August,1999"));
        $(".table-responsive").shouldHave(text("Maths, Physics"));
        $(".table-responsive").shouldHave(text("Reading"));
        $(".table-responsive").shouldHave(text("img.png"));
        $(".table-responsive").shouldHave(text("MeatGrinder street 13"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").click();




    }
}