package maxim.kim;

import com.codeborne.selenide.Configuration;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


import static com.codeborne.selenide.Selenide.*;


public class DownloadTest {
    @BeforeAll
    public static void config() {
        Configuration.startMaximized = true;
        Configuration.downloadsFolder = "resources";
    }
    //comment 1.1 for hw
    //comment 2.1 for hw
    //comment 3.1 for hw
    @Test
    public void downloadFile() throws IOException {
        open("https://the-internet.herokuapp.com/download");
        File file = $("a[href=\"download/model.txt\"]").download();
        String content = IOUtils.toString(new FileReader(file));
        System.out.println(content);
        Assertions.assertTrue(content.contains("Age: Under 25, 25-60, Older than 60"));
    }

}
