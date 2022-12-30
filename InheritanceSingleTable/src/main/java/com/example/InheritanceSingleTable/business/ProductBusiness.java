package com.example.InheritanceSingleTable.business;

import com.example.InheritanceSingleTable.domain.Product;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

public class ProductBusiness {
    @PersistenceContext
    private EntityManager entityManager;

    public ProductBusiness(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void addProduct(Product product){
        EntityTransaction entityTransaction=entityManager.getTransaction();
        try{
            entityTransaction.begin();
            entityManager.persist(product);
            entityTransaction.commit();
        }
        catch(Exception e){
            if(entityTransaction.isActive())entityTransaction.rollback();
        }
    }
    public void deleteProductById(Long id){
        Product product=entityManager.find(Product.class,id);
        EntityTransaction transaction= entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.remove(product);
            transaction.commit();
        }
        catch (Exception e){
            if(transaction.isActive())transaction.rollback();
        }
    }
    public void updateProduct(Product product){
        EntityTransaction transaction=entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.merge(product);
        }
        catch (Exception e){
            if (transaction.isActive())transaction.rollback();
        }
    }
    public Product getProduct(Long id){

        return   entityManager.find(Product.class,id);

    }
}
