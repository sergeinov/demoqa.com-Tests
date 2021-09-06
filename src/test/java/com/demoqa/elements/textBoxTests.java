package com.demoqa.elements;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class textBoxTests {

    @BeforeAll
    static void setup() {
        Configuration.browser = "firefox";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }


    @Test
    void fillFildsTest() {
        open("/text-box");

        // fill the fields
        $("input[id='userName'").setValue("TestName");
        $("input[id='userEmail'").setValue("test@gmail.com");
        $("textarea[id='currentAddress']").setValue("London, 13");
        $("textarea[id='permanentAddress']").setValue("Moskow, 22");

        // submitting
        $("#submit").scrollIntoView(true);
        $("#submit").pressEnter();

        // checking output
        $("#output #name").shouldHave(text("Name:TestName"));
        $("#output #email").shouldHave(text("Email:test@gmail.com"));
        $("#output #currentAddress").shouldHave(text("Current Address :London, 13"));
        $("#output #permanentAddress").shouldHave(text("Permananet Address :Moskow, 22"));

    }
}
