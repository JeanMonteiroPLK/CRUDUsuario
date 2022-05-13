package com.usuario.apirest.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usuario.apirest.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

}
