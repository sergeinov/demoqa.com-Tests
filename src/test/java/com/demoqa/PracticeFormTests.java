package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
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
        $("#subjectsInput").setValue("Maths").pressEnter();

        // HobbiesCheckBoxesTest
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

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

        //Checking filled fields
        $x("//div[@class='modal-body']//table//tbody").shouldHave(text("TestName TestLastName"));
        $x("//div[@class='modal-body']//table//tbody").shouldHave(text("test@gmail.com"));
        $x("//div[@class='modal-body']//table//tbody").shouldHave(text("Other"));
        $x("//div[@class='modal-body']//table//tbody").shouldHave(text("5659874563"));
        $x("//div[@class='modal-body']//table//tbody").shouldHave(text("13 July,2000"));
        $x("//div[@class='modal-body']//table//tbody").shouldHave(text("Hindi, Maths"));
        $x("//div[@class='modal-body']//table//tbody").shouldHave(text("Sports, Reading, Music"));
        $x("//div[@class='modal-body']//table//tbody").shouldHave(text("test.pdf"));
        $x("//div[@class='modal-body']//table//tbody").shouldHave(text("Moskow, Lenina 14, a.3"));
        $x("//div[@class='modal-body']//table//tbody").shouldHave(text("Haryana"));
        $x("//div[@class='modal-body']//table//tbody").shouldHave(text("Karnal"));

    }
}
