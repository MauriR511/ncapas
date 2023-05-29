package com.example.mauri.services.implementations;

import com.example.mauri.models.entities.Song;
import com.example.mauri.repositories.SongRepository;
import com.example.mauri.services.SongService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void save(Song song) throws Exception {
        Song newSong = new Song(
                song.getTitle(),
                song.getDuration()
        );

        songRepository.save(newSong);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteByTitle(String title) throws Exception {
        Song song = songRepository.findOneByTitle(title);

        if (song != null){
            songRepository.deleteSongByTitle(title);
        }

    }

    @Override
    public Song findOneByTitle(String title) {
        try {
            return songRepository.findOneByTitle(title);
        }
        catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Song> findAllByTitle(String title) {
        try {
            return songRepository.findAllByTitle(title);
        }
        catch (Exception e) {
            return null;
        }
    }

    @Override
    public void updateTitle(String title) {
        Song song = songRepository.findOneByTitle(title);

        if (song != null){
            song.setTitle(title);
            songRepository.save(song);
        }

    }
}
