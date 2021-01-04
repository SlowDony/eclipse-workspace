package com.slowdony;

import com.slowdony.circle.CircleLinkedList;
import com.slowdony.single.SingleLinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//AbstractList<Integer> arrayList = new ArrayList<Integer>(10);
//		arrayList.add(1);
//		arrayList.add(3);
//		arrayList.add(4);
//		arrayList.add(3);
//		arrayList.add(4);
//		arrayList.add(null);
////		System.out.println(arrayList.toString());
//		arrayList.remove(2);
		
//		System.out.println(arrayList.indexOf(null));
//		System.out.println(arrayList.toString());
//		System.out.println("hello哈哈");
		
//		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
////		list.size = 2;
////		list.add(1);
////		list.add(2);
////		list.add(0, 3);
////		list.add(0, 222);
//		list.add(2222);
//		list.add(33);
//		list.add(33333);
//		
//		System.out.println(list.toString());
////		list.remove(1);
//		list.set(2, 2222222);
//		System.out.println(list.toString());
//		Integer integer = list.get(1);
//		System.out.println(integer);
		
		CircleLinkedList<Integer> list1 = new CircleLinkedList<Integer>();
		list1.add(12);
		list1.add(13);
		System.out.println(list1.toString());
	}

}
