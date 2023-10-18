package com.itwill.jpa.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.jpa.dao.product.ProductDao;
import com.itwill.jpa.entity.product.Product;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao productDao;
	

    public void saveProduct(Product product) {
        productDao.insertProduct(null);
    }

//    @Transactional
//    public void updateProduct(Long productId, String name, int price) {
//        Product findProduct = productRepository.findOneById(productId);
//  //      findProduct.setName(name);
//  //      findProduct.setPrice(price);
//    }
//
//    public List<Product> findProduct() {
//        return productRepository.findAll();
//    }
//
//    public Product findOne(Long productId) { return productRepository.findOneById(productId);
//    }
}
