//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: The file contains the BackwardSongIterator class that defines the properties and methods of
//        an iterator that plays a song list backward
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
import java.util.NoSuchElementException;

/**
 * The file contains the ForwardSongIterator class that defines the properties and methods of
 * an iterator that plays a song list forward
 * 
 * @author Pranav Sharma
 * @author Pujan Patel
 */
public class BackwardSongIterator implements java.util.Iterator<Song>{
  private LinkedNode<Song> next; //reference to the next linked node in a list of nodes
  
  /**
   * Constructor that assigns the tail of a linked node list to the next variable
   * 
   * @param first the tail of a linked node list
   */
  public BackwardSongIterator(LinkedNode<Song> last) {
    this.next = last;
  }
  
  /**
   * Checks if the previous node is null
   * 
   * @return true if next is not null, false otherwise
   */
  public boolean hasNext() {
    return next != null;
  }
  
  /**
   * Returns the current song in the iterator and moves to the previous song in the linked list
   * 
   * @returns the current song in the iterator
   * @throws NoSuchElementException with a descriptive message if hasNext is null
   */
  public Song next() {
    if(this.hasNext() == false) {
      throw new NoSuchElementException("there are no more songs to return in the reverse direction");
    }
    Song temp = next.getData();
    next = next.getPrev();
    return temp;
  }
}
