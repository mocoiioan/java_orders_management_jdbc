package com.example.assignment3.Presentation;

import com.example.assignment3.Model.Clients;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * The type Client view.
 */
public class ClientView {
    private Button addClientButton;
    private Button updateClientButton;
    private Button deleteClientButton;
    private Button viewClientButton;
    private Button backButton;
    private TextField idTextField;
    private TextField nameTextField;
    private TextField emailTextField;
    private TextField addressTextField;
    private TableView<Clients> tableView;

    /**
     * Instantiates a new Client view.
     */
    public ClientView() {
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

        emailTextField = new TextField();
        emailTextField.setPromptText("Email");
        emailTextField.setEditable(true);
        emailTextField.setLayoutX(400);
        emailTextField.setLayoutY(50);
        emailTextField.setPrefWidth(100);

        addressTextField = new TextField();
        addressTextField.setPromptText("Address");
        addressTextField.setEditable(true);
        addressTextField.setLayoutX(550);
        addressTextField.setLayoutY(50);
        addressTextField.setPrefWidth(100);

        addClientButton = new Button("Add Client");
        addClientButton.setLayoutX(100);
        addClientButton.setLayoutY(100);
        addClientButton.setPrefWidth(100);
        addClientButton.setOnAction(ClientController.addClient);

        updateClientButton = new Button("Update Client");
        updateClientButton.setLayoutX(250);
        updateClientButton.setLayoutY(100);
        updateClientButton.setPrefWidth(100);
        updateClientButton.setOnAction(ClientController.updateClient);

        deleteClientButton = new Button("Delete Client");
        deleteClientButton.setLayoutX(400);
        deleteClientButton.setLayoutY(100);
        deleteClientButton.setPrefWidth(100);
        deleteClientButton.setOnAction(ClientController.deleteClient);

        viewClientButton = new Button("View Clients");
        viewClientButton.setLayoutX(550);
        viewClientButton.setLayoutY(100);
        viewClientButton.setPrefWidth(100);
        viewClientButton.setOnAction(ClientController.viewAllClients);

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
     * Gets email text field.
     *
     * @return the email text field
     */
    public TextField getEmailTextField() {
        return emailTextField;
    }

    /**
     * Gets address text field.
     *
     * @return the address text field
     */
    public TextField getAddressTextField() {
        return addressTextField;
    }

    /**
     * Gets add client button.
     *
     * @return the add client button
     */
    public Button getAddClientButton() {
        return addClientButton;
    }

    /**
     * Gets update client button.
     *
     * @return the update client button
     */
    public Button getUpdateClientButton() {
        return updateClientButton;
    }

    /**
     * Gets delete client button.
     *
     * @return the delete client button
     */
    public Button getDeleteClientButton() {
        return deleteClientButton;
    }

    /**
     * Gets view client button.
     *
     * @return the view client button
     */
    public Button getViewClientButton() {
        return viewClientButton;
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
     * Gets table view.
     *
     * @return the table view
     */
    public TableView getTableView() {
        return tableView;
    }

}
