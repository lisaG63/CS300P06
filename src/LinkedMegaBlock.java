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


/**
 * This class models and implements a linked list of MegaBlock objects
 * 
 * @author Weihang Guo, Jiaqi Zhang
 *
 */
public class LinkedMegaBlock {
  
  private MegaBlock block; // data field of this linkedMegaBlock
  private LinkedMegaBlock next; // link to the next linkedMegaBlock
  
  /**
   * Creates a new LinkedMegaBlock that has a specific MegaBlock as data and null as next reference
   * @param block data field to be set for this new LinkedMegaBlock
   */
  public LinkedMegaBlock(MegaBlock block) {
    this.block = block;
    next = null;
  }
  
  /**
   * Creates a new LinkedMegaBlock with a specific data block and a specific reference to the next 
   * LinkedMegaBlock
   * @param block data field to be set for this newLinkedMegaBlock
   * @param next reference to the next LinkedMegaBlock of this LinkedMegaBlock
   */
  public LinkedMegaBlock(MegaBlock block, LinkedMegaBlock next) {
    this.block = block;
    this.next = next;
  }
  
  /**
   * Returns the block data field of this LinkedMegaBlock
   * @return the block data field of this LinkedMegaBlock
   */
  public MegaBlock getBlock() {
    return block;
  }
  
  /**
   * Sets the block instance field of this LinkedMegaBlock
   * @param block the block to set
   */
  public void setBlock(MegaBlock block) {
    this.block = block;
  }
  
  /**
   * Returns the reference to the next field of this LinkedMegaBlock
   * @return the next
   */
  public LinkedMegaBlock getNext() {
    return next;
  }
  
  /**
   * Sets the reference to the next field of this LinkedMegaBlock
   * @param next the next to set
   */
  public void setNext(LinkedMegaBlock next) {
    this.next = next;
  }
  
  /**
   * Returns a String representation of this Linked MegaBlock object. 
   * This String will be : block.toString() + " -> ". 
   * If next field is not null block.toString() + " -> END" .
   * @return a String representation of this Linked MegaBlock object
   */
  @Override
  public String toString() {
    if (next != null) {
      return block.toString() + " -> ";
      //When the LinkedMegaBlock has a next block, its color and label should be followed by " -> ". 
    }
    else {
      return block.toString() + " -> END";
      //When the LinkedMegaBlock is the tail, it should be followed by " -> END".
    }
    
  }
  



}
