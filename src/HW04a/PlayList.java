/*
 * Title: PlayList.java
 * Abstract: This program convert decimal to binary.
 * Author: Kazuma Saito
 * Email: kasaito@csumb.edu
 * Estimate: 30m
 * Date: 10/01/2023
 */
package HW04a;

public class PlayList {
    private Song[] songs;
    private int size;
    public static final int DEFAULT_CAPACITY = 10;

    public PlayList() {
        this.songs = new Song[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void add(Song s) {
        if (size == songs.length - 1) {
            resize();
        }
        songs[size++] = s;
    }

    public void print() {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < size; i++) {
            int minutes = songs[i].getLength() / 60;
            int seconds = songs[i].getLength() % 60;

            sb.append((i + 1) + ". ");
            sb.append(songs[i].getTitle());
            sb.append(" (" + songs[i].getArtist() + ") ");
            sb.append(minutes + ":");
            if (seconds < 10) {
                sb.append("0");
            }
            sb.append(seconds);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public void resize() {
        Song[] newSongs = new Song[songs.length + 1];
        for (int i = 0; i < songs.length; i++) {
            newSongs[i] = songs[i];
        }
        songs = newSongs;
    }

    public void move(int startingPosition, int endingPosition) {
        int startingIndex = startingPosition - 1;
        int endingIndex = endingPosition - 1;
        Song moveSong = songs[startingIndex];

        // remove
        for (int i = startingIndex; i < size; i++) {
            songs[i] = songs[i + 1];
        }
        size--;
        System.out.println(songs.length);
        // insert
        for (int i = size; i > endingIndex; i--) {
            songs[i] = songs[i - 1];
        }
        songs[endingIndex] = moveSong;
        size++;
    }

    private int linearSearch(int year) {
        System.out.println("Running Linear Search");
        for (int i = 0; i < size; i++) {
            if (songs[i].getYear() == year) {
                return i;
            }
        }
        return -1;
    }

    private int binarySearch(int year) {
        System.out.println("Running Binary Search");
        int first = 0;
        int last = size - 1;

        while (first <= last) {
            int middle = (first + last) / 2;
            int middleSong = songs[middle].getYear();
            if (middleSong == year) {
                return middle;
            } else if (middleSong < year) {
                first = middle + 1;
            } else {
                last = middle - 1;
            }
        }

        return -1;
    }

    private boolean isSortedByYear() {
        for (int i = 1; i < size; i++) {
            if (songs[i].getYear() < songs[i - 1].getYear()) {
                return false;
            }
        }
        return true;
    }

    public int search(int year) {
        if (isSortedByYear()) {
            return binarySearch(year);
        } else {
            return linearSearch(year);
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < size; i++) {
            int minutes = songs[i].getLength() / 60;
            int seconds = songs[i].getLength() % 60;

            sb.append((i + 1) + ". ");
            sb.append(songs[i].getTitle());
            sb.append(" (" + songs[i].getArtist() + ") ");
            sb.append(minutes + ":");
            if (seconds < 10) {
                sb.append("0");
            }
            sb.append(seconds);
            sb.append("\n");
        }

        return sb.toString();
    }
}
