package services;

import java.util.Collection;

import javax.inject.Inject;

import src.io.altar.jseproject.model.Entity;
import src.io.altar.jseproject.repositories.EntityRepository;

public abstract class EntityService<T extends EntityRepository<E>, E extends Entity> {
	
	@Inject
	protected T repository;
	

	public Collection<E>  getAll() {
		return repository.getAllEntities();
	}
	
	public E getOne(long id) {
		return repository.getEntity(id);
	}
	
	public long create (E entity) {
		
		return repository.createEntity(entity);
	}
	
	public String edit(long id, E entity) {
		return "";
	}
	
	public String del(long id) {
		return "";
	}

}
