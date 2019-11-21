package io.altar.jseproject.textinterface;

import io.altar.jseproject.textinterface.State;

public class ShelfScreen extends State{
	public int on() {
		String pageShelfs = "Por favor selecione uma das seguintes opcoes:\n"
				+ "1) Criar nova prateleira\n"
				+ "2) Editar prateleira exixtente\n"
				+ "3) Consultar detalhes de prateleira\n"
				+ "4) Remover uma prateleira\n"
				+ "5) Voltar ao ecra anterior";
		int[] values = {1, 2, 3, 4, 5};
		return scUtil.getInt(pageShelfs, values);
	}
}
