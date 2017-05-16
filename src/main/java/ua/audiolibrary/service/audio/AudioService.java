package ua.audiolibrary.service.audio;

import ua.audiolibrary.domain.Audio;

public interface AudioService {
    Audio findByFilePath(String path);

    void playAudio(String audioPath);
}