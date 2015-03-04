package functional;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ChildDressPage;
import pages.ChildWorldPage;


public class VisualFilterTest extends AbstractTest{

    @Test
    public void visualFilterTest(){
        ChildWorldPage kidsWorld = home.openKidsWorld();
        Assert.assertTrue(kidsWorld.isOpened());
        ChildDressPage kidsDress = kidsWorld.openKidsDress();
        Assert.assertTrue(kidsDress.isOpened());
    }

}