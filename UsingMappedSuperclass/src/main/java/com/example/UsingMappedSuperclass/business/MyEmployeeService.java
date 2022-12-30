package com.example.UsingMappedSuperclass.business;

import com.example.UsingMappedSuperclass.entity.MyEmployee;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;



/*   @Transactional
    public MyEmployee createMyEmployee(MyEmployee employee) {
        entityManager.getTransaction().begin();//it throws an error
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        return employee;
    }*/
@Service
public class MyEmployeeService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public MyEmployee createMyEmployee(MyEmployee employee) {
        entityManager.persist(employee);
        return employee;
    }

    @Transactional
    public MyEmployee updateMyEmployee(MyEmployee employee) {
        return entityManager.merge(employee);
    }
    @Transactional
    public MyEmployee readMyEmployee(long id) {
        return entityManager.find(MyEmployee.class, id);
    }

    @Transactional
    public void deleteMyEmployee(long id) {
        MyEmployee employee = entityManager.find(MyEmployee.class, id);
        entityManager.remove(employee);
    }
}