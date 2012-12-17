package org.easetech.easytest.spring.config;

import java.util.List;
import org.easetech.easytest.samples.Item;
import org.easetech.easytest.samples.ItemId;
import org.easetech.easytest.samples.ItemService;

import java.util.List;
import org.easetech.easytest.samples.Item;
import org.easetech.easytest.samples.ItemId;
import org.easetech.easytest.samples.ItemService;

import org.easetech.easytest.annotation.TestBean;
import org.easetech.easytest.samples.RealItemService;
import org.junit.Ignore;

@Ignore
public class TestConfig {
    
    @TestBean public RealItemService itemService(){
        return new RealItemService();
    }
    
    @TestBean("realItemService") public RealItemService realItemService(){
        return new RealItemService();
    }
    
    @TestBean("thisIsAnotherRealItemBean") public ItemService thisIsAnotherRealItemBean(){
        return new ItemService() {
            
            
            public void initialize() {
                // TODO Auto-generated method stub
                
            }
            
            
            public List<Item> getItems(ItemId itemid, String searchText, String itemType) {
                // TODO Auto-generated method stub
                return null;
            }
            
            
            public Item findItem(ItemId itemId) {
                // TODO Auto-generated method stub
                return null;
            }
        };
    }
    
    

}
