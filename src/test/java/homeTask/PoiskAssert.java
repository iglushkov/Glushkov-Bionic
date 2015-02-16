package homeTask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PoiskAssert {

    @Test
    public void SearchsomeTest() throws IOException {

        String b = "JustSomeText";

        String a = new String(Files.readAllBytes(Paths.get("/Users/admin/Documents/Java_projects/Bionic-QS8/src/test/resources/test1.txt")));

        Assert.assertTrue(a.contentEquals(b));
    }

}