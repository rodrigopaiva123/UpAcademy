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

import services.ProductService;
import src.io.altar.jseproject.model.Product;
import src.io.altar.jseproject.repositories.ProductRepository;

@Path("products")
public class ProductController extends  EntityController<ProductService, ProductRepository, Product>{

	ProductService service = new ProductService();
	
	@GET
	@Path("healthcheck")
	@Produces("text/plain")
	public String healthcheck() {
		return "O controller esta em cima";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Product>  getAll() {
		return service.getAll();
	}
		
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getOne(@PathParam("id") long id) {
		return service.getOne(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public long post(Product product) {
		return service.post(product);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void put(@PathParam("id") long id, Product product) {
		service.put(product);
	}
	
	@DELETE
	@Path("1")
	@Produces(MediaType.APPLICATION_JSON)
	public void del(long id) {
		service.del(id);
	}
}
