package src.io.altar.jseproject.textinterface;

import src.io.altar.jseproject.utils.*;

import java.util.Collection;

import src.io.altar.jseproject.model.Product;
import src.io.altar.jseproject.model.Shelf;
import src.io.altar.jseproject.repositories.ShelfRepository;
import src.io.altar.jseproject.repositories.ProductRepository;;

public class TextInterface {
	
	private static ScannerUtils scUtil = new ScannerUtils();
	static ProductRepository bdProduct = ProductRepository.getInstance();
	static ShelfRepository bdShelf = ShelfRepository.getInstance();


	public static void main(String[] args) {
		startScreen();
	}
		
	
	static void startScreen() {
		
		String page1 = "Por favor selecione uma das seguintes opcoes:\n"
				+ "1) Listar produtos\n"
				+ "2) Listar prateleiras\n"
				+ "3) Sair";
		
		int[] values = {1, 2, 3};
		
		int input = scUtil.getInt(page1, values);
			
		switch (input) {
		case (1):
			productScreen();
		case (2):
			shelfScreen();
		case (3):
			close();
		
		}
		
	}
	
	static void productScreen() {
		
		String pageProducts = "Por favor selecione uma das seguintes opcoes:\n"
				+ "1) Criar novo produto\n"
				+ "2) Editar produto exixtente\n"
				+ "3) Consultar detalhes de produto\n"
				+ "4) Remover um produto\n"
				+ "5) Voltar ao ecra anterior"; 
		
		int[] values = {1, 2, 3, 4, 5};
		
		int input = scUtil.getInt(pageProducts, values);
		
		switch (input) {
		case(1):
			createProduct();
		case(2):
			editProductScreen();
		case(3):
			showProducts();
		case(4):
			removeProduct();
		case(5):
			startScreen();
		}
		
	}
	
	static void shelfScreen() {
		
		String pageShelfs = "Por favor selecione uma das seguintes opcoes:\n"
				+ "1) Criar nova prateleira\n"
				+ "2) Editar prateleira exixtente\n"
				+ "3) Consultar detalhes de prateleira\n"
				+ "4) Remover uma prateleira\n"
				+ "5) Voltar ao ecra anterior";
		
		int[] values = {1, 2, 3, 4, 5};
		
		int input = scUtil.getInt(pageShelfs, values);
		
		switch (input) {
		case(1):
			createShelf();
		case(2):
			editShelfScreen();
		case(3):
			showShelfs();
		case(4):
			removeShelfs();
			case(5):
			startScreen();
		}
	}
	
	static void editProductScreen() {
		String disp = "Por favor selecione uma das seguintes opcoes:\n"
				+ "1) Editar preco\n"
				+ "2) Editar IVA\n"
				+ "3) Editar prateleiras";
		
		int[] values = {1, 2, 3};
		
		int input = scUtil.getInt(disp, values);
			
		switch (input) {
		case (1):
			edProdPrice();
		case (2):
			edProdIva();
		case (3):
			edProdShelfs();
		
		}
	}
	
	static void editShelfScreen() {
		String disp = "Por favor selecione uma das seguintes opcoes:\n"
				+ "1) Editar dimensao\n"
				+ "2) Editar preco\n"
				+ "3) Editar produto";
		
		int[] values = {1, 2, 3};
		
		int input = scUtil.getInt(disp, values);
			
		switch (input) {
		case (1):
			edShelffSize();
		case (2):
			edShelfPrice();
		case (3):
			edShelfProd();
		
		}
	}
	
 	static void close () {
		System.out.println("");
		System.exit(0);
	}

	static void createProduct() {
	Product product = new Product (
			scUtil.getInt("Indique preco do produto a criar"), scUtil.getInt("Indique Iva do produto a criar"));
	bdProduct.createEntity(product);
	productScreen();
	}
	
	static Product getProduct() {
		noProductAlert();
		displayProducts();
		Collection<Long> allIds = bdProduct.getAllIds();
		long [] array = allIds.parallelStream().mapToLong(l -> l).toArray();
		long id = scUtil.getLong("Indique o ID do produto", array);
		Product product = bdProduct.getEntity(id);
		return product;
	}
	
	static void edProdPrice() {
		Product editedProduct = getProduct();
		int editedPrice = scUtil.getInt("Indique o novo preco do produto");
		editedProduct.setPrice(editedPrice);
		bdProduct.editEntity(editedProduct);
		productScreen();
	}
	
	static void edProdIva() {
		Product editedProduct = getProduct();
		int editedIVA = scUtil.getInt("Indique o novo Iva do produto");
		editedProduct.setIVA(editedIVA);
		bdProduct.editEntity(editedProduct);
		productScreen();
	}

	static void edProdShelfs() {
		Product editedProduct = getProduct();
		long editedShelfId = scUtil.getInt("Indique o ID de uma nova prateleira para o produto");
		Shelf editedShelf = bdShelf.getEntity(editedShelfId);
		editedShelf.setProduct(editedProduct);
		editedProduct.getShelfIds().add(editedShelfId);
		bdProduct.editEntity(editedProduct);
		productScreen();
	}
	 
	static void showProducts() {
		noProductAlert();
		displayProducts();
		productScreen();
	}
	
	static void removeProduct() {
		Product product = getProduct();
		for (long shelfId : product.getShelfIds()) {
			Shelf shelf = bdShelf.getEntity(shelfId);
			shelf.setProduct(null);
		}
		bdProduct.removeEntity(product.getId());
		productScreen();
	}
	
	static void createShelf() {
		Shelf shelf = new Shelf (
				scUtil.getInt("Indique a dimensao da prateleira"),  
				scUtil.getInt("Indique opreco de aluguer"));
		bdShelf.createEntity(shelf);
		shelfScreen();
		}
		
	static Shelf getShelf() {
		noShelfAlert();
		displayShelfs();
		Collection<Long> allIds = bdShelf.getAllIds();
		long [] array = allIds.parallelStream().mapToLong(l -> l).toArray();
		long id = scUtil.getLong("Indique o ID da preteleira", array);
		Shelf shelf = bdShelf.getEntity(id);
		return shelf;
	}
	 
	static void edShelffSize() {
		Shelf editedShelf = getShelf();
		int editedSize = scUtil.getInt("Indique o novo tamanho da prateleira");
		editedShelf.setSize(editedSize);
		bdShelf.editEntity(editedShelf);
		shelfScreen();
	}

	static void edShelfPrice() {
		Shelf editedShelf = getShelf();
		float editedPrice = scUtil.getInt("Indique o novo preco de aluguer");
		editedShelf.setPrice(editedPrice);
		bdShelf.editEntity(editedShelf);
		shelfScreen();
	}

	static void edShelfProd() {
		Shelf editedShelf = getShelf();
		long editedProductId = scUtil.getInt("Escolha o ID do produto a adicionar");
		Product editedProduct = bdProduct.getEntity(editedProductId);
		editedShelf.setProduct(editedProduct);
		bdShelf.editEntity(editedShelf);
		editedProduct.getShelfIds().add(editedProductId);
		shelfScreen();
	}
	
	static void showShelfs() {
		noShelfAlert();
		displayShelfs();
		shelfScreen();
	}
	
	static void removeShelfs() {
		Shelf shelf = getShelf();
		long pId = shelf.getProduct().getId();
		Product product = bdProduct.getEntity(pId);
		for (long shelfId : product.getShelfIds()) {
			if (shelf.getId() == shelfId) {
				product.getShelfIds().remove(shelfId);
			}
		}
		bdShelf.removeEntity(shelf.getId());
		shelfScreen();
	}
	
	static void displayShelfs() {
		Collection<Shelf> shelfs = bdShelf.getAllEntities();
		for (Shelf shelf : shelfs) {
			System.out.println(shelf);
		}
	}

	static void displayProducts() {
		Collection<Product> products = bdProduct.getAllEntities();
		for (Product product: products) {
			System.out.println(product);
		}
	}
	
	static void noProductAlert() {
		if(bdProduct.currentId == 0) {
			System.out.println("Nao existem Produtos");
			productScreen();
		}
	}
	
	static void noShelfAlert() {
		if(bdProduct.currentId == 0) {
			System.out.println("Nao existem Prateleiras");
			productScreen();
		}
	}
	
}
