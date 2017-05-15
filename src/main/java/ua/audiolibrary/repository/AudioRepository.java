package ua.audiolibrary.repository;

import ua.audiolibrary.domain.Audio;

public interface AudioRepository {
    Audio findByFilePath(String path);
}