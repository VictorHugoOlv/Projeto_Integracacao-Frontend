package com.example.projetointegracao;

import com.example.projetointegracao.controllers.FrontController;
import com.example.projetointegracao.dto.LineDTO;
import com.example.projetointegracao.services.CategoryService;
import com.example.projetointegracao.services.LineService;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@ExtendWith(ApplicationExtension.class)
public class FrontControllerTest {

    @Mock
    private LineService lineService;

    @Mock
    private CategoryService categoryService;

    @Spy
    @InjectMocks
    private FrontController frontController;

    @BeforeEach
    void setUp() {
        frontController.lineComboBox = new ComboBox<>();
        frontController.categoriesWithProductsTreeView = new TreeView<>();
        frontController.modelsTitledPane = new TitledPane();
    }

    @Test
    @DisplayName("Garantir que a ComboBox está sendo preenchida corretamente")
    void InitializeTest() {
        List<LineDTO> lineDTOList = Arrays.asList(new LineDTO(1L, "linha1"));
        when(lineService.getAllLines()).thenReturn(lineDTOList);

        frontController.initialize();

        assertEquals(1, frontController.lineComboBox.getItems().size());
        assertEquals("linha1", frontController.lineComboBox.getItems().get(0).getName());
    }
}
