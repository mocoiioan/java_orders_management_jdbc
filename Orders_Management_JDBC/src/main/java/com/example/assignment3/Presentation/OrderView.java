package com.example.assignment3.Presentation;

import com.example.assignment3.Model.Orders;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * The type Order view.
 */
public class OrderView {
    private Button addOrderButton;
    private Button updateOrderButton;
    private Button deleteOrderButton;
    private Button viewOrderButton;
    private Button backButton;
    private TextField idTextField;
    private TextField clientsNameTextField;
    private TextField productsNameTextField;
    private TextField quantityTextField;
    private TableView<Orders> tableView;

    /**
     * Instantiates a new Order view.
     */
    public OrderView() {
        idTextField = new TextField();
        idTextField.setPromptText("ID");
        idTextField.setEditable(true);
        idTextField.setLayoutX(100);
        idTextField.setLayoutY(50);
        idTextField.setPrefWidth(100);

        clientsNameTextField = new TextField();
        clientsNameTextField.setPromptText("Client Name");
        clientsNameTextField.setEditable(true);
        clientsNameTextField.setLayoutX(250);
        clientsNameTextField.setLayoutY(50);
        clientsNameTextField.setPrefWidth(100);

        productsNameTextField = new TextField();
        productsNameTextField.setPromptText("Product Name");
        productsNameTextField.setEditable(true);
        productsNameTextField.setLayoutX(400);
        productsNameTextField.setLayoutY(50);
        productsNameTextField.setPrefWidth(100);

        quantityTextField = new TextField();
        quantityTextField.setPromptText("Quantity");
        quantityTextField.setEditable(true);
        quantityTextField.setLayoutX(550);
        quantityTextField.setLayoutY(50);
        quantityTextField.setPrefWidth(100);

        addOrderButton = new Button("Add Order");
        addOrderButton.setLayoutX(100);
        addOrderButton.setLayoutY(100);
        addOrderButton.setPrefWidth(100);
        addOrderButton.setOnAction(OrderController.addOrder);

        updateOrderButton = new Button("Update Order");
        updateOrderButton.setLayoutX(250);
        updateOrderButton.setLayoutY(100);
        updateOrderButton.setPrefWidth(100);
        updateOrderButton.setOnAction(OrderController.updateOrder);

        deleteOrderButton = new Button("Delete Order");
        deleteOrderButton.setLayoutX(400);
        deleteOrderButton.setLayoutY(100);
        deleteOrderButton.setPrefWidth(100);
        deleteOrderButton.setOnAction(OrderController.deleteOrder);

        viewOrderButton = new Button("View Order");
        viewOrderButton.setLayoutX(550);
        viewOrderButton.setLayoutY(100);
        viewOrderButton.setPrefWidth(100);
        viewOrderButton.setOnAction(OrderController.viewAllOrders);

        backButton = new Button("Back");
        backButton.setLayoutX(100);
        backButton.setLayoutY(550);
        backButton.setPrefWidth(100);

        tableView = new TableView<>();
        tableView.setLayoutX(100);
        tableView.setLayoutY(200);
        tableView.setPrefWidth(550);
        tableView.setPrefHeight(300);
        tableView.setEditable(false);
    }

    /**
     * Gets add order button.
     *
     * @return the add order button
     */
    public Button getAddOrderButton() {
        return addOrderButton;
    }

    /**
     * Gets update order button.
     *
     * @return the update order button
     */
    public Button getUpdateOrderButton() {
        return updateOrderButton;
    }

    /**
     * Gets delete order button.
     *
     * @return the delete order button
     */
    public Button getDeleteOrderButton() {
        return deleteOrderButton;
    }

    /**
     * Gets view order button.
     *
     * @return the view order button
     */
    public Button getViewOrderButton() {
        return viewOrderButton;
    }

    /**
     * Gets back button.
     *
     * @return the back button
     */
    public Button getBackButton() {
        return backButton;
    }

    /**
     * Gets id text field.
     *
     * @return the id text field
     */
    public TextField getIdTextField() {
        return idTextField;
    }

    /**
     * Gets clients name text field.
     *
     * @return the clients name text field
     */
    public TextField getClientsNameTextField() {
        return clientsNameTextField;
    }

    /**
     * Gets products name text field.
     *
     * @return the products name text field
     */
    public TextField getProductsNameTextField() {
        return productsNameTextField;
    }

    /**
     * Gets quantity text field.
     *
     * @return the quantity text field
     */
    public TextField getQuantityTextField() {
        return quantityTextField;
    }

    /**
     * Gets table view.
     *
     * @return the table view
     */
    public TableView<Orders> getTableView() {
        return tableView;
    }
}
