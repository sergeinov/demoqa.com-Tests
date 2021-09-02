package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.value;
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
    void nameLastNameTest() {
        String path = "D:\\Download\\test.pdf";
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
        $("#genterWrapper").$(byText("Other")).isSelected();

        // mobilePhoneTest
        $("input#userNumber").setValue("5659874563");

        // dateOfBirthTest
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-dropdown-container--select").click();
        $(".react-datepicker__year-select").$(byText("2000")).click();
        $(".react-datepicker__month-dropdown-container--select").click();
        $(".react-datepicker__month-select").$(byText("July")).click();
        $(".react-datepicker__month .react-datepicker__week .react-datepicker__day--013").click();

        // subjectsFieldTest
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("#subjectsInput").setValue("Math").pressEnter();

        // HobbiesCheckBoxesTest
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();

        // selectPictureTest
        $("input#uploadPicture").uploadFile(file);

        // CurrentAddressTest
        $("#currentAddress-wrapper textarea#currentAddress").setValue("Moskow, Lenina 14, a.3").pressEnter();

        // selectStateAndselectCityTest
        $("#state").click();
        $("#state").$(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Karnal")).click();

        // submitTest
        $("button#submit").pressEnter();

        // todo
        //$("input#firstName").shouldHave(value("TestName"));
        //$("input#lastName").shouldHave(value("TestLastName"));
        //$("input#userEmail").shouldHave(value("test@gmail.com"));
        //$("input#userNumber").shouldHave(value("5659874563"));
    }
}
