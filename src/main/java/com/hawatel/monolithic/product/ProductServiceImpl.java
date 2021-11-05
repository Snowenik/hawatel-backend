package com.hawatel.monolithic.product;

import com.hawatel.monolithic.audit.LoggerServiceImpl;
import com.hawatel.monolithic.operation.OperationRepository;
import com.hawatel.monolithic.operation.OperationServiceImpl;
import com.hawatel.monolithic.operation.OperationType;
import com.hawatel.monolithic.user.User;
import com.hawatel.monolithic.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private OperationServiceImpl operationService;

    @Autowired
    private LoggerServiceImpl loggerService;

    @Override
    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public String addNewProduct(NewProductDTO newProductDTO) {
        Product product = new Product();
        User user = userRepository.findById(newProductDTO.getUserId()).get();
        user.addProduct(product);
        product.setProduct(newProductDTO.getProduct());
        product.setComment(newProductDTO.getComment());
        product.setValue(newProductDTO.getValue());
        product.setAmount(newProductDTO.getAmount());
        productRepository.save(product);
        user.addOperation(operationService.createNewOperation(OperationType.ADD, new Date()));
        loggerService.logOperation(user, new Date(), OperationType.ADD);
        return "Produkt zostal dodany pomyslnie";
    }

    @Override
    public String deleteProduct(DeleteProductDTO deleteProductDTO) {
        Product product = productRepository.findById(deleteProductDTO.getProductId()).get();
        User user = userRepository.findById(deleteProductDTO.getUserId()).get();
        user.removeProduct(product);
        productRepository.delete(product);
        user.addOperation(operationService.createNewOperation(OperationType.REMOVE, new Date()));
        loggerService.logOperation(user, new Date(), OperationType.REMOVE);
        return "Produkt zostal usuniety";
    }

    @Override
    public String editProduct(EditProductDTO editProductDTO) {
        Product product = productRepository.findById(editProductDTO.getProductId()).get();
        User user = userRepository.findById(editProductDTO.getUserId()).get();
        product.setProduct(editProductDTO.getProduct());
        product.setAmount(editProductDTO.getAmount());
        product.setValue(editProductDTO.getValue());
        product.setComment(editProductDTO.getComment());
        user.addOperation(operationService.createNewOperation(OperationType.MODIFY, new Date()));
        loggerService.logOperation(user, new Date(), OperationType.MODIFY);
        return "Zmiany zostaly zapisane pomyslnie";
    }

    @Override
    public Product getProduct(GetProductDTO getProductDTO) {
        return productRepository.findById(getProductDTO.getProductId()).get();
    }
}















