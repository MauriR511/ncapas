package com.example.mauri.services.implementations;

import com.example.mauri.models.entities.Playlist;
import com.example.mauri.models.entities.User;
import com.example.mauri.repositories.PlaylistRepository;
import com.example.mauri.repositories.UserRepository;
import com.example.mauri.services.PlaylistService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void save(Playlist playlist, User user) throws Exception {
        Playlist newPlaylist = new Playlist(
                playlist.getTitle(),
                playlist.getDescription(),
                user
        );

        playlistRepository.save(newPlaylist);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteByTitle(String title) throws Exception {

        playlistRepository.deletePlaylistByTitle(title);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteById(String id) throws Exception {
        UUID code = UUID.fromString(id);
        playlistRepository.deleteById(code);

    }

    @Override
    public Playlist findOneByTitle(String title) {
        try {
            return playlistRepository.findOneByTitle(title);
        }
        catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Playlist> findAllByTitle(String title) {
        try {
            return playlistRepository.findAllByTitle(title);
        }
        catch (Exception e) {
            return null;
        }
    }

    @Override
    public void updateTitle(String title) {
        Playlist playlist = playlistRepository.findOneByTitle(title);

        if (playlist != null){
            playlist.setTitle(title);
            playlistRepository.save(playlist);
        }
    }
}
