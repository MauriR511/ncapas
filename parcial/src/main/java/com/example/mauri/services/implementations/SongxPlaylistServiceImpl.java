package com.example.mauri.services.implementations;

import com.example.mauri.models.entities.Playlist;
import com.example.mauri.models.entities.Song;
import com.example.mauri.models.entities.SongxPlaylist;
import com.example.mauri.repositories.SongxPlaylistRepository;
import com.example.mauri.services.SongxPlaylistService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongxPlaylistServiceImpl implements SongxPlaylistService {

    @Autowired
    private SongxPlaylistRepository songxPlaylistRepository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void save(SongxPlaylist songxPlaylist, Song song, Playlist playlist) throws Exception {
        SongxPlaylist newSongxPlaylist = new SongxPlaylist(
                song,
                playlist,
                songxPlaylist.getDateAdded()
        );

        songxPlaylistRepository.save(newSongxPlaylist);
    }

    @Override
    public List<Song> findSongByPlaylist(String title) {
        try {
            return songxPlaylistRepository.findSongByPlaylist(title);
        }
        catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Playlist> findPlaylistBySong(String title) {
        try {
            return songxPlaylistRepository.findPlaylistBySong(title);
        }
        catch (Exception e) {
            return null;
        }
    }

    @Override
    public void updateSongxPlaylist(SongxPlaylist songxPlaylist, Song song, Playlist playlist) {


    }

    @Override
    public void deleteSongxPlaylist(SongxPlaylist songxPlaylist, Song song, Playlist playlist) {

    }
}
