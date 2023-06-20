package com.example.mauri.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetSongDTO {
    private String title;
    private String duration;
}
