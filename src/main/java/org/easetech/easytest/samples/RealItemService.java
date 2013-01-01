
package org.easetech.easytest.samples;

import java.util.List;
import org.easetech.easytest.samples.dao.ItemDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class RealItemService implements ItemService {
    
    @Autowired
    private ItemDaoImpl itemDao;

    public ItemDaoImpl getItemDao() {
        return itemDao;
    }

    public void setItemDao(ItemDaoImpl itemDao) {
        this.itemDao = itemDao;
    }

    
    public List<Item> getItems(ItemId itemId, String searchText, String itemType) {
        
        return itemDao.select(itemType , searchText);
        
    }
    
    public void insertTestData(){
        itemDao.insert(new ItemId(1L), "Harry Potter", "book");
        itemDao.insert(new ItemId(2L), "Batman", "ebook");
        itemDao.insert(new ItemId(3L), "Spiderman", "ebook");
        itemDao.insert(new ItemId(4L), "Spiderman", "journal");
        itemDao.insert(new ItemId(5L), "Batman", "book");
        itemDao.insert(new ItemId(6L), "Harry Potter", "ebook");
        itemDao.insert(new ItemId(7L), "Superman", "ebook");
        itemDao.insert(new ItemId(8L), "Superman", "journal");
    }

    
    public Item findItem(ItemId itemId) {
        System.out.println(itemDao == null);
        System.out.println("findItems Called");
        Item item = new Item("Item Description Modified Again","BOOK",itemId);
        return item;
    }

    /**
     * 
     */
    
    public void initialize() {
        insertTestData();
        
    }

}
