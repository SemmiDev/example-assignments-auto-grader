// tidak boleh diubah
package auto.grader.app;


public class App 
{
    public int addTwoNumbers(int a, int b) {
        return a + b;
    }

    public int addManyNumbers(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        return total;
    }

    public String toUpperCase(String text) {
        return text.toUpperCase();
    }
}
