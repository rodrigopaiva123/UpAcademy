package io.altar.jseproject.textinterface;

import io.altar.jseproject.textinterface.State;

public class StartScreen extends State{
	public int on() {
		String page1 = "Por favor selecione uma das seguintes opcoes:\n"
				+ "1) Listar produtos\n"
				+ "2) Listar prateleiras\n"
				+ "3) Sair";
		int [] values = {1, 2};
		return scUtil.getInt(page1, values);
	}
}
