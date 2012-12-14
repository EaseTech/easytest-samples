package org.easetech.easytest.spring.example;

import org.easetech.easytest.samples.ItemId;

public class ItemImpl implements ItemInterface {
    
    private  ItemId itemId;
    
    private  String itemDesc;
    
    /**
     * @param itemId the itemId to set
     */
    public void setItemId(ItemId itemId) {
        this.itemId = itemId;
    }


    /**
     * @param itemDesc the itemDesc to set
     */
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }


    public ItemImpl(){
        itemId = null;
        itemDesc = "";
    }

    
    public ItemId getItemId() {
        return itemId;
    }

    
    public String getItemDescription() {
        return itemDesc;
    }
    
    


    public ItemImpl(ItemId itemId, String itemDesc) {
        super();
        this.itemId = itemId;
        this.itemDesc = itemDesc;
    }
    
    

}
