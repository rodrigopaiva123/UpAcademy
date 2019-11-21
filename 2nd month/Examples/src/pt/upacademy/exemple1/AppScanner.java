package pt.upacademy.exemple1;

public class AppScanner {
	private ScannerUtils scUtil = new ScannerUtils();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppScanner app = new AppScanner();
		app.start();
	}
	
	private void start() {
		int[] values = {1, 2, 3, 4};
		int result = scUtil.getInt("Introduza uma opcao(1,2,3,4)", values);
		System.out.println(result);
	}
} 