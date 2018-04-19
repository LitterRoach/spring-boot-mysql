package com.example.demo;

import com.example.demo.dao.DepartmentRepository;
import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.po.Department;
import com.example.demo.po.Role;
import com.example.demo.po.User;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {JpaConfiguration.class})
@SpringBootTest
@EnableAutoConfiguration(exclude = {JpaRepositoriesAutoConfiguration.class})
public class DemoApplicationTests {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Before
    public void initData() {
        userRepository.deleteAll();
        departmentRepository.deleteAll();
        roleRepository.deleteAll();

        Department department = new Department();
        department.setName("开发部1");
        departmentRepository.save(department);
        Assert.assertNotNull(department.getId());

        {
            Department department2 = new Department();
            department2.setName("开发部2");
            departmentRepository.save(department2);
        }

        Role role = new Role();
        role.setName("admin");
        roleRepository.save(role);
        Assert.assertNotNull(role.getId());

        User user = new User();
        user.setName("欧阳鹏");
        user.setCreateDate(new Date());
        user.setDepartment(department);
        user.setRoles(Lists.newArrayList(role));
        userRepository.save(user);

    }

    @Test
    public void contextLoads() {
//        Pageable pageable = new PageRequest(0, 10, new Sort(Sort.Direction.ASC, "id"));
//        Page<User> page = userRepository.findAll(pageable);
//        Assert.assertNotNull(page);
//        for (User user : page.getContent()) {
//            LOG.info("userName:" + user.getName() + "," + ",departmentName:" + user.getDepartment().getName());
//        }


        /**
         * getByNameEquals 与 getByName 使用等效
         */
        {
            Department d = departmentRepository.getByNameEquals("开发部2");
            LOG.info("name:" + d.getName() + ", id:" + d.getId());
        }
        {
            Department d = departmentRepository.getByName("开发部2");
            LOG.info("name:" + d.getName() + ", id:" + d.getId());
        }
        //从结果来看getByNameLike并没有起到Like的效果，而是equals
        {
//            Department d = departmentRepository.getByNameLike("开发部");
            Department d = departmentRepository.getByNameLike("开发部2");
            LOG.info("name:" + d.getName() + ", id:" + d.getId());
        }
    }
}
