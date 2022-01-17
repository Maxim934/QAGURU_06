package maxim.kim.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class MainPage {
    //locators&elements
    // Элементы, открытия странцы игроки
    public SelenideElement usersTab = $("[data-target=\"#s-menu-users\"]"),
            playersSection = $(byText("Players")),
            userNameSortButton = $(byText("Username")),
            ExportCsvButton = $("[data-target=\"#myModal\"]"),
            exportDataHeader = $(byText("Export data"));
    //чек боксы при загрузки файла
    public SelenideElement firstNameCheckBox = $("[value = name]"),
            lastNameCheckBox = $("[value = surname]"),
            emailCheckBox = $("[value = email]"),
            phoneCheckBox = $("[value = phone_number]"),
            hallCheckBox = $("[value = node_id]"),
            registrationDateCheckBox = $("[value = create_at]"),
            lastVisitCheckBox = $("[value = lastvisit_at]"),
            registrationIPCheckBox = $("[value = registration_ip]"),
            exportDataBtn = $("[value = Export]");

    public MainPage exportPlayersCsv() {
        usersTab.click();
        playersSection.click();
        userNameSortButton.click();
        ExportCsvButton.click();
        exportDataHeader.shouldBe(Condition.visible);
        return this;
    }

    public MainPage exportData() {
        firstNameCheckBox.click();
        lastNameCheckBox.click();
        emailCheckBox.click();
        phoneCheckBox.click();
        hallCheckBox.click();
        registrationDateCheckBox.click();
        lastVisitCheckBox.click();
        registrationIPCheckBox.click();
        return this;
    }


    public MainPage checkSort() throws FileNotFoundException {
        File report = exportDataBtn.download();
        String file = report.getPath();
        List<String> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(values[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> clonedList = new ArrayList<>(records);
        ArrayList<String> clonedList1 = (ArrayList<String>) clonedList.stream().sorted().collect(Collectors.toList());
        if (!records.equals(clonedList1)) {
            Assertions.fail();
        }
        return this;
    }

}
