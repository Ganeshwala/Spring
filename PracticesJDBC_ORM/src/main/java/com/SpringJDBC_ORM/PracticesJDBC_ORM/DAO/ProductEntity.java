package com.SpringJDBC_ORM.PracticesJDBC_ORM.DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class ProductEntity {

	@Id
	@Column(name="ID")
	private int Id;
	@Column(name="Name")
	private String name;
	@Column(name="Description")
	private String descrp;
	@Column(name="price")
	private double price;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescrp() {
		return descrp;
	}

	public void setDescrp(String descrp) {
		this.descrp = descrp;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductEntity [Id=" + Id + ", name=" + name + ", descrp=" + descrp + ", price=" + price + "]";
	}

}
