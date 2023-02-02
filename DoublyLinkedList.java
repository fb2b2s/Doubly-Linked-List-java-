/** @author rbk
 *  Singly linked list: for instructional purposes only
 *  Ver 1.0: 2018/08/21
 *  Ver 2.0: 2018/08/28: modified to be able to extend to DoublyLinkedList
 *  Entry class has generic type associated with it, to allow inheritance.
 *  We can now have a doubly linked list class DLL that has

 */

import java.util.Iterator;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> extends SinglyLinkedList<T> {
    static class Entry<E> extends SinglyLinkedList.Entry<E> {
		Entry<E> prev;
		Entry(E x, Entry<E> next, Entry<E> prev) {
			super(x, next); // single pointers
			this.prev = prev; // double pointer
		}
    }

	Entry<T> head, tail;
	public DoublyLinkedList (){
		super();
		head = new Entry<>(null, null, null);
		tail = head; // we have dll head and tail
	}

	public Iterator<T> iterator1() { return new DLLIterator();} // class getter

	protected class DLLIterator extends SLLIterator {
		protected Entry<T> cursor;

		public DLLIterator() {
			super(); 
			cursor = head; // dll cursor
		}

		public boolean hasPrev() { 
			return !(cursor == head || cursor.prev == head); }
 
		public void add(T x) {
			Entry<T> node = new Entry<>(x, null, null);

			if(head.next == null){
				tail = node;
				tail.prev = head;
			}
			else{
				node.next = cursor.next;
				cursor.next = node;
				node.prev = cursor;
				
				if (cursor == tail) {
					tail = node;
				}
				else {
					((Entry<T>)(node.next)).prev = node;
				}
			}
			size++;
		}
	}

	public static void main(String[] args) {
		DoublyLinkedList<Integer> lst = new DoublyLinkedList<>();
		Iterator<Integer> it = lst.iterator1();

		it.add(1); // dll method 
		it.hasPrev(); // dll method 
		it.hasNext(); // parent class method
		lst.printList(); 

		Scanner in = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		
		whileloop:
			while(in.hasNext()){
				int com = in.nextInt();
				switch(com) {
					case 1 : // move to next element and print it
						if(it.hasNext()){
							System.out.println(it.next());
						}
						else{
							break whileloop;
						}
						break;
					case 2: // add the element
						int num = sc.nextInt();
						// it.add(num);
						lst.printList();
						break;
					default:
						break whileloop;
				}
			}
	}
}