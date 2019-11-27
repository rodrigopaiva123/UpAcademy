package src.io.altar.jseproject.repositories;

import src.io.altar.jseproject.model.Product;

public class ProductRepository extends EntityRepository<Product>{
	
	private static final ProductRepository INSTANCE = new ProductRepository();
	
	public static ProductRepository getInstance() {
		return INSTANCE;
	}
	
	private ProductRepository () {
		
	}

}
