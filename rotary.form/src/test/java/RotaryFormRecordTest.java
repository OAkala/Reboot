/*
   *************************************************************************************************
   Program: RotaryFormRecordTest.java
   Repository Name: Reboot
   Date Created: 19-Jul-19
   Program Description: This file contains all the necessary test to ensure that the
   RotaryFormRecord file, and subsequentlu the PestProblem file, are working as expected.
   *************************************************************************************************
*/

import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class RotaryFormRecordTest extends CommonTest {

    @Test
    public void othersShouldHaveSetterAndGetter() {
        String expected = "bees";
        pestProblem.setOthers(expected);
        record.setOthers(expected);

        String finalExpected = expected;
        assertAll("othersSetterAndGetter",
                () -> assertEquals(finalExpected, pestProblem.getOthers()),
                () -> assertEquals(finalExpected, record.getOthers())
        );
        expected = "";
        assertEquals(-1, record.setOthers(expected), "Input checker not working.");
    }

    @Test
    public void pestInfoShouldHaveSetterAndGetter() {
        boolean[] expected = {true, true, false};
        IntStream.range(0, expected.length).forEach(i -> pestProblem.setPestInfo(i, expected[i]));
        IntStream.range(0, expected.length).forEach(i -> record.setPestInfo(i, expected[i]));

        assertAll("pestInfoSetterAndGetter",
                () -> assertArrayEquals(expected, pestProblem.getPestInfo()),
                () -> assertArrayEquals(expected, record.getPestInfo()),
                () -> assertEquals(-1, pestProblem.setPestInfo((1000), true))
        );
    }

    @Test
    public void unitAddressShouldHaveSetterAndGetter() {
        String expected = "";
        assertEquals(-1, record.setUnitAddress(expected), "Input checker not working.");
        expected = "1400-103";
        record.setUnitAddress(expected);
        assertEquals(expected, record.getUnitAddress());
    }

    @Test
    public void keyHomeShouldHaveSetterAndGetter() {
        String expected = "house";
        assertEquals(-1, record.setKeyHome(expected), "Input checker not working.");
        expected = "home";
        record.setKeyHome(expected);
        assertEquals(expected.toUpperCase(), record.getKeyHome());
    }

    @Test
    public void commentsShouldHaveSetterAndGetter() {
        String expected = "";
        assertEquals(-1, record.setComments(expected), "Input checker not working.");
        expected = "I will not go back to that unit";
        record.setComments(expected);
        assertEquals(expected, record.getComments());
    }

    @Test
    public void pestLevelShouldHaveSetterAndGetter() {
        String expected = "okay";
        assertEquals(-1, record.setPestLevel(expected), "Input checker not working.");
        expected = "low";
        record.setPestLevel(expected);
        assertEquals(expected.toUpperCase(), record.getPestLevel());
    }

    @Test
    public void houseKeepingShouldHaveSetterAndGetter() {
        String expected = "";
        assertEquals(-1, record.setHouseKeeping(expected), "Input checker not working.");
        expected = "terrible";
        record.setHouseKeeping(expected);
        assertEquals(expected, record.getHouseKeeping());
    }

    @Test
    public void followUpShouldHaveSetterAndGetter() {
        record.setFollowup(false);
        assertFalse(record.isFollowup());
    }

    @Test
    public void equalsMethod() {
        RotaryFormRecord other = new RotaryFormRecord();
        String unitAddress = "1400-101";
        other.setUnitAddress(unitAddress);
        assertNotEquals(record, other);

        other.setUnitAddress(this.unitAddress);
        assertEquals(record, record);
    }

    private void toStringDelimitedTokens() {
        int numTokens = record.toString().split(", ").length;
        assertEquals((record.getClass().getDeclaredFields().length + 1), numTokens);
    }

    private void toStringForNewRecord() {
        RotaryFormRecord test = new RotaryFormRecord();
        assertAll(
                () -> assertAll("check for empty string",
                        () -> assertFalse(super.toString().isEmpty()),
                        () -> assertFalse(test.toString().isEmpty())
                ),
                () -> {
                    String expected = "\"none\"";
                    assertEquals(expected, test.superToString());
                    expected = "null, null, false, null, null, none, \"none\"";
                    assertEquals(expected, test.toString());
                }
        );
    }

    private void toStringPestProblemChecker() {
        boolean[] booleans = {false, true, false};
        IntStream.range(0, booleans.length).forEach(i -> pestProblem.setPestInfo(i, booleans[i]));
        pestProblem.setOthers("beetles");
        String expected = "\"Mice,beetles\"";
        assertEquals(expected, pestProblem.toString());
    }

    private void toStringRotaryFormChecker() {
        record.setPestLevel("high");
        record.setComments("none");
        record.setHouseKeeping("terrible");
        String expected = "VU-205, KEY, true, HIGH, terrible, none, " + pestProblem.toString();
        assertEquals(expected, record.toString());
    }

    @Test
    public void toStringMethodTests() {
        toStringDelimitedTokens();
        toStringRotaryFormChecker();
        toStringPestProblemChecker();
        toStringForNewRecord();
    }

    @Test
    public void superToStringMethodTest() {
        PestProblem pestProblem1 = new PestProblem(record.getPestInfo());
        pestProblem1.setOthers(record.getOthers());
        assertEquals(pestProblem1.toString(), record.superToString());
    }

    @Test
    public void test() {
        Object[] arr = {};
        System.out.println(arr.length);
    }
}
