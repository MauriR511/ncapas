package com.example.mauri.services;

import com.example.mauri.models.entities.Song;

import java.util.List;

public interface SongService {
    void save(Song song) throws Exception;
    void deleteByTitle(String title) throws Exception;
    Song findOneByTitle(String title);
    List<Song> findAllByTitle(String title);
    void updateTitle(String title);
}
