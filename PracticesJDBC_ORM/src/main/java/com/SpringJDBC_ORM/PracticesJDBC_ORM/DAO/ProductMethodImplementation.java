package com.SpringJDBC_ORM.PracticesJDBC_ORM.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("productClass")
public class ProductMethodImplementation implements ProductMethods {


	String sqlQuery;
	@Autowired
	JdbcTemplate jTemplate;
	@Autowired
	HibernateTemplate hTemplate;
	
	public JdbcTemplate getjTemplate() {
		return jTemplate;
	}

	public void setjTemplate(JdbcTemplate jTemplate) {
		this.jTemplate = jTemplate;
	}

	public HibernateTemplate gethTemplate() {
		return hTemplate;
	}

	public void sethTemplate(HibernateTemplate hTemplate) {
		this.hTemplate = hTemplate;
	}

	@Override
	public int insertProduct(ProductEntity insertProduct) {
		sqlQuery="insert into product values(?,?,?,?)";
		int result = jTemplate.update(sqlQuery, insertProduct.getId(),insertProduct.getName(),insertProduct.getDescrp(),insertProduct.getPrice());
		return result;
	}

	@Override
	@Transactional
	public void updateProduct(ProductEntity updateProduct) {
		hTemplate.update(updateProduct);
	}

	@Override
	public int deleteProduct(ProductEntity deleteProduct) {
		sqlQuery="delete from product where id=?";
		int result = jTemplate.update(sqlQuery, deleteProduct.getId());
		return result;
	}

	@Override
	public ProductEntity findProduct(ProductEntity serachProduct) {
		sqlQuery="select * from product where id=?";
		ProductRowMapper rowMapper = new ProductRowMapper();
		ProductEntity pe=jTemplate.queryForObject(sqlQuery, rowMapper,serachProduct.getId());
		return pe;
	}

	@Override
	@Transactional
	public List<ProductEntity> findAllProduct() {
		List<ProductEntity> p = hTemplate.loadAll(ProductEntity.class);
		return p;
	}

}
