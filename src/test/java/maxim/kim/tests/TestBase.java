package maxim.kim.tests;

import com.codeborne.selenide.Configuration;
import maxim.kim.pages.AuthorizationPage;
import maxim.kim.pages.MainPage;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.FileDownloadMode.PROXY;


public class TestBase {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    MainPage mainPage = new MainPage();

    @BeforeAll
    static void config() {
        Configuration.proxyEnabled = true;
        Configuration.fileDownload = PROXY;
        Configuration.downloadsFolder = "src/test/resources";
        Configuration.startMaximized = true;
    }
}
