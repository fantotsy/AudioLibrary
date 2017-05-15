package ua.audiolibrary.service;

import ua.audiolibrary.domain.Audio;

public interface AudioService {
    Audio findByFilePath(String path);
}