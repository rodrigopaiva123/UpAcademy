package controllers;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
	@Path("/product/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Shelf>  getByProductId(@PathParam("id") long id) {
		return service.getByProductId(id);
	}
	
}
