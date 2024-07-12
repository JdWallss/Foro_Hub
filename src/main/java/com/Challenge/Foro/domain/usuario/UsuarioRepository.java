package com.Challenge.Foro.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {

   // UserDetails findByEmail(String username);
}
