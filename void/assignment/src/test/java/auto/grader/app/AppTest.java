package auto.grader.app;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;

import java.io.PrintStream;

public class AppTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    App app = new App();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void addTwoNumbers() {
        app.addTwoNumbers(1,2);
        
        // Assert
        String expectedOutput = "3";
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    public void addTwoNumbers2WithNewLine() {
        app.addTwoNumbers2WithNewLine(5,2);
        
        // Assert
        String expectedOutput = "7\n";
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    public void printOddNumber() {
        app.printOddNumbers(1,10);
        
        // Assert
        String expectedOutput = "1\n3\n5\n7\n9\n";
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}
