package com.example.assignment3.Presentation;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * The type Main view.
 */
public class MainView {
    private Button clientButton;
    private Button productButton;
    private Button orderButton;

    /**
     * Instantiates a new Main view.
     */
    public MainView() {
        clientButton = new Button();
        clientButton.setText("Client");
        clientButton.setLayoutX(110);
        clientButton.setLayoutY(50);
        clientButton.setPrefWidth(100);

        productButton = new Button();
        productButton.setText("Product");
        productButton.setLayoutX(110);
        productButton.setLayoutY(100);
        productButton.setPrefWidth(100);

        orderButton = new Button();
        orderButton.setText("Order");
        orderButton.setLayoutX(110);
        orderButton.setLayoutY(150);
        orderButton.setPrefWidth(100);
    }

    /**
     * Gets client button.
     *
     * @return the client button
     */
    public Button getClientButton() {
        return clientButton;
    }

    /**
     * Gets product button.
     *
     * @return the product button
     */
    public Button getProductButton() {
        return productButton;
    }

    /**
     * Gets order button.
     *
     * @return the order button
     */
    public Button getOrderButton() {
        return orderButton;
    }
}
