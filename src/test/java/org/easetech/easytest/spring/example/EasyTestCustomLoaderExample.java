package org.easetech.easytest.spring.example;

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
public class EasyTestCustomLoaderExample {
    
    private ItemService testSubject;

    @Before
    public void setUp() {
        testSubject = new MockItemService();
    }
    
    @Test
    @DataLoader(loader = CustomObjectDataLoader.class)
    public void testGetItemsWithCustomLoader(ItemId itemId){
        System.out.println("ItemId is :" + itemId.toString());
        Item item = testSubject.findItem(itemId);
        Assert.assertNotNull(item);
        Assert.assertEquals(item.getItemId(), itemId);
        
    }
    
    
    

}
