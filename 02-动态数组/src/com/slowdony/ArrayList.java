package com.slowdony;

public class ArrayList<E> {

	//元素数量
	private int size;
	
	//所有元素
	private E[] elements;
	
	private static final int DEFAULT_CAPACITY = 10;
	private static final int ELEMENT_NOT_FOUND = -1;
	
	@SuppressWarnings("unchecked")
	public ArrayList(int capaticy) {
		capaticy = (capaticy < DEFAULT_CAPACITY) ?DEFAULT_CAPACITY:capaticy;
		elements = (E[]) new Object[capaticy];
		
	}
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder string = new StringBuilder();
			string.append("size=").append(size).append(",[");
			for (int i = 0; i < size; i++) {
				if (i>0){
					string.append(",");
				}
				string.append(elements[i]);
			}
			string.append("]");
			return string.toString();
	}
	
	// 元素的数量
	public int size() {
		return size;
	}
	// 是否为空
	public boolean isEmpty() {
		return size == 0;
	}
//	// 是否包含某个元素
//	boolean contains(E element) {
//		
//	}
	// 添加元素到最后面
	public void add(E element) {
		add(size,element);
	}
	// 在index的位置插入一个元素
	public void add(int index,E element) {
		rangeCheckForAdd(index);
		ensureCapacity(size+1);
		for (int i = size; i < index; i--) {
			elements[i] = elements[i-1];
		}
		elements[index] = element;
		size++;
	}
	
	//扩容
	@SuppressWarnings("unchecked")
	private void ensureCapacity(int element) {
		// TODO Auto-generated method stub
		int oldCapcity = elements.length;
		if(oldCapcity>=element)return;
		//扩容把原来的大小扩大1.5倍
		int newCapcity = oldCapcity+(oldCapcity>>1);
		E[]newElements = (E[]) new Object[newCapcity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		System.out.println(oldCapcity + "扩容" + newCapcity);
		
	}
//	// 返回index位置对应的元素
//	E get(int index) {
//		
//	}
//	// 设置index位置的元素
//	E set(int index, E element) {
//		
//	}
	
	/**
	 *  清除所有元素
	 */
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0; 
	}
	
	/**
	 * 移除元素
	 * @param index
	 * @return
	 */
	public E remove(int index) {
		
		rangeCheck(index);
		
		E old = elements[index];
		for (int i = index +1; i < size; i++) {
			elements[i-1] = elements[i];
		}
		elements[--size] = null;
		return old;
	}
	
	/**
	 * 检查数组是否越界
	 * @param index
	 */
	private void rangeCheck(int index) {
		if (index < 0 || index>=size) {
			outOfBounds(index);
		}
	}

	/**
	 * 检查添加元素是否越界
	 * @param index
	 */
	private void rangeCheckForAdd(int index) {
		if (index<0||index>size) {
			outOfBounds(index);
		}
	}
	
	/**
	 * 抛出异常
	 * @param index
	 */
	private void outOfBounds(int index) {
		// TODO Auto-generated method stub
		throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
	}
	
	
	
	/**
	 *  查看元素的位置
	 * @param element
	 * @return
	 */
	public int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) return i;
			}
		}else {
			for (int i = 0; i < size; i++) {
				if (element.equals(elements[i])) return i;
			}
		}
		
		
		return ELEMENT_NOT_FOUND;
	}


}
