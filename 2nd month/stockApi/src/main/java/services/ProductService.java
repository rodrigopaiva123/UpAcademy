package services;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import src.io.altar.jseproject.model.Product;
import src.io.altar.jseproject.repositories.ProductRepository;

@RequestScoped
public class ProductService extends EntityService<ProductRepository, Product> {

	@Inject
	ShelfService shelfService;

	@Transactional
	@Override
	public String edit(long id, Product product, boolean needsEdit) {

		String str = "";
		boolean validParams = false;

		if (id == (product.getId() == 0 ? id : product.getId()) && repository.getAllIds().contains(id)) {
			validParams = true;
		} else {
			str = "error: ID";
		}

		if (validParams == true) {
			product.setId(id);
			repository.editEntity(product);
			str = "Edit successfull";
				}

		return str;
	}

	@Transactional
	@Override
	public String del(long id) {
		repository.removeEntity(id);
		return "Product deleted";
	}
}
