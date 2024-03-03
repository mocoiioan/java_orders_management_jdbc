package com.example.assignment3.Model;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Products.
 */
public class Products {
    private Integer productsId;
    private String productsName;
    private Integer productsStock;
    private Double productsPrice;

    /**
     * Instantiates a new Products.
     */
    public Products() {
    }

    /**
     * Instantiates a new Products.
     *
     * @param productId    the product id
     * @param productName  the product name
     * @param productStock the product stock
     * @param productPrice the product price
     */
    public Products(Integer productId, String productName, Integer productStock, Double productPrice) {
        super();
        this.productsId = productId;
        this.productsName = productName;
        this.productsStock = productStock;
        this.productsPrice = productPrice;
    }

    /**
     * Instantiates a new Products.
     *
     * @param productName  the product name
     * @param productStock the product stock
     * @param productPrice the product price
     */
    public Products(String productName, Integer productStock, Double productPrice) {
        super();
        this.productsName = productName;
        this.productsStock = productStock;
        this.productsPrice = productPrice;
    }

    /**
     * Gets products id.
     *
     * @return the products id
     */
    public Integer getProductsId() {
        return productsId;
    }

    /**
     * Sets products id.
     *
     * @param productsId the products id
     */
    public void setProductsId(Integer productsId) {
        this.productsId = productsId;
    }

    /**
     * Gets products name.
     *
     * @return the products name
     */
    public String getProductsName() {
        return productsName;
    }

    /**
     * Sets products name.
     *
     * @param productsName the products name
     */
    public void setProductsName(String productsName) {
        this.productsName = productsName;
    }

    /**
     * Gets products stock.
     *
     * @return the products stock
     */
    public Integer getProductsStock() {
        return productsStock;
    }

    /**
     * Sets products stock.
     *
     * @param productsStock the products stock
     */
    public void setProductsStock(Integer productsStock) {
        this.productsStock = productsStock;
    }

    /**
     * Gets products price.
     *
     * @return the products price
     */
    public Double getProductsPrice() {
        return productsPrice;
    }

    /**
     * Sets products price.
     *
     * @param productsPrice the products price
     */
    public void setProductsPrice(Double productsPrice) {
        this.productsPrice = productsPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productsId +
                ", productName='" + productsName + '\'' +
                ", productStock=" + productsStock +
                ", productPrice=" + productsPrice +
                '}';
    }

    /**
     * Products id property simple string property.
     *
     * @return the simple string property
     */
    public SimpleStringProperty productsIdProperty() {
        return new SimpleStringProperty(String.valueOf(productsId));
    }

    /**
     * Products name property simple string property.
     *
     * @return the simple string property
     */
    public SimpleStringProperty productsNameProperty() {
        return new SimpleStringProperty(productsName);
    }

    /**
     * Products stock property simple string property.
     *
     * @return the simple string property
     */
    public SimpleStringProperty productsStockProperty() {
        return new SimpleStringProperty(String.valueOf(productsStock));
    }

    /**
     * Products price property simple string property.
     *
     * @return the simple string property
     */
    public SimpleStringProperty productsPriceProperty() {
        return new SimpleStringProperty(String.valueOf(productsPrice));
    }

    public List<SimpleStringProperty> getPropertyList(){
        List<SimpleStringProperty> ssp = new ArrayList<>();
        ssp.add(productsIdProperty());
        ssp.add(productsNameProperty());
        ssp.add(productsStockProperty());
        ssp.add(productsPriceProperty());
        return ssp;
    }
}
