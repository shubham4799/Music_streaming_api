package com.geekster.MusicAPI.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="music_id")
    private Integer musicId;

    @Column(name="name")
    private String musicName;

    @Column(name="musicType")
    private String musicType;

    @Column(name="singerName")
    private String singerName;
    @Column(name="songReleasedYear")
    private String songReleasedYear;




    @ManyToOne
    User user;


}
