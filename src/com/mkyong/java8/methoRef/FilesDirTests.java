package com.mkyong.java8.methoRef;

import java.nio.file.Path;
import static java.nio.file.Files.isRegularFile;
import static java.nio.file.Files.isExecutable;
import static java.nio.file.Files.isReadable;
import static java.nio.file.Files.isWritable;

public class FilesDirTests {
	

    public static boolean isAccessible(Path p) {
        return isRegularFile(p) & isReadable(p)
                & isExecutable(p) & isWritable(p);

    }

}
