import org.example.CaesarCipherDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;


public class OutputTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    // test program running for 0.2 seconds

    @Test
    public void testRunExecution() {
        // Set the inputs (12-character string and a fixed seed value)
        String input = "HELLOWORLD!!\n7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        // Call the main method
        CaesarCipherDriver.main(null);
        // Extract the output
        String output = outputStreamCaptor.toString();
        System.out.println(output);
        // Check if the output contains the expected ciphertext
        Assertions.assertTrue(true, "Output: " + output);
    }
    @Test
    public void testAnyCiphertextOutput() {
        // Set the inputs (12-character string and a fixed seed value)
        String input = "HELLOWORLD!!\n7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Call the main method
        CaesarCipherDriver.main(null);

        // Extract the output
        String output = outputStreamCaptor.toString();

        // Check if the output contains the expected ciphertext
        Assertions.assertTrue(output.contains("Ciphertext: "), "Expected: Ciphertext: \nActual: " + output);
    }
    @Test
    public void testBaseCiphertextOutput() {
        // Set the inputs (12-character string and a fixed seed value)
        String input = "HELLOWORLD!!\n7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Call the main method
        CaesarCipherDriver.main(null);

        // Extract the output
        String output = outputStreamCaptor.toString();

        // Check if the output contains the expected ciphertext
        Assertions.assertTrue(output.contains("Ciphertext: "), "Expected: Ciphertext: \nActual: " + output);
        String[] parts = output.split("Ciphertext: ");
        if (parts.length > 1) {
            String cipherText = parts[1].split("\n")[0].trim();
            Assertions.assertEquals("XQOVWWGEXZKO", cipherText, "Expected: XQOVWWGEXZKO\nActual: " + cipherText);
        } else {
            Assertions.fail("Ciphertext not found in output");
        }
    }
    @Test
    public void testFailCiphertextOutput() {
        // Set the inputs (12-character string and a fixed seed value)
        String input = "HELLOME";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Call the main method
        CaesarCipherDriver.main(null);
        // Extract the output
        String output = outputStreamCaptor.toString();
        String expected = "Please read directions and rerun it again!";
        // Check if the output contains the expected ciphertext
        Assertions.assertTrue(output.contains(expected), "Expected: " + expected + "\nActual: " + output);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
        System.setIn(System.in);
    }
}


