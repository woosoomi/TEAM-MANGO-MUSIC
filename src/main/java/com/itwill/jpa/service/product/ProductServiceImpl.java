package com.itwill.jpa.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.jpa.dao.product.ProductDao;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.repository.product.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	@Autowired
	private final ProductRepository productRepository;
	private final ProductDao productDao;
	

	public ProductServiceImpl(ProductRepository productRepository, ProductDao productDao) {
		this.productRepository = productRepository;
		this.productDao = productDao;
	}
	
    public void saveProduct(Product product) {
        productDao.insertProduct(product);
    }

    // ============================ 음악 내립차순 정렬 ============================//
//	@Override
//	public List<ProductDao> getAllMusicByProductNoDesc() {
//		return productDao.getAllMusicByProductNoDesc();
//	}
	
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
