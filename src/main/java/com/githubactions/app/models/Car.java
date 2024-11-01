package com.githubactions.app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityScan
public class Car {
    private Long id;
    private String numero_serie;
    private String marque;
    private String modele;
    private String couleur;
}
