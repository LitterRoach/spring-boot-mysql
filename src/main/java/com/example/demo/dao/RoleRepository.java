package com.example.demo.dao;

import com.example.demo.po.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Author: ouyp </p>
 * <p>Date: 2018-04-19 10:31</p>
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
