package maxim.kim.tests;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static maxim.kim.tests.TestData.*;

public class MainTest extends TestBase {
    @Test
    public void auth() throws FileNotFoundException {
        authorizationPage.autrorization(adminLogin, adminPassword);
        mainPage.exportPlayersCsv()
                .exportData()
                .checkSort();
    }

}
