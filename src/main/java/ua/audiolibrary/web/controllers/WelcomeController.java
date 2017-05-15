package ua.audiolibrary.web.controllers;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.audiolibrary.domain.Audio;
import ua.audiolibrary.service.AudioService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Controller(value = "welcomeController")
public class WelcomeController {
    @Autowired
    private AudioService audioService;

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

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public void test() {
        System.out.println("TEST");
        Audio audio = audioService.findByFilePath("C:\\Users\\Anton_Tsymbal\\Downloads\\Gillicuddy_-_05_-_Springish.mp3");
        System.out.println(audio.getFileName());
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