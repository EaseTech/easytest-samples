
package org.easetech.easytest.samples;

import java.util.List;

public interface ItemService {

    public List<Item> getItems(ItemId itemid, String searchText, String itemType);

    public Item findItem(ItemId itemId);
    
    public void initialize();

}
