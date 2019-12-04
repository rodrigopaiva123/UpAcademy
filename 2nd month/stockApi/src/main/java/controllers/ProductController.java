package controllers;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import services.ProductService;
import src.io.altar.jseproject.model.Product;
import src.io.altar.jseproject.repositories.ProductRepository;

@Path("products")
@RequestScoped
public class ProductController extends  EntityController<ProductService, ProductRepository, Product>{

	@Inject
	ProductService service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Product>  getAll() {
		return service.getAll();
	}
	
}
