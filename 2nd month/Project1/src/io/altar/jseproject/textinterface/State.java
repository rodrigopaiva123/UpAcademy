package io.altar.jseproject.textinterface;

import java.util.Collection;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;
import io.altar.jseproject.utils.ScannerUtils;

abstract class State {
	static ScannerUtils scUtil = new ScannerUtils();
	static ProductRepository bdProduct = ProductRepository.getInstance();
	static ShelfRepository bdShelf = ShelfRepository.getInstance();
	public abstract int on();
	

	static Collection <Long> displayProducts() {
		Collection<Long> allIds = bdProduct.getAllIds();
		if(allIds.isEmpty()) {
			System.out.println("Nao existem Produtos");
		} else {
			Collection<Product> products = bdProduct.getAllEntities();
			for (Product product: products) {
				System.out.println(product);
			}
		}
		return allIds;
	}
	
	static Collection<Long> displayShelfs() {
		Collection<Long> allIds = bdShelf.getAllIds();
		if(allIds.isEmpty()) {
			System.out.println("Nao Existem Prateleiras");
		} else {
			Collection<Shelf> shelfs = bdShelf.getAllEntities();
			for (Shelf shelf : shelfs) {
				System.out.println(shelf);
			}
		}
		return allIds;
	}

	
	static Product getProduct() {
		Product product = null;
		Collection<Long> allIds = displayProducts();
		if(allIds.isEmpty() == false) {
			long [] array = allIds.parallelStream().mapToLong(l -> l).toArray();
			int id = scUtil.getLong("Indique o ID do produto", array);
			product = bdProduct.getEntity(id);
		}
		return product;
	}
	
	static Shelf getShelf() {
		Shelf shelf = null;
		Collection<Long> allIds = displayShelfs();
		if(allIds.isEmpty() == false) {
		long [] array = allIds.parallelStream().mapToLong(l -> l).toArray();
		long id = scUtil.getLong("Indique o ID da preteleira", array);
		shelf = bdShelf.getEntity(id);
		}
		return shelf;
	}
}
