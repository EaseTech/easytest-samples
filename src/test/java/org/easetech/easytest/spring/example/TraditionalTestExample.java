package org.easetech.easytest.spring.example;

import org.junit.AfterClass;

import java.util.List;
import junit.framework.Assert;
import org.easetech.easytest.samples.Item;
import org.easetech.easytest.samples.ItemId;
import org.easetech.easytest.samples.ItemService;
import org.easetech.easytest.samples.MockItemService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TraditionalTestExample {
    
    public static ItemService testSubject ;
    
    @BeforeClass
    public static void setup(){
        testSubject = new MockItemService();
    }
    
    @Test
    public void testItemServiceGetMethod(){
        
        ItemId itemid = new ItemId(2600L);
        String searchText = new String("Batman");
        String itemType = new String("ebook");
        List<Item> items = testSubject.getItems(itemid, searchText, itemType);
        Assert.assertNotNull(items);
        Assert.assertEquals(2, items.size());
        
        
        itemid = new ItemId(3600L);
        searchText = new String("SuperMan");
        itemType = new String("journal");
        items = testSubject.getItems(itemid, searchText, itemType);
        Assert.assertNotNull(items);
        Assert.assertEquals(1, items.size());
        
        
        itemid = new ItemId(4000L);
        searchText = new String("");
        itemType = new String("");
        items = testSubject.getItems(itemid, searchText, itemType);
        Assert.assertNotNull(items);
        Assert.assertEquals(0, items.size());
        
    }
    
    @AfterClass
    public static void tearDown(){
        testSubject = null;
    }

}
