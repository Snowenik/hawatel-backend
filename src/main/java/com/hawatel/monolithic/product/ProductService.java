package com.hawatel.monolithic.product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();
    String addNewProduct(NewProductDTO newProductDTO);
    String deleteProduct(DeleteProductDTO deleteProductDTO);
    String editProduct(EditProductDTO editProductDTO);
    Product getProduct(GetProductDTO getProductDTO);
}
