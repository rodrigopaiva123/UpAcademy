package io.altar.jseproject.textinterface;

import io.altar.jseproject.textinterface.State;

public class ProductScreen extends State{
	public int on() {
		String pageProducts = "Por favor selecione uma das seguintes opcoes:\n"
				+ "1) Criar novo produto\n"
				+ "2) Editar produto exixtente\n"
				+ "3) Consultar detalhes de produto\n"
				+ "4) Remover um produto\n"
				+ "5) Voltar ao ecra anterior"; 
		int[] values = {1, 2, 3, 4, 5};
		return scUtil.getInt(pageProducts, values);
	}
}
