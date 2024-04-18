package com.riwi.primeraweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.primeraweb.entity.Coder;
import com.riwi.primeraweb.repository.CoderRepository;

/*
 * Indica que esta clase será un servicio
 */
@Service
public class CoderService {
    /*
     * Autowired le indica a spring Boot que esto es una inyección de dependencias
     */
    @Autowired
    private CoderRepository objCoderRepository;

    /**
     * Servicio para listar todos los coders
     */
    public List<Coder> findAll() {
        return this.objCoderRepository.findAll();
    }


    /*
     * Método para listar los coders de forma paginada
     */
    public Page<Coder> fingPaginated(int page, int size) {
        if (page < 0) {
            page = 1;
        }

        // Crear objeto de paginación
        Pageable objPageable = PageRequest.of(page, size);

        return this.objCoderRepository.findAll(objPageable);
    }
    /*
     * Servicio para guardar un Coder
     * */

    public Coder insert(Coder objCoder) {
        return this.objCoderRepository.save(objCoder); //el método save es propio del JPA hace el proceso del insert
    }

    /*
    * METODO PARA ELIMINAR A UN CODER
    * */
    public void delete(Long id) {
        this.objCoderRepository.deleteById(id);
    }

    /*
    * SERVICIO PARA ACTUALIZAR UN CODER
    * */

    public Coder update (Long id, Coder objCoder){

        Coder objCoderDB = this.findByid(id); //busca el coder por ID

        if (objCoderDB== null) return null; //verifica si existe el coder
        objCoderDB=objCoder; //actualiza el coder antiguo

        return  this.objCoderRepository.save(objCoderDB); //guarda el coder
    }

    /*
    * OBTENER CODER POR ID
    */
    public Coder findByid (Long id){
        return this.objCoderRepository.findById(id).orElse(null);

    }

    public Coder findByName(String name) {
        return objCoderRepository.findByName(name).orElse(null);
    }




}
