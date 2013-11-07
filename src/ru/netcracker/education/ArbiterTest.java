package ru.netcracker.education;


import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Никита
 * Date: 07.11.13
 * Time: 11:32
 * To change this template use File | Settings | File Templates.
 */
public class ArbiterTest {
    private Arbiter SUT = new Arbiter(0,2,0,2,2);

    @Test
    public void Test1() {
        SUT.arrangeMatch();
    }


}
