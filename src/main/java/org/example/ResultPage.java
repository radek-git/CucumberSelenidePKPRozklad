package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class ResultPage {

    public List<Result> getResults() {
        List<Result> results = new ArrayList<>();

        $(Selectors.byClassName("odd")).waitUntil(Condition.visible, 10000);
        List<SelenideElement> elements = $$(Selectors.byXpath("//tbody/tr"));
        System.out.println("lista elementów: " + elements.size());

        LocalTime departureTime;
        LocalTime arrivalTime;
        for (SelenideElement e : elements) {
            departureTime = LocalTime.parse(e.$x("(td[contains(@class, 'overview-time-td')]/p/span[@class='clear-lowres' and ./span[contains(text(), 'ODJAZD')]]/span)[3]").getText());
            arrivalTime = LocalTime.parse(e.$x("(td[contains(@class, 'overview-time-td')]/p/span[@class='clear-lowres' and ./span[contains(text(), 'PRZYJAZD')]]/span)[3]").getText());

            results.add(new Result(departureTime, arrivalTime));

        }
        return results;
    }



    public void displayResults() {
        List<Result> results = getResults().stream().sorted(Comparator.comparingInt(Result::getTravelLength))
                .collect(Collectors.toList());
        for (Result result : results) {
            System.out.println(result);
        }
    }
}
