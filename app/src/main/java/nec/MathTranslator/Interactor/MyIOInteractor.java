package nec.MathTranslator.Interactor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * Subinteractor for I/O operations with the system.
 * 
 * TODO: If files/operations get heavier, each operation will have to be turned
 * into a runnable and passed to the ThreadController for multithreading. For
 * now though, the overhead most probably outweighs any potential benefits.
 */

public class MyIOInteractor
        implements MyInteractor {

    private MyMainInteractor mainInteractor;

    private final FileSystem fsDefault;
    private final Path customTranslationDatabasePath;

    public MyIOInteractor(MyMainInteractor mainInteractor) {
        /**
         * Ref to the mainInteractor for potential inter-interactor coordination
         * and for MainController/ThreadController access
         */ 
        this.mainInteractor = mainInteractor;
        
        /**
         * Get default FileSystem: Unclear if this is sufficient for cross-
         * platform functionality
         */
        fsDefault = FileSystems.getDefault();

        // Set Up Paths
        this.customTranslationDatabasePath = setCustomTranslationDatabasePath();
    }

    /**
     * Path initializations. Current paths required:
     * 1. Path to the translationMap text file.
     * 
     * TBD: 
     * 1. Save the translationMap as json instead of txt?
     * 2. Encryption required? Probably not.
     */
    private Path setCustomTranslationDatabasePath() {
        Path toRet = this.fsDefault
                .getPath("data", "customTranslations.txt");
        System.out.println(toRet.toString());
        System.out.println(toRet.toAbsolutePath().toString());
        try {
            Files.createDirectory(toRet.getParent());
            Files.createFile(toRet);
            return toRet;
        } catch (FileAlreadyExistsException ex) {
            System.out.println("File already exists.");
            return toRet;
        } catch (IOException e) {
            System.out.println("Something else went wrong.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * At what file size would a buffered reader and/or an input/outpout stream
     * combo with multithreading make sense? For smaller files the overhead of 
     * that is not worth it, so I'm sticking to single I/O operations of
     * read/write for now.
     */
    protected Map<String, String> loadTranslationMapFromFile() {
        try (BufferedReader reader = Files.newBufferedReader(this.customTranslationDatabasePath)) {
            Map<String, String> translationMap = new HashMap<>();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parsedLine = parseInput(line);
                translationMap.put(parsedLine[0], parsedLine[1]);
            }

            return translationMap;
        } catch (IOException e) {
            System.out.println("Someting went wrong.");
            return null;
        }
    }

    protected String[] parseInput(String input) {
        String[] parsed = new String[2];
        parsed = input.split(":");
        return parsed;
    }

    protected void saveTranslationMapToFile(final Map<String, String> transMap) {
        String toSave = "";
        for (String key : transMap.keySet()) {
            toSave = toSave.concat(key).concat(":").concat(transMap.get(key).concat("\n"));
        }

        toSave = toSave.trim();
        
        try (BufferedWriter writer = Files.newBufferedWriter(this.customTranslationDatabasePath)) {
            writer.write(toSave);
        } catch (IOException e) {
            System.out.println("Something went wrong.");
        }
    }
}
