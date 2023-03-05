import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {
    DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

    @BeforeEach
    void setUp() {
        dll.add(4);
        dll.add(5);
        dll.add(6);
    }

//    @Test
//    void testRemove() {
//        Iterator<Integer> it = dll.iterator();
//        int size = 2;
//        assertEquals(size, dll.size);
//        it.next();
//        it.remove();
//        size--;
//        assertEquals(size, dll.size);
//    }

    @Test
    void testForwardTraverse() {
        Iterator<Integer> it = dll.iterator();
        int val = 4;
        while(it.hasNext()) {
            assertEquals(val, it.next());
            val++;
        }
    }

    @Test
    void testBackwardTraverse() {
        Iterator<Integer> it = dll.iterator();
        while(it.hasNext()) { it.next(); }

        int val = 6;
        while(((DoublyLinkedList.DLLIterator) it).hasPrev()) {
            assertEquals(val, ((DoublyLinkedList.DLLIterator) it).prev());
            val--;
        }
    }
}
