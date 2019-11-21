package pt.upacademy.herancas;

public class Dog implements Animal{
	
//	private String owner;
//	private int numPatas;
	
	public Dog() {
		
	}
	
	public Dog(String name, String eats, int age, String owner, int numPatas) {
		super();
//		this.owner = owner;
//		this.numPatas = numPatas;
	}
	
	
	
	@Override //náo e obrigatorio mas e boa pratica
	public void speak () {
//		super.speak();
		System.out.println("Woof, woof!");
	}

	@Override
	public void addAge(int newAge) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int nextId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
