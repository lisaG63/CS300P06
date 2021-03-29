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
 * This class models and implements a linked list of MegaBlock objects.
 * 
 * @author Weihang Guo, Jiaqi Zhang
 *
 */
public class LinkedListMegaBlock {
  
  private LinkedMegaBlock head; // head of this list
  private LinkedMegaBlock tail; // tail of this list
  private int size; // size of this list (total number of megablocks stored in this list)
  private int redCount; // number of RED megablocks stored in this list
  private int yellowCount; // number of YELLOW megablocks stored in this list
  private int blueCount; // number of BLUE megablocks stored in this list
  
  /**
   * Creates an empty linked list of mega blocks
   */
  public LinkedListMegaBlock() {
    //initializes all the fields
    head = null;
    tail = null;
    size = 0;
    redCount = 0;
    yellowCount = 0;
    blueCount = 0;
  }
  
  /**
   * Returns true if this list contains no elements.
   * @return true if this list is empty, and false otherwise.
   */
  public boolean isEmpty() {
    if(size == 0) {
      return true;
    }
    return false;
  }
  
  /**
   * Returns the size of this list.
   * @return the number of megablocks stored in this list
   */
  public int size() {
    return size;
  }
  
  /**
   * Removes all of the elements from this list. The list will be empty after this call returns.
   */
  public void clear() {
    //assigns the default values to all the fields so that all the blocks will be garbage collected.
    head = null;
    tail = null;
    size = 0;
    redCount = 0;
    yellowCount = 0;
    blueCount = 0;
  }
  
  /**
   * Adds a blueBlock at the end of this list
   * @param blueBlock new element to be added to this list
   * @throws IllegalArgumentException if blueBlock is null or if the color of the 
   * specific blueBlock is not equal to Color.BLUE
   */
  public void addBlue(MegaBlock blueBlock) {
    if(blueBlock == null || !blueBlock.getColor().equals(Color.BLUE)) {
      throw new IllegalArgumentException();
      //When the input MegaBlock is null or the color of the block is not blue, throw 
      //an IllegalArgumentException.
    }
    LinkedMegaBlock newBlock = new LinkedMegaBlock(blueBlock);
    //Creates a LinkedMegaBlock which takes the blueBlock as its value.
    //When the list is empty, the new blue block will be the only block in the list.
    if(isEmpty()) {
      head = newBlock;
      tail = newBlock;
      //if the list is empty, the blueBlock would be both head and tail of the list
      size ++;
      blueCount ++;
      //updates the size and blueCount
      return;
    }
    //When the list is not empty, the blueBlock will be added at the end of this list.
    getLinkedMegaBlock(size() - 1).setNext(newBlock);
    //set the previous block's next block to the blue block.
    tail = newBlock;//assign the blue block to tail
    //updates the size and blueCount
    size ++;
    blueCount ++;
    
  }
  
  /**
   * Adds a redBlock at the head of this list
   * @param redBlock new element to be added to this list
   * @throws IllegalArgumentException if redBlock is null or if the color of the 
   * specific redBlock is not equal to Color.RED
   */
  public void addRed(MegaBlock redBlock) {
    if(redBlock == null || !redBlock.getColor().equals(Color.RED)) {
      throw new IllegalArgumentException();
      //When the input redBlock is null or the color of the redBlock is not red, 
      //throw an IllegalArgumentException.
    }
    //Creates a LinkedMegaBlock which takes the redBlock as its value.
    LinkedMegaBlock newBlock = new LinkedMegaBlock(redBlock);
    //When the list is empty, the new red block will be the only block in the list.
    if(isEmpty()) {
      head = newBlock;
      tail = newBlock;
      //if the list is empty, the redBlock would be both head and tail of the list
      size ++;
      redCount ++;
      //updates the size and redCount
      return;
    }
    //When the list is not empty, the redBlock will be added at the head of this list.
    newBlock.setNext(head);//the new block's next block will be the head
    head = newBlock;//set head to the new block
    //updates the size and redCount
    size ++;
    redCount ++;
  }

  /**
   * Adds the provided yellowBlock at the position index in this list
   * @param yellowBlock new element to be added to this list
   * @param index index at which the specified yellow block is to be inserted
   * @throws IllegalArgumentException if yellowBlock is null or if the color of the 
   * specific yellowBlock is not equal to Color.YELLOW
   * @throws IndexOutOfBoundsException if the index is out of the range reserved for yellow 
   * blocks (index < redCount || index > size - blueCount)
   */
  public void addYellow(int index, MegaBlock yellowBlock) {
    if(yellowBlock == null || !yellowBlock.getColor().equals(Color.YELLOW)) {
      throw new IllegalArgumentException();
      //When the input yellowBlock is null or the color of the yellowBlock is not yellow, 
      //throw an IllegalArgumentException.
    }
    if(index < redCount || index > size - blueCount) {
      throw new IndexOutOfBoundsException();
      //when the yellow block is not added between the red blocks and blue blocks, 
      //throw and IndexOutOfBoundsException.
    }

    LinkedMegaBlock newBlock = new LinkedMegaBlock(yellowBlock);
    //Creates a LinkedMegaBlock which takes in the yellowBlock as its value.
    if(isEmpty()) {
      head = newBlock;
      tail = newBlock;
      //if the list is empty, the yellowBlock would be both head and tail of the list
      size ++;
      yellowCount ++;
      //updates the size and yellowCount
    } else if (index == 0) {
      //When there is no red block and the yellowBlock is added at the head of the list, 
      //it should be the head.
      newBlock.setNext(head);//points the next block of the new block to head.
      head = newBlock;//sets head to the new block
      //updates size and yellowCount
      size ++;
      yellowCount ++;
    } else if (index == size()) {
      //When there is no blue block and the yellowBlock is added at the end of the list, 
      //it should be the tail
      getLinkedMegaBlock(size() - 1).setNext(newBlock);
      //sets the previous block's next block to the new block
      tail = newBlock;//sets tail to the new block
      //updates size and yellowCount
      size ++;
      yellowCount ++;
    } else {
      //When there are at least one red block and one blue block, the yellow block will be added
      //between them.
      newBlock.setNext(getLinkedMegaBlock(index));
      //sets the next block of the new yellow block to the block at the given index.
      getLinkedMegaBlock(index - 1).setNext(newBlock);
      //sets the previous block's next block to the new yellow block
      //updates the size and yellowCount
      size ++;
      yellowCount ++;
    }
  }
  
  /**
   * Returns the element stored at position index of this list without removing it.
   * @param index position within this list
   * @return the megablock object stored at position index of this list
   * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
   */
  public MegaBlock get(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException();
      //when there is no block existing at the given index, throw IndexOutOfBoundsException
    }
    LinkedMegaBlock curBlock = head;
    //uses the curBlock to run through the whole list starting from the head
    for(int i = 0; i < index; i ++) {
      curBlock = curBlock.getNext();
      //when the current block has a next block, assign the next block to the current block
    }
    return curBlock.getBlock();
    
  }
  
  
  /**
   * Replaces the megablock at the specified position in this list with the specified element if 
   * they have the same Color
   * @param index index of the block to replace
   * @param block element to be stored at the specified position
   * @return the element previously at the specified position
   * @throws IllegalArgumentException if object is null or is not equal to the megablock already 
   * at at index position
   * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
   */
  public MegaBlock set(int index, MegaBlock block) {
    if (!get(index).equals(block)) {
      throw new IllegalArgumentException();
      //when the new block and the block already at the index position have different colors,
      //throw IllegalArgumentException
    }
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException();
      //when no block is at the given index position, throw IndexOutOfBoundsException
    }
    get(index).setLabel(block.getLabel());
    //since the color of the two blocks is the same, only the label of the old block will be 
    //changed to the label of the new block
    return get(index);
  }
  

  /**
   * Removes and returns the mega block at the head of this list if its color is red
   * @return a reference to the removed element
   * @throws NoSuchElementException if this list does not contain any red mega block
   */
  public MegaBlock removeRed() {
    if (redCount == 0) {
      throw new NoSuchElementException();
      //when there is no red block, throw NoSuchElementException
    }

    LinkedMegaBlock curBlock = head;//store the red block to be removed in curBlock
    head = head.getNext();//set head to the block after the head
    //updates redCount and size
    redCount --;
    if (size() == 1) {
    //when there is only one red block, remove it by setting the tail to null
      tail = null;
    }
    size --;
    return curBlock.getBlock();
  }
  
  /**
   * Removes and returns the element at the tail of this list if it has a blue color
   * @return a reference to the removed element
   * @throws NoSuchElementException if this list does not contain any blue block
   */
  public MegaBlock removeBlue() {
    if (blueCount == 0) {
      throw new NoSuchElementException();
      //When there is no blue block, throw NoSuchElementException
    }
    
    LinkedMegaBlock curBlock = tail;//store the blue block to be removed in curBlock
    if (size() == 1) {
      //when there is only one blue block, remove it by setting both head and tail to null
      head = null;
      tail = null;
    } else {
    getLinkedMegaBlock(size() - 2).setNext(null);//set the previous block's next block to null
    tail = getLinkedMegaBlock(size() - 2);//set tail to the previous block
    //updates blueCount and size
    }
    blueCount --;
    size --;
    return curBlock.getBlock();
  }
  
  /**
   * Removes and returns the element stored at index position in this list.
   * @param index position of the element to remove in this list
   * @return a reference to the removed element
   * @throws IndexOutOfBoundsException if the index is out of range 
   * (index < redCount or index >= size - blueCount)
   */
  public MegaBlock removeYellow(int index) {
    if (index < redCount || index >= size - blueCount) {
      throw new IndexOutOfBoundsException();
      //when the index is not between the red and blue blocks, throw IndexOutOfBoundsException
    }

    MegaBlock curBlock = get(index);//store the yellow block to be removed in curBlock
    if (size() == 1) {
      //when there is only one yellow block, remove the only yellow block by setting both head and 
      //tail to null
      head = null;
      tail = null;      
    } else if (index == size() - 1) {
      //When there is no blue block, and the last yellow block is to be removed, the previous block
      //will be the nail of the list.
      getLinkedMegaBlock(index - 1).setNext(null);
      //set the next block of the block before the yellow block to null
      tail = getLinkedMegaBlock(index - 1);
      //set tail to the block before the yellow block
      //updates the yellowCount and size
      yellowCount --;
      size --;
      return curBlock;
    } else if (index == 0) {
      //When there is no red block and the first yellow block is to be removed, the block after the
      //yellow block will be the head of the list.
      head = getLinkedMegaBlock(index + 1); //set the head to the block after the yellow block
      //updates the yellowCount and size
      yellowCount --;
      size --;
      return curBlock;
    }
    //when there is at least one red block and one blue block, a yellow block in between is to be 
    //removed, the block comes before and after it would be linked together.
    //updates the yellowCount and size
    yellowCount --;
    size --;
    return curBlock;
    
    
  }
  

  
  /**
   * Returns the LinkedMegaBlock at position index of this list without removing it.
   * @param index position within this list
   * @return the LinkedMegaBlock object stored at position index of this list
   * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
   */
  private LinkedMegaBlock getLinkedMegaBlock(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException();
      //when there is no block existing at the given index, throw IndexOutOfBoundsException
    }
    LinkedMegaBlock curBlock = head;
    //uses the curBlock to run through the whole list starting from the head
    for(int i = 0; i < index; i ++) {
      curBlock = curBlock.getNext();
      //when the current block has a next block, assign the next block to the current block
    }
    return curBlock;
  }
  
  /**
   * Returns the number of red mega bloks stored in this list
   * @return the redCount
   */
  public int getRedCount() {
    return redCount;
  }

  /**
   * Returns the number of blue mega bloks stored in this list
   * @return the blueCount
   */
  public int getBlueCount() {
    return blueCount;
  }
  
  /**
   * Returns the number of yellow mega bloks stored in this list
   * @return the yellowCount
   */
  public int getYellowCount() {
    return yellowCount;
  }
  
  /**
   * Returns a String representation of the contents of this list
   * @return a String representation of the content of this list. If this list is empty, an empty 
   * String ("") will be returned
   */
  @Override
  public String toString(){
    if (size == 0) {
      return "";//If this list is empty, an empty String ("") will be returned
    }
    String list = "";
    LinkedMegaBlock curBlock = head;
    while(curBlock != null) {//traverse through the whole list
      list = list + curBlock.toString();
      //add the string represented by each LinkedMegaBlock to the String list
      curBlock = curBlock.getNext();
    }
    return list;
  }
  

  

}
