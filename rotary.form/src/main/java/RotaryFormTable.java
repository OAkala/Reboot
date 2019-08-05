/*
   *************************************************************************************************
   Program: RotaryFormTable.java
   Repository Name: Rotary-Form
   Date Created: 03-Jul-19
   Program Description: This class holds all the records that are in a given form
   *************************************************************************************************
*/
import java.lang.reflect.*;
import java.util.*;

public class RotaryFormTable {
    protected ArrayList<RotaryFormRecord> table = new ArrayList<>();

    public RotaryFormTable() {
        table.add(new RotaryFormRecord());
    }

    public RotaryFormTable(String unit, String keyHome, String pestLevel, String houseKeeping) {
        table.add(new RotaryFormRecord(unit, keyHome, pestLevel, houseKeeping));
    }

    public RotaryFormRecord getRecord(int index) {
        return table.get(index);
    }

    public void addRecord() {
        if (!table.isEmpty()) {
            try {
                if (!checkRecordField(table.size() - 1)) {
                    System.out.println("Please fill out previous record.");
                } else {
                    table.add(new RotaryFormRecord());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            table.add(new RotaryFormRecord());
            System.out.println("Record successfully added"); //might remove later
        }
    }

    public void deleteRecord(int index) {
        table.remove(index);
    }

    public void clear(int index) {
        table.set(index, new RotaryFormRecord());
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (RotaryFormRecord record : table) {
            try {
                str.append(record.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            str.append(System.lineSeparator());
        }
        return str.toString().trim();
    }

    private boolean checkRecordField(int index) throws Exception {
        if (!table.isEmpty()) {
            RotaryFormRecord record = getRecord(index);
            for (Field field : record.getClass().getDeclaredFields()) {
                if (!(field.getName().equals("STRING_FIELDS") || field.getName().equals("followup"))) {
                    StringBuilder getter = new StringBuilder();
                    getter.append("get");
                    getter.append(field.getName().substring(0, 1).toUpperCase());
                    getter.append(field.getName().substring(1));
                    try {
                        Method method = record.getClass().getDeclaredMethod(getter.toString());
                        if (String.valueOf(method.invoke(record)) == null) {
                            return false;
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
            }
            return true;
        }
        throw new Exception("There are no records in current table");
    }

    public void setRecord(int index, RotaryFormRecord record) {
        table.add(index, record);
    }
}