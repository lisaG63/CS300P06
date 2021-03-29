
public class Test {
  
  /**
  * Helper method to display the contents of a list of mega blocks
  * @param list a reference to a LinkedListMegaBlock object
  * @throws NullPointerException if list is null
  */
  private static void display(LinkedListMegaBlock list) {
  // display list content
  System.out.println("list content: " + list);
  // display information about the size of this list and the its blocks’ color counts
  System.out.println("Size: " + list.size() +
  ", redCount: " + list.getRedCount() +
  ", yellowCount: " + list.getYellowCount() +
  ", blueCount: " + list.getBlueCount());
  System.out.println();
  }

  public static void main(String[] args) {
    // Create a new empty LinkedListMegaBlocks list
    LinkedListMegaBlock list = new LinkedListMegaBlock();
    // display list’s content and size information
    display(list);
    // Add some blocks to list and display its contents and size information
    list.addBlue(new MegaBlock(Color.BLUE, 'C')); // add a blue mega block
    display(list);
    list.addBlue(new MegaBlock(Color.BLUE, 'S')); // add a blue mega block
    display(list);
    list.addYellow(0,new MegaBlock(Color.YELLOW, 'Y')); // add a yellow mega block
    // at index 0 of this list
    display(list);
    list.addRed(new MegaBlock(Color.RED, 'A')); // add a red mega block to this list
    display(list);
    list.addRed(new MegaBlock(Color.RED, 'B')); // add a red mega block to this list
    display(list);
    list.addYellow(3, new MegaBlock(Color.YELLOW, 'H')); // add a yellow mega block
    // at index 3 of this list
    display(list);
    // remove/add some blocks and display the list after each operation
    list.removeBlue(); // remove a blue block
    display(list);
    list.removeBlue(); // remove a blue block
    display(list);
    // add a yellow block at the end of list (the list contains zero blue blocks)
    list.addYellow(list.size(), new MegaBlock(Color.YELLOW, 'W'));
    display(list);
    list.removeRed(); // remove a red block
    display(list);
    list.removeYellow(list.size()-1); // remove the yellow block at the end of list
    display(list);
    list.set(0, new MegaBlock(Color.RED, 'E'));
    display(list);
    list.set(2, new MegaBlock(Color.YELLOW, 'R'));
    display(list);
    list.removeRed();
    display(list);
    list.removeYellow(0);
    display(list);
    list.removeYellow(0);
    display(list);
    list.addYellow(0, new MegaBlock(Color.YELLOW, 'Y'));
    list.addBlue(new MegaBlock(Color.BLUE, 'C'));
    list.addRed(new MegaBlock(Color.RED, 'A'));
    display(list);
    list.removeYellow(1);
    display(list);
    list.removeBlue();
    list.removeRed();
    display(list);
    list.addBlue(new MegaBlock(Color.BLUE, 'B'));
    display(list);
    list.removeBlue();
    display(list);
    list.addYellow(0, new MegaBlock(Color.YELLOW, 'B'));
    list.addYellow(1, new MegaBlock(Color.YELLOW, 'D'));
    display(list);
  }

}
