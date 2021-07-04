package com.SpringJDBC_ORM.PracticesJDBC_ORM.DAO;
import java.util.*;

public interface ProductMethods {

	int insertProduct(ProductEntity insertProduct);
	void updateProduct(ProductEntity updateProduct);
	int deleteProduct(ProductEntity deleteProduct);
	ProductEntity findProduct(ProductEntity serachProduct);
	List<ProductEntity> findAllProduct();
}
