package services;

import java.util.Collection;

import javax.inject.Inject;
import javax.transaction.Transactional;

import src.io.altar.jseproject.model.GenericEntity;
import src.io.altar.jseproject.repositories.EntityRepository;

public abstract class EntityService<T extends EntityRepository<E>, E extends GenericEntity> {
	
	@Inject
	protected T repository;
	
	@Transactional
	public Collection<E>  getAll() {
		return repository.getAllEntities();
	}
	
	@Transactional
	public Collection<Long>  getAllIds() {
		return repository.getAllIds();
	}
	
	@Transactional
	public E getOne(long id) {
		return repository.getEntity(id);
	}
	
	@Transactional
	public E create (E entity) {
		return repository.createEntity(entity);
	}
	
	public abstract String edit(long id, E entity);
	
	public abstract String del(long id);

	public long getCount() {
		return repository.getCount();
	}

	public abstract String editProductInShelf(long id, E entity, Long productId);

}
