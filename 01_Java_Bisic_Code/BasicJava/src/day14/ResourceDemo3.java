package day14;

class Resource143 {
	private String name;
	private String sex;
	private boolean flag = false;

	public synchronized void set(String name, String sex) {
		if (flag)
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		this.name = name;
		this.sex = sex;
		flag = true;
		this.notify();
	}

	public synchronized void out() {
		if (!flag)
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		System.out.println(name + "...+...." + sex);
		flag = false;
		notify();
	}
}

//����
class Input143 implements Runnable {
	Resource143 r;

	//	Object obj = new Object();
	Input143(Resource143 r) {
		this.r = r;
	}

	public void run() {
		int x = 0;
		while (true) {
			if (x == 0) {
				r.set("mike", "nan");
			} else {
				r.set("����", "ŮŮŮŮŮŮ");
			}
			x = (x + 1) % 2;
		}
	}
}

//���
class Output143 implements Runnable {

	Resource143 r;

	//	Object obj = new Object();
	Output143(Resource143 r) {
		this.r = r;
	}

	public void run() {
		while (true) {
			r.out();
		}
	}
}

class Resource143Demo3 {
	public static void main(String[] args) {
		//������Դ��
		Resource143 r = new Resource143();
		//��������
		Input143 in = new Input143(r);
		Output143 out = new Output143(r);
		//�����̣߳�ִ��·����
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		//�����߳�
		t1.start();
		t2.start();
	}
}
