package org.example.practica.servicios;

import lombok.AllArgsConstructor;
import org.example.practica.modelos.Vecino;
import org.example.practica.repositorios.VecinoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VecinoServicio {

    @Autowired
    private VecinoRepositorio vecinoRepositorio;

    public void crearVecino(Vecino vecino){
        Vecino vecinoNuevo = new Vecino();
        vecinoNuevo.setNombre(vecino.getNombre());
        vecinoNuevo.setApellidos(vecino.getApellidos());
        vecinoNuevo.setTelefono(vecino.getTelefono());
        vecinoRepositorio.save(vecinoNuevo);
    }

    public List<Vecino> listarVecinos(){
        List<Vecino> listaVecinos = vecinoRepositorio.findAll();
        return listaVecinos;
    }
    public Vecino findById(Integer idVecino){
        Vecino vecino = vecinoRepositorio.findById(idVecino)
                .orElseThrow(() -> new RuntimeException("No existe un vecino con este ID"));
        return vecino;
    }

    public void eliminarVecino(Integer id){
        vecinoRepositorio.deleteById(id);
    }

    public void editarVecino(Integer idVecino, Vecino vecino){
        Vecino vecinoEditar = vecinoRepositorio.findById(idVecino)
                .orElseThrow(() -> new RuntimeException("No existe un vecino con este ID"));
        vecinoEditar.setNombre(vecino.getNombre());
        vecinoEditar.setApellidos(vecino.getApellidos());
        vecinoEditar.setTelefono(vecino.getTelefono());
        vecinoRepositorio.save(vecinoEditar);
    }
}
