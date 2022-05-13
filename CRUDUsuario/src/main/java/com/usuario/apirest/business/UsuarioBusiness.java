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

	public List<UsuarioSimples> listarUsuarios() {
		List<UsuarioSimples> simples = new ArrayList<>();
		List<Usuario> todos = usuarioRepository.findAll();
		for (Usuario u : todos) {
			simples.add(new UsuarioSimples(u));
		}
		return simples;
	}
	
//	public EnderecoSimples listarEnderecoPorIdDeUsuario(String id) {
//		Usuario usuario = listarUsuarioPorId(id);
//		return null;
//	}
	
	public Usuario listarUsuarioPorId(String id) {
		Optional<Usuario> usuario = usuarioRepository.findById(UUID.fromString(id));
		if (usuario.isPresent()) {
			return usuario.get();
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
