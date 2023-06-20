package com.example.mauri.services;

import com.example.mauri.models.dtos.GetSongDTO;
import com.example.mauri.models.dtos.SaveSongDTO;
import com.example.mauri.models.entities.Song;

import java.util.List;

public interface SongService {
    void save(SaveSongDTO song) throws Exception;
    void deleteByTitle(String title) throws Exception;
    GetSongDTO findOneByTitle(String title);
    List<Song> findAllByTitle(String title);
    List<GetSongDTO> findAll();

    List<GetSongDTO> findByTitleContaining(String title);
    void updateTitle(String title);
}
