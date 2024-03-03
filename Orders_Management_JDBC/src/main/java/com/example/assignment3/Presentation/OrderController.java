package com.example.assignment3.Presentation;

import com.example.assignment3.BusinessLogic.OrdersBLL;
import com.example.assignment3.BusinessLogic.ProductsBLL;
import com.example.assignment3.Connection.ConnectionFactory;
import com.example.assignment3.DataAccess.OrdersDAO;
import com.example.assignment3.DataAccess.ProductsDAO;
import com.example.assignment3.Model.Orders;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * The type Order controller.
 */
public class OrderController {
    private static OrderView orderView;
    private static OrdersBLL ordersBLL;

    /**
     * Instantiates a new Order controller.
     *
     * @param orderView the order view
     */
    public OrderController(OrderView orderView) {
        this.orderView = orderView;
        ordersBLL = new OrdersBLL();
    }

    /**
     * Gets order view.
     *
     * @return the order view
     */
    public OrderView getOrderView() {
        return orderView;
    }

    /**
     * The constant viewAllOrders.
     */
    public static EventHandler<ActionEvent> viewAllOrders = actionEvent -> {
        List<String> fields = new ArrayList<>();
        List<Orders> ordersList = ordersBLL.findAllOrders(fields);
        orderView.getTableView().getColumns().clear();
        List<TableColumn<Orders, String>> tCol = new ArrayList<>();
        ObservableList<Orders> ordersObservableList = FXCollections.observableArrayList(ordersList);
//        List<SimpleStringProperty> ssp = (new Orders()).getPropertyList();
        Integer i = 0;
        for(String s : fields){
            TableColumn<Orders, String> col = new TableColumn<>(s);
            col.setPrefWidth(135);
            final Integer finalInt = i;
            col.setCellValueFactory(f -> f.getValue().getPropertyList().get(finalInt));
            tCol.add(col);
            i++;
        }
        orderView.getTableView().setItems(ordersObservableList);
        for(TableColumn<Orders, String> col : tCol){
            orderView.getTableView().getColumns().add(col);
        }
    };

    /**
     * The constant addOrder.
     */
    public static EventHandler<ActionEvent> addOrder = actionEvent -> {
        Orders order = new Orders(orderView.getClientsNameTextField().getText(),
                orderView.getProductsNameTextField().getText(),
                Integer.parseInt(orderView.getQuantityTextField().getText()));

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "select productsStock from Products where productsName = ?";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, orderView.getProductsNameTextField().getText());
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int stock = resultSet.getInt("productsStock");
                if (stock < Integer.parseInt(orderView.getQuantityTextField().getText())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Not enough stock!");
                    alert.show();
                    return;
                } else {
                    Orders dummyOrder = ordersBLL.insertOrder(order);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

    };

    /**
     * The constant updateOrder.
     */
    public static EventHandler<ActionEvent> updateOrder = actionEvent -> {
        Orders order = new Orders(Integer.parseInt(orderView.getIdTextField().getText()),
                orderView.getClientsNameTextField().getText(),
                orderView.getProductsNameTextField().getText(),
                Integer.parseInt(orderView.getQuantityTextField().getText()));

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = "select productsStock from Products where productsName = ?";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, orderView.getProductsNameTextField().getText());
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int stock = resultSet.getInt("productsStock");
                if (stock < Integer.parseInt(orderView.getQuantityTextField().getText())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Not enough stock!");
                    alert.show();
                    return;
                } else {
                    Orders dummyOrder = ordersBLL.updateOrder(order, orderView.getClientsNameTextField().getText());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

    };

    /**
     * The constant deleteOrder.
     */
    public static EventHandler<ActionEvent> deleteOrder = actionEvent -> {
        String name = orderView.getClientsNameTextField().getText();
        String dummyString = ordersBLL.deleteOrder(name);
    };
}
