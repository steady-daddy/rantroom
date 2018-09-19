package com.webapp.rantroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.rantroom.model.Rants;

@Repository
public interface RantRepository extends JpaRepository<Rants, Long> {

}