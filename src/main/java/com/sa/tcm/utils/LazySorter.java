package com.sa.tcm.utils;

import java.util.Comparator;
import org.primefaces.model.SortOrder;

import com.sa.tcm.entity.Runner;
 
public class LazySorter implements Comparator<Runner> {
 
    private String sortField;
     
    private SortOrder sortOrder;
     
    public LazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
 
    public int compare(Runner runner1, Runner runner2) {
        try {
            Object value1 = Runner.class.getField(this.sortField).get(runner1);
            Object value2 = Runner.class.getField(this.sortField).get(runner2);
 
            int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}