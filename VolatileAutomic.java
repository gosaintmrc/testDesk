package jvm;

public class VolatileAutomic extends Thread{
	
	private volatile int a=0;
	
	public static void main(String[] args) {
		final VolatileAutomic test=new VolatileAutomic();
		for(int i=0;i<10;i++){
			/**
			 * 启动10个线程，每一个线程自增1000，那么最终应该是10000
			 */
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }
		while(Thread.activeCount()>1){
			Thread.yield(); 
			//保证前面的线程都执行完毕
		}
		System.out.println(test.a);
	}
	public void increase() {
        a++;
    }
}
