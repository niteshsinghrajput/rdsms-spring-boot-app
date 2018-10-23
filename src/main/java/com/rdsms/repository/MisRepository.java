package com.rdsms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rdsms.entity.MIS;

@Repository
public interface MisRepository  extends JpaRepository<MIS, Long>{

}
