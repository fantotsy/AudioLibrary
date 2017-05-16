package ua.audiolibrary.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ua.audiolibrary.domain.Audio;
import ua.audiolibrary.service.audio.AudioService;
import ua.audiolibrary.service.catalog.DirectoryService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller(value = "welcomeController")
public class WelcomeController {
    @Resource(name = "basicAudioService")
    private AudioService audioService;
    @Resource(name = "basicDirectoryService")
    private DirectoryService directoryService;

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

    @RequestMapping(value = "/directory", method = RequestMethod.GET)
    public String browseBaseDirectory(HttpServletRequest request) {
        return "redirect:" + request.getScheme() + "://localhost:8085/AudioLibrary/directory/audio_library";
    }

    @RequestMapping(value = "/directory/**", method = RequestMethod.GET)
    public String browseDirectory(ModelMap model, HttpServletRequest request) {
        String requestUri = request.getRequestURI();
        Matcher matcher = Pattern.compile("(?<=/AudioLibrary/directory/).*").matcher(requestUri);
        if (matcher.find()) {
            String directoryPath = matcher.group();
            model.addAttribute("subDirectories", directoryService.directorySubDirectories(directoryPath));
        } else {
            throw new IllegalStateException("Illegal URL state");
        }
        return "directory";
    }
}