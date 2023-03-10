package mx.edu.utez.ropa.ropa.controller;

import mx.edu.utez.ropa.ropa.model.Ropa;
import mx.edu.utez.ropa.ropa.service.RopaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/ropa")
public class RopaController {

    @Autowired
    RopaService ropaService;

    List<Ropa> listRopa = new LinkedList<>();

    @GetMapping("/")
    public String listRopa(Model modelo){
        listRopa = ropaService.listRopa();
        modelo.addAttribute("listRopa", listRopa);
        return "ropa";
    }

    @PostMapping("/register")
    public String save(Ropa ropa, Model modelo){
        if(ropaService.save(ropa)){
            modelo.addAttribute("ropa", true);
        }else{
            modelo.addAttribute("ropa", false);
        }
        return "ropa";
    }

}
