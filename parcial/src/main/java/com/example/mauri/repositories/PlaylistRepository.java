package com.example.mauri.repositories;

import com.example.mauri.models.entities.Playlist;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.UUID;

public interface PlaylistRepository
    extends ListCrudRepository<Playlist, UUID> {
    Playlist findOneByTitle(String title);
    void deletePlaylistByTitle(String title);
    List<Playlist> findAllByTitle(String title);
}
