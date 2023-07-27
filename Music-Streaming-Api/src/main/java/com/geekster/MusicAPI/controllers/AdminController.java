package com.geekster.MusicAPI.controllers;

import com.geekster.MusicAPI.dto.SignInInput;
import com.geekster.MusicAPI.dto.SignInOutput;
import com.geekster.MusicAPI.dto.SignUpOutput;
import com.geekster.MusicAPI.models.Admin;
import com.geekster.MusicAPI.models.Music;
import com.geekster.MusicAPI.models.User;

import com.geekster.MusicAPI.services.MusicService;
import com.geekster.MusicAPI.services.TokenService;
import com.geekster.MusicAPI.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    MusicService musicService;
    @Autowired
    UserService userService;
    @Autowired
    TokenService authService;

    @PostMapping("/signup")
    public SignUpOutput signUp(@Valid @RequestBody User signUpDto){
        return userService.signUp(signUpDto);
    }


    @PostMapping("/signin")
    public SignInOutput signIn(@Valid @RequestBody SignInInput signInDto){
        return userService.signIn(signInDto);
    }
    @GetMapping("musicPlayList")
    public ResponseEntity<List<Music>> getMusicPlayList(@RequestParam String email, @RequestParam String token){
        HttpStatus status;
        List<Music> musicList=null;
        if(authService.authenticate(email,token)){
            musicList=musicService.getAllMusic(token);
            status = HttpStatus.OK;
        }
        else
        {
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<List<Music>>(musicList , status);
    }

    @PostMapping("/addMusic")
    public String addMusic(@Valid @RequestParam String email, @RequestParam String token, @RequestBody List<Music> music){

        if(authService.authenticate(email,token)){
            User user =  authService.findUserByToken(token);

            List<Music> musicList=music;
            for(Music mu:musicList) {
                mu.setUser(user);
                musicService.addMusic(mu);
            }

            return  " music added successfully";

        }else
        {
            return "Invalid user";
        }

    }

    @DeleteMapping("/deleteMusicById/{id}")
    public String deleteSong(@Valid @RequestParam String email, @RequestParam String token, @RequestParam Integer id) {
        if (authService.authenticate(email, token)) {
            User user = authService.findUserByToken(token);

            musicService.deleteSong(id);
            return "music deleted successfully";
        }else
        {
            return "Invalid music id";
        }
    }

    @GetMapping("/getMusicById/{id}")
    public Optional<Music> getAllMusic(@PathVariable Integer id){
       return musicService.getMusicById(id);
    }

    @PutMapping("/update/{id}")
    public void updateMusic(@PathVariable Integer id,@RequestBody Music music){
        musicService.updateMusic(id,music);
    }

}
