package com.example.assignment3.BusinessLogic;

import com.example.assignment3.DataAccess.ProductsDAO;
import com.example.assignment3.Model.Products;

import java.util.List;

/**
 * The type Products bll.
 */
public class ProductsBLL {
    private ProductsDAO productsDAO;

    /**
     * Instantiates a new Products bll.
     */
    public ProductsBLL() {
        this.productsDAO = new ProductsDAO();
    }

    /**
     * Find product by id products.
     *
     * @param id the id
     * @return the products
     */
    public Products findProductById(int id) {
        Products product = productsDAO.findById(id);
        if (product == null) {
            throw new IllegalArgumentException("The product with id =" + id + " was not found!");
        }
        return product;
    }

    /**
     * Find all products list.
     *
     * @return the list
     */
    public List<Products> findAllProducts(List<String> fields) {
        List<Products> products = productsDAO.findAll(fields);
        if (products == null) {
            throw new IllegalArgumentException("There are no products in the database!");
        }
        return products;
    }

    /**
     * Insert product products.
     *
     * @param product the product
     * @return the products
     */
    public Products insertProduct(Products product) {
        Products products = productsDAO.insert(product);
        if (products == null) {
            throw new IllegalArgumentException("The product could not be inserted!");
        }
        return products;
    }

    /**
     * Delete product string.
     *
     * @param name the name
     * @return the string
     */
    public String deleteProduct(String name){
        Products products = new Products();
        products.setProductsName(productsDAO.delete(name));
        if (products == null) {
            throw new IllegalArgumentException("The product could not be deleted!");
        }
        return name;
    }

    /**
     * Update product products.
     *
     * @param product the product
     * @param name    the name
     * @return the products
     */
    public Products updateProduct(Products product, String name) {
        Products products = productsDAO.update(product, name);
        if (products == null) {
            throw new IllegalArgumentException("The product could not be updated!");
        }
        return products;
    }
}
