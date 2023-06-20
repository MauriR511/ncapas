package com.example.mauri.repositories;

import com.example.mauri.models.entities.Playlist;
import com.example.mauri.models.entities.Song;
import com.example.mauri.models.entities.SongxPlaylist;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.UUID;

public interface SongxPlaylistRepository
    extends ListCrudRepository<SongxPlaylist, UUID> {

}
