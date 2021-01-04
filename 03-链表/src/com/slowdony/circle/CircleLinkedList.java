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
		E element = remove(current);
		if (size == 0) {
			current = null;
		}else {
			current = next;
		}
		return element;
	}
	
	@Override
	public void clear() {
		size = 0;
		first = null;
		last = null;
		// TODO Auto-generated method stub

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
		E old = node.elementE;
		node.elementE = element;
		return old;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		rangeCheckForAdd(index);
		if (index==size) {
			Node<E> oldLast = last;
			last = new Node<E>(oldLast, element, first);
			//这是链表添加的第一个元素
			if (oldLast == null) {
				first = last;
				first.next = first;
				first.prev = first;
			}else {
				oldLast.next = last;
				first.prev = last;
			}
		}else {
			Node<E> next = node(index);
			Node<E> prev = next.prev;
			Node<E> node = new Node<E>(prev, element, next);
			next.prev = node;
			prev.next = node;
			if (next == first) { // index == 0
				first = node;
			}
		}
		size ++;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		rangeCheck(index);
		
		return remove(node(index));
	}

	@Override
	public int indexOf(E element) {
		// TODO Auto-generated method stub
		if (element == null) {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (node.elementE == null)return i;
				node.next = node;
			}
		}else {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (element.equals(node.elementE)) return i;
				node.next = node;
			}
		}
		return ELEMENT_NOT_FOUND;
	}

	/**
	 * 获取index位置对应的节点对象
	 * @param index
	 * @return
	 */
	private Node<E> node(int index){
		rangeCheck(index);
		if (index<(size>>1)) {
			Node<E> node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		}else {
			Node<E> node = last;
			for (int i = 0; i < index; i--) {
				node = node.prev;
			}
			return node;
		}
	}
	/**
	 * 移除节点
	 * @param node
	 * @return
	 */
	private E remove(Node<E> node) {
		if (size == 1) {
			first = null;
			last = null;
		}
		else {
			Node<E> prev = node.prev;
			Node<E> next = node.next;
			prev.next = next;
			next.prev = prev;
			if (node == first) {
				first = next;
			}
			if (node == last) {
				last = prev;
			}
		}
		
		size--;
		return node.elementE;
		
	}

}
