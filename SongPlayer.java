//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: The file contains the SongPlayer class manages songs in a alist as well as controls the
// order in which they are played
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
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The file contains the SongPlayer class manages songs in a list as well as controls the order in
 * which they are played
 * 
 * @author Pranav Sharma
 * @author Pujan Patel
 */
public class SongPlayer implements Iterable<Song> {
  private int size; // size of the list
  private LinkedNode<Song> head; // head of this doubly linked list
  private LinkedNode<Song> tail; // tail of this doubly linked list
  private boolean playingBackward; // true if this song player is reading the list backward

  /**
   * Adds a Song to the end of a list
   * 
   * @param oneSong The song to be added to the end of the list
   * @throws NullPointerException with a descriptive message if the song is null
   */
  public void addLast​(Song oneSong) throws NullPointerException {
    if (oneSong == null) {
      throw new NullPointerException("passed oneSong is null");
    }
    LinkedNode<Song> newNode = new LinkedNode<Song>(tail, oneSong, null);
    if (tail == null) {
      tail = head = newNode;
    } else {
      tail.setNext​(newNode);
      tail = newNode;
    }
    size++;
  }

  /**
   * Adds a Song to the beginning of a list
   * 
   * @param oneSong The song to be added to the end of the list
   * @throws NullPointerException with a descriptive message if the song is null
   */
  public void addFirst​(Song oneSong) throws NullPointerException {
    if (oneSong == null) {
      throw new NullPointerException("passed oneSong is null");
    }
    LinkedNode<Song> newNode = new LinkedNode<Song>(null, oneSong, head);
    if (head == null) {
      head = tail = newNode;
    } else {
      head.setPrev​(newNode);
      head = newNode;
    }
    size++;
  }

  /**
   * Adds a song at a specific index in the linked list of songs
   * 
   * @param index   The index at which the song must be added
   * @param oneSong The song that is added to the list
   * @throws NullPointerException with a descriptive message if the song is null
   */
  public void add​(int index, Song oneSong) throws NullPointerException {
    if (oneSong == null) {
      throw new NullPointerException("oneSong is null");
    }
    if(index == 0) {
     addFirst​(oneSong);
     return;
    }
    if (index > size - 1) {
      throw new IndexOutOfBoundsException(" index is out of the size() range");
    }

    LinkedNode<Song> temp = head;
    for (int i = 0; i < index - 1; i++) {
      temp = temp.getNext();
    }
    LinkedNode<Song> newNode = new LinkedNode<Song>(temp, oneSong, temp.getNext());
    temp.setNext​(newNode);
    newNode.getNext().setPrev​(newNode);
    size++;
  }

  /**
   * Gets the first song of the list
   * 
   * @return the first song in the list
   * @throws NoSuchElementException with a descriptive message if the list is empty
   */
  public Song getFirst() throws NoSuchElementException {
    if (head == null) {
      throw new NoSuchElementException("list is empty");
    }
    return head.getData();
  }

  /**
   * Gets the last song in the linked list
   * 
   * @return the last song in the linked list
   * @throws NoSuchElementException with a descriptive message if the list is empty
   */
  public Song getLast() throws NoSuchElementException {
    if (tail == null) {
      throw new NoSuchElementException("list is empty");
    }
    return tail.getData();
  }

  /**
   * Gets a Song at a specific index in the list
   * 
   * @param index at which the song is being retrieved
   * @return the Song at the specified index
   * @throws IndexOutOfBoundsException with a descriptive message if index is out of bound
   */
  public Song get​(int index) throws IndexOutOfBoundsException {
    if (index > size() - 1) {
      throw new IndexOutOfBoundsException("index is out of the 0 ... size()-1 range");
    }
    LinkedNode<Song> temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.getNext();
    }
    return temp.getData();
  }

  /**
   * Removes the first song of the list
   * 
   * @return the first song of the list
   */
  public Song removeFirst() throws NoSuchElementException {
    if (head == null) {
      throw new NoSuchElementException("List is empty");
    }
    Song temp = head.getData();
    if (head.getNext() != null) {
      head = head.getNext();
      head.setPrev​(null);
      size--;
    } else {
      clear();
    }
    return temp;
  }

  /**
   * Removes the last element of the list
   * 
   * @return the last element of the list
   */
  public Song removeLast() throws NoSuchElementException {
    if (tail == null) {
      throw new NoSuchElementException("List is empty");
    }
    Song temp = tail.getData();
    if (tail.getPrev() != null) {
      tail = tail.getPrev();
      tail.setNext​(null);
      size--;
    } else {
      clear();
    }
    return temp;
  }

  /**
   * Removes a Song at a specific index
   * 
   * @param index the index at which the song is being removed
   * @return the Song that is being removed
   * @throws IndexOutOfBoundsException with a descriptive message if index is out of bounds
   */
  public Song remove​(int index) throws IndexOutOfBoundsException {
    if (index > size - 1 || index < 0) {

      throw new IndexOutOfBoundsException("index is out of the 0 .. size()-1 range");
    }
    if(index == 0) {
      return removeFirst();
    }
    if (head == null) {
      return null;
    }

    LinkedNode<Song> temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.getNext();
    }
    Song tempSong = temp.getData();
    temp.getPrev().setNext​(temp.getNext());
    if (temp.getNext() != null)
      temp.getNext().setPrev​(temp.getPrev());
    size--;
    return tempSong;
  }

  /**
   * Checks if the list contains a Song
   * 
   * @param o The song that the list is being searched
   * @return true if the list contains the song, otherwise return false
   */
  public boolean contains​(Song o) {
    if (head == null) {
      return false;
    }
    LinkedNode<Song> temp = head;
    while (temp != null) {
      if (temp.getData().equals(o)) {
        return true;
      }
      temp = temp.getNext();
    }
    return false;
  }

  /**
   * Clears the list
   */
  public void clear() {
    head = null;
    tail = null;
    size = 0;
  }

  /**
   * Checks if the list is empty
   * 
   * @return true if the list is empty, false otherwise
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * returns the size of the linked list
   * 
   * @return the size of the linked list
   */
  public int size() {
    return size;
  }

  /**
   * Overridden method that returns an iterator either moving forward or backward depending on the
   * playingBackward field
   * 
   * @return an iterator moving forward or backward in the linked list
   */
  @Override
  public Iterator<Song> iterator() {
    if (playingBackward == false) {
      ForwardSongIterator iterator = new ForwardSongIterator(head);
      return iterator;
    } else {
      BackwardSongIterator iterator = new BackwardSongIterator(tail);
      return iterator;
    }
  }

  /**
   * Switches the value of playingBackward
   */
  public void switchPlayingDirection() {
    playingBackward = !playingBackward;
  }

  /**
   * Begins playing through all songs depending on the direction of the iterator gathered form
   * iterator()
   * 
   * @return A String representation of all songs in the list separated with a new line
   */
  public String play() {
    String output = "";
    for (Song s : this) {
      output += s.toString();
    }
    return output;
  }
}
