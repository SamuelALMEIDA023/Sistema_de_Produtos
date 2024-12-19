package aplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entitie.ImportedProduct;
import entitie.Product;
import entitie.UsedProduct;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		List<Product> listProd = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int N = sc.nextInt();
		sc.nextLine(); 
		
		for(int i = 0; i < N; i++) {
			System.out.println("Product #"+ (i + 1) +" data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			String chosen = sc.nextLine();
			
			switch (chosen) {
			case "i": 
				System.out.print("Name: ");
				String name = sc.nextLine();

				System.out.print("Price: ");
				Double price = sc.nextDouble();
				
				System.out.print("Customs fee:");
				Double customsFee = sc.nextDouble();
				sc.nextLine(); 
				ImportedProduct importProd = new ImportedProduct(name, price, customsFee);
				listProd.add(importProd);
				
				break;
				
			case "c":
				System.out.print("Name: ");
				String nameProd = sc.nextLine();
			
				System.out.print("Price: ");
				Double priceProd = sc.nextDouble();
				sc.nextLine();
				Product prod = new Product(nameProd, priceProd);
				listProd.add(prod);
				
				break;
				
			case "u":
				System.out.print("Name: ");
				String namePr = sc.nextLine();
		
				System.out.print("Price: ");
				Double pricePr = sc.nextDouble();
				sc.nextLine();
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				
				UsedProduct used = new UsedProduct(namePr, pricePr, date );
				listProd.add(used);
			}
			
		}
		
		System.out.println();
		System.out.println("PRICE TAGS: ");
		
		for(Product p: listProd) {
			System.out.println(p.priceTag());
		}
		

	}

}
