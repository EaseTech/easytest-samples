package org.easetech.easytest.spring.example;

import java.beans.PropertyEditorManager;
import junit.framework.Assert;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.converter.ConverterManager;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.easetech.easytest.samples.Item;
import org.easetech.easytest.samples.ItemConverter;
import org.easetech.easytest.samples.ItemId;
import org.easetech.easytest.samples.ItemIdEditor;
import org.easetech.easytest.samples.ItemService;
import org.easetech.easytest.samples.MockItemService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths={"classpath:xmlBasedData.xml"})
public class EasyTestConverterExample {
    
    private ItemService testSubject;

    @Before
    public void setUp() {
        testSubject = new MockItemService();
    }
    
    @BeforeClass
    public static void setup(){
        PropertyEditorManager.registerEditor(ItemId.class, ItemIdEditor.class);
        ConverterManager.registerConverter(ItemConverter.class);
    }
    
    @Test
    public void getItemsData(Item item){
        System.out.println("Item is" + item);
        Item searchedItem = testSubject.findItem(item.getItemId());
        Assert.assertNotNull(searchedItem);
        Assert.assertEquals(item.getItemId(), searchedItem.getItemId());
    }

}
