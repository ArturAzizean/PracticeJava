package Practicks;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class TestFiles {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/home/artur/file");

        Files.walkFileTree(path, new MyfileVisitor());
        String a ;
        byte[]bytes = new byte[0];


    }
}

class MyfileVisitor extends SimpleFileVisitor<Path>{

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.getFileName());

        return FileVisitResult.CONTINUE;
    }
}
