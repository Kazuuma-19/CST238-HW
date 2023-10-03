/*
 * Title: Song.java
 * Abstract: This program convert decimal to binary.
 * Author: Kazuma Saito
 * Email: kasaito@csumb.edu
 * Estimate: 30m
 * Date: 10/01/2023
 */
package HW04a;

public class Song {
    private String title;
    private String artist;
    private int year;
    private int length;

    public Song(String title, String artist, int year, int length) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }

    public int getLength() {
        return length;
    }

    public boolean equals(Song song) {
        if (title.equals(song.getTitle()) && artist.equals(song.getArtist()) && length == song.getLength()) {
            return true;
        }
        return false;
    }

    public String toString() {
        int minutes = getLength() / 60;
        int seconds = getLength() % 60;

        StringBuffer sb = new StringBuffer();
        sb.append(getTitle());
        sb.append(" (" + getArtist() + ") ");

        sb.append(minutes + ":");
        if (seconds < 10) {
            sb.append("0");
        }
        sb.append(seconds);

        return sb.toString();
    }
}
