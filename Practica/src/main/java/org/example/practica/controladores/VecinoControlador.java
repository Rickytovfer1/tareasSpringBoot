package org.example.practica.controladores;

import lombok.AllArgsConstructor;
import org.example.practica.modelos.Vecino;
import org.example.practica.servicios.VecinoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class VecinoControlador {

    @Autowired
    private VecinoServicio vecinoServicio;

    @GetMapping("/listaVecinos")
    public String listarVecinos(Model model){
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
}
