package com.itwill.jpa.service.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.repositiry.product.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public void saveProduct(Product product) {
        productRepository.insert(product);
    }

    @Transactional
    public void updateProduct(Long productId, String name, int price) {
        Product findProduct = productRepository.findOneById(productId);
        findProduct.setName(name);
        findProduct.setPrice(price);
    }

    public List<Product> findProduct() {
        return productRepository.findAll();
    }

    public Product findOne(Long productId) { return productRepository.findOneById(productId);
    }
}
