//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: The file contains the Song class that defines the properties of a Song and its given
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
 * 
 * @author Pranav Sharma
 * @author Pujan Patel
 *
 */
public class Song {
  private String songName; // name or title of the song
  private String artist; // artist of the song
  private String duration; // duration of the song

  /**
   * Constructor of song that sets the name, artist, and duration
   * 
   * @param songName Name of the song
   * @param artist   Artist of the song
   * @param duration Duration of the song, must be correctly formatted
   * @throws IllegalArgumentException with a descriptive message if any field is null or blank, also
   *                                  if duration is not properly formatted
   */
  public Song(String songName, String artist, String duration) throws IllegalArgumentException {
    if (songName == null || artist == null || duration == null || songName.isBlank()
        || artist.isBlank() || duration.isBlank()) {
      throw new IllegalArgumentException(
          "either of songName, or artist, or duration is null or is blank");
    }
    try {
      if (Integer.parseInt(duration.substring(0, duration.indexOf(":"))) > 59
          || Integer.parseInt(duration.substring(0, duration.indexOf(":"))) < 0
          || Integer.parseInt(duration.substring(duration.indexOf(":") + 1)) > 59
          || Integer.parseInt(duration.substring(duration.indexOf(":") + 1)) < 0) {
        throw new IllegalArgumentException();
      }
    } catch (Exception e) {
      throw new IllegalArgumentException("The duration string is not properly formatted");
    }
    this.songName = songName;
    this.artist = artist;
    this.duration = duration;
  }

  /**
   * gets the name of the song
   * 
   * @return the name of the song
   */
  public String getSongName() {
    return songName;
  }

  /**
   * gets the artist of the Song
   * 
   * @return the artist of the song
   */
  public String getArtist() {
    return artist;
  }

  /**
   * gets the duration of the song
   * 
   * @return the duration of the song
   */
  public String getDuration() {
    return duration;
  }

  
  @Override
  /**
   * Converts the Song object to a String
   * 
   * @return the string representation of the object
   */
  public String toString() {
    String output = this.songName + "---" + this.artist + "---" + this.duration + "\n";
    return output;
  }

  /**
   * Checks if an object is a Song and it is equivalent to this Song object
   * 
   * @return true if the two objects are equivalent
   */
  public boolean equals(Object other) {
    if (!(other instanceof Song) || other == null) {
      return false;
    }
    Song s = (Song) other;

    if (this.songName.toLowerCase().equals(s.songName.toLowerCase())
        && this.artist.toLowerCase().equals(s.artist.toLowerCase())) {
      return true;
    }
    return false;
  }
}
