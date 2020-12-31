package com.slowdony.single;

import javax.xml.soap.Node;

import com.slowdony.AbstractList;

/**
 * 增加一个虚拟头结点
 * @author mac
 *
 */
public class SingleLinkedList2<E> extends AbstractList<E> {

	private Node<E> first;
	public SingleLinkedList2() {
		first = new Node<>(null,null);
	}
	private class Node<E>{
		E elementE;
		Node<E> nextNode;
		public Node(E elementE,Node<E> next) {
			this.elementE = elementE;
			this.nextNode = next;
		}
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		size = 0;
		first = null;
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
		rangeCheckForAdd(index);
		if (index == 0) {
			first = new Node<E>(element, first);
		}else {
			Node<E> prevNode = node(index-1);
			prevNode.nextNode = new Node<E>(element, prevNode.nextNode);
		}
		size++;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		rangeCheck(index);
		
		Node<E> prev = index == 0 ? first: node(index-1);
		Node<E> node = prev.nextNode;
		prev.nextNode = node.nextNode;
		size--;
 		return node.elementE;
	}

	@Override
	public int indexOf(E element) {
		// TODO Auto-generated method stub
		if (element == null) {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (node.elementE == null) return i;
				node = node.nextNode;
			}
		}else {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (element.equals(node.elementE)) return i; 
				node = node.nextNode;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	private Node<E> node(int index){
		rangeCheck(index);
		Node<E> node = first.nextNode;
		for (int i = 0; i < index; i++) {
			node = node.nextNode;
		}
		return node;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("size=").append(size).append(",[");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (i!= 0) {
				stringBuilder.append(",");
			}
			stringBuilder.append(node.elementE);
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}
