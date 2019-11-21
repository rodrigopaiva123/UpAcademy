package io.altar.jseproject.textinterface;

public class MyState {
	public State[] States = {
			new StartScreen(),       //State 0
			new ProductScreen(),     //State 1
			new CreateProduct(),     //State 2
			new EditProductScreen(), //State 3
			new EdProdPrice(),       //State 4
			new EdProdIva(),         //State 5
			new EdProdShelfs(),      //State 6
			new ShowProducts(),      //State 7
			new RemoveProduct(),     //State 8
			new ShelfScreen(),       //State 9
			new CreateShelf(),       //State 10
			new EditShelfScreen(),   //State 11
			new EdShelfSize(),       //State 12
			new EdShelfPrice(),      //State 13
			new EdShelfProd(),       //State 14
			new ShowShelfs(),        //State 15
			new RemoveShelfs(),      //State 16
	};
			
			private int[][] transition = { 
					{ 1, 9 },              // State 0  StartScreen
					{ 2, 3, 7, 8, 0 },     // State 1  ProductScreen
					{ 1 },                 // State 2  CreateProduct
					{ 4, 5, 6 },           // State 3  EditProductScreen
					{ 1 },                 // State 4  EdProdPrice
					{ 1 },                 // State 5  EdProdIva
					{ 1 },                 // State 6  EdProdShelfs
					{ 1 },                 // State 7  ShowProducts
					{ 1 },                 // State 8  RemoveProduct
					{ 10, 11, 15, 16, 0 }, // State 9  ShelfScreen
					{ 2 },                 // State 10 CreateShelf
					{ 12, 13, 14 },        // State 11 EditShelfScreen
					{ 2 },                 // State 12 EdShelffSize
					{ 2 },                 // State 13 EdShelfPrice
					{ 2 },                 // State 14 EdShelfProd
					{ 2 },                 // State 15 ShowShelfs
					{ 2 },                 // State 16 RemoveShelfs
			};

	int current = 0;
	
	public static void main(String[] args) {
		MyState state = new MyState();
		int option;

		while (true) {
			option = state.States[state.current].on();
			if (state.current == 0 && option == 3) {
				System.out.println("Exit");
				break;
			}
			state.current = state.transition[state.current][option - 1];
		}
	}
	
}
