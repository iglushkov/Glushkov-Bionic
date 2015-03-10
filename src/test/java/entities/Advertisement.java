package entities;
import utils.DataGenerator;
import utils.PropertyLoader;

import java.io.File;

public class Advertisement {
    public String title = DataGenerator.getRandomString(6);
    public String description = DataGenerator.getRandomString(60);
    public String photoUrl = new File(getDefaultPhotoPath()).getAbsolutePath();
    public String name = DataGenerator.getRandomString(10);
    public String email = DataGenerator.getRandomEmail();
    public int size = DataGenerator.getRandomInt(90);


    private static String getDefaultPhotoPath()
    {
        String projectPath = PropertyLoader.loadProperty("project.path");
        String filePath = "/src/test/resources/image.jpg";
        return projectPath + filePath;
    }
}