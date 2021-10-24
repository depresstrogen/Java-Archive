
public class Threading{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread() {
			public void run() {
				int n = 1;
				Thread.currentThread().setName("Thread");
				while (true) {
					System.out.println(Thread.currentThread().getName() + " Loop # " + n);
					n ++;
				}
			}
		}.start();
		int i = 1;
		while (true) {
			System.out.println(Thread.currentThread().getName() + " Loop # " + i);
			i ++;
		}
	}
	// Now both methods cant run at the same time 
	public synchronized void method1() {
		
	}
	public synchronized void method2() {
		
	}
}
