package com.riwi.vacant.services.interfaces;

import org.springframework.data.domain.Page;

public interface CrudService <REQUEST,RESPONSE,TYPE>{

    Page<RESPONSE>getAll(int page, int size);

    RESPONSE create (REQUEST request);
    REQUEST update (REQUEST request, TYPE id);
    Void delete (TYPE id);
    RESPONSE getByID(TYPE id);

}
