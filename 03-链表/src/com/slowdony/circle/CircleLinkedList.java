package com.slowdony.circle;

import javax.xml.soap.Node;

import com.slowdony.AbstractList;

public class CircleLinkedList<E> extends AbstractList<E> {
	private Node<E> first;
	private Node<E> last;
	private Node<E> current;

	private static class Node<E> {
		E elementE;
		Node<E> prev;
		Node<E> next;

		public Node(Node<E> prev, E element, Node<E> next) {
			// TODO Auto-generated constructor stub
			this.prev = prev;
			this.elementE = element;
			this.next = next;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			StringBuilder stringBuilder = new StringBuilder();
			if (prev != null) {
				stringBuilder.append(prev.elementE);
			}else {
				stringBuilder.append("null");
			}
			stringBuilder.append("_").append(elementE).append("_");
			if (next != null) {
				stringBuilder.append(next.elementE);
			}else {
				stringBuilder.append("null");
			}
			return stringBuilder.toString();
		}
		
	}
	public void reset() {
		current = first;
	}
	public E next() {
		if (current == null) return null;
		current = current.next;
		return current.elementE;
	}
	
	public E remove() {
		if (current == null) return null;
		Node<E> next = current.next;
		E element = remove()
	}
	
	@Override
	public void clear() {

		// TODO Auto-generated method stub

	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub

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

	private E name() {
		
	}
	

}
