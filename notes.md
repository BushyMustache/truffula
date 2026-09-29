# Truffula Notes
As part of Wave 0, please fill out notes for each of the below files. They are in the order I recommend you go through them. A few bullet points for each file is enough. You don't need to have a perfect understanding of everything, but you should work to gain an idea of how the project is structured and what you'll need to implement. Note that there are programming techniques used here that we have not covered in class! You will need to do some light research around things like enums and and `java.io.File`.

PLEASE MAKE FREQUENT COMMITS AS YOU FILL OUT THIS FILE.

## App.java
- I'm assuming it uses methods from the TruffulaOptions class since it needs a TruffuklaOptions to be created.
- The main function of this file is to print something which is a directory tree.
- There'll be if statements to testify whether to "use color" or "show hidden files.

## ConsoleColor.java
- Each color shown below has a ANSI escape code (a line of code that identifies the color?).
- There's a constructor for a ConsoleColor object with a code String.
- There's a get method for the code in the ConsoleColor object.

## ColorPrinter.java / ColorPrinterTest.java
- It utilizes PrintStream, which I recall allows Java to write output into a file.
- The ConsoleColor class is needed for this file.
- Works similar to System.out.print() and System.out.println() except with color.
- In the test file, I should make tests that check if the output is printed correctly
for each color and each time I reset back to default color.

## TruffulaOptions.java / TruffulaOptionsTest.java
- Acts like settings for the TruffulaPrinter like an actual printer would have options.
- TruffulaPrinter will use this class to check if it should print hidden files or use color in the output.
- I should implement tests for if exceptions are thrown correctly and if the options are set correctly.

## TruffulaPrinter.java / TruffulaPrinterTest.java
- Prints a directory in a tree structure with indentation for each folder.
- Color is optional so ConsoleColor and ColorPrinter is used here too.
- I would have to implement color distinction and case-insensitive sorting.
- I should implements tests that check if the output the right colors (if there is), indentation, and
if it's sorted correctly.

## AlphabeticalFileSorter.java
- The class that'll sort the files by name alphabetically while ignoring case.
- This will probably be the helper method for when I print sorted output in TruffulaPrinter.
- It returns a File[] so I assume this should be used after I print to a file.