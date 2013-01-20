
package org.easetech.easytest.spring.example;


import java.beans.PropertyEditorManager;
import java.util.List;
import junit.framework.Assert;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Intercept;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.SpringTestRunner;
import org.easetech.easytest.samples.Item;
import org.easetech.easytest.samples.ItemId;
import org.easetech.easytest.samples.ItemIdEditor;
import org.easetech.easytest.samples.ItemService;
import org.easetech.easytest.spring.config.XmlBusinessConfig;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringTestRunner.class)
@ContextConfiguration(classes = { XmlBusinessConfig.class }, loader = AnnotationConfigContextLoader.class)
@TransactionConfiguration(transactionManager="transactionManager" )
@Transactional
@DataLoader(filePaths = { "classpath:input-data.xml" })
public class TestSpringConfiguration {

    @Autowired
    @Intercept
    private ItemService testSubject;
    
    /**
     * Example showing the usage of propertyEditors for getting custom object.
     */
    @BeforeClass
    public static void setUp() {
        PropertyEditorManager.registerEditor(ItemId.class, ItemIdEditor.class);
    }
    
    @Test
    public void testSimple(){
        System.out.println(testSubject == null);
    }

    
    @Test
    public void getItemsDataUsingXMLLoader(@Param(name="searchText") String searchText, @Param(name="itemType") String itemType, ItemId itemId , @Param(name="expectedItems") int expectedItems) {
        System.out.println(testSubject == null);
        List<Item> items = testSubject.getItems(itemId, searchText, itemType);
        Assert.assertNotNull(items);
        Assert.assertEquals(expectedItems, items.size());
       
    }
}
