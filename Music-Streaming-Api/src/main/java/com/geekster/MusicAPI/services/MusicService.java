package com.geekster.MusicAPI.services;

import com.geekster.MusicAPI.models.Music;
import com.geekster.MusicAPI.models.User;
import com.geekster.MusicAPI.repository.IMusicRepo;
import com.geekster.MusicAPI.repository.ITokenRepo;
import com.geekster.MusicAPI.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService {
    @Autowired
    IMusicRepo musicRepo;
    @Autowired
    IUserRepo userRepo;
    @Autowired
    ITokenRepo tokenRepo;

    public void addMusic(Music mu) {
        musicRepo.save(mu);
    }

//    public List<Music> getAllMusic(String token) {
//        User user = tokenRepo.findFirstByToken(token).getUser();
//        List<Music> musicList = musicRepo.findByUser(user);
//        return musicList;
//    }


    public Optional<Music> getMusicById(Integer id) {
        return musicRepo.findById(id);
    }

//    public void updateMusic(Integer id , Music music) {
//      //  Music existingSong = musicRepo.findById(id).orElse(null);
//        Music mu = musicRepo.findMusicByMusicId(id);
//        User user = mu.getUser();
//        music.setUser(user);
//       // musicRepo.deleteById(id);
//        musicRepo.save(music);
//
//    }

    public boolean updateMusic(Integer id, Music musicToUpdate, User user) {
        Optional<Music> existingMusicOptional = musicRepo.findById(id);
        if (existingMusicOptional.isPresent()) {
            Music existingMusic = existingMusicOptional.get();
            if (existingMusic.getUser().getUserId().equals(user.getUserId())) {
                existingMusic.setMusicName(musicToUpdate.getMusicName());
                existingMusic.setMusicType(musicToUpdate.getMusicType());
                existingMusic.setSingerName(musicToUpdate.getSingerName());
                existingMusic.setSongReleasedYear(musicToUpdate.getSongReleasedYear());
                // Set other attributes that you want to update
                musicRepo.save(existingMusic);
                return true;
            }
        }
        return false;
    }
    public Optional<Music> getMusicByMusicName(String musicName) {
          return musicRepo.findByMusicName(musicName);
    }


    public boolean deleteSong(Integer id) {
        Music existingSong = musicRepo.findById(id).orElse(null);
        if (existingSong != null) {
            musicRepo.delete(existingSong);
            return true;
        } else {
            return false;
        }


//    public String deleteSong(String music) {
//
//            List<Music> songList=musicRepo.findSongByName(music);
//            if(songList.isEmpty()){
//                return "song does not exist";
//            }
//            musicRepo.deleteByMusic(music);
//            return "deleted";
//
//
//    }
    }


    public List<Music> getAllMusic() {
        return musicRepo.findAll();
    }
}
