package com.example.demo.dao;

import com.example.demo.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Author: ouyp </p>
 * <p>Date: 2018-04-19 10:29</p>
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
