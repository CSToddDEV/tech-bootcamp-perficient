package com.perficient.techbootcampcalvintodd;

import com.perficient.techbootcampcalvintodd.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class TechBootcampPerficientApplicationTests {

    @Mock
    Product mockProduct;

    @Test
    @DisplayName("This Method Is a Test Assert to Ensure that True === True")
    public void thisMethodAssertsTrue() {
        assertTrue(true);
    }

    @Test
    @DisplayName("This Method Tests that a Product Creates With The Correct Name")
    public void testNewProductName() {
        Product new_product = new Product();
        assertEquals("Beard Oil", new_product.getProduct_type(), "Name should be the same as when created");
    }

    @Test
    @DisplayName("This Method Tests that a Product Creates With The Correct Cost")
    public void testNewProductCost() {
        Product new_product = new Product();
        assertEquals(12.99, new_product.getPrice(), "Cost should be the same as when created");
    }

    @Test
    @DisplayName("Test Mocking with Mockito")
    public void testMocking() {
        assertNotNull(mockProduct);
        when(mockProduct.getProduct_type()).thenReturn("WAX");
        when(mockProduct.getPrice()).thenReturn(5.99);

        assertEquals("WAX", mockProduct.getProduct_type(), "The Product Name should equal the mock " +
                "product name");
        assertEquals(5.99, mockProduct.getPrice(), "The product price should equal the mock product " +
                "price");
    }

    @Test
    @DisplayName("Testing Write To Log Error Handling")
    public void testError() {
        Product new_product = new Product();
        double price = new_product.getPrice();
        assertEquals(price, -12.12, "Price should be negative 12.12 so that Error message triggers.");
    }
}
