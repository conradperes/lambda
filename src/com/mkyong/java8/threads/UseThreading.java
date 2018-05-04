package com.mkyong.java8.threads;
import static java.lang.System.out;
public class UseThreading {
	 public static void main(String[] args) {
	        //Old version
//	        Runnable thrd1 = new Runnable(){
	//
//	            @Override
//	            public void run() {
//	                out.println("Hello Thread 1.");
//	            }  
//	        };

	        /* 
	         *****************************************
	         * Using lambda expression inner classes *
	         *****************************************
	         */
	        Runnable thrd1 = () -> out.println("Hello Thread 1.");

	        new Thread(thrd1).start();

	         // Old Version
//	        new Thread(new Runnable() {
	//
//	            @Override
//	            public void run() {
//	                out.println("Hello Thread 2.");
//	            }
//	        }).start();
	        
	        /* 
	         ******************************************
	         * Using lambda exprssion anonymous class *
	         ******************************************
	         */
	        new Thread(() -> out.println("Hello Thread 2.")).start();

	    }
}
