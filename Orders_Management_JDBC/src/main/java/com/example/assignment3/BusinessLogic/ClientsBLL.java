package com.example.assignment3.BusinessLogic;

import com.example.assignment3.DataAccess.ClientsDAO;
import com.example.assignment3.Model.Clients;

import java.util.List;

/**
 * The type Clients bll.
 */
public class ClientsBLL {
    private ClientsDAO clientsDAO;

    /**
     * Instantiates a new Clients bll.
     */
    public ClientsBLL() {
        this.clientsDAO = new ClientsDAO();
    }

    /**
     * Gets clients dao.
     *
     * @return the clients dao
     */
    public ClientsDAO getClientsDAO() {
        return clientsDAO;
    }

    /**
     * Find client by id clients.
     *
     * @param id the id
     * @return the clients
     */
    public Clients findClientById(int id) {
        Clients client = clientsDAO.findById(id);
        if (client == null) {
            throw new IllegalArgumentException("The client with id =" + id + " was not found!");
        }
        return client;
    }

    /**
     * Find all clients list.
     *
     * @return the list
     */
    public List<Clients> findAllClients(List<String> fields) {
        List<Clients> clients = clientsDAO.findAll(fields);
        if (clients == null) {
            throw new IllegalArgumentException("There are no clients in the database!");
        }
        return clients;
    }

    /**
     * Insert client clients.
     *
     * @param client the client
     * @return the clients
     */
    public Clients insertClient(Clients client) {
        Clients clients = clientsDAO.insert(client);
        if (clients == null) {
            throw new IllegalArgumentException("The client could not be inserted!");
        }
        return clients;
    }

    /**
     * Delete client string.
     *
     * @param name the name
     * @return the string
     */
    public String deleteClient(String name) {
        Clients clients = new Clients();
        clients.setClientsName(clientsDAO.delete(name));
        if (clients == null) {
            throw new IllegalArgumentException("The client could not be deleted!");
        }
        return name;
    }

    /**
     * Update client clients.
     *
     * @param client the client
     * @param name   the name
     * @return the clients
     */
    public Clients updateClient(Clients client, String name) {
        Clients clients = clientsDAO.update(client, name);
        if (clients == null) {
            throw new IllegalArgumentException("The client could not be updated!");
        }
        return clients;
    }
}
