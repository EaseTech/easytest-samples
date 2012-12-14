package org.easetech.easytest.spring.example;

import org.easetech.easytest.loader.LoaderType;

import org.easetech.easytest.annotation.DataLoader;

import org.easetech.easytest.runner.DataDrivenTestRunner;

import org.junit.runner.RunWith;

import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.converter.ConverterManager;
import org.easetech.easytest.samples.ItemId;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * Example test case that explores how an interface can be passed
 * as method parameter
 *
 */
@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths={"classpath:interfaceData.xml"} , loaderType=LoaderType.XML)
public class EasyTestInterfaceExample {
    
    @BeforeClass
    public static void before(){
        ConverterManager.registerConverter(ItemInterfaceConverter.class);
    }
    
    @Test
    public void testMethod(ItemInterface item , @Param(name ="expectedItemId") ItemId itemId){
        Assert.assertNotNull(item);
        Assert.assertEquals(itemId.getValue(), item.getItemId().getValue());
        System.out.println(item.getItemDescription());
    }

}
