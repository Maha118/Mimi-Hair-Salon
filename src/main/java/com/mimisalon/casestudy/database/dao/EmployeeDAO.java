package com.mimisalon.casestudy.database.dao;

import com.mimisalon.casestudy.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long> {

    public Employee findById(Integer id);
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE :firstName AND e.lastName LIKE :lastName")
    List<Employee> findByFirstNameandLastName(String firstName, String lastName);
}


