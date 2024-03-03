package com.example.assignment3.DataAccess;

import com.example.assignment3.Connection.ConnectionFactory;
import com.example.assignment3.Model.Clients;
import com.example.assignment3.Model.Orders;
import com.example.assignment3.Model.Products;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * The type Abstract dao.
 *
 * @param <T> the type parameter
 */
public class AbstractDAO<T> {
    /**
     * The constant LOGGER.
     */
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
    private final Class<T> type;


    /**
     * Instantiates a new Abstract dao.
     */
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }


    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    private String createInsertQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(type.getSimpleName());
        sb.append(" (");
        for (Field field : type.getDeclaredFields()) {
            sb.append(field.getName());
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(") VALUES (");
        for (Field field : type.getDeclaredFields()) {
            sb.append("?, ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(")");
        return sb.toString();
    }

    private String createUpdateQuery(String queryField) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(type.getSimpleName());
        sb.append(" SET ");
        for (Field field : type.getDeclaredFields()) {
            sb.append(field.getName());
            sb.append(" = ?, ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(" WHERE " + queryField + " =?");
        return sb.toString();
    }

    private String createDeleteQuery(String queryField) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + queryField + " =?");
        return sb.toString();
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<T> findAll(List<String> fields) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("_");
        query = query.split("WHERE")[0];
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            for (Field field : type.getDeclaredFields()) {
                fields.add(field.getName());
            }
            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Find by id t.
     *
     * @param id the id
     * @return the t
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery(type.getSimpleName() + "Id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T) ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Insert t.
     *
     * @param t the t
     * @return the t
     */
    public T insert(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createInsertQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            int i = 1;
            for (Field field : type.getDeclaredFields()) {
                field.setAccessible(true);
                statement.setObject(i, field.get(t));
                i++;
            }
            statement.executeUpdate();
            return t;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Update t.
     *
     * @param t    the t
     * @param name the name
     * @return the t
     */
    public T update(T t, String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createUpdateQuery(type.getSimpleName() + "Name");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            int i = 1;
            for (Field field : type.getDeclaredFields()) {
                field.setAccessible(true);
                statement.setObject(i, field.get(t));
                i++;
            }
            statement.setString(i, name);
            statement.executeUpdate();
            return t;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Delete string.
     *
     * @param name the name
     * @return the string
     */
    public String delete(String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createDeleteQuery(type.getSimpleName() + "Name");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.executeUpdate();
            return name;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }


    public JTable generateTable() {
        List<String> fields = new ArrayList<>();
        List<T> obj = findAll(fields);
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.setColumnIdentifiers(fields.toArray());
        for(T t : obj){
            Object[] rows = new Object[fields.size()];
            int i = 0;
            for(String s : fields){
                try {
                    Field field = type.getDeclaredField(fields.get(i));
                    field.setAccessible(true);
                    rows[i] = field.get(t);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                i++;
            }
            defaultTableModel.addRow(rows);
        }
        JTable jTable = new JTable(defaultTableModel);
        jTable.setRowHeight(20);
        Integer i = 0;
        for(String s : fields){
            jTable.getColumnModel().getColumn(i).setPreferredWidth(135);
            i++;
        }
        return jTable;
    }
}

