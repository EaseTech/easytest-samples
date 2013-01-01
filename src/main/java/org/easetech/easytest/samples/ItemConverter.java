
package org.easetech.easytest.samples;

import java.util.Map;
import org.easetech.easytest.converter.AbstractConverter;

public class ItemConverter extends AbstractConverter<Item> {

    
    public Item convert(Map<String, Object> convertFrom) {
        Item item = null;

        if (convertFrom != null) {
            item = new Item();
            item.setDescription((String) convertFrom.get("itemDescription"));
            ItemId itemId = new ItemId(Long.valueOf((String) convertFrom.get("itemId")));
            item.setItemType((String) convertFrom.get("itemType"));
        }
        return item;
    }

}
