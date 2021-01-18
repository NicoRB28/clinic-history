package com.pinta.clinichistory.repository;

import org.springframework.data.repository.CrudRepository;

import com.pinta.clinichistory.model.Illness;

public interface IllnessRepository extends CrudRepository<Illness, Long> {

}
