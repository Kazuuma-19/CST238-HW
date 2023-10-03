package HW04a;

public class Main {
    public static void main(String[] args) {
        PlayList pl1 = new PlayList();
        pl1.add(new Song("Rapper's Delight", "Sugarhill Gang", 1979, 427));
        pl1.add(new Song("Never Gonna Give You Up", "Rick Astley", 1987, 215));
        System.out.println(pl1);
        System.out.println(pl1.search(1979) + " - first index for 1979 (should be 0)");
        System.out.println("Index of shortest song, should be 1: " + pl1.shortestSongIndex());
        System.out.println();
        pl1.move(1, 0);
        System.out.println(pl1);
        System.out.println(pl1.search(1979) + " - first index for 1979 (should be 1)");

        System.out.println("Index of shortest song, should be 0: " + pl1.shortestSongIndex());
        System.out.println("Title of longest song (should be Rapper's Delight): " + pl1.longestSong().getTitle());
        System.out.println();
        PlayList pl2 = new PlayList();
        System.out.println(pl2);
        System.out.println(pl2.search(1979) + " - first index for 1979 (should be -1)");
        System.out.println("Index of shortest song, should be -1: " + pl2.shortestSongIndex());
        System.out.println("Longest song (should be null): " + pl2.longestSong());
    }
}
