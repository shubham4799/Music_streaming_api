package com.geekster.MusicAPI.controllers;

import com.geekster.MusicAPI.models.Music;
import com.geekster.MusicAPI.models.User;
import com.geekster.MusicAPI.services.MusicService;
import com.geekster.MusicAPI.services.TokenService;
import com.geekster.MusicAPI.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RestController
public class SongController {

    @Autowired
    MusicService musicService;
    @Autowired
    UserService userService;
    @Autowired
    TokenService authService;

    @GetMapping("/getMusicById/{id}")
    public Optional<Music> getAllMusic(@PathVariable Integer id){
        return musicService.getMusicById(id);
    }
}
