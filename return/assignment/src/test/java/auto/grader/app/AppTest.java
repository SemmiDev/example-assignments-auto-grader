package auto.grader.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    App app = new App();

    @Test
    public void addTwoNumbers() {
        int result = app.addTwoNumbers(1,2);
        assertEquals(3, result);
    }

    @Test
    public void addManyNumbers() {
        int[] nums = new int[]{1,2,3,4,5};
        int result = app.addManyNumbers(nums);
        assertEquals(15, result);
    }

    @Test
    public void addManyNumbers1() {
        int[] nums = new int[]{1,2,3,4};
        int result = app.addManyNumbers(nums);
        assertEquals(10, result);
    }

    @Test
    public void addManyNumbers2() {
        int[] nums = new int[]{1,1,1,1,1};
        int result = app.addManyNumbers(nums);
        assertEquals(5, result);
    }

    @Test
    public void addManyNumbers3() {
        int[] nums = new int[]{1,10,-2,-3};
        int result = app.addManyNumbers(nums);
        assertEquals(6, result);
    }    

    @Test
    public void toUpperCase() {
        String result = app.toUpperCase("sammi");
        assertEquals("SAMMI", result);
    }
}
