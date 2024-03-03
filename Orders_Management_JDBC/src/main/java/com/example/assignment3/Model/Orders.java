package com.example.assignment3.Model;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Orders.
 */
public class Orders {
    private Integer ordersId;
    private String ordersName;
    private String productsName;
    private Integer productsQuantity;

    /**
     * Instantiates a new Orders.
     */
    public Orders() {
    }

    /**
     * Instantiates a new Orders.
     *
     * @param orderId         the order id
     * @param clientName      the client name
     * @param productName     the product name
     * @param productQuantity the product quantity
     */
    public Orders(Integer orderId, String clientName, String productName, Integer productQuantity) {
        super();
        this.ordersId = orderId;
        this.ordersName = clientName;
        this.productsName = productName;
        this.productsQuantity = productQuantity;
    }

    /**
     * Instantiates a new Orders.
     *
     * @param clientName      the client name
     * @param productName     the product name
     * @param productQuantity the product quantity
     */
    public Orders(String clientName, String productName, Integer productQuantity) {
        super();
        this.ordersName = clientName;
        this.productsName = productName;
        this.productsQuantity = productQuantity;
    }

    /**
     * Gets orders id.
     *
     * @return the orders id
     */
    public Integer getOrdersId() {
        return ordersId;
    }

    /**
     * Sets orders id.
     *
     * @param ordersId the orders id
     */
    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    /**
     * Gets orders name.
     *
     * @return the orders name
     */
    public String getOrdersName() {
        return ordersName;
    }

    /**
     * Sets orders name.
     *
     * @param ordersName the orders name
     */
    public void setOrdersName(String ordersName) {
        this.ordersName = ordersName;
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
     * Gets products quantity.
     *
     * @return the products quantity
     */
    public Integer getProductsQuantity() {
        return productsQuantity;
    }

    /**
     * Sets products quantity.
     *
     * @param productsQuantity the products quantity
     */
    public void setProductsQuantity(Integer productsQuantity) {
        this.productsQuantity = productsQuantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + ordersId +
                ", clientName='" + ordersName + '\'' +
                ", productName='" + productsName + '\'' +
                ", productQuantity=" + productsQuantity +
                '}';
    }

    /**
     * Orders id property simple string property.
     *
     * @return the simple string property
     */
    public SimpleStringProperty ordersIdProperty() {
        return new SimpleStringProperty(ordersId.toString());
    }

    /**
     * Orders name property simple string property.
     *
     * @return the simple string property
     */
    public SimpleStringProperty ordersNameProperty() {
        return new SimpleStringProperty(ordersName);
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
     * Products quantity property simple string property.
     *
     * @return the simple string property
     */
    public SimpleStringProperty productsQuantityProperty() {
        return new SimpleStringProperty(productsQuantity.toString());
    }

    public List<SimpleStringProperty> getPropertyList(){
        List<SimpleStringProperty> ssp = new ArrayList<>();
        ssp.add(ordersIdProperty());
        ssp.add(ordersNameProperty());
        ssp.add(productsNameProperty());
        ssp.add(productsQuantityProperty());
        return ssp;
    }
}
