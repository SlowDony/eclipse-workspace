package com.slowdony;

public abstract class AbstractList<E> implements List<E> {

	/**
	 * 元素数量
	 */
	protected int size;


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public Boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public Boolean contains(E element) {
		// TODO Auto-generated method stub
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}

	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		add(size, element);
	}
	
	/**
	 * 角标越界抛出异常
	 */
	protected void outOfBounds(int index) {
		throw new IndexOutOfBoundsException("Index:" + index + ",size" + size);
	}

	/**
	 * 数组角标判断
	 */
	protected void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			outOfBounds(index);
		}
	}

	/**
	 * 添加元素时数组角标判断
	 * 
	 * @param index
	 */
	protected void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			outOfBounds(index);
		}
	}

}
