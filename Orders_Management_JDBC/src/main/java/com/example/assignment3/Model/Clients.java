package com.example.assignment3.Model;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Clients.
 */
public class Clients {
    private Integer clientsId;
    private String clientsName;
    private String clientsEmail;
    private String clientsAddress;

    /**
     * Instantiates a new Clients.
     */
    public Clients() {
    }

    /**
     * Instantiates a new Clients.
     *
     * @param clientId      the client id
     * @param clientName    the client name
     * @param clientEmail   the client email
     * @param clientAddress the client address
     */
    public Clients(Integer clientId, String clientName, String clientEmail, String clientAddress) {
        super();
        this.clientsId = clientId;
        this.clientsName = clientName;
        this.clientsEmail = clientEmail;
        this.clientsAddress = clientAddress;
    }

    /**
     * Instantiates a new Clients.
     *
     * @param clientName    the client name
     * @param clientEmail   the client email
     * @param clientAddress the client address
     */
    public Clients(String clientName, String clientEmail, String clientAddress) {
        super();
        this.clientsName = clientName;
        this.clientsEmail = clientEmail;
        this.clientsAddress = clientAddress;
    }

    /**
     * Gets clients id.
     *
     * @return the clients id
     */
    public Integer getClientsId() {
        return clientsId;
    }

    /**
     * Sets clients id.
     *
     * @param clientsId the clients id
     */
    public void setClientsId(Integer clientsId) {
        this.clientsId = clientsId;
    }

    /**
     * Gets clients name.
     *
     * @return the clients name
     */
    public String getClientsName() {
        return clientsName;
    }

    /**
     * Sets clients name.
     *
     * @param clientsName the clients name
     */
    public void setClientsName(String clientsName) {
        this.clientsName = clientsName;
    }

    /**
     * Gets clients email.
     *
     * @return the clients email
     */
    public String getClientsEmail() {
        return clientsEmail;
    }

    /**
     * Sets clients email.
     *
     * @param clientsEmail the clients email
     */
    public void setClientsEmail(String clientsEmail) {
        this.clientsEmail = clientsEmail;
    }

    /**
     * Gets clients address.
     *
     * @return the clients address
     */
    public String getClientsAddress() {
        return clientsAddress;
    }

    /**
     * Sets clients address.
     *
     * @param clientsAddress the clients address
     */
    public void setClientsAddress(String clientsAddress) {
        this.clientsAddress = clientsAddress;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientsId +
                ", clientName='" + clientsName + '\'' +
                ", clientEmail='" + clientsEmail + '\'' +
                ", clientAddress='" + clientsAddress + '\'' +
                '}';
    }

    /**
     * Clients id property simple string property.
     *
     * @return the simple string property
     */
    public SimpleStringProperty clientsIdProperty() {
        return new SimpleStringProperty(String.valueOf(clientsId));
    }

    /**
     * Clients name property simple string property.
     *
     * @return the simple string property
     */
    public SimpleStringProperty clientsNameProperty() {
        return new SimpleStringProperty(clientsName);
    }

    /**
     * Clients email property simple string property.
     *
     * @return the simple string property
     */
    public SimpleStringProperty clientsEmailProperty() {
        return new SimpleStringProperty(clientsEmail);
    }

    /**
     * Clients address property simple string property.
     *
     * @return the simple string property
     */
    public SimpleStringProperty clientsAddressProperty() {
        return new SimpleStringProperty(clientsAddress);
    }

    public List<SimpleStringProperty> getPropertyList(){
        List<SimpleStringProperty> ssp = new ArrayList<>();
        ssp.add(clientsIdProperty());
        ssp.add(clientsNameProperty());
        ssp.add(clientsEmailProperty());
        ssp.add(clientsAddressProperty());
        return ssp;
    }
}
