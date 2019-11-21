package io.altar.jseproject.textinterface;

import io.altar.jseproject.textinterface.State;

public class EditShelfScreen extends State{
	public int on() {
		String disp = "Por favor selecione uma das seguintes opcoes:\n"
				+ "1) Editar dimensao\n"
				+ "2) Editar preco\n"
				+ "3) Editar produto";
		
		int[] values = {1, 2, 3};
		return scUtil.getInt(disp, values);
	}
}
