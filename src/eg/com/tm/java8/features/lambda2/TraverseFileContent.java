package eg.com.tm.java8.features.lambda2;

import static java.lang.System.out;
import static java.nio.file.Files.exists;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import static java.nio.file.Paths.get;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Conrad Peres
 */
public class TraverseFileContent {

    private static final Logger LOGGER = getLogger(TraverseFileContent.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Path path = get("src", "resources", "data.txt");

            if (exists(path, NOFOLLOW_LINKS)) {

                LOGGER.config(path.toAbsolutePath().toString());
                LOGGER.info(path.toAbsolutePath().toString());
                List<String> lines = readAllLines(path, StandardCharsets.ISO_8859_1);

                // Traversing with for each
                for (String line : lines)
                    out.println(line);
                
                // Traversing with iterator
                Iterator<String> itr = lines.iterator();

                while (itr.hasNext())
                    out.println(itr.next());
                
                //------------------------------------
                // Traversing with lambda new forEach
                lines.forEach(line -> out.print(line));

                // or with streams
                lines.stream().forEach(line -> out.print(line));

            } else {

                LOGGER.log(SEVERE, "{0} , Doesn't exists", path.toAbsolutePath());
            }
        }
        catch (IOException ex) {
        	ex.printStackTrace();
            LOGGER.severe(ex.getMessage());
        }
    }
}