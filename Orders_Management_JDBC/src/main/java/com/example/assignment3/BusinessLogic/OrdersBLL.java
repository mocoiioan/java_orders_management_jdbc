package com.example.assignment3.BusinessLogic;

import com.example.assignment3.DataAccess.OrdersDAO;
import com.example.assignment3.Model.Orders;

import java.util.List;

/**
 * The type Orders bll.
 */
public class OrdersBLL {
    private OrdersDAO ordersDAO;

    /**
     * Instantiates a new Orders bll.
     */
    public OrdersBLL() {
        this.ordersDAO = new OrdersDAO();
    }

    /**
     * Find order by id orders.
     *
     * @param id the id
     * @return the orders
     */
    public Orders findOrderById(int id) {
        Orders order = ordersDAO.findById(id);
        if (order == null) {
            throw new IllegalArgumentException("The order with id =" + id + " was not found!");
        }
        return order;
    }

    /**
     * Find all orders list.
     *
     * @return the list
     */
    public List<Orders> findAllOrders(List<String> fields) {
        List<Orders> orders = ordersDAO.findAll(fields);
        if (orders == null) {
            throw new IllegalArgumentException("There are no orders in the database!");
        }
        return orders;
    }

    /**
     * Insert order orders.
     *
     * @param order the order
     * @return the orders
     */
    public Orders insertOrder(Orders order) {
        Orders orders = ordersDAO.insert(order);
        if (orders == null) {
            throw new IllegalArgumentException("The order could not be inserted!");
        }
        return orders;
    }

    /**
     * Delete order string.
     *
     * @param name the name
     * @return the string
     */
    public String deleteOrder(String name){
        Orders orders = new Orders();
        orders.setOrdersName(ordersDAO.delete(name));
        if (orders == null) {
            throw new IllegalArgumentException("The order could not be deleted!");
        }
        return name;
    }

    /**
     * Update order orders.
     *
     * @param order the order
     * @param name  the name
     * @return the orders
     */
    public Orders updateOrder(Orders order, String name) {
        Orders orders = ordersDAO.update(order, name);
        if (orders == null) {
            throw new IllegalArgumentException("The order could not be updated!");
        }
        return orders;
    }

}
