package com.slowdony;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Main.main()");
//		ArrayList<Integer> array = new ArrayList<Integer>();
//		array.add(99);
//		array.add(88);
//		array.add(33);
//		array.add(99);
//		array.add(88);
//		array.add(33);
//		array.add(99);
//		array.add(88);
//		array.add(33);
//		array.add(99);
//		for (int i = 0; i < 20; i++) {
//			array.add(i);
//		}
		
		
		ArrayList<Person>  personArray = new ArrayList<Person>();
		personArray.add(new Person(10, "jack"));
		personArray.add(null);
		personArray.add(new Person(20, "hash"));
		personArray.add(new Person(30, "luse"));
		personArray.add(null);
		
//		System.out.println(array);
//		System.out.println(array.remove(2));
//		System.out.println(array);
//		array.add(7, 77);
//		personArray.remove(1);
		System.out.println(personArray);
		;
		System.out.println(personArray.indexOf(null));
	}

}
