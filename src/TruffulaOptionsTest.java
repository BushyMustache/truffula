import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class TruffulaOptionsTest {

  @Test
  void testValidDirectoryIsSet(@TempDir File tempDir) throws FileNotFoundException {
    // Arrange: Prepare the arguments with the temp directory
    File directory = new File(tempDir, "subfolder");
    directory.mkdir();
    String directoryPath = directory.getAbsolutePath();
    String[] args = {"-nc", "-h", directoryPath};

    // Act: Create TruffulaOptions instance
    TruffulaOptions options = new TruffulaOptions(args);

    // Assert: Check that the root directory is set correctly
    assertEquals(directory.getAbsolutePath(), options.getRoot().getAbsolutePath());
    assertTrue(options.isShowHidden());
    assertFalse(options.isUseColor());
  }

  @Test
  void testDirectoryWithHiddenFilesNotShownAndColorNotUsed(@TempDir File tempDir) throws FileNotFoundException {
    File directory = new File(tempDir, "subfolder");
    directory.mkdir();
    String directoryPath = directory.getAbsolutePath();
    String[] args = {"-nc", directoryPath};

    TruffulaOptions options = new TruffulaOptions(args);

    assertFalse(options.isShowHidden());
    assertFalse(options.isUseColor());
  }

  @Test
  void testDirectoryWithHiddenFilesShownAndColorUsed(@TempDir File tempDir) throws FileNotFoundException {
    File directory = new File(tempDir, "subfolder");
    directory.mkdir();
    String directoryPath = directory.getAbsolutePath();
    String[] args = {"-h", directoryPath};

    TruffulaOptions options = new TruffulaOptions(args);

    assertTrue(options.isShowHidden());
    assertTrue(options.isUseColor());
  }

  @Test
  void testDirectoryWithHiddenFilesNotShownAndColorUsed(@TempDir File tempDir) throws FileNotFoundException {
    File directory = new File(tempDir, "subfolder");
    directory.mkdir();
    String directoryPath = directory.getAbsolutePath();
    String[] args = {directoryPath};

    TruffulaOptions options = new TruffulaOptions(args);

    assertFalse(options.isShowHidden());
    assertTrue(options.isUseColor());
  }

  @Test
  void testInvalidDirectoryThrowsException(@TempDir File tempDir) throws FileNotFoundException {
    File directory = new File(tempDir, "subfolder");
    directory.mkdir();
    String directoryPath = "directory.getAbsolutePath()";
    String[] args = {"-nc", "-h", directoryPath};

    assertThrows(FileNotFoundException.class, () -> new TruffulaOptions(args));
  }

  @Test
  void testNoDirectoryThrowsException(@TempDir File tempDir) throws FileNotFoundException {
    String[] args = {"-nc", "-h", "directoryPath"};

    assertThrows(FileNotFoundException.class, () -> new TruffulaOptions(args));
  }
}
