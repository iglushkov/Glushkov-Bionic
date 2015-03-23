package entities;

import org.apache.commons.lang3.RandomStringUtils;
import utils.PropertyLoader;

public class Advertisement {

    public String imagePath = PropertyLoader.loadProperty("project.path") + "/src/test/resources/image.jpg";
    public String title = "";
    public String itemPrice = "";
    public String description = "";
    public String contactPerson = "";
    public String email = "";

    public Advertisement(Boolean correct) {
        if (correct) {
            title = RandomStringUtils.randomAlphabetic(5).toLowerCase();
            itemPrice = RandomStringUtils.randomNumeric(3);
            description = RandomStringUtils.randomAlphabetic(50).toLowerCase();
            contactPerson = RandomStringUtils.randomAlphabetic(5).toLowerCase();
            email = RandomStringUtils.randomAlphabetic(5).toLowerCase() + "@ukr.net";
        } else {
            title = RandomStringUtils.randomAlphabetic(4).toLowerCase();
            itemPrice = RandomStringUtils.randomNumeric(14);
            description = RandomStringUtils.randomAlphabetic(49).toLowerCase();
            contactPerson = RandomStringUtils.randomAlphabetic(1).toLowerCase();
            email = RandomStringUtils.randomAlphabetic(5).toLowerCase();
        }
    }

}