package org.easetech.easytest.spring.example;

import java.util.List;
import junit.framework.Assert;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.easetech.easytest.samples.Item;
import org.easetech.easytest.samples.ItemId;
import org.easetech.easytest.samples.ItemService;
import org.easetech.easytest.samples.MockItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataDrivenTestRunner.class)
public class EasyTestCombinedExample {
    
    private ItemService testSubject;

    @Before
    public void setUp() {
        testSubject = new MockItemService();
    }
    
    @Test
    @DataLoader(filePaths={"csvBasedData.csv"})
    public void testCaseWithOneParameter(@Param(name="itemId")ItemId itemId){
        System.out.println("testSimpleCaseWithOneParameter : " + itemId);
        Item item = testSubject.findItem(itemId);
        Assert.assertNotNull(item);
        Assert.assertEquals(item.getItemId(), itemId);

    }
    
    @Test
    @DataLoader(filePaths={"xmlBasedData.xml"} , loaderType = LoaderType.XML)
    public void getItemsData(@Param(name="itemId") ItemId itemId , @Param(name="itemType") String itemType , @Param(name="expectedItems")int expectedItems){
        System.out.println(itemId + itemType + expectedItems);
        List<Item> items = testSubject.getItems(itemId, "", itemType);
        Assert.assertNotNull(items);
        Assert.assertEquals(expectedItems, items.size());
    }
    
    @Test
    @DataLoader(loader = CustomObjectDataLoader.class)
    public void testGetItemsWithCustomLoader(@Param ItemId itemId){
        System.out.println("ItemId is :" + itemId.toString());
        Item item = testSubject.findItem(itemId);
        Assert.assertNotNull(item);
        Assert.assertEquals(item.getItemId(), itemId);
        
    }

}
