
package org.easetech.easytest.spring.example;

import java.beans.PropertyEditorManager;
import java.util.List;
import junit.framework.Assert;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.easetech.easytest.samples.Item;
import org.easetech.easytest.samples.ItemId;
import org.easetech.easytest.samples.ItemIdEditor;
import org.easetech.easytest.samples.ItemService;
import org.easetech.easytest.samples.MockItemService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "classpath:xmlBasedData.xml" })
public class EasyTestXMLExample {

    private ItemService testSubject;

    @Before
    public void setUp() {
        testSubject = new MockItemService();
    }

    @BeforeClass
    public static void setup() {
        PropertyEditorManager.registerEditor(ItemId.class, ItemIdEditor.class);
        //PropertyEditorManager.registerEditor(Integer.class, IntEditor.class);
    }

    //This will fail because expectedItems is of type String whereas items.size() is of type int.
    @Test
    public void getItemsData(@Param( "itemId")
    String itemId, @Param( "itemType")
    String itemType, @Param( "expectedItems")
    int expectedItems) {
        ItemId id = new ItemId(Long.valueOf(itemId)) ;
        List<Item> items = testSubject.getItems(id, "", itemType);       
        Assert.assertNotNull(items);
        Assert.assertEquals(expectedItems, items.size());
    }
    
    //UNCOMMENT THIS, INTRODUCE THE DATA IN xmlBasedData.xml FOR THIS METHOD AND RUN
//    @Test
//    public void getItemsDataWithStrongType(@Param
//    ItemId itemId, @Param( "itemType")
//    String itemType, @Param( "expectedItems")
//    int expectedItems) {
//        List<Item> items = testSubject.getItems(itemId, "", itemType);       
//        Assert.assertNotNull(items);
//        Assert.assertEquals(expectedItems, items.size());
//    }

}
