package com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.entity.Mobiles;

public interface MobileRepository extends JpaRepository<Mobiles, Integer>{
	

	List<Mobiles> findByEmployeeId(Integer employeeId);

}
