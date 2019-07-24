/*
   *************************************************************************************************
   Program: RotaryFormRecord.java
   Repository Name: Rotary-Form
   Date Created: 03-Jul-19
   Program Description: This class is extends the PestProblem class and contains all the
   necessary data required in a record on the form.
   *************************************************************************************************
*/
import java.lang.reflect.*;
import java.util.stream.Stream;

public class RotaryFormRecord extends PestProblem {
    private String unitAddress;
    private String keyHome;
    private boolean followup;
    private String pestLevel;
    private String houseKeeping;
    private String comments;

    public RotaryFormRecord() {
        comments = "none";
    }

    /**
     *
     * @param unitAddress
     * @param keyHome
     * @param pestLevel
     * @param houseKeeping
     */
    public RotaryFormRecord(String unitAddress, String keyHome, String pestLevel,
                            String houseKeeping) {
        setUnitAddress(unitAddress);
        setKeyHome(keyHome);
        setPestLevel(pestLevel);
        setHouseKeeping(houseKeeping);
        comments = "none";
    }

    /**
     * @return
     */
    public String getUnitAddress() {
        return unitAddress;
    }

    /**
     * @param unitAddress
     * @return
     */
    public int setUnitAddress(String unitAddress) {
        if (unitAddress != null) {
            if (!unitAddress.isEmpty()) {
                this.unitAddress = unitAddress;
                return 1;
            }
            return -1;
        }
        this.unitAddress = null;
        return 1;
    }

    public String getKeyHome() {
        return keyHome;
    }

    public int setKeyHome(String keyHome) {
        if (keyHome != null) {
            if (keyHome.equalsIgnoreCase("key") || keyHome.equalsIgnoreCase("home")) {
                this.keyHome = keyHome.toUpperCase();
                return 1;
            }
            return -1;
        }
        this.keyHome = null;
        return 1;
    }

    public boolean isFollowup() {
        return followup;
    }

    public void setFollowup(boolean followup) {
        this.followup = followup;
    }

    public String getPestLevel() {
        return pestLevel;
    }

    /**
     * @param pestLevel
     * @return
     */
    public int setPestLevel(String pestLevel) {
        if (pestLevel != null) {
            if (Stream.of("low", "medium", "high").anyMatch(pestLevel::equalsIgnoreCase)) {
                this.pestLevel = pestLevel.toUpperCase();
                return 1;
            }
            return -1;
        }
        this.pestLevel = null;
        return 1;
    }

    public String getHouseKeeping() {
        return houseKeeping;
    }

    /**
     * @param houseKeeping
     * @return
     */
    public int setHouseKeeping(String houseKeeping) {
        if (houseKeeping != null) {
            if (!houseKeeping.isEmpty()) {
                this.houseKeeping = houseKeeping;
                return 1;
            }
            return -1;
        }
        this.houseKeeping = null;
        return 1;
    }

    /**
     * @return
     */
    public String getComments() {
        return comments;
    }

    public int setComments(String comments) {
        if (!comments.isEmpty()) {
            this.comments = comments;
            return 1;
        }
        return -1;
    }

    /**
     * @param field
     * @param data
     */
    public void fill(int field, String data) {
        switch (field) {
            case 1:
                setUnitAddress(data);
            case 2:
                setOthers(data);
            case 3:
                setKeyHome(data);
            case 5:
                setPestLevel(data);
            case 6:
                setHouseKeeping(data);
            case 7:
                setComments(data);
        }
    }

    public void fill(int field, boolean bool) {
        if (field == 4) {
            setFollowup(bool);
        }
    }

    /**
     *
     * @return
     */
    public String toString() {
            StringBuilder str = new StringBuilder();

            for (Field field : getClass().getDeclaredFields()) {
                String value = null;
                StringBuilder getter = new StringBuilder();
                if (field.getGenericType().getTypeName().equalsIgnoreCase("boolean")) { //modify this
                    getter.append("is");
                } else {
                    getter.append("get");
                }
                getter.append(field.getName().substring(0, 1).toUpperCase());
                getter.append(field.getName().substring(1));
                try {
                    Method method = getClass().getDeclaredMethod(getter.toString());
                    value = String.valueOf(method.invoke(this));
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                str.append(value);
                str.append(", ");
            }
            str.append(super.toString());
            return str.toString();
    }

    public boolean equals(Object o) {
        if (o instanceof RotaryFormRecord) {
            RotaryFormRecord other = (RotaryFormRecord) o;
            return getUnitAddress().equals((other.getUnitAddress()));
        }
        return false;
    }

    public String superToString() {
        return super.toString();
    }
}


