package src.io.altar.jseproject.repositories;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;

import src.io.altar.jseproject.model.Entity;



public class EntityRepository<T extends Entity>{

	private LinkedHashMap<Long, T> baseDeDados = new LinkedHashMap<Long, T>();
	
	public long currentId;
	
	private long returnLastId() {
		return ++currentId;
	}
	
	public long createEntity (T entity) {
		entity.id = returnLastId();
		baseDeDados.put(currentId, entity);
		return currentId;
	}
	
	public Set<Long> getAllIds() {
		return baseDeDados.keySet();
	}
	
	public Collection<T> getAllEntities() {
		return baseDeDados.values();
	}
	
	public T getEntity(long id) {
		return baseDeDados.get(id);
	}
	
	public void editEntity(T editedEntity) {
		baseDeDados.put(editedEntity.id, editedEntity);
	}
	
	public void removeEntity(long id) {
		baseDeDados.remove(id);
	}

	@Override
	public String toString() {
		return "EntityRepository [baseDeDados=" + baseDeDados + ", currentId=" + currentId + "]";
	}
	
	
	
}
