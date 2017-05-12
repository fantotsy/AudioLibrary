package ua.audiolibrary.web.controllers;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Controller
public class WelcomeController {

    @RequestMapping(value = "/")
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "Hi, user!");
        return "home";
    }

    @RequestMapping(value = "/play", method = RequestMethod.GET)
    public String playAudio(ModelMap model, @RequestParam("audio") String audioName) {
        playSound(audioName);
        model.addAttribute("greeting", "Audio, play!");
        return "home";
    }

    public void playSound(String audioName) {
        String baseFolderPath = "C:\\Users\\Anton_Tsymbal\\Downloads\\";

        try {
            FileInputStream fileInputStream = new FileInputStream(baseFolderPath + audioName);
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