//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: This class implements unit test methods to check the correctness of Song, LinkedNode,
//////////////// SongPlayer
// ForwardSongIterator and BackwardSongIterator classes in P07 Iterable Song Player assignment.
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
 * This class implements unit test methods to check the correctness of Song, LinkedNode, SongPlayer
 * ForwardSongIterator and BackwardSongIterator classes in P07 Iterable Song Player assignment.
 *
 * @author Pranav Sharma
 * @author Pujan Patel
 */
public class SongPlayerTester {
  /**
   * This method test and make use of the Song constructor, an accessor (getter) method, overridden
   * method toString() and equal() method defined in the Song class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSong() {
    // tests constructor
    Song correct = new Song("Happy", "Pharell", "3:29");
    // 2. Test getSongName
    if (!correct.getSongName().equals("Happy")) {
      System.out.println("ERROR: getSongName() does not provide expected result");
      return false;
    }

    // Test getArtist
    if (!correct.getArtist().equals("Pharell")) {
      System.out.println("ERROR: getArtist() does not provide expected result");
      return false;
    }

    // Test getDuration
    if (!correct.getDuration().equals("3:29")) {
      System.out.println("ERROR: getDuration() does not provide expected result");
      return false;
    }
    try {
      Song wrongDuration = new Song("Reminder", "Weeknd", "69:04");
      System.out.println("ERROR: getDuration() does not provide expected error");
      return false;
    } catch (IllegalArgumentException expected) {
    } catch (Exception e) {
      System.out.println("ERROR: getDuration() does not provide expected error");
    }

    // Test toString
    if (!correct.toString().equals("Happy---Pharell---3:29\n")) {
      System.out.println("ERROR: toString() does not provide expected result");
      return false;
    }

    // Test equals

    Song expected = new Song("Happy", "Pharell", "3:29");
    if (!correct.equals(expected)) {
      System.out.println("ERROR: equals() does not correctly compare songs\n");
      return false;
    }
    return true;
  }

  /**
   * This method test and make use of the LinkedNode constructor, an accessor (getter) method, and a
   * mutator (setter) method defined in the LinkedCart class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLinkedNode() {
    LinkedNode<String> n1 = new LinkedNode<>(null, "FirstNode", null);
    LinkedNode<String> n2 = new LinkedNode<>(n1, "SecondNode", null);
    LinkedNode<String> n3 = new LinkedNode<>(n2, "ThirdNode", null);
    n1.setNext​(n2);
    n2.setNext​(n3);

    // Test getPrev();
    if (!n2.getPrev().equals(n1)) {
      System.out.println("ERROR: getPrev() does not provide correct output");
      return false;
    }

    // Test getNext()
    if (!n2.getNext().equals(n3)) {
      System.out.println("ERROR: getNext() does not provide correct output");
      return false;
    }

    // Test setPrev​()
    n2.setPrev​(n3);
    if (!n2.getPrev().equals(n3)) {
      System.out.println("ERROR: setPrev() does not correctly modify node");
      return false;
    }

    // Test setNext()
    n2.setNext​(n1);
    if (!n2.getNext().equals(n1)) {
      System.out.println("ERROR: setNext() does not correctly modify node");
      return false;
    }

    // Test getData()
    if (!n2.getData().equals("SecondNode")) {
      System.out.println("ERROR: getData() does not correctly access node");
      return false;
    }
    return true;
  }

  /**
   * This method checks for the correctness of addFirst(), addLast() and add(int index) method in
   * SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerAdd() {
    SongPlayer songList = new SongPlayer();
    songList.addFirst​(new Song("Mojito", "Jay Chou", "3:05"));
    songList.addLast​(new Song("Secret", "Jay Chou", "3:05"));
    songList.addFirst​(new Song("Clear Day", "Jay Chou", "4:59"));
    songList.addFirst​(new Song("Save Your Tears", "The Weeknd", "3:35"));
    songList.add​(1, new Song("Oh My God", "Adele", "3:45"));

    String expectedOutput =
        "Save Your Tears---The Weeknd---3:35\nOh My God---Adele---3:45\nClear Day---Jay Chou---4:59"
            + "\nMojito---Jay Chou---3:05\nSecret---Jay Chou---3:05\n";

    // testing add methods
    if (!(songList.play().equals(expectedOutput))) {
      System.out.println("ERROR: add()/addFirst()/addLast() does not correctly add node");
      return false;
    }
    // testing add methods exceptions

    try {
      songList.addFirst​(null);
      System.out.println("ERROR: addFirst() does not throw correct exception");
      return false;
    } catch (NullPointerException e) {
    } catch (Exception e) {
      System.out.println("ERROR: addFirst() does not throw correct exception");
      return false;
    }

    try {
      songList.addLast​(null);
      System.out.println("ERROR: addLast() does not throw correct exception");
      return false;
    } catch (NullPointerException e) {
    } catch (Exception e) {
      System.out.println("ERROR: addLast() does not throw correct exception");
      return false;
    }

    try {
      songList.add​(1, null);
      System.out.println("ERROR: add() does not throw correct exception with null");
      return false;
    } catch (NullPointerException e) {
    } catch (Exception e) {
      System.out.println("ERROR: add() does not throw correct exception with null");
      return false;
    }

    try {
      songList.add​(20, new Song("NC-17", "Travis Scott", "3:29"));
      System.out.println("ERROR: add() does not throw correct exception");
      return false;
    } catch (IndexOutOfBoundsException e) {
    } catch (Exception e) {
      System.out.println("ERROR: add() does not throw correct exception");
      return false;
    }

    return true;
  }

  /**
   * This method checks for the correctness of getFirst(), getLast() and get(int index) method in
   * SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerGet() {
    SongPlayer songList = new SongPlayer();
    songList.addFirst​(new Song("Mojito", "Jay Chou", "3:05"));
    songList.addLast​(new Song("Secret", "Jay Chou", "3:05"));
    songList.addFirst​(new Song("Clear Day", "Jay Chou", "4:59"));
    songList.addFirst​(new Song("Save Your Tears", "The Weeknd", "3:35"));
    songList.add​(1, new Song("Oh My God", "Adele", "3:45"));


    // Test getFirst()
    String expectedOuput = "Save Your Tears---The Weeknd---3:35\n";
    if (!(songList.getFirst().toString().equals(expectedOuput))) {
      System.out.println("ERROR: getFirst() does not correctly get Node");
      return false;
    }


    // Test getLast()
    String expectedOuput1 = "Secret---Jay Chou---3:05\n";
    if (!(songList.getLast().toString().equals(expectedOuput1))) {
      System.out.println("ERROR: getLast() does not correctly get Node");
      return false;
    }

    // Test get()
    String expectedOuput2 = "Clear Day---Jay Chou---4:59\n";
    if (!(songList.get​(2).toString().equals(expectedOuput2))) {
      System.out.println("ERROR: get() does not correctly get node");
      return false;
    }


    // Testing the get methods exceptions
    SongPlayer exceptionList = new SongPlayer();

    try {
      exceptionList.getFirst();
      System.out.println("ERROR: getFirst() does not throw correct exception with null");
      return false;
    } catch (NoSuchElementException e) {
    } catch (Exception e) {
      System.out.println("ERROR: getLast() does not throw correct exception with null");
      return false;
    }

    try {
      exceptionList.getLast();
      System.out.println("ERROR: getLast() does not throw correct exception with null");
      return false;
    } catch (NoSuchElementException e) {
    } catch (Exception e) {
      System.out.println("ERROR: getLast() does not throw correct exception with null");
      return false;
    }

    try {
      exceptionList.get​(1);
      System.out.println("ERROR: get() does not throw correct exception with null");
      return false;
    } catch (IndexOutOfBoundsException e) {
    } catch (Exception e) {
      System.out.println("ERROR: get() does not throw correct exception with null");
      return false;
    }

    return true;
  }

  /**
   * This method checks for the correctness of removeFirst(), removeLast() and remove(int index)
   * method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerRemove() {
    SongPlayer songList = new SongPlayer();
    songList.addFirst​(new Song("Mojito", "Jay Chou", "3:05"));
    songList.addLast​(new Song("Secret", "Jay Chou", "3:05"));
    songList.addFirst​(new Song("Clear Day", "Jay Chou", "4:59"));
    songList.addFirst​(new Song("Save Your Tears", "The Weeknd", "3:35"));
    songList.add​(1, new Song("Oh My God", "Adele", "3:45"));


    songList.removeFirst();
    songList.removeLast();
    songList.remove​(2);


    String expectedOutput = "Oh My God---Adele---3:45\n" + "Clear Day---Jay Chou---4:59\n";


    // testing remove methods

    if (!(songList.play().equals(expectedOutput))) {
      System.out
          .println("ERROR: remove()/removeFirst()/removeLast() does not correctly remove nodes");
      return false;
    }


    // testing remove methods exceptions

    SongPlayer exceptionList = new SongPlayer();
    try {
      exceptionList.removeFirst();
      System.out.println("ERROR: removeFirst() does not throw correct exception");
      return false;
    } catch (NoSuchElementException e) {
    } catch (Exception e) {
      System.out.println("ERROR: removeFirst() does not throw correct exception");
      return false;
    }

    try {
      exceptionList.removeLast();
      System.out.println("ERROR: removeLast() does not throw correct exception");
      return false;
    } catch (NoSuchElementException e) {
    } catch (Exception e) {
      System.out.println("ERROR: removeLast() does not throw correct exception");
      return false;
    }

    try {
      exceptionList.remove​(10);
      System.out.println(exceptionList.size());
      System.out
          .println("ERROR: remove() does not throw correct exception for index being out list");
      return false;
    } catch (IndexOutOfBoundsException e) {
    } catch (Exception e) {
      System.out
          .println("ERROR: remove() does not throw correct exception for index being out list");
      return false;
    }

    return true;
  }

  /**
   * This method checks for the correctness of iterator(), switchPlayingDirection() and String
   * play() method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerIterator() {
    SongPlayer s = new SongPlayer();
    Song s1 = new Song("Out of Time", "The Weekend", "3:34");
    Song s2 = new Song("Happy", "Pharrel", "4:13");
    Song s3 = new Song("Pursuit of Happiness", "Kid Cuddi", "2:19");
    s.addFirst​(s1);
    s.addLast​(s2);
    s.addLast​(s3);

    Iterator<Song> it = s.iterator();
    if (!it.next().equals(s1) || !it.next().equals(s2) || !it.next().equals(s3)) {
      System.out.println("ERROR: iterator() method does not return a working iterator");
      return false;
    }

    s.switchPlayingDirection();
    Iterator backwardIt = s.iterator();
    if (!backwardIt.next().equals(s3) || !backwardIt.next().equals(s2)
        || !backwardIt.next().equals(s1)) {
      System.out.println(
          "ERROR: switchPlayingDirection() does not correctly switch the direction of the iterator"
              + "");
      return false;
    }

    s.switchPlayingDirection();
    Iterator<Song> it2 = s.iterator();
    String output = s.play();
    String expectedOutput =
        "Out of Time---The Weekend---3:34\nHappy---Pharrel---4:13\nPursuit of Happiness---Kid Cuddi---2:19\n";
    if (!output.equals(expectedOutput)) {
      System.out.println("ERROR: Play() does not properly print out the songs");
      return false;
    }

    return true;

  }

  /**
   * This method checks for the correctness of contains(Object song), clear(), isEmpty()and size()
   * method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerCommonMethod() {
    SongPlayer s = new SongPlayer();
    Song s1 = new Song("Out of Time", "The Weekend", "3:34");
    Song s2 = new Song("Happy", "Pharrel", "4:13");
    Song s3 = new Song("Pursuit of Happiness", "Kid Cuddi", "2:19");
    s.addFirst​(s1);
    s.addLast​(s2);
    s.addLast​(s3);

    if (!s.contains​(s3) || !s.contains​(s2) || !s.contains​(s1) || s.size() != 3) {
      System.out.println("ERROR: contains() or size() method does not return the correct results");
      return false;
    }

    s.clear();
    if (!s.isEmpty() || s.size() != 0) {
      System.out.println("ERROR: isEmpty() or size() method does not return the correct results");
      return false;
    }

    return true;
  }

  /**
   * This method checks for the correctness of ForwardSongIterator class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testForwardSongIterator() {
    LinkedNode<Song> n1 = new LinkedNode<>(null, new Song("Song1", "Artist1", "1:01"), null);
    LinkedNode<Song> n2 = new LinkedNode<>(n1, new Song("Song2", "Artist2", "2:02"), null);
    LinkedNode<Song> n3 = new LinkedNode<>(n2, new Song("Song3", "Artist3", "3:03"), null);
    n1.setNext​(n2);
    n2.setNext​(n3);
    // TODO: Test Constructor
    ForwardSongIterator i = new ForwardSongIterator(n1);

    // Test hasNext()
    if (!i.hasNext() == true) {
      System.out.println("ERROR: hasNext() does not provide correct output");
      return false;
    }

    // Test next() for head
    if (!i.next().toString().equals("Song1---Artist1---1:01\n")) {
      System.out.println("ERROR: next() does not provide correct output for head");
      return false;
    }

    // Test next() for !head
    if (!i.next().toString().equals("Song2---Artist2---2:02\n")) {
      System.out.println("ERROR: next() does not provide correct output for !head");
      return false;
    }

    // TODO: Test that correct exceptions are caught
    try {
      i.next();
      i.next();
      System.out.println(
          "ERROR: next() did not throw an exception after the list has been iterated through");
      return false;
    } catch (NoSuchElementException e) {

    } catch (Exception e) {
      System.out.println(
          "ERROR: next() did not throw the right exception after the list has been iterated through"
          + "");
      return false;
    }
    return true;
  }

  /**
   * This method checks for the correctness of BackwardSongIterator class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBackwardSongIterator() {
    LinkedNode<Song> n1 = new LinkedNode<>(null, new Song("Song1", "Artist1", "1:01"), null);
    LinkedNode<Song> n2 = new LinkedNode<>(n1, new Song("Song2", "Artist2", "2:02"), null);
    LinkedNode<Song> n3 = new LinkedNode<>(n2, new Song("Song3", "Artist3", "3:03"), null);
    n1.setNext​(n2);
    n2.setNext​(n3);
    // TODO: Test Constructor
    BackwardSongIterator i = new BackwardSongIterator(n3);

    // Test hasNext()
    if (!i.hasNext() == true) {
      System.out.println("ERROR: hasNext() does not provide correct output");
      return false;
    }

    // Test next() for head
    if (!i.next().toString().equals("Song3---Artist3---3:03\n")) {
      System.out.println("ERROR: next() does not provide correct output for tail");
      return false;
    }

    // Test next() for !head
    if (!i.next().toString().equals("Song2---Artist2---2:02\n")) {
      System.out.println("ERROR: next() does not provide correct output for !tail");
      return false;
    }

    try {
      i.next();
      i.next();
      System.out.println(
          "ERROR: next() did not throw an exception after the list has been iterated through");
      return false;
    } catch (NoSuchElementException e) {

    } catch (Exception e) {
      System.out.println(
          "ERROR: next() did not throw the right exception after the list has been iterated through"
          + "");
      return false;
    }
    return true;
  }

  /**
   * This method calls all the test methods defined and implemented in your SongPlayerTester class.
   * 
   * @return true if all the test methods defined in this class pass, and false otherwise.
   */
  public static boolean runAllTests() {
    if (testSong() && testLinkedNode() && testForwardSongIterator() && testBackwardSongIterator()
        && testSongPlayerGet() && testSongPlayerRemove() && testSongPlayerAdd() && 
        testSongPlayerCommonMethod() && testSongPlayerIterator()) {
      return true;
    }
    return false;
  }

  /**
   * Driver method defined in this SongPlayerTester class
   * 
   * @param args input arguments if any.
   */
  public static void main(String[] args) {
    System.out.println(runAllTests());

    /*
     * System.out.println("Run All Tests: " + runAllTests()); SongPlayer songList = new
     * SongPlayer(); songList.addFirst​(new Song("Mojito", "Jay Chou", "3:05"));
     * songList.addFirst​(new Song("Secret", "Jay Chou", "4:56")); songList.addFirst​(new
     * Song("Clear Day", "Jay Chou", "4:59")); songList.addFirst​(new Song("Dragon Fist",
     * "Jay Chou", "4:32")); songList.addFirst​(new Song("Out of Time", "The Weeknd", "3:34"));
     * songList.addLast​(new Song("StarBoy", "The Weeknd", "3:50")); songList.addLast​(new
     * Song("Save Your Tears", "The Weeknd", "3:35")); songList.add​(1, new Song("Simple Love",
     * "Jay Chou", "4:30")); songList.add​(2, new Song("Superman Can’t Fly", "Jay Chou", "4:59"));
     * songList.addLast​(new Song("Oh My God", "Adele", "3:45")); songList.addLast​(new
     * Song("Levitating", "Dua Lipa", "3:23")); songList.add​(6, new Song("Be Kind",
     * "Marshmello & Halsey", "2:53"));
     * System.out.println("---------------- Play Forward -----------------");
     * System.out.println(songList.play());
     * System.out.println("------------------------------------------------");
     * 
     * 
     * System.out.println("songList.remove(6) -- Be Kind -- removed\n" +
     * "songList.removeFirst(); -- Out of Time -- removed\n" +
     * "songList.removeLast(); -- Levitating -- removed\n"); songList.remove​(6);
     * songList.removeFirst(); songList.removeLast();
     * System.out.println("---------------- Play Forward -----------------");
     * System.out.println(songList.play());
     * System.out.println("------------------------------------------------");
     * 
     * Song oneSong = new Song("Mojito", "Jay Chou", "3:05");
     * System.out.println(songList.contains​(oneSong)); System.out.println();
     * System.out.println("songList.size(): " + songList.size()); System.out.println(); oneSong =
     * new Song("Be Kind", "Marshmello & Halsey", "2:53");
     * System.out.println(songList.contains​(oneSong)); System.out.println();
     * System.out.println("---------------- Play Forward -----------------");
     * System.out.println(songList.play()); System.out.println();
     * System.out.println("---------------- Play Backward -----------------");
     * songList.switchPlayingDirection(); System.out.println(songList.play());
     * System.out.println("------------------------------------------------");
     */
  }
}
