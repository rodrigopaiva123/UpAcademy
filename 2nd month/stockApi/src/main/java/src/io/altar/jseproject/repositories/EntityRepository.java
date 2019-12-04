package src.io.altar.jseproject.repositories;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import src.io.altar.jseproject.model.GenericEntity;


public abstract class EntityRepository<T extends GenericEntity>{
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public T createEntity (T entity) {
		return entityManager.merge(entity);
	}
	
	public T getEntity(long id) {
		return entityManager.find(getEntityClass(), id);
	}
	
	public Collection<Long> getAllIds() {
		return entityManager.createNamedQuery(getAllEntityIdsQueryName(), Long.class).getResultList();
	}
	
	protected abstract String getAllEntityIdsQueryName();
	

	public Collection<T> getAllEntities() {
		return entityManager.createNamedQuery(getAllEntityQueryName(), getEntityClass()).getResultList();
	}


	protected abstract Class<T> getEntityClass();
	
	protected abstract String getAllEntityQueryName();
	
	
	public T editEntity(T editedEntity) {
		return entityManager.merge(editedEntity);
	}
	
	public void removeEntity(long id) {
		T entity = entityManager.find(getEntityClass(), id);
		entityManager.remove(entity);
	}
	
	public long getCount() {
		return entityManager.createNamedQuery(getEntityCount(), Long.class).getSingleResult().longValue();
	}

	protected abstract String getEntityCount();
}
