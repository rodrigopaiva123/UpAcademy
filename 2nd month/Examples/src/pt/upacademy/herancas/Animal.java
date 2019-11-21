package pt.upacademy.herancas;

public interface Animal {
	
	
//	private static int currentId = 0;
//	private int id;
//	private String name;
//	private String eats;
//	private int age;
	
	
//	public Animal(String name, String eats, int age) {
//		this.id = nextId();
//		this.name = name;
//		this.eats = eats;
//		this.age = age;
//	}
	
	public abstract void speak();
	
	public void addAge (int newAge);

	public int nextId();
	
//	@Override
//	public String toString() {
//		return "Animal [name=" + name + ", eats=" + eats + ", age=" + age + "]";
//	}
//	
	
	
}
