package com.slowdony;

@SuppressWarnings("unchecked")
public class ArrayList<E> extends AbstractList<E> {

	/**
	 * 所有元素
	 */
	private E[] elements;

	/**
	 * 默认大小
	 */
	private static final int DEFAULT_CAPACITY = 10;

	public ArrayList(int capacity) {
		capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
		elements = (E[]) new Object[capacity];
	}

	/*
	 * 构造方法
	 */
	public ArrayList() {
		this(DEFAULT_CAPACITY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		rangeCheck(index);
		return elements[index];
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		rangeCheck(index);
		E old = elements[index];
		elements[index] = element;
		return old;
	}
//	size = 6 
//	index = 3
//	1 3 4 "5" 6 7 8
	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		rangeCheckForAdd(index);
		ensureCapacity(size+1);
		for (int i = size; i > index; i--) {
			elements[i] = elements[i-1];
		}
		elements[index] = element;
		size++;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		rangeCheck(index);
		E old = elements[index];
		for (int i = index + 1; i < size; i++) {
			elements[i-1] = elements[i];
		}
		elements[--size] = null;
		return old;
	}

	@Override
	public int indexOf(E element) {
		// TODO Auto-generated method stub
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) {
					return i;
				}
			}
		}else {
			for (int i = 0; i < size; i++) {
				if (element.equals(elements[i])) {
					return i;
				}
			}
		}
		return ELEMENT_NOT_FOUND;
	}

	/**
	 * 扩容
	 * 
	 * @param capacity
	 */
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity)
			return;
		//新容量比旧容量扩大1.5倍
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElecments = (E[])new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElecments[i] = elements[i];
		}
		elements = newElecments;
		System.out.println(oldCapacity + "扩容为" + newCapacity);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		StringBuilder string = new StringBuilder();
			string.append("数组大小为:").append(size).append(",分别是:[");
		
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(",");
			}
			string.append(elements[i]);
		}		
		string.append("]");
		return string.toString();
	}
}
