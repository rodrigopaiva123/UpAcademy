package src.io.altar.jseproject.repositories;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import src.io.altar.jseproject.model.Product;
import src.io.altar.jseproject.model.Shelf;

@ApplicationScoped
public class ShelfRepository extends EntityRepository<Shelf>{

	@Override
	protected Class<Shelf> getEntityClass() {
		return Shelf.class;
	}

	@Override
	protected String getAllEntityQueryName() {
		return Shelf.GET_ALL_SHELVES_QUERY_NAME;
	}

	public List<Shelf> findByProductId(long id) {
		return entityManager
				.createNamedQuery(Shelf.GET_SHELVES_BY_PRODUCT_ID_QUERY_NAME, Shelf.class)
				.setParameter("productId", id)
				.getResultList();
	}

	@Override
	protected String getAllEntityIdsQueryName() {
		return Product.GET_ALL_PRODUCTS_QUERY_NAME;
	}
	
}
