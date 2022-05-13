package com.usuario.apirest.models;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioSimples {
	
	UUID id;
	String nome;
	//String cpf;
	String dataNascimento;
	String email;
	
	public UsuarioSimples(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		//this.cpf = usuario.getCpf();
		this.dataNascimento = usuario.getDataNascimento();
		this.email = usuario.getEmail();
	}
}
