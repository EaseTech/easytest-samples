
package org.easetech.easytest.spring.example;

import java.util.ArrayList;
import java.util.List;
import org.easetech.easytest.samples.Item;
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
public class TheoriesTestExample {

    private ItemService testSubject;

    @Before
    public void setUp() {
        testSubject = new MockItemService();
    }

    public static class ItemTypeSupplier extends ParameterSupplier {

        @Override
        public List<PotentialAssignment> getValueSources(ParameterSignature sig) {
            List<PotentialAssignment> list = new ArrayList<PotentialAssignment>();
            list.add(PotentialAssignment.forValue("", "ebook"));
            list.add(PotentialAssignment.forValue("", "book"));
            list.add(PotentialAssignment.forValue("", "journal"));
            return list;
        }

    }

    public static class ItemIdSupplier extends ParameterSupplier {

        @Override
        public List<PotentialAssignment> getValueSources(ParameterSignature sig) {
            List<PotentialAssignment> list = new ArrayList<PotentialAssignment>();
            list.add(PotentialAssignment.forValue("", new ItemId(1L)));
            list.add(PotentialAssignment.forValue("", new ItemId(2L)));
            list.add(PotentialAssignment.forValue("", new ItemId(3L)));
            return list;
        }

    }

    public static class SearchTextSupplier extends ParameterSupplier {

        @Override
        public List<PotentialAssignment> getValueSources(ParameterSignature sig) {
            List<PotentialAssignment> list = new ArrayList<PotentialAssignment>();
            list.add(PotentialAssignment.forValue("", "Batman"));
            list.add(PotentialAssignment.forValue("", "superMan"));
            list.add(PotentialAssignment.forValue("", "spiderman"));
            return list;
        }

    }

    @Theory
    public void testItemServiceGetMethod(@ParametersSuppliedBy(ItemIdSupplier.class)
    ItemId itemId, @ParametersSuppliedBy(SearchTextSupplier.class)
    String searchText, @ParametersSuppliedBy(ItemTypeSupplier.class)
    String itemTypeString) {
        System.out.println("ItemId is: " + itemId + " searchText is :" + searchText + " item type is :"
            + itemTypeString);
        List<Item> items = testSubject.getItems(itemId, searchText, itemTypeString);
    }

}
