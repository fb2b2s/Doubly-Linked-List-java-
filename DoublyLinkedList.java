import java.util.Iterator;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> extends SinglyLinkedList<T> {
	private static class Entry<E> extends SinglyLinkedList.Entry<E> {
		Entry<E> prev;
		Entry(E x, Entry<E> next, Entry<E> prev) {
			super(x, next);
			this.prev = prev;
		}
	}

	private Entry<T> head, tail;
	public DoublyLinkedList () {
		super();
	}

	public static void main(String[] args) {
		System.out.println("Hello there!");
	}
}