package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void setup() {
        Configuration.browser = "firefox";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void nameLastNameTest() {
        String path = "src/test/resourses/img/testPicture.jpg";
        File file = new File(path);

        open("/automation-practice-form");

        // nameLastNameTest
        $("input#firstName").setValue("TestName");
        $("input#lastName").setValue("TestLastName");

        // emailTest
        $("input#userEmail").setValue("test@gmail.com");

        // GenderRadioButtonTest
        $("#genterWrapper").$(byText("Male")).click();
        $("#genterWrapper").$(byText("Female")).click();
        $("#genterWrapper").$(byText("Other")).click();

        // mobilePhoneTest
        $("input#userNumber").setValue("5659874563");

        // dateOfBirthTest
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__month .react-datepicker__week .react-datepicker__day--013").click();

        // subjectsFieldTest
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("#subjectsInput").setValue("Maths").pressEnter();

        // HobbiesCheckBoxesTest
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        // Scrolling the page
        $("#uploadPicture").scrollIntoView(true);
        //$("t#uploadPicture").scrollIntoView(true).uploadFile(file);

        // selectPictureTest
        $("#uploadPicture").scrollIntoView(true).uploadFile(file);
        //$("t#uploadPicture").uploadFromClasspath("/img/testPicture.jpg");

        // CurrentAddressTest
        $("#currentAddress").setValue("Moskow, Lenina 14, a.3");

        // selectStateAndselectCityTest
        $("#state").click();
        $("#state").$(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Karnal")).click();

        // submitTest
        $("button#submit").pressEnter();

        //Checking filled fields
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $x("//table/tbody").shouldHave(text("TestName TestLastName"));
        $x("//table/tbody").shouldHave(text("test@gmail.com"));
        $x("//table/tbody").shouldHave(text("Other"));
        $x("//table/tbody").shouldHave(text("5659874563"));
        $x("//table/tbody").shouldHave(text("13 July,2000"));
        $x("//table/tbody").shouldHave(text("Hindi, Maths"));
        $x("//table/tbody").shouldHave(text("Sports, Reading, Music"));
        $x("//table/tbody").shouldHave(text("testPicture.jpg"));
        $x("//table/tbody").shouldHave(text("Moskow, Lenina 14, a.3"));
        $x("//table/tbody").shouldHave(text("Haryana"));
        $x("//table/tbody").shouldHave(text("Karnal"));

    }
}
