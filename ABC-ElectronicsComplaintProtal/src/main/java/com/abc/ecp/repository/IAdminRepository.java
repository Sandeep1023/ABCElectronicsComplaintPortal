package com.abc.ecp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.ecp.entities.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Integer> {

}
