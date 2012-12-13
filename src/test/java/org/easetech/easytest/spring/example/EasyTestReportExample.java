
package org.easetech.easytest.spring.example;

import org.easetech.easytest.annotation.Report;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.runner.RunWith;

import java.util.List;
import junit.framework.Assert;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.samples.Item;
import org.easetech.easytest.samples.ItemId;
import org.easetech.easytest.samples.ItemService;
import org.easetech.easytest.samples.MockItemService;
import org.junit.Test;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "classpath:xmlBasedData.xml" }, loaderType = LoaderType.XML)
@Report
public class EasyTestReportExample {

    
    public ItemService itemService = new MockItemService();

    @Test
    public List<Item> getItemsData(
        @Param(name = "itemId")Long itemId, 
        @Param(name = "itemType")String itemType, 
        @Param(name = "expectedItems")int expectedItems) {
        List<Item> items = itemService.getItems(new ItemId(itemId), "", itemType);
        Assert.assertEquals(expectedItems, items.size());
        return items;
    }

}
