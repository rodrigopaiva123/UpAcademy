package src.io.altar.jseproject.model;

import java.io.Serializable;

public class Entity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public long id;

	public Entity () {
	}

	public long getId() {
		return id;
	}

}
