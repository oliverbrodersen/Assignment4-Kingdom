package kingdom.ArrayList;

import kingdom.Flyweight.GoldBar;
import kingdom.Flyweight.Valuable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    private ListADT<String> list;

    @BeforeEach
    public void createList()
    {
        list = new ArrayList<>();
    }

    @Test //Testing if the correct exception is thrown
    void tryingToAddElementAtWrongIndex() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
        {
            list.add(5,"Test");
        });
    }

    @Test //Testing if add method is working correctly
    void tryingToAddElementAtCorrectIndex() {
        list.add(0,"Test");
        Assertions.assertEquals("Test",list.get(0));
    }

    @Test
    void tryingToAddManyObjects() {
        for (int i = 0; i < 101; i++) {
            list.add("Test");
        }
    }

    @Test
    void setUnsetElementAtWrongIndex()
    {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
        {
            list.set(5,"Test");
        });
    }

    @Test
    void setUnsetElementAtCorrectIndex() {
        list.add("Test");
        list.set(0,"Cat");
        Assertions.assertEquals("Cat",list.get(0));
    }

    @Test // Expected IndexOutOfBoundsException got IllegalStateException.
    void tryingToGetElementAtWrongIndex()
    {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
        {
            list.get(5);
        });
    }

    @Test
    void testAdd() {
    }

    @Test
    void set() {
    }

    @Test
    void get() {
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void contains() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void isFull() {
    }

    @Test
    void size() {
    }

    @Test
    void testToString() {
    }
}