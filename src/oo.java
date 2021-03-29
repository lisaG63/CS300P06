import java.util.Iterator;
import java.util.Stack;

public class oo {
  
  public static void main(String[] args){
    Stack<Integer> stack = new Stack(); // creates an empty stack
    stack.push(1);
    stack.push(2);
    stack.push(3); 
    Iterator<Integer> iterator = stack.iterator(); // returns an iterator over the stack starting from its top.
    System.out.print(iterator.next());
  }

}
