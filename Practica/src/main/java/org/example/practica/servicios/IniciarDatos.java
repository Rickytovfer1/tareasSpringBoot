package org.example.practica.servicios;

import org.example.practica.enumerados.Rol;
import org.example.practica.modelos.Usuario;
import org.example.practica.modelos.Vecino;
import org.example.practica.repositorios.UsuarioRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.github.javafaker.Faker;

@Component
public class IniciarDatos implements CommandLineRunner {

    private final VecinoServicio servicio;
    private final UsuarioRepositorio usuarioRepositorio;
    private final PasswordEncoder passwordEncoder;

    public IniciarDatos(VecinoServicio servicio,
                        UsuarioRepositorio usuarioRepositorio,
                        PasswordEncoder passwordEncoder) {
        this.servicio = servicio;
        this.usuarioRepositorio = usuarioRepositorio;
        this.passwordEncoder = passwordEncoder;
    }

    private void crearUsuarioSiNoExiste(String nombre, String contrasenaEnClaro, Rol rol) {
        if (usuarioRepositorio.findByNombre(nombre) != null) return;

        Usuario u = new Usuario();
        u.setNombre(nombre);
        u.setContrasena(passwordEncoder.encode(contrasenaEnClaro));
        u.setRol(rol);

        usuarioRepositorio.save(u);
    }

    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i < 20; i++) {
            Vecino v = new Vecino();
            v.setNombre(Faker.instance().dog().name());
            v.setTelefono(Faker.instance().artist().name());
            v.setApellidos(Faker.instance().artist().name());
            servicio.crearVecino(v);
        }

        crearUsuarioSiNoExiste("admin", "admin123", Rol.ADMIN);
        crearUsuarioSiNoExiste("manager", "manager123", Rol.MANAGER);
        crearUsuarioSiNoExiste("usuario", "usuario123", Rol.USUARIO);
    }
}