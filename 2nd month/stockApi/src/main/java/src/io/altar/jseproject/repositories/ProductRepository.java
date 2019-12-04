package src.io.altar.jseproject.repositories;

import javax.enterprise.context.ApplicationScoped;

import src.io.altar.jseproject.model.Product;

@ApplicationScoped
public class ProductRepository extends EntityRepository<Product>{

	@Override
	protected Class<Product> getEntityClass() {
		return Product.class;
	}

	@Override
	protected String getAllEntityQueryName() {
		return Product.GET_ALL_PRODUCTS_QUERY_NAME;
	}

	@Override
	protected String getAllEntityIdsQueryName() {
		return Product.GET_ALL_PRODUCTS_IDS;
	}

	@Override
	protected String getEntityCount() {
		return Product.GET_PRODUCTS_COUNT;
	}
	

}
