package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }


    @Test
    void nameLastNameTest() {
        open("/automation-practice-form");
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
        $("#subjectsContainer .subjects-auto-complete__value-container").setValue("Subject");

        //$("#subjectsContainer").shouldHave(value("Subject"));
    }

}
