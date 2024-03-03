package com.example.assignment3.Presentation;

import com.example.assignment3.Model.Products;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * The type Product view.
 */
public class ProductView {
    private Button addProductButton;
    private Button updateProductButton;
    private Button deleteProductButton;
    private Button viewProductsButton;
    private Button backButton;
    private TextField idTextField;
    private TextField nameTextField;
    private TextField priceTextField;
    private TextField stockTextField;
    private TableView<Products> tableView;

    /**
     * Instantiates a new Product view.
     */
    public ProductView(){
        idTextField = new TextField();
        idTextField.setPromptText("ID");
        idTextField.setEditable(true);
        idTextField.setLayoutX(100);
        idTextField.setLayoutY(50);
        idTextField.setPrefWidth(100);

        nameTextField = new TextField();
        nameTextField.setPromptText("Name");
        nameTextField.setEditable(true);
        nameTextField.setLayoutX(250);
        nameTextField.setLayoutY(50);
        nameTextField.setPrefWidth(100);

        priceTextField = new TextField();
        priceTextField.setPromptText("Price");
        priceTextField.setEditable(true);
        priceTextField.setLayoutX(400);
        priceTextField.setLayoutY(50);
        priceTextField.setPrefWidth(100);

        stockTextField = new TextField();
        stockTextField.setPromptText("Stock");
        stockTextField.setEditable(true);
        stockTextField.setLayoutX(550);
        stockTextField.setLayoutY(50);
        stockTextField.setPrefWidth(100);

        addProductButton = new Button("Add Product");
        addProductButton.setLayoutX(100);
        addProductButton.setLayoutY(100);
        addProductButton.setPrefWidth(100);
        addProductButton.setOnAction(ProductController.addProduct);

        updateProductButton = new Button("Update Product");
        updateProductButton.setLayoutX(250);
        updateProductButton.setLayoutY(100);
        updateProductButton.setPrefWidth(100);
        updateProductButton.setOnAction(ProductController.updateProduct);

        deleteProductButton = new Button("Delete Product");
        deleteProductButton.setLayoutX(400);
        deleteProductButton.setLayoutY(100);
        deleteProductButton.setPrefWidth(100);
        deleteProductButton.setOnAction(ProductController.deleteProduct);

        viewProductsButton = new Button("View Products");
        viewProductsButton.setLayoutX(550);
        viewProductsButton.setLayoutY(100);
        viewProductsButton.setPrefWidth(100);
        viewProductsButton.setOnAction(ProductController.viewAllProducts);

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
     * Gets add product button.
     *
     * @return the add product button
     */
    public Button getAddProductButton() {
        return addProductButton;
    }

    /**
     * Gets update product button.
     *
     * @return the update product button
     */
    public Button getUpdateProductButton() {
        return updateProductButton;
    }

    /**
     * Gets delete product button.
     *
     * @return the delete product button
     */
    public Button getDeleteProductButton() {
        return deleteProductButton;
    }

    /**
     * Gets view products button.
     *
     * @return the view products button
     */
    public Button getViewProductsButton() {
        return viewProductsButton;
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
     * Gets name text field.
     *
     * @return the name text field
     */
    public TextField getNameTextField() {
        return nameTextField;
    }

    /**
     * Gets price text field.
     *
     * @return the price text field
     */
    public TextField getPriceTextField() {
        return priceTextField;
    }

    /**
     * Gets stock text field.
     *
     * @return the stock text field
     */
    public TextField getStockTextField() {
        return stockTextField;
    }

    /**
     * Gets table view.
     *
     * @return the table view
     */
    public TableView<Products> getTableView() {
        return tableView;
    }
}
