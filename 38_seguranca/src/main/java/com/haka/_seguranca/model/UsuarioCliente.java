package com.haka._seguranca.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class UsuarioCliente {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String username;
    private  String password;
    private String email;

    public UsuarioCliente(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
