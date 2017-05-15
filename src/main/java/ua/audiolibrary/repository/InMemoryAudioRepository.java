package ua.audiolibrary.repository;

import org.springframework.stereotype.Repository;
import ua.audiolibrary.domain.Audio;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository(value = "inMemoryAudioRepository")
public class InMemoryAudioRepository implements AudioRepository {
    private final List<Audio> audios;

    public InMemoryAudioRepository() {
        audios = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        audios.add(new Audio("C:\\Users\\Anton_Tsymbal\\Downloads\\Gillicuddy_-_05_-_Springish.mp3",
                "Gillicuddy_-_05_-_Springish"));
    }

    @Override
    public Audio findByFilePath(String path) {
        if (audios.isEmpty()) {
            throw new IllegalStateException("Audios list is empty!");
        } else if (path == null) {
            throw new IllegalStateException("Path is empty!");
        } else {
            for (Audio audio : audios) {
                if (path.equals(audio.getFilePath())) {
                    return audio;
                }
            }
            throw new RuntimeException("Audio by path not found.");
        }
    }
}