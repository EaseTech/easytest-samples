/****************************************************************************************************************
*
*  Copyright (c) 2012 OCLC, Inc. All Rights Reserved.
*
*  OCLC proprietary information: the enclosed materials contain
*  proprietary information of OCLC, Inc. and shall not be disclosed in whole or in 
*  any part to any third party or used by any person for any purpose, without written
*  consent of OCLC, Inc.  Duplication of any portion of these materials shall include this notice.
*
******************************************************************************************************************/

package org.easetech.easytest.samples;

import java.util.ArrayList;

import java.util.Collections;

import java.util.List;

/**
 * TODO Describe me
 *
 */
public class MockItemService implements ItemService {

    /**
     * @param itemid
     * @param searchText
     * @param itemType
     * @return
     */
    @Override
    public List<Item> getItems(ItemId itemid, String searchText, String itemType) {
        List<Item> items = new ArrayList<Item>();
        Item item1 = new Item(searchText, itemType, itemid);
        items.add(item1);
        if(itemid.getValue().toString().equals("2600")){           
            Item item2 = new Item(searchText.concat("next"), itemType, itemid);
            items.add(item2);
            
        }else if(itemid.getValue().toString().equals("4000")){
            return Collections.EMPTY_LIST;
        }
        return items;
    }

    /**
     * @param itemId
     * @return
     */
    @Override
    public Item findItem(ItemId itemId) {
        return new Item("mockItem", "book", itemId);
    }

    /**
     * 
     */
    @Override
    public void initialize() {
        // TODO Auto-generated method stub

    }

    /**
     * @param searchText
     * @return
     */
    public Item getItemFromSearchText(String searchText) {
        return new Item(searchText ,"book", new ItemId(1L));
    }

}
