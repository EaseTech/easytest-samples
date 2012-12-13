
package org.easetech.easytest.samples;

public class Item {

    private String description;

    private String itemType;

    private ItemId itemId;

    public Item(){
        
    }
    

    /**
     * Construct a new Item
     * @param description
     * @param itemType
     * @param itemId
     * @param libraryId
     */
    public Item(String description, String itemType, ItemId itemId) {
        super();
        this.description = description;
        this.itemType = itemType;
        this.itemId = itemId;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the itemType
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * @param itemType the itemType to set
     */
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

   

    public ItemId getItemId() {
        return itemId;
    }

    public void setItemId(ItemId itemId) {
        this.itemId = itemId;
    }


    @Override
    public String toString() {
        return "Item [description=" + description + ", itemType=" + itemType + ", itemId=" + itemId + ""
            + "]";
    }

    

}
