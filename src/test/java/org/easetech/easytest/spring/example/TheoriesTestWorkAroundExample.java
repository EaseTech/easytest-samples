
package org.easetech.easytest.spring.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.easetech.easytest.samples.ItemId;
import org.easetech.easytest.samples.ItemService;
import org.easetech.easytest.samples.MockItemService;
import org.junit.Before;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TheoriesTestWorkAroundExample {

    private ItemService testSubject;

    @Before
    public void setUp() {
        testSubject = new MockItemService();
    }

    public static class GetItemsDataSupplier extends ParameterSupplier {

        @Override
        public List<PotentialAssignment> getValueSources(ParameterSignature sig) {
            List<PotentialAssignment> list = new ArrayList<PotentialAssignment>();
            HashMap<String, Object> inputData = new HashMap<String, Object>();
            inputData.put("ItemId", new ItemId(1L));
            inputData.put("itemType", "ebook");
            inputData.put("searchText", new String( "potter"));
            list.add(PotentialAssignment.forValue("", inputData));
            HashMap<String, Object> inputData1 = new HashMap<String, Object>();
            inputData1.put("ItemId", new ItemId(2L));
            inputData1.put("itemType", "book");
            inputData1.put("searchText", new String ("spiderman" ));
            list.add(PotentialAssignment.forValue("", inputData1));
            // list.add(PotentialAssignment.forValue("", new String[]{"java" , "junit" , "nasa"}));
            return list;
        }

    }

    @Theory
    public void testGetItems(@ParametersSuppliedBy(GetItemsDataSupplier.class)
    HashMap<String, Object> inputData) {
        // This is not a good practice and is shown only for example purposes
        ItemId libraryId = (ItemId) inputData.get("ItemId");
        String itemType = (String) inputData.get("itemType");
        String searchText = (String) inputData.get("searchText");
        System.out.println("library Id : " + libraryId + " and item type : " + itemType
            + " and search text array :" + searchText);
        

    }

}
