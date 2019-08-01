/*
   *************************************************************************************************
   Program: PestProblem.java
   Repository Name: Rotary-Form
   Date Created: 03-Jul-19
   Program Description: This is a field of the rotary form that holds the data on what pests were
   of concern in that unit.
   *************************************************************************************************
*/
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;

public class PestProblem {
    private static final String[] PESTS = {"RODENTS", "MICE", "ANTS"};
    private boolean[] pestInfo = new boolean[PESTS.length];
    private String others;

    /**
     * PestProblem -
     * Default constructor. Initializes instance variables with default values
     */
    PestProblem() {
        others = "NONE";
    }

    public PestProblem(boolean[] booleans) {
        pestInfo = booleans;
        others = "NONE";
    }

    /**
     * getOthers -
     * Returns value of others field.
     *
     * @return -- String object
     */
    public String getOthers() {
        return others;
    }

    /**
     * setOthers -
     * Sets value of others field. If value is successfully set then it returns '1' otherwise it
     * returns '-1'
     *
     * @param others -- String object
     * @return -- int value
     */
    public int setOthers(@NotNull String others) {
        int result = 1;
        if (!others.isEmpty()) {
            this.others = others.toUpperCase();
        } else {
            result = -1;
        }
        return result;
    }

    /**
     * getPest -
     * Returns data representing the pests in the record
     *
     * @return -- boolean[]
     */
    public boolean[] getPestInfo() {
        return pestInfo;
    }


    /**
     * setPests -
     * Sets the data values for the boolean array representing the pests
     *
     * @param pestIndex -- Array index
     * @param bool      -- data value
     * @return -- int value
     */
    public int setPestInfo(int pestIndex, boolean bool) {
        int result = 1;
        if (pestIndex < PESTS.length) {
            pestInfo[pestIndex] = bool;
        } else {
            result = -1;
        }
        return result;
    }

    /**
     * toString -
     * Returns a string representation of the contents of the PestProblem object.
     * The string representation consists of a list of the array's elements and the value of the
     * others field, enclosed in double quotes (<tt>"\"\""</tt>).  Adjacent elements are
     * separated by the characters <tt>","</tt> (a comma, no space).
     *
     * @return -- a string representation of the object
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\"");
        for (int i = 0; i < PESTS.length; ++i) {
            if (pestInfo[i]) {
                str.append(PESTS[i]).append(",");
            }
        }
        str.append(getOthers()).append("\"");
        return str.toString();
    }

    /**
     * equals -
     * Compares this string to the specified object.  The result is {@code
     * true} if and only if the argument is not {@code null} and is a {@code
     * PestProblem} object that represents the same field values as this object.
     *
     * @param o -- The object to compare this (@code PestProblem) against.
     * @return -- {@code true} if the given object represents a {@code String equivalent to this
     * string, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PestProblem)) return false;
        PestProblem that = (PestProblem) o;
        return Arrays.equals(pestInfo, that.pestInfo) && others.equals(that.others);
    }

    /**
     * hashcode -
     * Returns a hash code for this pest problem.
     * (The hash value of a new or default PestProblem object is 75724317)
     *
     * @return -- a hash code for this object
     *
     * @see Arrays#hashCode(boolean[])
     * @see String#hashCode()
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(getOthers());
        result = 31 * result + Arrays.hashCode(getPestInfo());
        return result;
    }
}
