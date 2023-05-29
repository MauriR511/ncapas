package com.example.mauri.services;

import com.example.mauri.models.entities.Playlist;
import com.example.mauri.models.entities.User;

import java.util.List;

public interface PlaylistService {
    void save(Playlist playlist, User user) throws Exception;
    void deleteByTitle(String title) throws Exception;
    void deleteById(String id) throws Exception;
    Playlist findOneByTitle(String title);
    List<Playlist> findAllByTitle(String title);
    void updateTitle(String title);
}
