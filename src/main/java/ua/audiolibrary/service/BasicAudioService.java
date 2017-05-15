package ua.audiolibrary.service;

import org.springframework.stereotype.Service;
import ua.audiolibrary.domain.Audio;
import ua.audiolibrary.infrastructure.AudioPlayer;
import ua.audiolibrary.repository.AudioRepository;

import javax.annotation.Resource;

@Service(value = "basicAudioService")
public class BasicAudioService implements AudioService {
    @Resource(name = "inMemoryAudioRepository")
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

    @Override
    public void playAudio(String audioPath) {
        AudioPlayer.play(audioPath);
    }
}