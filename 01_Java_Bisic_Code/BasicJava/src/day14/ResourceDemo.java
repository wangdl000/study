package day14;

/*
�̼߳�ͨѶ��
����߳��ڴ���ͬһ��Դ����������ȴ��ͬ��


*/

//��Դ
class Resource142 {
	String name;
	String sex;
}

//����
class Input implements Runnable {
	Resource142 r;

	//	Object obj = new Object();
	Input(Resource142 r) {
		this.r = r;
	}

	public void run() {
		int x = 0;
		while (true) {
			synchronized (r) {
				if (x == 0) {
					r.name = "mike";
					r.sex = "nan";
				} else {
					r.name = "����";
					r.sex = "ŮŮŮŮŮŮ";
				}
			}
			x = (x + 1) % 2;

		}
	}
}

//���
class Output implements Runnable {

	Resource142 r;

	//	Object obj = new Object();
	Output(Resource142 r) {
		this.r = r;
	}

	public void run() {
		while (true) {
			synchronized (r) {
				System.out.println(r.name + "....." + r.sex);
			}
		}
	}
}

class Resource142Demo {
	public static void main(String[] args) {
		//������Դ��
		Resource142 r = new Resource142();
		//��������
		Input in = new Input(r);
		Output out = new Output(r);
		//�����̣߳�ִ��·����
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		//�����߳�
		t1.start();
		t2.start();
	}
}
