package pt.upacademy.herancas;

public class Teste {

	public static void main(String[] args) {
		
//		Animal myAnimal = new Animal("Elefante", "amendoins", 10);
//		myAnimal.addAge(10);
//		myAnimal.speak();
		
		
		Animal myAnimalDog = (Animal) new Dog ("Killy", "racao", 1, "Manel", 4);
		myAnimalDog.speak();
		
		Dog myDog = new Dog("Samuel matarruano", "racao", 3, "Manel", 4);
		myDog.speak();
		
		Cat myCat = new Cat("Alice", "atum", 2, "Tobias", 4);
		myCat.speak();
		
//		Animal myAnimal2 = new Animal();
//		myAnimal2.speak();
		
		
	}

}
