package functional;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class FilteringTest extends AbstractTest{


    @Test(priority = 1)
    public void addAdvertTest() {
        openAddNewAdvertPage();
        addNewAdvert();
    }

    @Test(priority = 2)
    public void visualFilterTest() {
        openDetskiyMir();
        openDetskayaOdezhda();
    }

    @Test(priority = 3)
    public void priceFilterTest() {
        openDetskiyMir();
        openDetskayaOdezhda();
        sortByNew();
    }


    public void openAddNewAdvertPage() {
        HomePage homePage = new HomePage(browser);
        homePage.open();
        homePage.openAddNewAdvert();
    }

    public void addNewAdvert(){
        AddNewAdvertPage addNewAdvertPage = new AddNewAdvertPage(browser);
        addNewAdvertPage.generateAdvertData();
        addNewAdvertPage.fillInAllFields();
        addNewAdvertPage.openPreview();
        PreviewPage previewPage = new PreviewPage(browser);
        Assert.assertTrue(previewPage.previewIsOpened());
    }

    public void sortByNew() {
        ChildDressPage childDressPage = new ChildDressPage(browser);
        Assert.assertTrue(childDressPage.sortByNew());
    }

    public void openDetskiyMir() {
        HomePage homePage = new HomePage(browser);
        homePage.open();
        homePage.openDetskiyMir();
        ChildPage childPage = new ChildPage(browser);
        Assert.assertTrue(childPage.isOpened());
    }

    public void openDetskayaOdezhda() {
        ChildPage childPage = new ChildPage(browser);
        childPage.openOdezhda();
        ChildDressPage childDressPage = new ChildDressPage(browser);
        Assert.assertTrue(childDressPage.isOpened());
    }

}