package leitorImagens;

public class Foo extends Thread {
	private volatile boolean close = false;

	public void run() {
		while (!close) {
			// do work
		}
	}

	public void close() {
		close = true;
		// interrupt here if needed
	}
	
	public static void main(String[] args) {
		Foo foo2 = new Foo();
		Foo foo = foo2;
		foo.close();
		foo.start();
		foo2.close();
		foo2.start();
		
	}
}