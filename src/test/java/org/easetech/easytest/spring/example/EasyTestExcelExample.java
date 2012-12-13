package org.easetech.easytest.spring.example;


import junit.framework.Assert;

import org.easetech.easytest.samples.ItemId;

import org.easetech.easytest.samples.Item;

import org.easetech.easytest.samples.MockItemService;
import org.junit.Before;

import org.easetech.easytest.samples.ItemService;

import org.junit.Test;

import org.easetech.easytest.loader.LoaderType;

import org.easetech.easytest.annotation.DataLoader;

import org.easetech.easytest.annotation.Param;

import org.easetech.easytest.runner.DataDrivenTestRunner;

import org.junit.runner.RunWith;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths={"classpath:xlsBasedDataForClass.xls"} , loaderType = LoaderType.EXCEL)
public class EasyTestExcelExample {
    
    private ItemService testSubject;
    
    @Before
    public void setUp(){
        testSubject = new MockItemService();
    }
    
    @Test
    public void testCaseWithItemId(@Param(name="itemId")String itemId ){
        System.out.println("testCaseWithOneParameter :" + itemId);
        ItemId id = new ItemId(Long.valueOf(itemId));
        Item item = testSubject.findItem(id);
        Assert.assertNotNull(item);
        Assert.assertEquals(id, item.getItemId());
        
    }
    
    //UNCOMMENT THIS AND ADD DATA FOR THIS METHOD IN xlsBasedDataForClass.xls file under src/test/resources
    
//    @Test
//    public void testCaseWithSearchText(@Param(name="searchText")String searchText ){
//        System.out.println("testCaseWithOneParameterFromClassData :" + searchText);
//        Item item = testSubject.getItemFromSearchText(searchText);
//        Assert.assertNotNull(item);
//        Assert.assertEquals(searchText, item.getDescription());
//    }
    

}
