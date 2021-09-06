package com.javarush.task.task18.task1825;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        try {
            List<Path> files = readFileNames();
            Collections.sort(files);
            Path resultFileName = getFileNameWithoutPart(files.get(0));
            writeDataInFileFromOtherFiles(resultFileName, files);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Path getFileNameWithoutPart(Path path) {
        Path dir = path.getParent();
        Path fileName = path.getFileName();
        String[] fileParts = fileName.toString().split("\\.");
        if (fileParts.length == 0 || !fileParts[fileParts.length - 1].contains("part")) {
            return path;
        }

        StringBuilder resultFileName = new StringBuilder();

        for (int i = 0; i < fileParts.length - 1; i++) {
            resultFileName.append(fileParts[i]);
            if (i != fileParts.length - 2) {
                resultFileName.append(".");
            }
        }
        return dir.resolve(resultFileName.toString());
    }

    private static List<Path> readFileNames() throws IOException {
        List<Path> files = new ArrayList<>();
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while (!(line = console.readLine()).equals("end")) files.add(Paths.get(line));
        }
        return files;
    }

    private static void writeDataInFileFromOtherFiles(Path filePath, List<Path> files) throws IOException {
        try (OutputStream fileOut = Files.newOutputStream(filePath)) {
            for (Path file : files) {
                fileOut.write(Files.readAllBytes(file));
            }
        }
    }
}
