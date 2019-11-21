package pt.upacademy.SavingsExample;

public class Test {

	public static void main(String[] args) {
		
		Person user = new Person("Ronaldo", 34, 1000000);
		
		Person user2 = new Person("Georgina", 24, 100);
		
		user.getMoneyInAccount();
		
		user2.getMoneyInAccount();
		
		user2.withdrawMoneyFromAccount(1000);
		
		user2.getMoneyInAccount();
		
		user.withdrawMoneyFromAccount(300);
		
		user.getMoneyInAccount();
		
		user.depositMoney(600);
		
		user.getMoneyInAccount();
		
		System.out.println(user.toString());

	}

}
