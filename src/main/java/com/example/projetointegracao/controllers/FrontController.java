package com.example.projetointegracao.controllers;

import com.example.projetointegracao.dto.CategoryDTO;
import com.example.projetointegracao.dto.LineDTO;
import com.example.projetointegracao.dto.ProductDTO;
import com.example.projetointegracao.services.CategoryService;
import com.example.projetointegracao.services.LineService;
import javafx.collections.FXCollections;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.*;

public class FrontController {
    LineService lineService = new LineService();
    CategoryService categoryService = new CategoryService();
    List<LineDTO> lines;

    @FXML
    private TreeView<String> categoriesWithProductsTreeView;

    @FXML
    private TitledPane modelsTitledPane;

    @FXML
    private ComboBox<LineDTO> lineComboBox;

    @FXML
    public void initialize() {
        setComboBoxLine();
    }

    private void setComboBoxLine() {

        lines = lineService.getAllLines();

        lineComboBox.setItems(FXCollections.observableArrayList(lines));
        lineComboBox.setPromptText("Selecione uma Linha");
        lineComboBox.setOnAction(event -> onItemSelectedLineCombo());
    }

    private void onItemSelectedLineCombo() {

        Long selectedLine = lineComboBox
                .getSelectionModel()
                .getSelectedItem()
                .getId();

        if (selectedLine != null) {
            showCategoriesWithProducts();
            buildCategoryProductTree(categoryService.getCategoriesByLine(selectedLine));
        }
    }

    private void showCategoriesWithProducts() {
        modelsTitledPane.setDisable(false);
        modelsTitledPane.setExpanded(true);
    }

    private void buildCategoryProductTree(List<CategoryDTO> categories) {

        TreeItem<String> root = new TreeItem<>("Categorias com Produtos");
        root.setExpanded(true);

        for (CategoryDTO category : categories) {
            TreeItem<String> categoryItem = new TreeItem<>(category.getName());
            List<ProductDTO> productList = category.getProducts();
            for (ProductDTO product : productList) {
                categoryItem.getChildren().add(new TreeItem<>(product.getName()));
            }

            root.getChildren().add(categoryItem);
        }

        categoriesWithProductsTreeView.setRoot(root);
    }
}