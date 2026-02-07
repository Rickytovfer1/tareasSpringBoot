package org.example.practica.repositorios;

import org.example.practica.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{

    Usuario findByNombre(String userName);
}
