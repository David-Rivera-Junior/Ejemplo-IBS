package com.ibs.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.ibs.proyecto.model.Role;

public interface Test {
	
	@Query(nativeQuery = true, value = "select * from roles")
	List<Role> listRol();
}
