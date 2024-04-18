package com.riwi.primeraweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.primeraweb.entity.Coder;

import java.util.Optional;

@Repository
public interface CoderRepository extends JpaRepository<Coder, Long> {

    Optional<Coder> findByName(String name);
}
