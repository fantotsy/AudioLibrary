package ua.audiolibrary.service.catalog;

import java.util.List;

public interface DirectoryService {
    List<String> directorySubDirectories(String catalogPath);
}