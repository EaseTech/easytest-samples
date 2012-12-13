
package org.easetech.easytest.spring.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.easetech.easytest.io.Resource;
import org.easetech.easytest.loader.Loader;

/**
 * 
 * A Custom Data Loader that simply provides data from the class itself without reading any external files.
 * 
 */
public class CustomObjectDataLoader implements Loader {

    
    public Map<String, List<Map<String, Object>>> loadData(Resource resource) {
        Map<String, List<Map<String, Object>>> result = new HashMap<String, List<Map<String, Object>>>();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ItemId", "1");
        list.add(map);
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("ItemId", "2");
        list.add(map1);
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("ItemId", "3");
        list.add(map2);
        result.put("testGetItemsWithCustomLoader", list);
        return result;
    }

    
    public void writeData(Resource resource, Map<String, List<Map<String, Object>>> actualData, String... methodName) {
        // TODO Auto-generated method stub

    }

}
