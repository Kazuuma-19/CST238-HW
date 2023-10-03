package HW04a;

public class Main {
    public static void main(String[] args) {
        PlayList list = new PlayList();
//        Song s1 = new Song("Never Gonna Give You Up", "Rick Astley", 1987, 215);
//        Song s2 = new Song("Rapper's Delight", "Sugarhill Gang", 1979, 427);
//
//        list.add(s1);
//        list.add(s2);

        // equals
//        if (s1.equals(s2)) {
//            System.out.println("The song already exist");
//        } else {
//            System.out.println("The song is new");
//        }
//        System.out.println();

        list.add(new Song("Rolling in the Deep", "Adele", 1347, 228));
        list.add(new Song("Imagine", "John Lennon", 1387, 180));
        list.add(new Song("Hotel California", "Eagles", 1437, 391));
        list.add(new Song("Shape of You", "Ed Sheeran", 1495, 234));
//        list.add(new Song("Billie Jean", "Michael Jackson", 1587, 294));
//        list.add(new Song("Bohemian Rhapsody", "Queen", 1837, 360));
//        list.add(new Song("Sweet Child o' Mine", "Guns N' Roses", 1932, 355));
//        list.add(new Song("Yesterday", "The Beatles", 1983, 127));
//        list.add(new Song("Stairway to Heaven", "Led Zeppelin", 1987, 482));
//        list.add(new Song("Hello", "Adele", 2000, 295));
//        list.add(new Song("Radioactive", "Imagine Dragons", 2001, 187));
//        list.add(new Song("I Want to Hold Your Hand", "The Beatles", 2003, 141));
//        list.add(new Song("Smells Like Teen Spirit", "Nirvana", 2021, 301));

        System.out.println(list);
        System.out.println();

        // move
//        list.move(3, 5);
//        System.out.println(list);

        // linearSearch
        System.out.println(list.search(1495));
    }
}
