package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {

    public void inputStationFrom(String stationFrom) {
//        $(Selectors.byClassName("qc-cmp-ui-content")).waitUntil(Condition.visible, 10000);
        $(Selectors.byClassName("qc-cmp-button")).waitUntil(Condition.visible, 10000).click();
        $(Selectors.byClassName("anchor_close")).waitUntil(Condition.visible, 10000).click();
        $(Selectors.byId("from-station")).val(stationFrom);
    }

    public void inputStationTo(String stationTo) {
        $(Selectors.byId("to-station")).val(stationTo);
    }

    public void selectDate(String day) {
        $(Selectors.byClassName("data-filed")).click();
        $x("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a[contains(text(), '"+day+"')]").click();
    }

    public void selectTime(String time) {
        $(Selectors.byId("hour0")).click();
        $(Selectors.byId("hour0")).val(time);
        $(Selectors.byClassName("pick-date")).click();
    }

    public void selectTravelOption(String travelOption) {
        $x("//div[@class='checkbox3']/label/span[text()='" + travelOption + "']").click();
    }

    public ResultPage clickSearchButton() {
        $(Selectors.byId("singlebutton")).click();
        return new ResultPage();
    }


    //todo
    // wyniki wyszukiwań zapisać do listy resultów
    // każdy result posiada godz odjazdu, przyjazdu, czas podróży, nazwa przewoźnika
    // wyświetlić na konsoli od kiedy do kiedy i posortować po czasie i wyświetlić rosnąco
}
