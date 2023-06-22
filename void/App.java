// tidak boleh diubah
package auto.grader.app;


public class App 
{
    public void addTwoNumbers(int a, int b) {
        int sum =  a + b;
        System.out.print(sum);
    }

    public void addTwoNumbers2WithNewLine(int a, int b) {
        int sum =  a + b;
        System.out.println(sum);
    }


    public void printOddNumbers(int from, int to) {
        for (int i = from; i <= to; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }
}
