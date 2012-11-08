package org.easetech.easytest.spring.example;

import junit.framework.Assert;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.easetech.easytest.samples.Item;
import org.easetech.easytest.samples.ItemId;
import org.easetech.easytest.samples.ItemService;
import org.easetech.easytest.samples.MockItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTestExample {
    
    private String searchText;
    
    private String itemType;
    
    private ItemId itemId;
    
    private ItemService testSubject;
    
    //UNCOMMENT 
    //private String newSearchCriteria;
    
    @Before
    public void setUp(){
        testSubject = new MockItemService();
    }
    
    public ParameterizedTestExample(String searchText , String itemType, ItemId itemId 
      //UNCOMMENT 
        //, String newSearchCriteria
        ) {
       this.searchText = searchText;
       this.itemType = itemType;
       this.itemId = itemId;
       //this.newSearchCriteria = newSearchCriteria;
    }

    @Parameters
    public static Collection<Object[]> data() {
        //COMMENT THIS
      Object[][] data = new Object[][] { 
          { "harry Potter" , "ebook" ,new ItemId(2600L) }, 
          { "SuperMan" , "journal" ,new ItemId(3600L) },
          { "SpiderMan" , "book" ,new ItemId(4000L) }};
      
      /**UNCOMMENT Object[][] data = new Object[][] { 
          { "harry Potter" , "ebook" ,new ItemId(2L) , "new Search"}, 
          { "SuperMan" , "journal" ,new ItemId(1L)  , "old new Search"},
          { "SpiderMan" , "book" ,new ItemId(3L) , "new Old Search" }};
          */
      return Arrays.asList(data);
    }
    

    @Test
    public void testItemServiceGetMethod(){
        List<Item> items = testSubject.getItems(itemId, searchText, itemType);
        Assert.assertNotNull(items);
    }

    @Test
    public void testFindItem(){
        //UNCOMMENT Item item = testSubject.findItem(newSearchCriteria);
    }
}
