package com.usuario.apirest.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.apirest.business.UsuarioBusiness;
import com.usuario.apirest.exceptions.DeleteException;
import com.usuario.apirest.models.Usuario;
import com.usuario.apirest.models.UsuarioSimples;

@RestController
@RequestMapping(value = "/api")
public class UsuarioResource {

	@Autowired
	UsuarioBusiness usuarioBusiness;

	@GetMapping("/usuario")
	public List<UsuarioSimples> listar() {
		return usuarioBusiness.listar();
	}

	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> listarPorId(@PathVariable(value = "id") String id) {
		Usuario produto = usuarioBusiness.listarPorId(id);
		return ResponseEntity.ok(produto);
	}

	@PostMapping("/usuario")
	public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {
		usuarioBusiness.salvar(usuario);
		return ResponseEntity.created(URI.create("/produto/" + usuario.getId())).body(usuario);
	}

	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<String> deletar(@PathVariable(value = "id") String id) {
		ResponseEntity<String> response = null;
		try {
			Usuario usuario = usuarioBusiness.listarPorId(id);
			if (usuario != null) {
				usuarioBusiness.deletar(usuario);
				response = ResponseEntity.ok("Usuário deletado com sucesso!");
			} else {
				response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
			}
		} catch (DeleteException e) {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return response;
	}

	@PutMapping("/usuario")
	public Usuario atualizar(@RequestBody Usuario usuario) {
		return usuarioBusiness.atualizar(usuario);
	}

	@PatchMapping("/usuario/{id}/nome")
	public Usuario atualizarNome(@PathVariable(value = "id") String id, @RequestBody String nome) {
		Usuario usuario = usuarioBusiness.listarPorId(id);
		usuario.setNome(nome);
		return usuarioBusiness.atualizar(usuario);
	}

}