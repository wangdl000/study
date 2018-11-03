/*
jdk1.5�Ժ�ͬ��������װ���˶��� 
��������������ʽ��ʽ���嵽�˸ö����У�
����ʽ�����������ʾ������

Lock�ӿڣ� ���������ͬ����������ͬ����������ͬ������ʽ�����������ʵ��������
ͬʱ��Ϊ������һ�����ϼ��϶����������
lock():��ȡ����
unlock():�ͷ�����ͨ����Ҫ����finally������С�


Condition�ӿڣ����������Object�е�wait notify notifyAll������
			����Щ�������������������˷�װ�����Condition����������
			����������������ϡ�
await();
signal();
signalAll();



*/

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource
{
	private String name;
	private int count = 1;
	private boolean flag = false;

//	����һ��������
	Lock lock = new ReentrantLock();

	//ͨ�����е�����ȡ�����ϵļ���������
//	Condition con = lock.newCondition();

	//ͨ�����е�����ȡ�����������һ����������ߣ�һ����������ߡ�
	Condition producer_con = lock.newCondition();
	Condition consumer_con = lock.newCondition();

	
	public  void set(String name)//  t0 t1
	{
		lock.lock();
		try
		{
			while(flag)
//			try{lock.wait();}catch(InterruptedException e){}//   t1    t0
			try{producer_con.await();}catch(InterruptedException e){}//   t1    t0
		
			this.name = name + count;//��Ѽ1  ��Ѽ2  ��Ѽ3
			count++;//2 3 4
			System.out.println(Thread.currentThread().getName()+"...������5.0..."+this.name);//������Ѽ1 ������Ѽ2 ������Ѽ3
			flag = true;
//			notifyAll();
//			con.signalAll();
			consumer_con.signal();
		}
		finally
		{
			lock.unlock();
		}
		
	}

	public  void out()// t2 t3
	{
		lock.lock();
		try
		{
			while(!flag)
//			try{this.wait();}catch(InterruptedException e){}	//t2  t3
			try{cousumer_con.await();}catch(InterruptedException e){}	//t2  t3
			System.out.println(Thread.currentThread().getName()+"...������.5.0......."+this.name);//���ѿ�Ѽ1
			flag = false;
//			notifyAll();
//			con.signalAll();
			producer_con.signal();
		}
		finally
		{
			lock.unlock();
		}
		
	}
}

class Producer implements Runnable
{
	private Resource r;
	Producer(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			r.set("��Ѽ");
		}
	}
}

class Consumer implements Runnable
{
	private Resource r;
	Consumer(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			r.out();
		}
	}
}



class  ProducerConsumerDemo2
{
	public static void main(String[] args) 
	{
		Resource r = new Resource();
		Producer pro = new Producer(r);
		Consumer con = new Consumer(r);

		Thread t0 = new Thread(pro);
		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(con);
		Thread t3 = new Thread(con);
		t0.start();
		t1.start();
		t2.start();
		t3.start();

	}
}

