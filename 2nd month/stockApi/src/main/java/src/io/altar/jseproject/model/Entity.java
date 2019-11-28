package src.io.altar.jseproject.model;

import java.io.Serializable;

public class Entity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long id;

	public Entity () {
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

}
