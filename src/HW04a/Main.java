package HW04a;

public class Main {
    public static void main(String[] args) {
        PlayList list = new PlayList();
        Song s1 = new Song("Never Gonna Give You Up", "Rick Astley", 215);
        Song s2 = new Song("Rapper's Delight", "Sugarhill Gang", 427);

        list.add(s1);
        list.add(s2);

        // equals
        if (s1.equals(s2)) {
            System.out.println("The song already exist");
        } else {
            System.out.println("The song is new");
        }
        System.out.println();

        list.add(new Song("Bohemian Rhapsody", "Queen", 360));
        list.add(new Song("Imagine", "John Lennon", 180));
        list.add(new Song("Rolling in the Deep", "Adele", 228));
        list.add(new Song("Billie Jean", "Michael Jackson", 294));
        list.add(new Song("Hotel California", "Eagles", 391));
        list.add(new Song("Stairway to Heaven", "Led Zeppelin", 482));
        list.add(new Song("Shape of You", "Ed Sheeran", 234));
        list.add(new Song("Yesterday", "The Beatles", 127));
        list.add(new Song("Sweet Child o' Mine", "Guns N' Roses", 355));
        list.add(new Song("I Want to Hold Your Hand", "The Beatles", 141));
        list.add(new Song("Smells Like Teen Spirit", "Nirvana", 301));
        list.add(new Song("Hello", "Adele", 295));
        list.add(new Song("Radioactive", "Imagine Dragons", 187));

        System.out.println(list);
        System.out.println();

        // move
        list.move(3, 5);
        System.out.println(list);
    }
}
