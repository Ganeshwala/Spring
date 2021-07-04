package com.SpringJDBC_ORM.PracticesJDBC_ORM;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.SpringJDBC_ORM.PracticesJDBC_ORM.DAO.ProductEntity;
import com.SpringJDBC_ORM.PracticesJDBC_ORM.DAO.ProductMethods;

public class TesterApplication {

	public static void main(String[] args) {

		int id;
		String Name,details;
		double price;
		ApplicationContext con = new ClassPathXmlApplicationContext("com/SpringJDBC_ORM/PracticesJDBC_ORM/Configuration.xml");
		ProductMethods pmi=(ProductMethods)con.getBean("productClass");
		ProductEntity pe= new ProductEntity();
		System.out.println("1 Enter New Product");
		System.out.println("2 Update Product details");
		System.out.println("3 Delete Product");
		System.out.println("4 Serach Product by Product-id");
		System.out.println("5 Display Products");
		System.out.println("enter choice");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		switch(number) {
		case 1:
			System.out.println("Enter product Id");
			id = sc.nextInt();
			System.out.println("Enter product Name");
			Name = sc.next();
			System.out.println("Enter product Details");
			details  = sc.next();
			System.out.println("Enter product price");
			price = sc.nextDouble();
			pe.setId(id);
			pe.setName(Name);
			pe.setDescrp(details);
			pe.setPrice(price);
			if(pmi.insertProduct(pe)==1) {
				System.out.println("Insert Successfully");
			}
			else
				System.out.println("not Insert try again");
			break;
		case 2:
			System.out.println("Enter product Id");
			id = sc.nextInt();
			System.out.println("Enter product Name");
			Name = sc.next();
			System.out.println("Enter product Details");
			details  = sc.next();
			System.out.println("Enter product price");
			price = sc.nextDouble();
			pe.setId(id);
			pe.setName(Name);
			pe.setDescrp(details);
			pe.setPrice(price);
			pmi.updateProduct(pe);
			break;
		case 3:
			System.out.println("Enter product Id");
			id = sc.nextInt();
			pe.setId(id);
			pmi.deleteProduct(pe);
			break;
		case 4:
			System.out.println("Enter product Id");
			id = sc.nextInt();
			pe.setId(id);
			ProductEntity product =pmi.findProduct(pe);
			System.out.println(product);
			break;
		case 5:
			List<ProductEntity> pro = pmi.findAllProduct();
			for(ProductEntity p:pro) {
				System.out.print(p.getId()+" ");
				System.out.print(p.getName()+" ");
				System.out.print(p.getDescrp()+" ");
				System.out.print(p.getPrice()+" ");
				System.out.println();
			}
			break;
		}
	}
}
