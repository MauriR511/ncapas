package com.example.mauri.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "songxplaylist")
public class SongxPlaylist {

    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "song_code")
    private Song song;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "playlist_code")
    private Playlist playlist;

    @Column(name = "date_added")
    private Timestamp dateAdded;

    public SongxPlaylist(Song song, Playlist playlist, Timestamp dateAdded) {
        super();
        this.song = song;
        this.playlist = playlist;
        this.dateAdded = dateAdded;
    }
}
