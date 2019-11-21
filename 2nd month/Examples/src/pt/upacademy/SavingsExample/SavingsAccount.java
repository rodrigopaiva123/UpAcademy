package pt.upacademy.SavingsExample;

public class SavingsAccount {

	private int balance;

	public SavingsAccount(int balance) {
		this.balance = balance;
	}
	
	public int checkBal () {
		System.out.println("On Check -> Your balance is " + this.balance);
		return this.balance;
	}
	
	public int withdraw(int deb) {
		this.balance -= deb;
		System.out.println("On Withdraw -> Your balance is " + this.balance);
		return this.balance;
	}
	
	public int deposit(int value) {
		this.balance += value;
		System.out.println("On Deposit -> Your balance is " + this.balance);
		return this.balance;
	}

	@Override
	public String toString() {
		return "SavingsAccount [balance=" + balance + "]";
	}

	
	
}
