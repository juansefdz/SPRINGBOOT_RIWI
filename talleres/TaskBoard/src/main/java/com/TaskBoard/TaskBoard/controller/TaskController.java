package com.TaskBoard.TaskBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TaskBoard.TaskBoard.entity.Task;
import com.TaskBoard.TaskBoard.services.TasksService;

@Controller
@RequestMapping("/")
public class TaskController {
    @Autowired
    private TasksService objTasksService;
    /**
     * Método para mostrar la vista y enviarle la lista task
     */
    @GetMapping("/")
    public String showViewGetAll(Model objModel, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(required = false) String name){
        // LLamo el servicio y guardo la lista de tareas
        Page<Task> list = this.objTasksService.findPaginated(page - 1, size, name);
        objModel.addAttribute("taskList", list); // Llave- valor
        objModel.addAttribute("currentPage", page); // Llave- valor
        objModel.addAttribute("totalPages", list.getTotalPages()); // Llave- valor
    
        // Se debe retornar el nombre exacto de la vista html
        return "viewTasks";
    }


    @GetMapping("/form") //vista pagina inicial
    public String showViewFormTask(Model objModel){
        objModel.addAttribute("task",new Task());
        objModel.addAttribute("action","/task/create");

        return "viewForm";

    }

    /*
    * MÉTODO PARA INSERTAR UN CODER MEDIANTE POST
    * */
    @PostMapping("/task/create")
    public String createTask(@ModelAttribute Task objTask){ //modelAtributte se encarga de obtener la información enviada desde la vista.
        this.objTasksService.insert(objTask); //llamamos al servicio enviandole el coder a insertar

        return "redirect:/";

    }

    /*
    * METODO PARA MOSTRAR EL CODER QUE VA A ACTUALIZAR
    * */
    @GetMapping("/update/{id}")
    public String showFormUpdate (@PathVariable Long id , Model objModel){

        Task objTaskFind = this.objTasksService.findByid(id);

        objModel.addAttribute("task",objTaskFind);
        objModel.addAttribute("action","/edit/"+id);
        return "viewForm";

    }

    /*
    * METODO PARA ACTUALIZAR
    * */
    @PostMapping("/edit/{id}")
    public String updateCoder (@PathVariable Long id, @ModelAttribute Task objTask){

        this.objTasksService.update(id, objTask);

        return "redirect:/";

    }

    /*
    * METODO PARA ELIMINAR
    * */

    @GetMapping("/delete/{id}")
    public String deleteTask (@PathVariable Long id){

        this.objTasksService.delete(id);

        return "redirect:/";
    }


    /**
     * METODO PARA BUSCAR POR NOMBRE
     */

     @GetMapping("/task/search/")
     public String searchByTitle(@RequestParam("name") String name, Model model) {
         Page<Task> taskList = objTasksService.findPaginated(1, 10, name); // Obtener la lista de tareas que coinciden con el nombre
         model.addAttribute("taskList", taskList); // Agregar la lista de tareas al modelo para enviarla a la vista
         return "viewTasks"; // Retornar el nombre de la vista
     }
}
