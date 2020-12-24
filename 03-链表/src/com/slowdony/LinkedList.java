package com.slowdony;

/*
 * 单向链表
 */
public class LinkedList<E> extends AbstractList<E> {

	private Node<E> first;
	//私有类,链表中的节点
	private class Node<E> {
		E element;
		Node<E> next;
		//构造方法
		public Node(E element,Node<E> next) {
			this.element = element;
			this.next = next;
		}
	}
	
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		size = 0; 
		first = null;
		
	}
	/**
	 * 获取
	 */
	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		/**
		 * 最好 O(1)
		 * 最坏 O(n)
		 * 平均 O(n)
		 */
		return node(index).element;
	}
	/**
	 * 设置
	 */
	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		Node<E> node = node(index);
		E old = node.element;
		node.element = element;
		return old;
 	}
	/**
	 * 添加
	 */
	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		rangeCheckForAdd(index);
		
	}
	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int indexOf(E element) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * 获取index位置对应的节点对象
	 * @param index
	 * @return
	 */
	private Node<E> node(int index) {
		rangeCheck(index);
		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	

}
