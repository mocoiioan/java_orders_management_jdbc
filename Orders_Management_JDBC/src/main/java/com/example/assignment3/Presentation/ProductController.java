package com.example.assignment3.Presentation;

import com.example.assignment3.BusinessLogic.ProductsBLL;
import com.example.assignment3.Model.Products;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Product controller.
 */
public class ProductController {
    private static ProductView productView;
    private static ProductsBLL productsBLL;

    /**
     * Instantiates a new Product controller.
     *
     * @param productView the product view
     */
    public ProductController(ProductView productView) {
        this.productView = productView;
        productsBLL = new ProductsBLL();
    }

    /**
     * Gets product view.
     *
     * @return the product view
     */
    public ProductView getProductView() {
        return productView;
    }

    /**
     * The constant viewAllProducts.
     */
    public static EventHandler<ActionEvent> viewAllProducts = actionEvent -> {
        List<String> fields = new ArrayList<>();
        List<Products> productsList = productsBLL.findAllProducts(fields);
        productView.getTableView().getColumns().clear();
        List<TableColumn<Products, String>> tCol = new ArrayList<>();
        ObservableList productsObservableList = FXCollections.observableArrayList(productsList);
//        List<SimpleStringProperty> ssp = (new Products()).getPropertyList();
        Integer i = 0;
        for(String s : fields){
            TableColumn<Products, String> col = new TableColumn<>(s);
            col.setPrefWidth(135);
            final Integer finalInt = i;
            col.setCellValueFactory(f -> f.getValue().getPropertyList().get(finalInt));
            tCol.add(col);
            i++;
        }
        productView.getTableView().setItems(productsObservableList);
        for(TableColumn<Products, String> col : tCol){
            productView.getTableView().getColumns().add(col);
        }
    };

    /**
     * The constant addProduct.
     */
    public static EventHandler<ActionEvent> addProduct = actionEvent -> {
        Products product = new Products(productView.getNameTextField().getText(),
                Integer.parseInt(productView.getStockTextField().getText()),
                Double.parseDouble(productView.getPriceTextField().getText()));
        Products dummyProduct = productsBLL.insertProduct(product);
    };

    /**
     * The constant updateProduct.
     */
    public static EventHandler<ActionEvent> updateProduct = actionEvent -> {
        Products product = new Products(Integer.parseInt(productView.getIdTextField().getText()),
                productView.getNameTextField().getText(),
                Integer.parseInt(productView.getStockTextField().getText()),
                Double.parseDouble(productView.getPriceTextField().getText()));
        Products dummyProduct = productsBLL.updateProduct(product, productView.getNameTextField().getText());
    };

    /**
     * The constant deleteProduct.
     */
    public static EventHandler<ActionEvent> deleteProduct = actionEvent -> {
        String name = productView.getNameTextField().getText();
        String dummyString = productsBLL.deleteProduct(name);
    };
}
