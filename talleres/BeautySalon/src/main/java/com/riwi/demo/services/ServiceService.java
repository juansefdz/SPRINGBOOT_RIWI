package com.riwi.demo.services;

import com.riwi.demo.services.interfaces.IServiceService;
import com.riwi.demo.utils.request.ServiceRequest;
import com.riwi.demo.utils.response.ServiceResponse;
import org.springframework.data.domain.Page;

public class ServiceService implements IServiceService {
    @Override
    public Page<ServiceResponse> getAll(int page, int size) {
        return null;
    }

    @Override
    public ServiceResponse create(ServiceRequest serviceRequest) {
        return null;
    }

    @Override
    public ServiceResponse update(ServiceRequest serviceRequest, String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public ServiceResponse getByID(String id) {
        return null;
    }
}
