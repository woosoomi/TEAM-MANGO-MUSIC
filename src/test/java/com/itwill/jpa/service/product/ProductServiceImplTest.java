package com.itwill.jpa.service.product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.javassist.compiler.ast.Keyword;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.entity.product.Product;
@SpringBootTest
class ProductServiceImplTest {
	@Autowired
	ProductServiceImpl productServiceImpl;

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void searchProductsByKeywordTest() {
		String keyword = "강북멋쟁이";
		List<Product> products = productServiceImpl.searchProductsByKeyword(keyword);
		System.out.println("검색결과>>>" + products);
	}

}
