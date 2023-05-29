package com.example.mauri.services;

import com.example.mauri.models.entities.Playlist;
import com.example.mauri.models.entities.Song;
import com.example.mauri.models.entities.SongxPlaylist;

import java.util.List;

public interface SongxPlaylistService {
    void save(SongxPlaylist songxPlaylist, Song song, Playlist playlist) throws Exception;
    List<Song> findSongByPlaylist(String title);
    List<Playlist> findPlaylistBySong(String title);
    void updateSongxPlaylist(SongxPlaylist songxPlaylist, Song song, Playlist playlist);
    void deleteSongxPlaylist(SongxPlaylist songxPlaylist, Song song, Playlist playlist);
}
