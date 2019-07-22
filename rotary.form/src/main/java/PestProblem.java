/*
   *************************************************************************************************
   Program: PestProblem.java
   Repository Name: Rotary-Form
   Date Created: 03-Jul-19
   Program Description: This is a field of the rotary form that holds the data on what pests were
   of concern in that unit.
   *************************************************************************************************
*/
public class PestProblem {
    private static final String[] PESTS = {"Rodents", "Mice", "Ants"};
    private boolean[] pestInfo = new boolean[PESTS.length];
    private String others;

    /**
     * PestProblem -
     * Default constructor. Initializes instance variables with default values
     */
    PestProblem() {
        others = "none";
    }

    public PestProblem(boolean[] booleans) {
        pestInfo = booleans;
        others = "none";
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
    public int setOthers(String others) {
        if (!others.isEmpty()) {
            this.others = others;
            return 1;
        }
        return -1;

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
        if (pestIndex < PESTS.length) {
            pestInfo[pestIndex] = bool;
            return 1;
        }
        return -1;
    }

    /**
     * toString -
     * This method returns a delimited string with all the data from the object
     *
     * @return -- String object
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\"");
        for (int i = 0; i < PESTS.length; ++i) {
            if(pestInfo[i]) {
                str.append(PESTS[i]).append(",");
            }
        }
        str.append(getOthers()).append("\"");
        return str.toString();
    }
}
