package com.riwi.demo.services;

import com.riwi.demo.services.interfaces.IEmployeService;
import com.riwi.demo.utils.request.EmployeeRequest;
import com.riwi.demo.utils.response.EmployeeResponse;
import org.springframework.data.domain.Page;

public class EmployeeService implements IEmployeService {
    @Override
    public Page<EmployeeResponse> getAll(int page, int size) {
        return null;
    }

    @Override
    public EmployeeResponse create(EmployeeRequest employeeRequest) {
        return null;
    }

    @Override
    public EmployeeResponse update(EmployeeRequest employeeRequest, String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public EmployeeResponse getByID(String id) {
        return null;
    }
}
