package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE

    @Test
    public void testThreeAddThreeRemove(){
        BuggyAList<Integer> buggyAList =  new BuggyAList<>();
        AListNoResizing<Integer> aList =  new AListNoResizing<>();

        buggyAList.addLast(4);
        buggyAList.addLast(5);
        buggyAList.addLast(6);
        aList.addLast(4);
        aList.addLast(5);
        aList.addLast(6);

        assertEquals(aList.size(), buggyAList.size());

        assertEquals(aList.removeLast(), buggyAList.removeLast());
        assertEquals(aList.removeLast(), buggyAList.removeLast());
        assertEquals(aList.removeLast(), buggyAList.removeLast());

    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> buggyL =  new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                buggyL.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
                System.out.println("Buggy addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int buggySize = buggyL.size();
                System.out.println("size: " + size);
                System.out.println("buggy size: " + buggySize);
            } else if (operationNumber == 2){
                if (L.size() != 0){
                    int last =  L.getLast();
                    int buggyLast =  buggyL.getLast();
                    System.out.println("Last: " + last);
                    System.out.println("Buggy Last: " + buggyLast);
                }
            } else if (operationNumber == 3) {
                if (L.size() != 0){
                    int last =  L.removeLast();
                    int buggyLast =  buggyL.removeLast();
                    System.out.println("Remove Last: " + last);
                    System.out.println("Remove Buggy Last: " + buggyLast);
                }
            }
        }
    }
}
