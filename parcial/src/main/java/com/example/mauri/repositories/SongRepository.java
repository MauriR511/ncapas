package com.example.mauri.repositories;

import com.example.mauri.models.entities.Song;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.UUID;

public interface SongRepository
    extends ListCrudRepository<Song, UUID>{
    Song findOneByTitle(String title);
    void deleteSongByTitle(String title);
    List<Song> findAllByTitle(String title);
}
