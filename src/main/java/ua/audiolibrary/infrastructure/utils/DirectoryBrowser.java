package ua.audiolibrary.infrastructure.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryBrowser {
    private static final String BASE_AUDIO_DIRECTORY_PATH = "D:\\Other\\";

    public static List<String> directorySubDirectories(String directoryPath) {
        List<String> result = new ArrayList<>();
        File currentDirectory = new File(BASE_AUDIO_DIRECTORY_PATH + directoryPath);
        File[] directoryEntries = currentDirectory.listFiles();
        for (File entry : directoryEntries) {
            if (entry.isDirectory()) {
                result.add(entry.getName());
            }
        }
        return result;
    }
}