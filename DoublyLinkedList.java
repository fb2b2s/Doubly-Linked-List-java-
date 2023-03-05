import java.util.Iterator;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> extends SinglyLinkedList<T> {
	public static class Entry<E> extends SinglyLinkedList.Entry<E> {
		Entry<E> prev;
		Entry(E x, Entry<E> next, Entry<E> prev) {
			super(x, next);
			this.prev = prev;
		}
	}

	Entry<T> head, tail;
	public DoublyLinkedList () {
		super();
		head = new Entry<>(null, null, null);
		tail = head;
		super.head = (SinglyLinkedList.Entry<T>) (head);
		super.tail = (SinglyLinkedList.Entry<T>) (tail);
	}


	public Iterator<T> iterator() {return new DLLIterator();}

	public class DLLIterator extends SLLIterator {
		DLLIterator() {
			super();
		}

		public boolean hasPrev() {return !(prev == head);}

		@Override
		public void remove() {
			super.remove();
			if(cursor != null) {
				if(cursor.next != null) {
					((Entry<T>) (cursor.next)).prev
							= (Entry<T>) prev;
				}
				prev = ((Entry<T>) cursor).prev;
			}
		}

		public T prev() {
			T element = cursor.element;
			cursor = prev;
			prev = ((Entry<T>) cursor).prev;
			ready = true;
			return element;
		}
	}

	public void add(T x) {add(new Entry<T>(x, null, null));}

	private void add(Entry<T> node) {
		// which tail is updated: DEBUG
		node.prev = tail;
		super.add((SinglyLinkedList.Entry<T>) node);
		tail = ((Entry<T>) (super.tail));
	}

	public static void main(String[] args) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		Iterator<Integer> it = dll.iterator();

		int n = 10;
		for(int i=1; i<=n; i++) {
			dll.add(Integer.valueOf(i));
		}
		dll.printList();

		Scanner in = new Scanner(System.in);
		whileloop:
		while(in.hasNext()) {
			int com = in.nextInt();
			switch(com) {
				case 1:  // Move to next element and print it
					if (it.hasNext()) {
						System.out.println(it.next());
					} else {
						break whileloop;
					}
					break;
				case 2:  // Remove element
					it.remove();
					dll.printList();
					break;
				default:  // Exit loop
					break whileloop;
			}
		}
	}
}