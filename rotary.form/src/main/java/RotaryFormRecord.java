/*
   *************************************************************************************************
   Program: RotaryFormRecord.java
   Repository Name: Rotary-Form
   Date Created: 03-Jul-19
   Program Description: This class is extends the PestProblem class and contains all the
   necessary data required in a record on the form.
   *************************************************************************************************
*/
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.*;
import java.util.Objects;
import java.util.stream.Stream;

public class RotaryFormRecord extends PestProblem implements Cloneable, Comparable {
    private String unitAddress;
    private String keyHome;
    private boolean followup;
    private String pestLevel;
    private String houseKeeping;
    private String comments;
    private enum Level {
        LOW(1),
        MEDIUM(2),
        HIGH(3);

        private final int levelCode;

        Level(int levelCode) {
            this.levelCode = levelCode;
        }

        public int getLevelCode() {
            return this.levelCode;
        }
    }

    public RotaryFormRecord() {
        comments = "NONE";
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
        comments = "NONE";
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
                this.unitAddress = unitAddress.toUpperCase();
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
        int result = 1;
        if (keyHome != null) {
            if (keyHome.equalsIgnoreCase("key") || keyHome.equalsIgnoreCase("home")) {
                this.keyHome = keyHome.toUpperCase();
            } else {
                result = -1;
            }
        } else {
            this.keyHome = null;
        }
        return result;
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
        int result = 1;
        if (pestLevel != null) {
            if (Stream.of("low", "medium", "high").anyMatch(pestLevel::equalsIgnoreCase)) {
                this.pestLevel = pestLevel.toUpperCase();
            } else {
                result = -1;
            }
        } else {
            this.pestLevel = null;
        }
        return result;
    }

    public String getHouseKeeping() {
        return houseKeeping;
    }

    /**
     * @param houseKeeping
     * @return
     */
    public int setHouseKeeping(String houseKeeping) {
        int result = 1;
        if (houseKeeping != null) {
            if (!houseKeeping.isEmpty()) {
                this.houseKeeping = houseKeeping.toUpperCase();
            } else {
                result = -1;
            }
        } else {
            this.houseKeeping = null;
        }
        return result;
    }

    /**
     * @return
     */
    public String getComments() {
        return comments;
    }

    public int setComments(String comments) {
        int result = 1;
        if (!comments.isEmpty()) {
            this.comments = comments;
        } else {
            result = -1;
        }
        return result;
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

    public String superToString() {
        return super.toString();
    }

    public boolean hasNullField() {
        return (unitAddress == null) || (pestLevel == null) || (keyHome == null) || (houseKeeping == null);
    }

    public RotaryFormRecord clone() throws CloneNotSupportedException {
        return (RotaryFormRecord) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (this == o) {
            result = true;
        } else {
            if (o instanceof RotaryFormRecord) {
                if (super.equals(o)) {
                    RotaryFormRecord that = (RotaryFormRecord) o;
                    result = isFollowup() == that.isFollowup() &&
                            Objects.equals(getUnitAddress(), that.getUnitAddress()) &&
                            Objects.equals(getKeyHome(), that.getKeyHome()) &&
                            Objects.equals(getPestLevel(), that.getPestLevel()) &&
                            Objects.equals(getHouseKeeping(), that.getHouseKeeping()) &&
                            getComments().equals(that.getComments());
                }
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitAddress, keyHome, followup, pestLevel, houseKeeping, comments);
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     *
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     *
     * <p>Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(@NotNull Object o) {
        int result;
        if (o instanceof RotaryFormRecord) {
            RotaryFormRecord that = (RotaryFormRecord) o;
            if (this.unitAddress.compareTo(that.unitAddress) != 0) {
                result = this.unitAddress.compareTo(that.unitAddress);
            } else {
                result = Integer.compare(Level.valueOf(this.getPestLevel()).levelCode, Level.valueOf(that.getPestLevel()).levelCode);
            }
        } else {
            throw new ClassCastException();
        }
        return result;
    }
}


