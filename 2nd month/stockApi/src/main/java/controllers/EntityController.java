package controllers;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import services.EntityService;
import src.io.altar.jseproject.model.Entity;
import src.io.altar.jseproject.repositories.EntityRepository;

public abstract class EntityController<T extends EntityService<R,E>, R extends EntityRepository<E>, E extends Entity > {
 
	 @Inject
	 protected T service;
	 
	 @GET
		@Path("healthCheck")
		@Produces("text/plain")
		public String healthcheck() {
			return "Controller ok";
		}
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Collection<E>  getAll() {
			return service.getAll();
		}
			
		@GET
		@Path("/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public E getOne(@PathParam("id") long id) {
			return service.getOne(id);
		}
		
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public long post(E entity) {
			return service.create(entity);
		}
		
		@PUT
		@Path("/{id}")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String put(@PathParam("id") long id, E entity) {
			return service.edit(id, entity, true);
		}
		
		@DELETE
		@Path("/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public String del(@PathParam("id") long id) {
			return service.del(id);
		}
	
}
