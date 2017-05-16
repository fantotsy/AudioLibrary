package ua.audiolibrary.infrastructure.utils;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AudioPlayer {
    private static final String AUDIO_DIRECTORIES_PATH = "D:\\Other\\audio_library\\";

    public static void play(String audioPath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(AUDIO_DIRECTORIES_PATH + audioPath);
            Player player = new Player(fileInputStream);

            new Thread() {
                @Override
                public void run() {
                    try {
                        player.play();
                    } catch (JavaLayerException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

        } catch (FileNotFoundException | JavaLayerException e) {
            e.printStackTrace();
        }
    }
}