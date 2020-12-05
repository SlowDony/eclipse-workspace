package com.solwdony;

public class helloword {
	public static void main(String[] args) {
		System.out.println(fib(0));
		System.out.println(fib(1));
		System.out.println(fib(2));
		System.out.println(fib(3));
		System.out.println(fib(4));
		System.out.println(fib(5));
		System.out.println(fib(6));
		System.out.println(fib(45));
	}
	
	
	public static int fib1(int n) {
		if (n <= 1) return n;
		return fib1(n-1) + fib1(n-2);
	}
//	0 1 2 3 4 5 6 7
//	0 1 1 2 3 5 8 13
	public static int fib(int n) {
		if (n <= 1) return n;
		int first = 0;
		int second = 1;
		for (int i = 0; i < n - 1 ; i++) {
			int sum = first + second;
			first = second;
			second = sum;
		}
		return second;
	}
}
	
