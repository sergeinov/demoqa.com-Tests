package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.exactOwnText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    @BeforeAll
    static void setup() {
        Configuration.browser = "firefox";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void formTests() {
        String path = "src/test/resources/img/testPicture.jpg";
        File file = new File(path);

        open("/automation-practice-form");

        // check the title name
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        // nameLastName Test
        $("input#firstName").setValue("TestName");
        $("input#lastName").setValue("TestLastName");

        // email Test
        $("input#userEmail").setValue("test@gmail.com");

        // GenderRadioButton Test
        $("#genterWrapper").$(byText("Male")).click();
        $("#genterWrapper").$(byText("Female")).click();
        $("#genterWrapper").$(byText("Other")).click();

        // mobilePhone Test
        $("input#userNumber").setValue("5659874563");

        // dateOfBirth Test
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__month .react-datepicker__week .react-datepicker__day--013").click();

        // subjectsField Test
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("#subjectsInput").setValue("Maths").pressEnter();

        // HobbiesCheckBoxes Test
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        // Scrolling the page
        $("#uploadPicture").scrollIntoView(true);
        //$("#uploadPicture").scrollIntoView(true).uploadFile(file);

        // selectPicture Test
        $("#uploadPicture").scrollIntoView(true).uploadFile(file);
        //$("#uploadPicture").uploadFromClasspath("././img/testPicture.jpg");

        // CurrentAddress Test
        $("#currentAddress").setValue("Moskow, Lenina 14, a.3");

        // selectStateAndselectCity Test
        $("#state").click();
        $("#state").$(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Karnal")).click();

        // submit Test
        $("button#submit").pressEnter();

        //Checking filled fields
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("TestName TestLastName"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("test@gmail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Other"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("5659874563"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("13 July,2000"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Hindi, Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("testPicture.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Moskow, Lenina 14, a.3"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Haryana Karnal"));

    }
}
