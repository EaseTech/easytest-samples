package org.easetech.easytest.model;

import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="item_table")
public class ItemModel {
    
    /** The name associated with a model */
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    
    @Column(name = "item_type", nullable = false, length = 36)
    private String itemType;

    @Column(name = "item_desc", nullable = false, length = 36)
    private String itemDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
    
    
    

}
