package com.spring.springassignment.controller;

import com.spring.springassignment.entity.Product;
import com.spring.springassignment.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTest {
    @Mock
    private ProductService productService;
    @Mock
    private Model model;

    @InjectMocks
    private ProductController productController;

    @Test
    public void testListProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product());
        when(productService.findAll()).thenReturn(products);
        String view = productController.getAllProducts(model);
        assertEquals("products/list-products", view);
        verify(productService, times(1)).findAll();
    }

    @Test
    public void testShowFormForAdd() {
        String view = productController.showFormForAdd(model);
        assertEquals("products/product-form", view);
        verify(model, times(1)).addAttribute(eq("product"), any(Product.class));
    }

    @Test
    public void testSaveProduct() {
        Product product = new Product();
        String view = productController.saveProduct(product);
        assertEquals("redirect:/products", view);
        verify(productService, times(1)).save(product);
    }

    @Test
    public void testShowFormForUpdate() {
        int productId = 1;
        Product product = new Product();
        product.setId(productId);
        when(productService.findById(productId)).thenReturn(product);
        String view = productController.showFormForUpdate(productId, model);
        assertEquals("products/product-form", view);
        verify(productService, times(1)).findById(productId);
        verify(model, times(1)).addAttribute("product", product);
    }

    @Test
    public void testDelete() {
        int productId = 1;
        String view = productController.delete(productId);
        assertEquals("redirect:/products", view);
        verify(productService, times(1)).deleteById(productId);
    }
}
