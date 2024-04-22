package com.TaskBoard.TaskBoard.services;

import com.TaskBoard.TaskBoard.entity.Task;
import com.TaskBoard.TaskBoard.repository.TasksRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TasksService {


    @Autowired
    private TasksRepository objTasksRepository;

     /**
     * Servicio para listar todas las task
     */
    public List<Task> findAll() {
        return this.objTasksRepository.findAll();
    }

    
    /*
     * Método para listar las task de forma paginada
     */
    public Page<Task> findPaginated(int page, int size, String name) {
        Pageable pageable = PageRequest.of(page, size);
        if (name != null && !name.isEmpty()) {
            return objTasksRepository.findByTitle(name, pageable);
        } else {
            return objTasksRepository.findAll(pageable);
        }
    }
    /*
     * Servicio para guardar un Coder
     * */

    public Task insert(Task objTask) {
        return this.objTasksRepository.save(objTask); //el método save es propio del JPA hace el proceso del insert
    }

    /*
    * METODO PARA ELIMINAR A UN CODER
    * */
    public void delete(Long id) {
        this.objTasksRepository.deleteById(id);
    }

    /*
    * SERVICIO PARA ACTUALIZAR UN CODER
    * */

    public Task update (Long id, Task objTask){

        Task objTaskDB = this.findByid(id); //busca el coder por ID

        if (objTaskDB== null) return null; //verifica si existe el coder
        objTaskDB=objTask; //actualiza el coder antiguo

        return  this.objTasksRepository.save(objTaskDB); //guarda el coder
    }

    /*
    * OBTENER CODER POR ID
    */
    public Task findByid (Long id){
        return this.objTasksRepository.findById(id).orElse(null);

    }



}
