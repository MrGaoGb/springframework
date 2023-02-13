package com.ecology.utils.pooltest;


public class SynchronizeDemo {
	
	
	// 创建需要加锁的对象
	private Object lock = new Object();
	
	// 代码块
    public void method1() {
        synchronized (lock) {
			// 临界区：需要保护的资源
            System.out.println("lock ... synchronized!");
        }
    }
	
	// synchronized 修饰非静态方法
	public synchronized void method2(){
		System.out.println("method2");
	}
	
	
	// synchronized 修饰静态方法
	public synchronized static void method3(){
		System.out.println("method3");
	}

}
