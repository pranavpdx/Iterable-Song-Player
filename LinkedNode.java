//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: The file contains the LinkedNode class that defines the properties of a LinkedNode and its given
// methods
//
// Author: Pujan Patel, Pranav Sharma
// Email: phpatel4@wisc.edu, pnsharma@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: None used
// Online Sources: None used
//
///////////////////////////////////////////////////////////////////////////////
/**
 * The file contains the LinkedNode class that defines the properties of a LinkedNode and its given
 * methods
 * 
 * @author Pranav Sharma
 * @author Pujan Patel
 *
 * @param <T> The data within the LinkedNode
 */
public class LinkedNode<T> {
  private T data; // data field of this linked node
  private LinkedNode<T> prev; // reference to the previous linked node in a list of nodes
  private LinkedNode<T> next; // reference to the next linked node in a list of nodes

  /**
   * Constructor of a LinkedNode that sets the previous node, the data, and next node
   * 
   * @param prev1 the previous node to be assigned
   * @param data1 the data to be assigned
   * @param next1 the next node to be assigned
   */
  public LinkedNode(LinkedNode<T> prev1, T data1, LinkedNode<T> next1) {
    if(data1 == null) {
      throw new IllegalArgumentException("data is null");
    }
    this.data = data1;
    this.prev = prev1;
    this.next = next1;
  }
  
  /**
   * gets the previous node of the current node
   * 
   * @return the previous node
   */
  public LinkedNode<T> getPrev(){
    return prev;
  }
  
  /**
   * gets the next node of the current node
   * 
   * @return the next node
   */
  public LinkedNode<T> getNext(){
    return next;
  }
  
  /**
   * sets the previous node of the current node
   * 
   * @param prev the previous node
   */
  public void setPrev​(LinkedNode<T> prev) {
    this.prev = prev;
  }
  
  /**
   * sets the next node of the current node
   * 
   * @param next the next node
   */
  public void setNext​(LinkedNode<T> next) {
    this.next = next;
  }
  
  /**
   * gets the data of the node
   * 
   * @return the data of the node
   */
  public T getData() {
    return data;
  }
}
