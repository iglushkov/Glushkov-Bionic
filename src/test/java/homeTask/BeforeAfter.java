package homeTask;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.*;
import java.nio.file.Files;

import static java.nio.file.Paths.get;

public class BeforeAfter {

    @BeforeTest
    public void setUp() throws IOException {

        String text = "Hello world 6.5";
        File file = new File("test3.txt");
        BufferedWriter output = new BufferedWriter(new FileWriter(file));
        output.write(text);
        output.close();

    }

    @Test
    public void test() throws IOException {

        String infa = new String(Files.readAllBytes(get("test3.txt")));
        Assert.assertEquals(infa.matches("^.*\\d+\\.\\d+.*"), true);

    }

    @AfterTest
    public void tearDown() {

        File file = new File("test3.txt");
        file.delete();
    }

}



