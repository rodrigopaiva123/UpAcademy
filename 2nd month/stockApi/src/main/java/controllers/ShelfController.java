package controllers;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import services.ShelfService;
import src.io.altar.jseproject.model.Shelf;
import src.io.altar.jseproject.repositories.ShelfRepository;


@Path("shelves")
@RequestScoped
public class ShelfController extends  EntityController<ShelfService, ShelfRepository, Shelf>{

	@Inject
	ShelfService service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Shelf>  getByProductId(@QueryParam("productId") Integer productId) {
		Collection<Shelf> result;
		if (productId == null) {
			result = service.getAll();
		} else {
			result = service.getByProductId(productId);
		}
		return result;
	}
	
	@GET
	@Path("id")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Long>  getIdByProductId(@QueryParam("productId") Integer productId) {
		Collection<Long> result;
		if (productId == null) {
			result = service.getAllIds();
		} else {
			result = service.getIdByProductId(productId);
		}
		return result;
	}
	
	@GET
	@Path("count")
	@Produces(MediaType.APPLICATION_JSON)
	public Long  getCountByProductId(@QueryParam("productId") Integer productId) {
		return service.getCountByProductId(productId);
	}
	
	
}
