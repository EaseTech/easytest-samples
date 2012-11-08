package org.easetech.easytest.spring.example;

import org.junit.Before;

import junit.framework.Assert;

import org.easetech.easytest.samples.ItemId;

import java.util.List;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.easetech.easytest.samples.Item;
import org.easetech.easytest.samples.ItemService;
import org.easetech.easytest.samples.MockItemService;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths={"xmlBasedData.xml"} , loaderType=LoaderType.XML)
public class CaptureReturnedDataExample {
    
    private ItemService testSubject;

    @Before
    public void setUp() {
        testSubject = new MockItemService();
    }
    

    @Test
    public List<Item> getItemsData(@Param(name="itemId") ItemId itemId , @Param(name="itemType") String itemType , @Param(name="expectedItems")int expectedItems){
        List<Item> items = testSubject.getItems(itemId, "", itemType);
        Assert.assertEquals(expectedItems, items.size());
        return items;
    }
}
