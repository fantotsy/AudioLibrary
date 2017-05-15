package ua.audiolibrary.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.audiolibrary.domain.Audio;
import ua.audiolibrary.service.AudioService;

import javax.annotation.Resource;

@Controller(value = "welcomeController")
public class WelcomeController {
    @Resource(name = "basicAudioService")
    private AudioService audioService;

    @RequestMapping(value = "/")
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "Hi, user!");
        return "home";
    }

    @RequestMapping(value = "/play", method = RequestMethod.GET)
    public String playAudio(ModelMap model, @RequestParam("audio") String audioName) {
        audioService.playAudio(audioName);
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


}