package com.mimisalon.casestudy.database.dao;

import com.mimisalon.casestudy.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long> {


    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE :firstName AND e.lastName LIKE :lastName")
    List<Employee> findByFirstNameandLastName(String firstName, String lastName);

    @Query("SELECT e FROM Employee e WHERE e.id = :userId")
    List<Employee> findByUserId(@Param("userId") Integer userId);

    List<Employee> findAll();
    Optional<Employee> findById(Integer id);


        Optional<Employee> findByEmployeeId(Integer employeeId);

    }




