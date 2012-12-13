
package org.easetech.easytest.samples;

/**
 * 
 * An example of user defined Strongly typed object
 * 
 */
public class ItemId {

    /**
     * The id
     */
    private Long id;

    /**
     * 
     * Construct a new ItemId
     * 
     * @param id theid
     */
    public ItemId(Long id) {
        this.id = id;
    }
    
    public Long getValue(){
        return id;
    }

    /**
     * @return the toString representation
     */
    
    public String toString() {
        return "ItemId [id=" + id + "]";
    }

}
