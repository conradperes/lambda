package eg.com.tm.java8.features.lambda2.mthdRefs;

import static java.lang.System.out;
import static java.nio.file.Files.exists;
import static java.nio.file.Files.newDirectoryStream;
import static java.nio.file.Files.notExists;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import static java.nio.file.Paths.get;
import static java.util.logging.Logger.getLogger;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mkyong.java8.methoRef.FilesDirTests;

/**
 *
 * @author mohamed_taman
 */
public class MethodReference {

    private static final Path path = get("src", "",
                                         "eg/com/tm/java8/features/lambda2/mthdRefs");

    private static final Logger logger = getLogger(MethodReference.class.getName());

    private void doFilterAndPrintPath(Predicate<Path> pred) {
        try {
            newDirectoryStream(path).forEach(p -> {
                if (pred.test(p)) {
                    out.println(p.getFileName());
                }
            });
        }
        catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    private void doPrint() {

        // Static method reference
        doFilterAndPrintPath(FilesDirTests::isAccessible);

        // Instance method reference
        doFilterAndPrintPath(this::isNotExists);

    }

    private boolean isNotExists(Path p) {
        return notExists(p, new LinkOption[]{NOFOLLOW_LINKS});
    }

    private boolean isExists(Path p) {
        return exists(p, new LinkOption[]{NOFOLLOW_LINKS});
    }

    public static void main(String[] args) {

        MethodReference mr = new MethodReference();

        mr.doFilterAndPrintPath(mr::isExists);

        mr.doPrint();

    }

}