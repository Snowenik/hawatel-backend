package com.hawatel.monolithic.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {


    @Autowired
    private ProductServiceImpl productService;


    @GetMapping("/loadProducts")
    public @ResponseBody
    List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/addProduct")
    public @ResponseBody String addNewProduct(@RequestBody NewProductDTO newProductDTO) {
        return productService.addNewProduct(newProductDTO);
    }

    @PostMapping("/deleteProduct")
    public @ResponseBody String deleteProduct(@RequestBody DeleteProductDTO deleteProductDTO) {
        return productService.deleteProduct(deleteProductDTO);
    }

    @PostMapping("/editProduct")
    public @ResponseBody String editProduct(@RequestBody EditProductDTO editProductDTO) {
        return productService.editProduct(editProductDTO);
    }

    @PostMapping("/getProduct")
    public @ResponseBody Product getProduct(@RequestBody GetProductDTO getProductDTO) {
        return productService.getProduct(getProductDTO);
    }
}












