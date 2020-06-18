
public class CounterRacingSimple {

	public static void main(String[] args) {
        // работаем с анонимным объектом
		new CounterRacingSimple().doCounter();
	}
	
	private int count = 0;
	
	private synchronized void increment() {
		count++;
	}
	
	private void doCounter() {
        // Когда мы работаем с Runnable, мы создаем объект, а не поток. У него нет метода start(), а только run(), который к потокам не относится.
		//Поэтому нужно создать экземпляр Thread, а в его конструктор передать объект Runnable.
		// При этом мы сразу в конструкторе переопределяем метод run.
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
                
				for(int i = 0; i < 1_000_000; i++) {
					increment();
				}
                System.out.println("t1: " + count);
				
			}
		});

		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 1_000_000; i++) {
					increment();
				}
                System.out.println("t2: " + count);
				
			}
		});
		
		t1.start();
		t2.start();
	}

}
