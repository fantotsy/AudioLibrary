package ua.audiolibrary.infrastructure;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AudioPlayer {
    private static final String BASE_AUDIO_FOLDER_PATH = "C:\\Users\\Anton_Tsymbal\\Downloads\\";

    public static void play(String audioPath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(BASE_AUDIO_FOLDER_PATH + audioPath);
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