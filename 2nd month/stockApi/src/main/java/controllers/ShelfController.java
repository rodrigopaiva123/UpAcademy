package controllers;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import services.ShelfService;
import src.io.altar.jseproject.model.Shelf;
import src.io.altar.jseproject.repositories.ShelfRepository;

@Path("shelves")
public class ShelfController extends  EntityController<ShelfService, ShelfRepository, Shelf>{

	ShelfService service = new ShelfService();
	
	@GET
	@Path("healthCheck")
	@Produces("text/plain")
	public String healthcheck() {
		return "Controller ok";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Shelf>  getAll() {
		return service.getAll();
	}
		
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Shelf getOne(@PathParam("id") long id) {
		return service.getOne(id);
	}
	
	@GET
	@Path("/product/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Shelf> getByProductId(@PathParam("id") long id) {
		return service.getByProductId(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public long post(Shelf shelf) {
		return service.create(shelf);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String put(@PathParam("id") long id, Shelf shelf) {
		return service.edit(id, shelf);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void del(@PathParam("id") long id) {
		service.del(id);
	}
	
}
