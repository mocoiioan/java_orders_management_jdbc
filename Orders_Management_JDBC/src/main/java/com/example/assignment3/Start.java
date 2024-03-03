package com.example.assignment3;

import com.example.assignment3.BusinessLogic.ClientsBLL;
import com.example.assignment3.DataAccess.AbstractDAO;
import com.example.assignment3.DataAccess.ClientsDAO;
import com.example.assignment3.DataAccess.ProductsDAO;
import com.example.assignment3.Model.Clients;
import com.example.assignment3.Presentation.*;
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Start.
 */
public class Start extends Application {
    /**
     * The constant LOGGER.
     */
    protected final static Logger LOGGER = Logger.getLogger(Start.class.getName());

    /**
     * Open main window.
     *
     * @param otherStage the other stage
     */
    public void openMainWindow(Stage otherStage) {
        otherStage.close();
        Stage stage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, 320, 240);
        MainView mainView = new MainView();
        MainController mainController = new MainController(mainView);
        mainController.getMainView().getClientButton().setOnAction(event -> openClientWindow(stage));
        mainController.getMainView().getProductButton().setOnAction(event -> openProductWindow(stage));
        mainController.getMainView().getOrderButton().setOnAction(event -> openOrderWindow(stage));
        root.getChildren().addAll(mainController.getMainView().getClientButton(),
                mainController.getMainView().getProductButton(),
                mainController.getMainView().getOrderButton());
        stage.setTitle("Main Window");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Open client window.
     *
     * @param otherStage the other stage
     */
    public void openClientWindow(Stage otherStage) {
        otherStage.close();
        Stage stage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, 750, 600);
        ClientView clientView = new ClientView();
        ClientController clientController = new ClientController(clientView);
        clientController.getClientView().getBackButton().setOnAction(event -> openMainWindow(stage));
        root.getChildren().addAll(clientController.getClientView().getAddClientButton(),
                clientController.getClientView().getUpdateClientButton(),
                clientController.getClientView().getDeleteClientButton(),
                clientController.getClientView().getViewClientButton(),
                clientController.getClientView().getBackButton(),
                clientController.getClientView().getIdTextField(),
                clientController.getClientView().getNameTextField(),
                clientController.getClientView().getAddressTextField(),
                clientController.getClientView().getEmailTextField(),
                clientController.getClientView().getTableView());
        stage.setTitle("Client Window");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Open product window.
     *
     * @param otherStage the other stage
     */
    public void openProductWindow(Stage otherStage) {
        otherStage.close();
        Stage stage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, 750, 600);
        ProductView productView = new ProductView();
        ProductController productController = new ProductController(productView);
        productController.getProductView().getBackButton().setOnAction(event -> openMainWindow(stage));
        root.getChildren().addAll(productController.getProductView().getAddProductButton(),
                productController.getProductView().getUpdateProductButton(),
                productController.getProductView().getDeleteProductButton(),
                productController.getProductView().getViewProductsButton(),
                productController.getProductView().getBackButton(),
                productController.getProductView().getIdTextField(),
                productController.getProductView().getNameTextField(),
                productController.getProductView().getPriceTextField(),
                productController.getProductView().getStockTextField(),
                productController.getProductView().getTableView());
        stage.setTitle("Product Window");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Open order window.
     *
     * @param otherStage the other stage
     */
    public void openOrderWindow(Stage otherStage) {
        otherStage.close();
        Stage stage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, 750, 600);
        OrderView orderView = new OrderView();
        OrderController orderController = new OrderController(orderView);
        orderController.getOrderView().getBackButton().setOnAction(event -> openMainWindow(stage));
        root.getChildren().addAll(orderController.getOrderView().getAddOrderButton(),
                orderController.getOrderView().getUpdateOrderButton(),
                orderController.getOrderView().getDeleteOrderButton(),
                orderController.getOrderView().getViewOrderButton(),
                orderController.getOrderView().getBackButton(),
                orderController.getOrderView().getIdTextField(),
                orderController.getOrderView().getQuantityTextField(),
                orderController.getOrderView().getClientsNameTextField(),
                orderController.getOrderView().getProductsNameTextField(),
                orderController.getOrderView().getTableView());
        stage.setTitle("Order Window");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Stage dummyStage = new Stage();
        openMainWindow(dummyStage);

//        SwingNode swingNode = new SwingNode();
//        ProductsDAO productsDAO = new ProductsDAO();
//        JTable table = (productsDAO.generateTable());
//        table.setFillsViewportHeight(true);
//        JScrollPane scrollPane = new JScrollPane();
//        scrollPane.setViewportView(table);
//        swingNode.setContent(scrollPane);
//        swingNode.setLayoutX(135);
//        swingNode.setLayoutY(100);
//
//        Group root = new Group();
//        Scene scene = new Scene(root, 750, 600);
//        root.getChildren().add(swingNode);
//        stage.setScene(scene);
//        stage.show();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        launch();

//        SwingNode swingNode = new SwingNode();
//
//        // Create the JTable with the model
//        ClientsDAO clientsDAO = new ClientsDAO();
//        JTable table = (clientsDAO.generateTable());
//        swingNode.setContent(table);
//        Stage stage = new Stage();
//        Group root = new Group();
//        Scene scene = new Scene(root, 500, 500);
//        root.getChildren().add(swingNode);
//        stage.setScene(scene);
//        stage.show();

//        //Create a scroll pane and add the table to it
//        JScrollPane scrollPane = new JScrollPane(table);
//
//        // Create a panel to hold the scroll pane
//        JPanel panel = new JPanel(new BorderLayout());
//        panel.add(scrollPane, BorderLayout.CENTER);
//
//        // Create a frame and add the panel to it
//        JFrame frame = new JFrame("JTable Population Example");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add(panel);
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
    }
}