package services;

import java.util.Collection;

import src.io.altar.jseproject.model.Product;
import src.io.altar.jseproject.repositories.ProductRepository;

public class ProductService extends EntityService<ProductRepository, Product>{
	
	ProductRepository rep = ProductRepository.getInstance();

	public Collection<Product>  getAll() {
		return rep.getAllEntities();
	}
	
	public Product getOne(long id) {
		return rep.getEntity(id);
	}
	
	public long post (Product entity) {
		return rep.createEntity(entity);
	}
	
	public void put(Product product) {
		rep.editEntity(product);
	}
	
	public void del(long id) {
		rep.removeEntity(id);
	}

	

}
