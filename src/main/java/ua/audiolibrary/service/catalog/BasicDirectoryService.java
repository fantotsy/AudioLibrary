package ua.audiolibrary.service.catalog;

import org.springframework.stereotype.Service;
import ua.audiolibrary.infrastructure.utils.DirectoryBrowser;

import java.util.List;

@Service(value = "basicDirectoryService")
public class BasicDirectoryService implements DirectoryService {

    @Override
    public List<String> directorySubDirectories(String directoryPath) {
        return DirectoryBrowser.directorySubDirectories(directoryPath);
    }
}