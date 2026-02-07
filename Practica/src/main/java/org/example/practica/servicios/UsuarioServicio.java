package org.example.practica.servicios;

import org.example.practica.enumerados.Rol;
import org.example.practica.modelos.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsuarioServicio {
    Usuario crear(String nombre, String contrasenaEnClaro, Rol rol);
    Usuario actualizar(Integer id, String nuevoNombre, Rol nuevoRol);
    void cambiarContrasena(Integer id, String contrasenaActualEnClaro, String nuevaContrasenaEnClaro);
    Usuario obtenerPorId(Integer id);
    Usuario obtenerPorNombre(String nombre);
    List<Usuario> listar();
    Page<Usuario> listar(Pageable pageable);
    void eliminar(Integer id);
    Usuario obtenerUsuarioConectado();
}
