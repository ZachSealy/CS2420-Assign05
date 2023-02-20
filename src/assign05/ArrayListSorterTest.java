package assign05;

import assign05.ArrayListSorter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListSorterTest {

    @Test
    void mergesort() {
        ArrayList list = ArrayListSorter.generatePermuted(24);

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        ArrayListSorter.mergesort(list);

        System.out.println("\n");
        System.out.println("After");
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for (int i = 1; i <= 24; i++) {
            assertEquals(i, list.get(i - 1));
        }
    }

    @Test
    void mergesortBig() {
        ArrayList list = ArrayListSorter.generatePermuted(24);

        System.out.println("Before");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        ArrayListSorter.mergesort(list);

        System.out.println("\n");
        System.out.println("After");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    void quicksort() {
    	ArrayList list = ArrayListSorter.generatePermuted(8);

        System.out.println("Before");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        ArrayListSorter.quicksort(list);

        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        
        System.out.println("After");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        
        for (int i = 1; i <= 8; i++) {
            assertEquals(i, list.get(i - 1));
        }
    }

    @Test
    void generateAscending() {
        ArrayList list = ArrayListSorter.generateAscending(10);

        for (int i = 1; i <= 10; i++) {
            assertEquals(i, list.get(i - 1));
        }

        assertTrue(list.size() == 10);

    }

    @Test
    void generatePermuted() {
        ArrayList list = ArrayListSorter.generatePermuted(10);

        for (int i = 1; i <= 10; i++) {
            assertTrue(list.contains(i));
        }

        assertTrue(list.size() == 10);
        assertFalse(list.contains(11));

    }

    @Test
    void generateDescending() {
        ArrayList list = ArrayListSorter.generateDescending(10);

        for (int i = 0; i < 10; i++) {
            assertEquals(10 - i, list.get(i));
        }

        assertTrue(list.size() == 10);
    }

//    @Test
//    void mergeTestLeft() {
//        ArrayList list1 = new ArrayList<Integer>();
//        ArrayList list2 = new ArrayList<Integer>();
//        ArrayList list = new ArrayList<Integer>();
//
//        for (int i = 1; i <= 5; i++) {
//            list1.add(i);
//            list2.add(i + 5);
//        }
//
//        ArrayListSorter.merge(list, list1, list2);
//
//        for (int i = 1; i <= 10; i++) {
//            assertEquals(i, list.get(i - 1));
//        }


//    }

    @Test
    void mergeTestSplit() {
//        ArrayList list1 = new ArrayList<Integer>();
//        ArrayList list2 = new ArrayList<Integer>();
//        ArrayList list = new ArrayList<Integer>();
//
//        for (int i = 1; i <= 5; i++) {
//            list1.add(i*2);
//            list2.add((i * 2)-1);
//        }
//
//        ArrayListSorter.merge(list, list1, list2);
//
//        for (int i = 1; i <= 10; i++) {
//            assertEquals(i, list.get(i - 1));
//        }
//
    }
}