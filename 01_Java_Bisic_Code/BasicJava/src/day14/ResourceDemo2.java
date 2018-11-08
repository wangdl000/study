package day14;

/*
�ȴ�/���ѻ��ơ�

�漰�ķ�����

1��wait(): ���̴߳��ڶ���״̬����wait���̻߳ᱻ�洢���̳߳��С�
2��notify():�����̳߳���һ���߳�(����).
3��notifyAll():�����̳߳��е������̡߳�

��Щ���������붨����ͬ���С�
��Ϊ��Щ���������ڲ����߳�״̬�ķ�����
����Ҫ��ȷ���ײ��������ĸ����ϵ��̡߳�


Ϊʲô�����̵߳ķ���wait notify notifyAll��������Object���У�

��Ϊ��Щ�����Ǽ������ķ�������������ʵ��������
������������Ķ�������Ķ�����õķ�ʽһ��������Object���С�

*/
//��Դ
class Resource144 {
	String name;
	String sex;
	boolean flag = false;
}

//����
class Input144 implements Runnable {
	Resource144 r;

	//	Object obj = new Object();
	Input144(Resource144 r) {
		this.r = r;
	}

	public void run() {
		int x = 0;
		while (true) {
			synchronized (r) {
				if (r.flag)
					try {
						r.wait();
					} catch (InterruptedException e) {
					}
				if (x == 0) {
					r.name = "mike";
					r.sex = "nan";
				} else {
					r.name = "����";
					r.sex = "ŮŮŮŮŮŮ";
				}
				r.flag = true;
				r.notify();
			}
			x = (x + 1) % 2;

		}
	}
}

//���
class Output142 implements Runnable {

	Resource144 r;

	//	Object obj = new Object();
	Output142(Resource144 r) {
		this.r = r;
	}

	public void run() {
		while (true) {
			synchronized (r) {
				if (!r.flag)
					try {
						r.wait();
					} catch (InterruptedException e) {
					}
				System.out.println(r.name + "....." + r.sex);
				r.flag = false;
				r.notify();
			}
		}
	}
}

class Resource144Demo2 {
	public static void main(String[] args) {
		//������Դ��
		Resource144 r = new Resource144();
		//��������
		Input144 in = new Input144(r);
		Output142 out = new Output142(r);
		//�����̣߳�ִ��·����
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		//�����߳�
		t1.start();
		t2.start();
	}
}
