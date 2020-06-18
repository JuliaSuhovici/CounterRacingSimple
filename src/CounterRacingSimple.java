
public class CounterRacingSimple {

	public static void main(String[] args) {
        // �������� � ��������� ��������
		new CounterRacingSimple().doCounter();
	}
	
	private int count = 0;
	
	private synchronized void increment() {
		count++;
	}
	
	private void doCounter() {
        // ����� �� �������� � Runnable, �� ������� ������, � �� �����. � ���� ��� ������ start(), � ������ run(), ������� � ������� �� ���������.
		//������� ����� ������� ��������� Thread, � � ��� ����������� �������� ������ Runnable.
		// ��� ���� �� ����� � ������������ �������������� ����� run.
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
