package ua.audiolibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.audiolibrary.domain.Audio;
import ua.audiolibrary.repository.AudioRepository;

@Service(value = "audioService")
public class BasicAudioService implements AudioService {
    @Autowired
    private AudioRepository audioRepository;

    @Override
    public Audio findByFilePath(String path) {
        Audio result = null;
        try {
            result = audioRepository.findByFilePath(path);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}