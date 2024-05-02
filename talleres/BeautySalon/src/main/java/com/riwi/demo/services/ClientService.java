package com.riwi.demo.services;

import com.riwi.demo.services.interfaces.IClientService;
import com.riwi.demo.utils.request.ClientRequest;
import com.riwi.demo.utils.response.ClientResponse;
import org.springframework.data.domain.Page;

public class ClientService implements IClientService {
    @Override
    public Page<ClientResponse> getAll(int page, int size) {
        return null;
    }

    @Override
    public ClientResponse create(ClientRequest clientRequest) {
        return null;
    }

    @Override
    public ClientResponse update(ClientRequest clientRequest, String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public ClientResponse getByID(String id) {
        return null;
    }
}
