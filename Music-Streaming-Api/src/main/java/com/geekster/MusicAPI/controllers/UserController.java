package com.geekster.MusicAPI.controllers;

import com.geekster.MusicAPI.dto.SignInInput;
import com.geekster.MusicAPI.dto.SignInOutput;
import com.geekster.MusicAPI.dto.SignUpOutput;
import com.geekster.MusicAPI.models.Music;
import com.geekster.MusicAPI.models.User;
import com.geekster.MusicAPI.services.MusicService;
import com.geekster.MusicAPI.services.TokenService;
import com.geekster.MusicAPI.services.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    MusicService musicService;

    @PostMapping("/signup")
    public SignUpOutput signUp(@Valid @RequestBody User signUpDto){
        return userService.signUp(signUpDto);
    }

//    @PostMapping("/signin")
//    public SignInOutput signIn(@Valid @RequestBody SignInInput signInDto){
//        return userService.signIn(signInDto);
//    }

    @GetMapping("/getMusic/{musicName}")
    public Optional<Music> getMusic(@PathVariable String musicName){
        return musicService.getMusicByMusicName(musicName);
    }





}
