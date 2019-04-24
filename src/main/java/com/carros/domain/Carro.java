package com.carros.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String nome;
    private String tipo;

    //@Column(name = "url_foto")
    private String urlFoto;

    //@Column(name = "url_video")
    private String urlVideo;

    private String latitude;
    private String longitude;


}
