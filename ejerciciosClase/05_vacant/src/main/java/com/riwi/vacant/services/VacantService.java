package com.riwi.vacant.services;

import com.riwi.vacant.entities.Company;
import com.riwi.vacant.entities.Vacant;
import com.riwi.vacant.repositories.CompanyRepository;
import com.riwi.vacant.repositories.VacantRepository;
import com.riwi.vacant.services.interfaces.IVacantService;
import com.riwi.vacant.utils.dto.request.VacantRequest;
import com.riwi.vacant.utils.dto.response.CompanyToVacantResponse;
import com.riwi.vacant.utils.dto.response.VacantResponse;
import com.riwi.vacant.utils.enums.StatusVacant;
import com.riwi.vacant.utils.exceptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VacantService implements IVacantService {
    @Autowired
    private final VacantRepository vacantRepository;
    @Autowired
    private final CompanyRepository companyRepository;


    @Override
    public Page<VacantResponse> getAll(int page, int size) {
        if (page < 0) page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        return this.vacantRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public VacantResponse create(VacantRequest vacantRequest) {
        /*
         * Buscamos la compañia que corresponda con el id que esta dentro del request
         */
        Company company = this.companyRepository.findById(vacantRequest.getCompanyId())
                .orElseThrow(() -> new IdNotFoundException("Company"));

        /**
         * Convertimos el request a una instacia de vacante
         */
        Vacant vacant = this.requestToVacant(vacantRequest, new Vacant());
        vacant.setObjCompany(company);

        // Guardamos en la BD y convertimos la nueva entidad al DTO de respuesta
        return this.entityToResponse(this.vacantRepository.save(vacant));

    }

    @Override
    public VacantResponse update(VacantRequest vacantRequest, Long id) {
        //buscamos la vacante por ID
        Vacant vacant =this.find(id);
        //validamos la compañia
        Company company = this.companyRepository.findById(vacantRequest.getCompanyId()).orElseThrow(()-> new IdNotFoundException("Company"));
        //convertirmos el DTO
        vacant=this.requestToVacant(vacantRequest,vacant);
        //agregamos la vacante
        vacant.setObjCompany(company);
        //agregamos nuevo status
        vacant.setStatus(vacantRequest.getStatus());

        return this.entityToResponse(this.vacantRepository.save(vacant));
    }

    @Override
    public void delete(Long id) {
        Vacant vacant = this.find(id);
        this.vacantRepository.delete(vacant);

    }

    @Override
    public VacantResponse getByID(Long id) {

        return this.entityToResponse(this.find(id));
    }

    private VacantResponse entityToResponse(Vacant entity) {
        /*creamos instanciación dto de vacante*/
        VacantResponse response = new VacantResponse();
        //copia la entidad en el dto
        BeanUtils.copyProperties(entity, response);

        //creamos instancia del DTO de compañia dentro de vacante
        CompanyToVacantResponse companyDto = new CompanyToVacantResponse();

        BeanUtils.copyProperties(entity.getObjCompany(), companyDto);
        //agrego el dto lleno a la respuesta final
        response.setCompany(companyDto);
        return response;
    }

    private Vacant requestToVacant(VacantRequest request, Vacant entity) {

        entity.setTitle(request.getTitle());
        entity.setDescription(request.getDescription());
        entity.setStatus(StatusVacant.ACTIVE);

        return entity;

    }

    private Vacant find (Long id){
        return this.vacantRepository.findById(id).orElseThrow(()->new IdNotFoundException("Vacant"));
    }


}
