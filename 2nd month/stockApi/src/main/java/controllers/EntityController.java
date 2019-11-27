package controllers;

import services.EntityService;
import src.io.altar.jseproject.model.Entity;
import src.io.altar.jseproject.repositories.EntityRepository;

public abstract class EntityController<T extends EntityService<R,E>, R extends EntityRepository<E>, E extends Entity > {

	
	
}
