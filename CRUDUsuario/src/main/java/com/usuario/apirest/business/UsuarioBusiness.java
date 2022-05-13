package com.usuario.apirest.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuario.apirest.models.Usuario;
import com.usuario.apirest.models.UsuarioSimples;
import com.usuario.apirest.repository.UsuarioRepository;

@Service
public class UsuarioBusiness {
	@Autowired
	UsuarioRepository usuarioRepository;

	public List<UsuarioSimples> listar() {
		List<UsuarioSimples> simples = new ArrayList<>();
		List<Usuario> todos = usuarioRepository.findAll();
		for (Usuario u : todos) {
			simples.add(new UsuarioSimples(u));
		}
		return simples;
	}

	public Usuario listarPorId(String id) {
		Optional<Usuario> produto = usuarioRepository.findById(UUID.fromString(id));
		if (produto.isPresent()) {
			return produto.get();
		}
		return null;
	}

	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public void deletar(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}

	public Usuario atualizar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}
