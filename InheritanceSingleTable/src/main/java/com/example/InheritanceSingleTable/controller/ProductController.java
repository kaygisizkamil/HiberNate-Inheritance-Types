package com.example.InheritanceSingleTable.controller;

import com.example.InheritanceSingleTable.business.ProductBusiness;
import com.example.InheritanceSingleTable.domain.Product;
import lombok.Getter;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/products")
public class ProductController {
    private ProductBusiness productBusiness;

    public ProductController(EntityManager entityManager) {
        this.productBusiness = new ProductBusiness(entityManager);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductById(Long id){
        Product product=productBusiness.getProduct(id);
        if(product==null){
            return  Response.status(Response.Status.NOT_FOUND).build();
        }
        else return Response.ok(product).build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(Product product){
        productBusiness.addProduct(product);
        return Response.ok(product).build();
    }
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduct(@PathParam("id") long productId, Product product){
        Product productexisting=productBusiness.getProduct(productId);
        if(productexisting==null)return  Response.status(Response.Status.NOT_FOUND).build();
        else{
            product.setProductId(productId);
            productBusiness.updateProduct(product);
            return Response.ok(product).build();
        }
    }
    @DELETE
    @Path("{id}")
    public Response deleteProduct(@PathParam("id")Long id){
        Product product0=productBusiness.getProduct(id);
        if(product0==null)return Response.status(Response.Status.NOT_FOUND).build();
        else {
            productBusiness.deleteProductById(id);
            return Response.ok().build();
        }
    }
}
