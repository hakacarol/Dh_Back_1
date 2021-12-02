package com.haka._30_spring_data_hibernate.model;

import javax.persistence.*;

@Entity
public class Jogador {

    @Id
    @SequenceGenerator(name = "jogador_sequencia", sequenceName = "jogador_sequencia", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jogador_sequencia")
    private Integer id;
    private String nome;
    private String posicao;
    private String numero;
    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;
    @ManyToOne
    @JoinColumn(name = "treinador_id")
    private Treinador treinador;

    public Jogador(String nome, String posicao, String numero, Equipe equipe, Treinador treinador) {
        this.nome = nome;
        this.posicao = posicao;
        this.numero = numero;
        this.equipe = equipe;
        this.treinador = treinador;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public String getNumero() {
        return numero;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public Treinador getTreinador() {
        return treinador;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public void setTreinador(Treinador treinador) {
        this.treinador = treinador;
    }
}
