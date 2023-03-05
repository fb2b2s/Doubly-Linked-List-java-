import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {
    DoublyLinkedList<Integer> dll;
    Iterator<Integer> it;

    @BeforeEach
    void setUp() {
        dll = new DoublyLinkedList<>();
        it = dll.iterator();
        dll.add(4);
        dll.add(5);
        dll.add(6);
    }

    @Test
    void testRemove() {
        int size = 3;
        while(it.hasNext()) {
            assertEquals(size, dll.size);
            it.next();
            dll.printList();
            it.remove();
            size--;
        }
        assertEquals(size, dll.size);
    }

    @Test
    void testPointersAfterRemove() {
        it.next();
        it.next();
        it.remove();
        assertEquals(4, dll.head.next.element);
        assertEquals(dll.tail.element, dll.head.next.next.element);
        assertEquals(6, dll.head.next.next.element);
        assertEquals(dll.head.next, ((DoublyLinkedList.Entry<Integer>) (dll.head.next.next)).prev);
    }

    @Test
    void testRemove2() {
        it.next();
        it.next();
        it.remove();
        assertEquals(2, dll.size);

        ((DoublyLinkedList.DLLIterator) it).prev();
        int val = 4;
        while(it.hasNext()) {
            assertEquals(val, it.next());
            val += 2;
        }
        val -= 2;
        while(((DoublyLinkedList.DLLIterator) it).hasPrev()) {
            assertEquals(val, ((DoublyLinkedList.DLLIterator) it).prev());
            val -= 2;
        }
    }

    @Test
    void testForwardTraverse() {
        int val = 4;
        while(it.hasNext()) {
            assertEquals(val, it.next());
            val++;
        }
    }

    @Test
    void testBackwardTraverse() {
        while(it.hasNext()) { it.next(); }

        int val = 6;
        while(((DoublyLinkedList.DLLIterator) it).hasPrev()) {
            assertEquals(val, ((DoublyLinkedList.DLLIterator) it).prev());
            val--;
        }
    }
}
