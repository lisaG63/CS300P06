//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P06 Mega Blocks Builder
// Files:           LinkedMegaBLock.java, LinkedListMegaBlock.java, MegaBlockBuilderTester.java
// Course:          CS300, fall, 2019
//
// Author:          Weihang Guo, Jiaqi Zhang
// percentage:           wguo63@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Jiaqi Zhang
// Partner percentage:   jzhang2247@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X__ Write-up states that pair programming is allowed for this assignment.
// _X__ We have both read and understand the course Pair Programming Policy.
// _X__ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Milks: None
// Online Sources: None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


import java.util.NoSuchElementException;

/**
 * This class tests the methods in MegaBlock, LinkedMegaBlock and LinkedListMegaBlock class.
 * 
 * @author Weihang Guo, Jiaqi Zhang
 *
 */
public class MegaBlockBuilderTester {
  
  /**
   * Checks for the correctness of the MegaBlock.equals() method.
   * @return true when the method runs correctly, false otherwise.
   */
  public static boolean testMegaBlockEquals() {
    //Creates three MegaBlocks, two blue and one yellow.
    MegaBlock block1 = new MegaBlock(Color.BLUE, 'A');
    MegaBlock block2 = new MegaBlock(Color.BLUE, 'B');
    MegaBlock block3 = new MegaBlock(Color.YELLOW, 'C');
    //Checks the running result when calling equals()method to compare two MegaBlocks with the 
    //same color and two MegaBlocks with different colors.
    if (!block1.equals(block2)) {
      return false;
    } else if (block1.equals(block3)) {
      return false;
    } 
    return true;
    
  }
  
  /**
   * Checks for the correctness of the MegaBlock.toString() method.
   * @return true when the method runs correctly, false otherwise.
   */
  public static boolean testMegaBlockToString() {
    MegaBlock block = new MegaBlock(Color.RED, 'A');//Creates a MegaBlock.
    if (block.toString().equals("RED A")) {
      return true;
    }
    return false;
  }
  
  /**
   * Checks for the correctness of the methods in LinkedMegaBlock class.
   * @return true when the method runs correctly, false otherwise.
   */
  public static boolean testLinkedMegaBlock() {
    //Creates two LinkedMegaBlock using two different constructors.
    LinkedMegaBlock test1 = new LinkedMegaBlock(new MegaBlock(Color.YELLOW, 'C'));
    LinkedMegaBlock test2 = new LinkedMegaBlock(new MegaBlock(Color.BLUE, 'D'), test1);
    if (!test1.getBlock().equals(new MegaBlock(Color.YELLOW, 'G'))) {
      return false;//Tests the getBlock() method.
    }
    if (!test2.getNext().equals(test1)) {
      return false;//Tests the getNext() method.
    }
    if (!test2.toString().equals("BLUE D -> ")) {
      return false;//Tests the toString() method.
    }
    test1.setNext(new LinkedMegaBlock(new MegaBlock(Color.RED, 'E')));
    if (!test1.getNext().toString().equals("RED E -> END")) {
      return false;//Tests the setNext() method.
    }
    return true;
    
  }
  
  /**
   * Checks for the correctness of the LinkedListMegaBlock.addRed() method.
   * @return true when the method runs correctly, false otherwise.
   */
  public static boolean testLinkedMegaBlockListAddRed() {
    LinkedListMegaBlock test = new LinkedListMegaBlock();//Create a LinkedListMegaBlock.
    test.addRed(new MegaBlock(Color.RED, 'A'));
    //Add a red Block with the label A at the head of the linked list.
    if (!test.toString().equals("RED A -> END")) {
      return false;
    }
    test.addRed(new MegaBlock(Color.RED, 'B'));
    //Add a red Block with the label B at the head of the linked list.
    if (!test.toString().equals("RED B -> RED A -> END")) {
      return false;
    }
    try {
      test.addRed(new MegaBlock(Color.YELLOW, 'A'));
      return false;
      //Tests if an IllegalArgumentException is thrown when the color of the MegaBlock is not red.
    } catch (IllegalArgumentException e) {
      e.getMessage();
    }
    try {
      test.addRed(null);
      return false;
      //Tests if an IllegalArgumentException is thrown when the MegaBlock is null.
    } catch (IllegalArgumentException e) {
      e.getMessage();
    }
    return true;
  }

  /**
   * Checks for the correctness of the LinkedListMegaBlock.removeBlue() method
   * @return true when the method runs correctly, false otherwise.
   */
  public static boolean testLinkedListMegaBlockRemoveBlue() {
    LinkedListMegaBlock test = new LinkedListMegaBlock();//Creates a LinkedListMegaBlock.
    try{
      test.removeBlue();//Tests if an NoSuchElementException is thrown when there is no blue block.
      return false;
    } catch (NoSuchElementException e) {
      e.getMessage();
    }
    //Creates two blue MegaBLocks and removes the second one.
    test.addBlue(new MegaBlock(Color.BLUE, 'A'));
    test.addBlue(new MegaBlock(Color.BLUE, 'B'));
    test.removeBlue();
    if (test.getBlueCount() != 1) {
      return false;//Tests if there is only one blue block left.
    }
    if (!test.toString().equals("BLUE A -> END")) {
      return false;//Tests if the first blue block is the tail block.
    }
    return true;
  }
  
  /**
   * Print out the results of each test methods.
   * @param args input arguments
   */
  public static void main(String[] args) {
    System.out.println(testMegaBlockEquals() + " " + testMegaBlockToString() + " " + 
        testLinkedMegaBlock() + " " + testLinkedMegaBlockListAddRed() + " " + 
            testLinkedListMegaBlockRemoveBlue());
  }

}
