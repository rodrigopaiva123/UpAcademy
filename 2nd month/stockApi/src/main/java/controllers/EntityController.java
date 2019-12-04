package controllers;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import services.EntityService;
import src.io.altar.jseproject.model.GenericEntity;
import src.io.altar.jseproject.repositories.EntityRepository;

public abstract class EntityController<T extends EntityService<R,E>, R extends EntityRepository<E>, E extends GenericEntity> {
 
	 @Inject
	 protected T service;
	 
	 @Context
	 private UriInfo context;
	 
	 @GET
		@Path("healthCheck")
		@Produces("text/plain")
		public String healthcheck() {
			return "URI " + context.getRequestUri().toString() + " is OK!";
		}
			
		@GET
		@Path("/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public E getOne(@PathParam("id") long id) {
			return service.getOne(id);
		}
		
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public E post(E entity) {
			return service.create(entity);
		}
		
		@PUT
		@Path("/{id}")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String put(@PathParam("id") long id, E entity, @QueryParam("productId") Long productId) {
			String response; 
			if (productId == null) {
				response = service.edit(id, entity);
			} else {
				response = service.editProductInShelf(id, entity, productId);
			}
			
			return response;
		}
		
		@DELETE
		@Path("/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public String del(@PathParam("id") long id) {
			
			return service.del(id);
		}
		
		@GET
		@Path("count")
		@Produces(MediaType.TEXT_PLAIN)
		public long getCount() {
			return service.getCount();
		}
	
}
