package com.usuario.apirest.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_USUARIO")
@Getter
@Setter
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

	private String nome;
	private String cpf;
	private String dataNascimento;
	private String email;
	
	//private Endereco endereco;
	
}