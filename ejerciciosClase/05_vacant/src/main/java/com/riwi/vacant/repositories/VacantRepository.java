package com.riwi.vacant.repositories;

import com.riwi.vacant.entities.Vacant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacantRepository extends JpaRepository<Vacant,Long> {
}
