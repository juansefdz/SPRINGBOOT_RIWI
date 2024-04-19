package com.riwi.primeraweb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.primeraweb.entity.Coder;



@Repository
public interface CoderRepository extends JpaRepository<Coder, Long> {

    Page<Coder> findByName(Pageable page, String name);
}
