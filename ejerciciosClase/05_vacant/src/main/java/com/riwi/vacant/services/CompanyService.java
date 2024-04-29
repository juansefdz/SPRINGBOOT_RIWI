package com.riwi.vacant.services;

import com.riwi.vacant.entities.Company;
import com.riwi.vacant.entities.Vacant;
import com.riwi.vacant.repositories.CompanyRepository;
import com.riwi.vacant.services.interfaces.ICompanyService;
import com.riwi.vacant.utils.dto.request.CompanyRequest;
import com.riwi.vacant.utils.dto.response.CompanyResponse;
import com.riwi.vacant.utils.dto.response.VacantToCompanyResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService {
    @Autowired
    private final CompanyRepository companyRespository;

    @Override
    public Page<CompanyResponse> getAll(int page, int size) {
        if (page < 0)
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        //se hace el llamado del repositorio

        //return this.companyRespository.findAll(pagination).map(company->this.entityToResponse(company));
        return this.companyRespository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public CompanyResponse create(CompanyRequest request) {
        /*
        * convertimos el request en la entidad
        * */
        Company company = this.requestToEntity(request, new Company());
        /*agregamos la entidad en el repositorio y el retorno se convierte en
        * respuesta*/
        return this.entityToResponse(this.companyRespository.save(company));
    }

    @Override
    public CompanyRequest update(CompanyRequest companyRequest, String id) {
        return null;
    }

    @Override
    public Void delete(String id) {
        return null;
    }

    @Override
    public CompanyResponse getByID(String id) {
        //buscamos la compañia con el ID
        Company company=this.find(id);
        //convertimos la entidad al dto de respuesta
        return this.entityToResponse(company);
    }

    /**
     * METODO QUE SE ENCARGA DE CONVERTIR UNA ENTIDAD EN EL DTO DE RESPUESTA
     */

    private CompanyResponse entityToResponse(Company entity) {
        CompanyResponse response = new CompanyResponse();
        /*BeanUtils nos permite hacer copia de una clase en otra.
         * toda la entidad de tipo Company se copia con la info
         * requerida por la variable tipo CompanyResponse
         */
        BeanUtils.copyProperties(entity, response);
        /*
        * Stream: convierte la lista en la colección para poder iterarse
        * map: itera toda la lista y retorna cambios
        * collect: crea de nuevo toda la lista que se había transformado en colección
        * */

        response.setVacants(entity.getVacants().stream().map(this::vacantToResponse).collect(Collectors.toList()));
        return response;
    }

    private VacantToCompanyResponse vacantToResponse(Vacant entity) {
        VacantToCompanyResponse response = new VacantToCompanyResponse();
        BeanUtils.copyProperties(entity, response);

        return response;

    }

    private Company requestToEntity(CompanyRequest request, Company company){

        company.setContact(request.getContact());
        company.setLocation(request.getLocation());
        company.setName(request.getName());
        company.setVacants(new ArrayList<>());
        return company;
    }

    private Company find(String id){
        return this.companyRespository.findById(id).orElseThrow();
    }
}
