package com.dh._ORM_mesa_trabalho.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USUARIO")
@Getter @Setter
public class UsuarioEntity {

       @Id
       @GeneratedValue(strategy = GenerationType.SEQUENCE)
       private Integer id;

       private String usuario;
       private String senha;

}
