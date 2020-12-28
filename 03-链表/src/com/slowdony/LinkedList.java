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
		//在角标为1添加元素
		if (index == 0) {
			first = new Node<>(element,first);
		}else {
			Node<E> prevNode = node(index-1);
			prevNode.next = new Node<>(element,prevNode.next);
		}
		size ++ ;
	}
	
	/**
	 * 移除
	 */
	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		rangeCheck(index);
		Node<E> node = first;
		if (index == 0) {
			first = first.next;
		}else {
			Node<E> preNode = node(index - 1);
			node = preNode.next;
			preNode.next = node.next;
		}
		size -- ;
		return node.element;
	}
	//
	@Override
	public int indexOf(E element) {
		// TODO Auto-generated method stub
		if (element == null) {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (node.element == null)
					return i;
				node = node.next;
			}
		}else {
			Node<E> node = first;
			for(int i = 0; i<size; i++) {
				if ( node.element.equals(element)) {
					return i;
				}
				node = node.next;
			}
		}
		
		return ELEMENT_NOT_FOUND;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		StringBuilder string = new StringBuilder();
		string.append("Size=").append(size).append(",[");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i!=0) {
				string.append(", ");
			}
			
			string.append(node.element);
			node = node.next;
		}
		
		string.append("]");
		
		return string.toString();
	}
	

}
