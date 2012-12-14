package org.easetech.easytest.spring.example;

import org.easetech.easytest.samples.ItemId;


public interface ItemInterface {
    
    ItemId getItemId();
    
    String getItemDescription();
    
    void setItemId(ItemId itemId);

    void setItemDesc(String itemDesc);

}
