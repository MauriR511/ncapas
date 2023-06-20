package com.example.mauri.services.implementations;

import com.example.mauri.models.dtos.GetSongDTO;
import com.example.mauri.models.dtos.SaveSongDTO;
import com.example.mauri.models.entities.Song;
import com.example.mauri.repositories.SongRepository;
import com.example.mauri.services.SongService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void save(SaveSongDTO song) throws Exception {

        String[] parts = song.getDuration().split(":");

        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);

        int totalSeconds = (minutes * 60) + seconds;

        Song newSong = new Song(
                song.getTitle(),
                totalSeconds
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
    public GetSongDTO findOneByTitle(String title) {
        try {
            Song song = songRepository.findOneByTitle(title);

            int minutes = song.getDuration() / 60;
            int seconds = song.getDuration() % 60;

            String duration = minutes + ":" + seconds;


            GetSongDTO getSongDTO = new GetSongDTO(
                    song.getTitle(),
                    duration
            );

            return getSongDTO;
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
    public List<GetSongDTO> findAll() {
        List<Song> listSong = songRepository.findAll();
        List<GetSongDTO> newListSong = new ArrayList<>();

        for (Song song : listSong) {
            int minutes = song.getDuration() / 60;
            int seconds = song.getDuration() % 60;

            String duration = minutes + ":" + seconds;

            GetSongDTO getSongDTO = new GetSongDTO(
                    song.getTitle(),
                    duration
            );

            newListSong.add(getSongDTO);
        }
        return newListSong;
    }

    @Override
    public List<GetSongDTO> findByTitleContaining(String title) {
        List<Song> listSong = songRepository.findByTitleContaining(title);
        List<GetSongDTO> newListSong = new ArrayList<>();

        for (Song song : listSong) {
            int minutes = song.getDuration() / 60;
            int seconds = song.getDuration() % 60;

            String duration = minutes + ":" + seconds;

            GetSongDTO getSongDTO = new GetSongDTO(
                    song.getTitle(),
                    duration
            );

            newListSong.add(getSongDTO);
        }
        return newListSong;
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
