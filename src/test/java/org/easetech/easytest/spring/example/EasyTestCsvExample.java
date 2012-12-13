
package org.easetech.easytest.spring.example;

import java.util.List;
import junit.framework.Assert;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.easetech.easytest.samples.Item;
import org.easetech.easytest.samples.ItemId;
import org.easetech.easytest.samples.ItemService;
import org.easetech.easytest.samples.MockItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "classpath:csvBasedData.csv" })
public class EasyTestCsvExample {

    private ItemService testSubject;

    @Before
    public void setUp() {
        testSubject = new MockItemService();
    }

    @Test
    public void testSimpleCase() {
        System.out.println("This is a simple test");
    }

    @Test
    public void testCaseWithOneParameter(@Param(name = "itemId")
    int itemId) {
        
        System.out.println("testSimpleCaseWithOneParameter : " + itemId);
        
        ItemId id = new ItemId(Long.valueOf(itemId));
        Item item = testSubject.findItem(id);
        Assert.assertNotNull(item);
        Assert.assertEquals(id, item.getItemId());
    }

    @Test
    public void testCaseWithTwoParameter(@Param(name = "itemId")
    int itemId, @Param(name = "itemType")
    String itemType) {
        System.out.println("testSimpleCaseWithTwoParameter : " + itemId + " and itemType :" + itemType);
        ItemId id = new ItemId(Long.valueOf(itemId));
        List<Item> items = testSubject.getItems(id, "", itemType);
        Assert.assertNotNull(items);
        
    }

//     UNCOMMENT AND INTRODUCE YOUR OWN DATA
//     @Test
//     public void testCaseWithThreeParameter(@Param(name="itemId")int itemId , @Param(name="itemType")String itemType ,
//     @Param(name="searchText")String searchText){
//     System.out.println("testSimpleCaseWithTwoParameter : " + itemId +" and itemType :" + itemType +
//     " searchText is :" + searchText );   
//            ItemId id = new ItemId(Long.valueOf(itemId));
//            List<Item> items = testSubject.getItems(id, "", itemType);
//            Assert.assertNotNull(items);
//     }

}
