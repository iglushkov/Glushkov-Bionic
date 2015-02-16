package homeTask;

import org.testng.annotations.Test;
        import org.testng.Assert;
        import java.io.IOException;
        import java.nio.file.Files;
        import java.nio.file.Paths;

public class regExp1 {

    @Test
    public void RegExp() throws IOException {

        String infa = new String(Files.readAllBytes(Paths.get("/Users/admin/Documents/Java_projects/Bionic-QS8/src/test/resources/test2.txt")));

        Assert.assertEquals(infa.matches("^.*\\d+\\.\\d+.*"), true);

    }

}