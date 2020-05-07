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
    void tryingToGetElementAtCorrectIndex()
    {
        list.add("Test");
        Assertions.assertEquals("Test",list.get(0));
    }


    @Test
    void tryingToRemoveElementAtWrongIndex()
    {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
        {
            list.remove(5);
        });
    }

    @Test
    void tryingToRemoveSpecificElementThatDoesntExist()
    {
        for (int i = 0; i < 5; i++) {
            list.add("Test" + i);
        }
        Assertions.assertThrows(IllegalStateException.class, () ->
        {
            list.remove("Test6");
        });
    }

    @Test
    void tryingToRemoveSpecificElementThatDoesExist()
    {
        for (int i = 0; i < 5; i++) {
            list.add("Test" + i);
        }
            list.remove("Test2");
        Assertions.assertNotEquals("Test2",list.get(2));
    }

    @Test
    void tryingToRemoveElementAtCorrectIndex()
    {
        for (int i = 0; i < 5; i++) {
            list.add("Test" + i);
        }
        list.remove(2);
        Assertions.assertNotEquals("Test2",list.get(2));
    }

    @Test
    void gettingIndexOfUnspecifiedElement()
    {
        for (int i = 0; i < 5; i++) {
            list.add("Test" + i);
        }
        Assertions.assertEquals(-1,list.indexOf("Test10"));
    }

    @Test
    void gettingIndexOfElement()
    {
        for (int i = 0; i < 5; i++) {
            list.add("Test" + i);
        }
        Assertions.assertEquals(2,list.indexOf("Test2"));
    }

    @Test
    void gettingTrueContainsElement()
    {
        for (int i = 0; i < 5; i++) {
            list.add("Test" + i);
        }
        Assertions.assertTrue(list.contains("Test2"));
    }

    @Test
    void gettingFalseContainsElement()
    {
        for (int i = 0; i < 5; i++) {
            list.add("Test" + i);
        }
        Assertions.assertFalse(list.contains("Test10"));
    }

    @Test
    void isEmptyWhenFull()
    {
        for (int i = 0; i < 100; i++) {
            list.add("Test");
        }
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    void isEmptyWhenHalfFull()
    {
        for (int i = 0; i < 50; i++) {
            list.add("Test");
        }
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    void isEmptyWhenEmpty()
    {
        Assertions.assertTrue(list.isEmpty());
    }

    @Test //Method always returns true
    void isFullWhenFull()
    {
        for (int i = 0; i < 100; i++) {
            list.add("Test");
        }
        Assertions.assertTrue(list.isFull());
    }

    @Test //Method always returns true
    void isFullWhenHalfFull()
    {
        for (int i = 0; i < 50; i++) {
            list.add("Test");
        }
        Assertions.assertFalse(list.isFull());
    }

    @Test //Method always returns true
    void isFullWhenEmpty()
    {
        Assertions.assertFalse(list.isFull());
    }

    @Test
    void testingSizeWhenEmpty()
    {
        Assertions.assertEquals(0,list.size());
    }

    @Test
    void testingSizeWhenOverFull()
    {
        for (int i = 0; i < 101; i++) {
            list.add("Test");
        }
        Assertions.assertEquals(101,list.size());
    }

    @Test
    void testingSizeIsCorrect()
    {
        for (int i = 0; i < 7; i++) {
            list.add("Test");
        }
        Assertions.assertEquals(7,list.size());
    }
}