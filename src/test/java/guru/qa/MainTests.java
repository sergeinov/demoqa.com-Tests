package guru.qa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainTests {

    @BeforeEach
     void openUrlTest() {
        open("https://demoqa.com/automation-practice-form");
    }


    @Test
    void fillNameLastNameEmailFildsTest() {
        $("input[id='firstName'").setValue("TestName");
        $("input[id='lastName'").setValue("TestLastName");
        $("input[id='userEmail']").setValue("test@gmail.com");
    }


}
