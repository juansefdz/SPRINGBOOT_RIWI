package com.riwi.primeraweb.controller;

import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.PostRemove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.riwi.primeraweb.entity.Coder;
import com.riwi.primeraweb.services.CoderService;

@Controller
@RequestMapping("/")
public class CoderController {
    @Autowired
    private CoderService objCoderService;

    /**
     * Método para mostrar la vista y enviarle la lista coders
     */
    @GetMapping
    public String showViewGetAll(Model objModel, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size){
        // LLamo el servicio y guardo la lista de coders
        Page<Coder> list = this.objCoderService.fingPaginated(page - 1, size);
        objModel.addAttribute("coderList", list); // Llave- valor
        objModel.addAttribute("currentPage", page); // Llave- valor
        objModel.addAttribute("totalPages", list.getTotalPages()); // Llave- valor


        // Se debe retornar el nombre exacto de la vista html
        return "viewCoder";
    }

    @GetMapping("/form") //se encarga de mostrar la vista al usuario
    public String showViewFormCoder(Model objModel){

        objModel.addAttribute("coder",new Coder());
        objModel.addAttribute("action","/coder/create");

        return "viewForm";
    }
    /*
    * MÉTODO PARA INSERTAR UN CODER MEDIANTE POST
    * */
    @PostMapping("/coder/create")
    public String createCoder(@ModelAttribute Coder objCoder){ //modelAtributte se encarga de obtener la información enviada desde la vista.
        this.objCoderService.insert(objCoder); //llamamos al servicio enviandole el coder a insertar

        return "redirect:/";

    }

    /*
    * METODO PARA MOSTRAR EL CODER QUE VA A ACTUALIZAR
    * */
    @GetMapping("/update/{id}")
    public String showFormUpdate (@PathVariable Long id , Model objModel){

        Coder objCoderFind = this.objCoderService.findByid(id);

        objModel.addAttribute("coder",objCoderFind);
        objModel.addAttribute("action","/edit/"+id);
        return "viewForm";

    }

    /*
    * METODO PARA ACTUALIZAR
    * */
    @PostMapping("/edit/{id}")
    public String updateCoder (@PathVariable Long id, @ModelAttribute Coder objCoder){

        this.objCoderService.update(id, objCoder);

        return "redirect:/";

    }

    /*
    * METODO PARA ELIMINAR
    * */

    @GetMapping("/delete/{id}")
    public String deleteCoder (@PathVariable Long id){

        this.objCoderService.delete(id);

        return "redirect:/";
    }


    /**
     * METODO PARA BUSCAR POR NOMBRE
     */

    @GetMapping("/coder/search")
    public Coder searchByName(@RequestParam String name) {
        return objCoderService.findByName(name);
    }
}
