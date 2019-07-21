/*
   *************************************************************************************************
   Program: RotaryForm.java
   Repository Name: Rotary-Form
   Date Created: 08-Jul-19
   Program Description: This class represents a the pdf form that is being created.
   *************************************************************************************************
*/
import java.text.SimpleDateFormat;
import java.util.*;

public class RotaryForm extends RotaryFormTable {
    private String propertyName;
    private Date dateCreated;

    public RotaryForm() {
        dateCreated = new Date();
    }

    public RotaryForm(String propertyName) {
        this.propertyName = propertyName;
        dateCreated = new Date();
    }

    public RotaryForm(String propertyName, String unit, String keyHome, String pestLevel,
                      String houseKeeping) {
        this.propertyName = propertyName;
        dateCreated = new Date();
        table.add(new RotaryFormRecord(unit, keyHome, pestLevel, houseKeeping));
    }

    public String getFormName() {
        return getProperty_Name() + "-" + DateToString();
    }

    public String getProperty_Name() {
        return propertyName;
    }

    public void setProperty_Name(String property_Name) {
        this.propertyName = property_Name;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String DateToString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.format(getDateCreated());
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(getProperty_Name()).append(System.lineSeparator());
        str.append(getDateCreated()).append(System.lineSeparator()).append(System.lineSeparator());
        str.append(super.toString());
        return str.toString();
    }
}
