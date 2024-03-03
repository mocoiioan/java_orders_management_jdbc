package com.example.assignment3.Presentation;

import com.example.assignment3.BusinessLogic.ClientsBLL;
import com.example.assignment3.DataAccess.ClientsDAO;
import com.example.assignment3.Model.Clients;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Client controller.
 */
public class ClientController {
    private static ClientView clientView;
    private static ClientsBLL clientsBLL;

    /**
     * Instantiates a new Client controller.
     *
     * @param clientView the client view
     */
    public ClientController(ClientView clientView) {
        clientsBLL = new ClientsBLL();
        this.clientView = clientView;
    }

    /**
     * Gets client view.
     *
     * @return the client view
     */
    public ClientView getClientView() {
        return clientView;
    }

    /**
     * The constant viewAllClients.
     */
    public static EventHandler<ActionEvent> viewAllClients = actionEvent -> {
//        ClientsDAO clientsDAO = new ClientsDAO();
//        JTable table = (clientsDAO.generateTable());
//        table.setFillsViewportHeight(true);
//        JScrollPane scrollPane = new JScrollPane();
//        scrollPane.setViewportView(table);
//        SwingNode swingNode = new SwingNode();
//        swingNode.setContent(scrollPane);
//        swingNode.setLayoutX(135);
//        swingNode.setLayoutY(100);
//        clientView.setSwingNode(swingNode);
        List<String> fields = new ArrayList<>();
        List<Clients> clientsList = clientsBLL.findAllClients(fields);
        clientView.getTableView().getColumns().clear();
        List<TableColumn<Clients, String>> tCol = new ArrayList<>();
        ObservableList<Clients> observableList = FXCollections.observableArrayList(clientsList);
//        List<SimpleStringProperty> ssp = (new Clients()).getPropertyList();
        Integer i = 0;
        for (String s : fields) {
            TableColumn<Clients, String> col = new TableColumn<>(s);
            col.setPrefWidth(135);
            final Integer finalInt = i;
            col.setCellValueFactory(f -> f.getValue().getPropertyList().get(finalInt));
            tCol.add(col);
            i++;
        }
        clientView.getTableView().setItems(observableList);
        for (TableColumn<Clients, String> col : tCol) {
            clientView.getTableView().getColumns().add(col);
        }
    };

    /**
     * The constant addClient.
     */
    public static EventHandler<ActionEvent> addClient = actionEvent -> {
        Clients client = new Clients(clientView.getNameTextField().getText(),
                clientView.getEmailTextField().getText(),
                clientView.getAddressTextField().getText());
        Clients dummyClient = clientsBLL.insertClient(client);
    };

    /**
     * The constant updateClient.
     */
    public static EventHandler<ActionEvent> updateClient = actionEvent -> {
        Clients client = new Clients(Integer.parseInt(clientView.getIdTextField().getText()),
                clientView.getNameTextField().getText(),
                clientView.getEmailTextField().getText(),
                clientView.getAddressTextField().getText());
        Clients dummyClient = clientsBLL.updateClient(client, clientView.getNameTextField().getText());
    };

    /**
     * The constant deleteClient.
     */
    public static EventHandler<ActionEvent> deleteClient = actionEvent -> {
        String name = clientView.getNameTextField().getText();
        String dummyString = clientsBLL.deleteClient(name);
    };

}
