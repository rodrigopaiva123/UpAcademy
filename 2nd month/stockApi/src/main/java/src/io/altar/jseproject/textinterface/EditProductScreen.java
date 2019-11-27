package src.io.altar.jseproject.textinterface;

import src.io.altar.jseproject.textinterface.State;

public class EditProductScreen extends State{
	public int on() {
		
		String disp = "Por favor selecione uma das seguintes opcoes:\n"
				+ "1) Editar preco\n"
				+ "2) Editar IVA\n"
				+ "3) Editar prateleiras";
		int [] values = { 1, 2, 3 };
		return scUtil.getInt(disp, values);
	}
}
