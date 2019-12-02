package services;

import java.util.Collection;
import java.util.Set;

import javax.inject.Inject;

import src.io.altar.jseproject.model.Entity;
import src.io.altar.jseproject.repositories.EntityRepository;

public abstract class EntityService<T extends EntityRepository<E>, E extends Entity> {
	
	@Inject
	protected T repository;
	

	public Collection<E>  getAll() {
		return repository.getAllEntities();
	}
	
	public Set<Long>  getAllIds() {
		return repository.getAllIds();
	}
	
	public E getOne(long id) {
		return repository.getEntity(id);
	}
	
	public long create (E entity) {
		
		return repository.createEntity(entity);
	}
	
	public abstract String edit(long id, E entity, boolean isEdit);
	
	public abstract String del(long id);

}
