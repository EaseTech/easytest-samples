package org.easetech.easytest.spring.example;

import java.util.Map;
import org.easetech.easytest.converter.AbstractConverter;
import org.easetech.easytest.samples.ItemId;

public class ItemInterfaceConverter extends AbstractConverter<ItemInterface> {


    
    public ItemInterface convert(Map<String, Object> convertFrom) {
        ItemInterface item = new ItemImpl();
        if (convertFrom != null) {
            item = new ItemImpl();
            item.setItemDesc((String) convertFrom.get("itemDesc"));
            ItemId itemId = new ItemId(Long.valueOf((String) convertFrom.get("itemId")));
            item.setItemId(itemId);
        }
        return item;
    }

}
