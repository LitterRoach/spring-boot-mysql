package com.example.demo.dao;

import com.example.demo.po.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Author: ouyp </p>
 * <p>Date: 2018-04-19 10:31</p>
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    /**
     * 根据ID和名称模糊匹配获取部门
     * @param id
     * @param name
     * @return
     */
    List<Department> findByIdOrName(Long id, String name);
    /**
     * 根据部门名称模糊匹配
     * @param name
     * @return
     */
    Department getByName(String name);
    Department getByNameEquals(String name);
    Department getByNameLike(String name);
}
