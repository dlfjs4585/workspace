package class_basic.song;

public class SongTest {
    public static void main(String[] args) {

        Song s1 = new Song();
        String[] a = {"김","나","박"};
        s1.info("a","b","c",4,a);
        s1.printSongInfo();

    }


}
