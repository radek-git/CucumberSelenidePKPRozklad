import com.codeborne.selenide.Configuration;
import io.cucumber.java8.En;
import org.example.HomePage;
import org.example.ResultPage;

import static com.codeborne.selenide.Selenide.open;

public class ScheduleSteps implements En {

    private HomePage homePage;
    private ResultPage resultPage;

    public ScheduleSteps() {

        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;


        Given("User opens page", () -> {
            open("https://rozklad-pkp.pl/");
        });

        When("User inputs station form {string}", (String stationFrom) -> {
            homePage = new HomePage();
            homePage.inputStationFrom(stationFrom);
        });

        When("User inputs station to {string}", (String stationTo) -> {
            homePage.inputStationTo(stationTo);
        });

        When("User selects day of current month {string}", (String date) -> {
            homePage.selectDate(date);
        });

        When("User selects time {string}", (String time) -> {
            homePage.selectTime(time);
        });

        When("User selects travel options {string}", (String travelOption) -> {
            homePage.selectTravelOption(travelOption);
        });

        When("User clicks search button", () -> {
            resultPage = homePage.clickSearchButton();
        });

        Then("Results are displayed", () -> {
            resultPage.displayResults();
        });


    }
}
