package com.riwi.demo.services;

import com.riwi.demo.entities.Appointment;
import com.riwi.demo.repositories.AppointmentRepository;
import com.riwi.demo.services.interfaces.IAppointmentService;
import com.riwi.demo.utils.request.AppointmentRequest;
import com.riwi.demo.utils.response.AppointmentResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class AppointmentService implements IAppointmentService {

    @Autowired
    private final AppointmentRepository appointmentRepository;
    @Override
    public Page<AppointmentResponse> getAll(int page, int size) {
        if (page < 0)
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        return this.AppointmentRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public AppointmentResponse create(AppointmentRequest appointmentRequest) {
        Appointment appointment = this.requestToEntity(request, new Appointment());
        return this.entityToResponse(this.appointmentRepository.save(appointment));
    }

    @Override
    public AppointmentResponse update(AppointmentRequest appointmentRequest, String id) {
        Appointment appointmentToUpdate = this.find(id);

        Appointment appointment = this.requestToEntity(request, appointmentToUpdate);

        return this.entityToResponse(this.appointmentRepository.save(appointment));
    }

    @Override
    public void delete(String id) {
        Appointment appointment = this.find(id);

        this.appointmentRepository.delete(appointment);

    }

    @Override
    public AppointmentResponse getByID(String id) {
        Appointment appointment=this.find(id);
        return this.entityToResponse(appointment);
    }

    private AppointmentResponse entityToResponse(Appointment entity) {
        AppointmentResponse response = new AppointmentResponse();

        BeanUtils.copyProperties(entity, response);


        response.setApp(entity.getVacants().stream().map(this::vacantToResponse).collect(Collectors.toList()));
        return response;
    }

    private VacantToCompanyResponse vacantToResponse(Vacant entity) {
        VacantToCompanyResponse response = new VacantToCompanyResponse();
        BeanUtils.copyProperties(entity, response);

        return response;

    }

    private Appointment requestToEntity(AppointmentRequest request, Appointment appointment){


        return appointment;
    }

    private Appointment find(String id){

        return this.appointmentRepository.findById(id).orElseThrow(()-> new IdNotFoundException("Appointment"));
    }
}
