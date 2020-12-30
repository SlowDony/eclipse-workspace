package com.slowdony.single;

import com.slowdony.AbstractList;

/**
 * 单向链表
 * @author mac
 *
 */
public class SingleLinkedList<E> extends AbstractList<E> {
	
	private Node<E> firstNode;
	
	///根节点类
	private static class Node<E> {
		/*
		 * 值
		 */
		E elementE;
		/*
		 * 下一个节点
		 */
		Node<E> nextNode;
		/*
		 * 构造方法
		 */
		public Node(E elementE,Node<E> next) {
			this.elementE = elementE;
			this.nextNode = next;
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		size = 0;
		firstNode = null;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return node(index).elementE;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		Node<E> node = node(index);
		E oldE = node.elementE;
		node.elementE = element;
		return oldE;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		/**
		 * 检查越界
		 */
		rangeCheckForAdd(index);
		
		if (index == 0) {
			firstNode = new Node<E>(element,firstNode);
		}else {
			Node<E> node = node(index - 1);
			node.nextNode = new Node<E>(element,node.nextNode);
		}
		size ++;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		/**
		 * 检查越界
		 */
		rangeCheck(index);
		Node<E> first = firstNode;
		if (index == 0) {
			firstNode = firstNode.nextNode;
		}else {
			Node<E> prevNode = node(index-1);
			prevNode.nextNode = prevNode.nextNode.nextNode;
		}
		size --;
		return first.elementE;
	}

	@Override
	public int indexOf(E element) {
		// TODO Auto-generated method stub
		if (element == null){
			Node<E> node = firstNode;
 			for (int i = 0; i < size; i++) {
				if (node.elementE == null) return i;
				node = node.nextNode;
			}
		}else {
			Node<E> node = firstNode;
			for (int i = 0; i < size; i++) {
				if (element.equals(node.elementE)) return i;
				node = node.nextNode;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	private Node<E> node(int index){
		
		rangeCheck(index);
		
		Node<E> first = firstNode ;
		for (int i = 0; i < index; i++) {
			first = first.nextNode;
		}
		return first;
 	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("size=").append(size).append(",[");
		Node<E> node = firstNode;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				stringBuilder.append(", ");
			}
			stringBuilder.append(node.elementE);
			node = node.nextNode;
		}
		
		stringBuilder.append("]");
		return stringBuilder.toString();
		
	}

}
