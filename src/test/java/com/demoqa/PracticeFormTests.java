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
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";

        Configuration.startMaximized = true;
    }


    @Test
    void nameLastNameTest() {
        //open("/automation-practice-form");
        $("input#firstName").setValue("TestName");
        $("input#lastName").setValue("TestLastName");
    }

    @Test
    void emailTest() {
        open("/automation-practice-form");
        $("input#userEmail").setValue("test@gmail.com");
    }

    @Test
    void GenderRadioButtonTest() {
        open("/automation-practice-form");
        $("#genterWrapper").$(byText("Male")).click();
        $("#genterWrapper").$(byText("Female")).click();
        $("#genterWrapper").$(byText("Other")).click();

        $("#genterWrapper").$(byText("Other")).isSelected();
    }

    @Test
    void mobilePhoneTest() {
        open("/automation-practice-form");
        $("input#userNumber").setValue("5659874563");

        $("input#userNumber").shouldHave(value("5659874563"));
    }

    @Test
    void dateOfBirthTest() {
        open("/automation-practice-form");
        $("#dateOfBirthInput").click();

        $(".react-datepicker__year-dropdown-container--select").click();
        $(".react-datepicker__year-select").$(byText("2000")).click();

        $(".react-datepicker__month-dropdown-container--select").click();
        $(".react-datepicker__month-select").$(byText("July")).click();

        $(".react-datepicker__month .react-datepicker__week .react-datepicker__day--013").click();
    }

    @Test
    void subjectsFieldTest() {
        open("/automation-practice-form");
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("#subjectsInput").setValue("Math").pressEnter();
    }

    @Test
    void HobbiesCheckBoxesTest() {
        open("/automation-practice-form");
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
    }

    @Test
    void selectPictureTest() {
        String path = "D:\\Download\\test.pdf";
        File file =new File(path);

        open("/automation-practice-form");
        $("input#uploadPicture").uploadFile(file);
    }

    // ! не работает, хз
    @Test
    void CurrentAddressTest() {
        open("/automation-practice-form");
        $("#currentAddress-wrapper textarea#currentAddress").setValue("Moskow, Lenina 14, a.3");

    }

    @Test
    void selectStateTest() {
        open("/automation-practice-form");
        $("#state").$(byText("Select State")).click();

    }


}
