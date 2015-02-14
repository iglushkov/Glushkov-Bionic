import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Poisk_Assert {

        @Test
        public void someTest() throws IOException {
            String b = "qwe";
            String a = new String(Files.readAllBytes(Paths.get("/Users/admin/IdeaProjects/12.txt", new String[0])));
            Assert.assertTrue(a.contentEquals(b));
        }

}
