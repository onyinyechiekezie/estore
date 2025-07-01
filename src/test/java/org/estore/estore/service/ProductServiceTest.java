package org.estore.estore.service;

import org.estore.estore.dto.request.AddProductRequest;
import org.estore.estore.dto.request.UpdateProductRequest;
import org.estore.estore.dto.response.AddProductResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.estore.estore.util.TestUtils.buildAddProduct;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    public void testCanAddProduct() {
        AddProductRequest productRequest = new AddProductRequest();
        AddProductResponse productResponse = productService.add(buildAddProduct());
        assertThat(productResponse).isNotNull();
        assertThat(productResponse.getMedia()).isNotEmpty();
    }

    @Test
    @Sql(scripts = {"/db/script.sql"})
    public void testCanUpdateProduct(){
        System.out.println("Can update product");
        UpdateProductRequest updateProductRequest = new UpdateProductRequest();
        updateProductRequest.setName("");
    }
}
