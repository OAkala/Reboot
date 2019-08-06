/*
   *************************************************************************************************
   Program: CommonTest.java
   Repository Name: Olalekan AKala
   Date Created: 19-Jul-19
   Program Description:
   *************************************************************************************************
*/

import org.junit.Before;

import java.util.stream.IntStream;

public class CommonTest {

    protected final String others = "wasps";
    protected final boolean[] pestInfo = {true, false, true};
    protected PestProblem pestProblem;
    protected RotaryFormRecord record;
    protected RotaryFormTable table;
    protected final String unitAddress = "VU-205";
    protected final String keyHome = "KEY";
    protected final String pestLevel = "medium";
    protected final String houseKeeping = "decent";
    protected final String comments = "The unit had live activity. Intensive treatment required.";
    protected final boolean followUp = true;
    protected final int count = 4;

    @Before
    public void beforeCommonTestFormRecord() {
        pestProblem = new PestProblem(pestInfo);
        pestProblem.setOthers(others);

        record = new RotaryFormRecord(unitAddress, keyHome, pestLevel, houseKeeping);
        record.setComments(comments);
        record.setOthers(others);
        record.setFollowup(followUp);
        IntStream.range(0, pestInfo.length).forEach(i -> record.setPestInfo(i, pestInfo[i]));
    }

    @Before
    public void beforeCommonTestFormTable() {
        table = new RotaryFormTable(record);
    }
}
