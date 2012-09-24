
package org.easetech.easytest.samples.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.easetech.easytest.model.ItemModel;
import org.easetech.easytest.samples.ItemId;

/**
 * Implementation of ItemDao class
 *
 */
public class ItemDaoImpl{
    
    /**
     * The @PersistenceContext annotation has an optional attribute type, 
     * which defaults to PersistenceContextType.TRANSACTION. 
     * This default is what you need to receive a shared EntityManager proxy. 
     * The alternative, PersistenceContextType.EXTENDED, is a completely different affair: 
     * This results in a so-called extended EntityManager, which is not thread-safe and 
     * hence must not be used in a concurrently accessed component such as a Spring-managed 
     * singleton bean. Extended EntityManagers are only supposed to be used in stateful 
     * components that, for example, reside in a session, with the lifecycle of the EntityManager
     * not tied to a current transaction but rather being completely up to the application.
     */
    @PersistenceContext
    EntityManager entityManager;
    
    public void insert(ItemId itemId , String desc, String itemType){
        ItemModel model = new ItemModel();
        model.setId(itemId.toString());
        model.setItemDesc(desc);
        model.setItemType(itemType);
        entityManager.persist(model);
        entityManager.flush();
        
    }
    
    public List select(String itemType , String searchText){
        Query query = entityManager.createQuery("from ItemModel im where im.itemType =:itemType and im.itemDesc=:searchText");
        query.setParameter("itemType", itemType);
        query.setParameter("searchText", searchText);
        List result = query.getResultList();
        System.out.println(result.toString());
        return result;
    }

}
