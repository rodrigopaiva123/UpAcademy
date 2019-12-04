package src.io.altar.jseproject.repositories;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

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

	public List<Shelf> getAllShelvesByProductId(long id) {
		return entityManager
				.createNamedQuery(Shelf.GET_SHELVES_BY_PRODUCT_ID_QUERY_NAME, Shelf.class)
				.setParameter("productId", id)
				.getResultList();
	}

	@Override
	protected String getAllEntityIdsQueryName() {
		return Shelf.GET_ALL_SHELVES_IDS;
	}

	@Override
	protected String getEntityCount() {
		return Shelf.GET_SHELVES_COUNT;
	}

	public List<Long> getIdByProductId(long id) {
		return entityManager
				.createNamedQuery(Shelf.GET_SHELVES_IDS_BY_PRODUCT_ID, Long.class)
				.setParameter("productId", id)
				.getResultList();
		
	}

	public Long getCountByProductId(long id) {
		return entityManager
				.createNamedQuery(Shelf.GET_SHELVES_COUNT_BY_PRODUCT_ID, Long.class)
				.setParameter("productId", id)
				.getSingleResult().longValue();
	}

	public void editProductInShelf(long id, Shelf shelf, Long productId) {
		 entityManager
			.createNamedQuery(Shelf.UPDATE_SHELF_BY_PRODUCT_ID, Shelf.class)
			.setParameter("productId", productId)
			.setParameter("id", id)
			.executeUpdate();
	}
	
}
