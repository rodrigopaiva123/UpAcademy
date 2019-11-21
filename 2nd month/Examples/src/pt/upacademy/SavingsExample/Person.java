package pt.upacademy.SavingsExample;

public class Person {

		private String name;
		private int age;
		
		private SavingsAccount savings;
		
		public Person(String name, int age, int balance) {
			this.name = name;
			this.age = age;
			if (balance > 0) {
				this.savings = new SavingsAccount(balance);
			}
		}
		
		public int getMoneyInAccount() {
			System.out.println("Name " + this.name);
			return this.savings.checkBal();
		}
		
		public int withdrawMoneyFromAccount(int deb) {
			return this.savings.withdraw(deb);
		}
		
		public int depositMoney(int value) {
			return this.savings.deposit(value);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + ", savings=" + savings + "]";
		}
		
		
}
