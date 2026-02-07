package org.example.practica.controladores;

import lombok.AllArgsConstructor;
import org.example.practica.modelos.Usuario;
import org.example.practica.modelos.Vecino;
import org.example.practica.servicios.UsuarioServicio;
import org.example.practica.servicios.VecinoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class VecinoControlador {

    private final VecinoServicio vecinoServicio;

    private final UsuarioServicio usuarioServicio;

    public VecinoControlador(VecinoServicio vecinoServicio, UsuarioServicio usuarioServicio) {
        this.vecinoServicio = vecinoServicio;
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping("/listaVecinos")
    public String listarVecinos(Model model){
        Usuario usuario = usuarioServicio.obtenerUsuarioConectado();

        model.addAttribute("usuario", usuario);
        model.addAttribute("listaVecinos", vecinoServicio.listarVecinos());
        return "vecinos";
    }


    @GetMapping("/crearVecino")
    public String crearVecino(Model model){
        Vecino v = new Vecino();
        model.addAttribute("vecino",v);

        return "crearVecino";
    }

    @PostMapping("/crearVecino")
    public String crearVecino(@ModelAttribute("producto") Vecino vecino, Model model) {
        vecinoServicio.crearVecino(vecino);
        model.addAttribute("listaVecinos", vecinoServicio.listarVecinos());

        return "vecinos";
    }

    @GetMapping("/vecino/{id}")
    public String verVecino(Model model,@PathVariable Integer id){
        Vecino vecino = vecinoServicio.findById(id);
        model.addAttribute("vecino",vecino);

        return "verVecino";
    }

    @GetMapping("/vecino/eliminar/{id}")
    public String eliminarVecino(@PathVariable Integer id){
        vecinoServicio.eliminarVecino(id);
        return "redirect:/listaVecinos";
    }

    @GetMapping("/vecino/editar/{id}")
    public String editarVecino(@PathVariable Integer id, Model model){
        Vecino v = vecinoServicio.findById(id);
        model.addAttribute("vecino",v);

        return "editarVecino";
    }

    @PostMapping("/vecino/editar/{id}")
    public String editarVecino(@PathVariable Integer id, @ModelAttribute("vecino") Vecino vecino, Model model) {
        vecinoServicio.editarVecino(id, vecino);
        model.addAttribute("listaVecinos", vecinoServicio.listarVecinos());

        return "redirect:/listaVecinos";
    }
}
