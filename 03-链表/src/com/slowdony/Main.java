package com.slowdony;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractList<Integer> arrayList = new ArrayList<Integer>(10);
		arrayList.add(1);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(null);
		System.out.println(arrayList.toString());
		arrayList.remove(2);
		
		System.out.println(arrayList.indexOf(null));
		System.out.println(arrayList.toString());
	}

}
