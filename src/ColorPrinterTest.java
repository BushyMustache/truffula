import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ColorPrinterTest {

  @Test
  void testPrintlnWithRedColorAndReset() {
    // Arrange: Capture the printed output
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    ColorPrinter printer = new ColorPrinter(printStream);
    printer.setCurrentColor(ConsoleColor.RED);

    // Act: Print the message
    String message = "I speak for the trees";
    printer.println(message);


    String expectedOutput = ConsoleColor.RED + "I speak for the trees" + System.lineSeparator() + ConsoleColor.RESET;

    // Assert: Verify the printed output
    assertEquals(expectedOutput, outputStream.toString());
  }

  @Test
  void checkingIfColorIsResetAfterPrintlnWithRedColor() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    ColorPrinter printer = new ColorPrinter(printStream);
    printer.setCurrentColor(ConsoleColor.RED);

    String message = "I speak for the trees";
    printer.println(message);
    printer.println(message);

    String expectedOutput = ConsoleColor.RED + "I speak for the trees" + System.lineSeparator() + ConsoleColor.RESET + 
    ConsoleColor.WHITE + "I speak for the trees" + System.lineSeparator() + ConsoleColor.RESET;

    assertEquals(expectedOutput, outputStream.toString());
  }

  @Test
  void testPrintlnWithBlueColorAndNoReset() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    ColorPrinter printer = new ColorPrinter(printStream);
    printer.setCurrentColor(ConsoleColor.BLUE);

    String message = "I speak for the trees";
    printer.println("I am the Lorax", false);
    printer.println(message, false);


    String expectedOutput = ConsoleColor.BLUE + "I am the Lorax" + System.lineSeparator() + 
    ConsoleColor.BLUE + "I speak for the trees" + System.lineSeparator();

    assertEquals(expectedOutput, outputStream.toString());
  }

  @Test 
  void testPrintWithResetAndTestPrintWithNoReset() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    ColorPrinter printer = new ColorPrinter(printStream);
    printer.setCurrentColor(ConsoleColor.YELLOW);

    String firstPart = "I am the Lorax. ";
    String secondPart = "I speak for the trees, ";
    String thirdPart = "for the trees have no tongues.";
    String author = "- by Dr. Seuss";

    printer.print(firstPart);
    printer.setCurrentColor(ConsoleColor.GREEN);
    printer.print(secondPart, false);
    printer.println(thirdPart);
    printer.print(author);

    String expectedOutput = ConsoleColor.YELLOW + "I am the Lorax. " + ConsoleColor.RESET + 
    ConsoleColor.GREEN + "I speak for the trees, " + 
    ConsoleColor.GREEN + "for the trees have no tongues." + System.lineSeparator() + ConsoleColor.RESET +
    ConsoleColor.WHITE + "- by Dr. Seuss" + ConsoleColor.RESET;

    assertEquals(expectedOutput, outputStream.toString());
  }
}
