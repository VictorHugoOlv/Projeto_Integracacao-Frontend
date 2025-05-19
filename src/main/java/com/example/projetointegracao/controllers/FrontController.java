package com.example.projetointegracao.controllers;

import javafx.collections.FXCollections;
import org.example.controllers.CategoryController;
import org.example.controllers.LineController;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import org.example.models.Category;
import org.example.models.Line;
import org.example.models.Product;

import java.util.*;

public class FrontController {
    LineController lineController = new LineController();
    CategoryController categoryController = new CategoryController();

    @FXML
    private TreeView<String> categoriesWithProductsTreeView;

    @FXML
    private TitledPane modelsTitledPane;

    @FXML
    private ComboBox<Line> lineComboBox;

    @FXML
    public void initialize() {
        setComboBoxLine();
    }

    private void setComboBoxLine() {

        List<Line> lines = lineController.getAllLines();

        lineComboBox.setItems(FXCollections.observableArrayList(lines));
        lineComboBox.setPromptText("Selecione uma Linha");
        lineComboBox.setOnAction(event -> onItemSelectedLineCombo());
    }

    private void onItemSelectedLineCombo() {

        Line selectedLine = lineComboBox
                .getSelectionModel()
                .getSelectedItem();

        if (selectedLine != null) {
            showCategoriesWithProducts();
            buildCategoryProductTree(categoryController.getCategoriesByLine(selectedLine));
        }
    }

    private void showCategoriesWithProducts() {
        modelsTitledPane.setDisable(false);
        modelsTitledPane.setExpanded(true);
    }

    private void buildCategoryProductTree(List<Category> categories) {

        TreeItem<String> root = new TreeItem<>("Categorias com Produtos");
        root.setExpanded(true);

        for (Category category : categories) {
            TreeItem<String> categoryItem = new TreeItem<>(category.getCategoryName());

            for (Product product : category.getProducts()) {
                categoryItem.getChildren().add(new TreeItem<>(product.getProductName()));
            }

            root.getChildren().add(categoryItem);
        }

        categoriesWithProductsTreeView.setRoot(root);
    }
}