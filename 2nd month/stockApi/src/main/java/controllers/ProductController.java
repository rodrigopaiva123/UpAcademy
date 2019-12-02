package controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;

import services.ProductService;
import src.io.altar.jseproject.model.Product;
import src.io.altar.jseproject.repositories.ProductRepository;

@Path("products")
@RequestScoped
public class ProductController extends  EntityController<ProductService, ProductRepository, Product>{

	@Inject
	ProductService service;
	
}
