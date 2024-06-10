package class_basic.song;

public class Song {

    String title;
    String artist;
    String album;
    int year;
    String[] composer = new String[3];


    public void info(String title1, String artist1, String album1, int year1, String[] composer1){
        title = title1;
        artist = artist1;
        album = album1;
        year = year1;
        composer = composer1;

    }


    public void printSongInfo(){
        System.out.println("제목 : " + title);
        System.out.println("가수 : " + artist);
        System.out.println("엘범 : " + album);
        System.out.println("발표된 년도 : " + year);
        System.out.print("작곡가 : ");
        for (int i = 0; i < composer.length; i++){
            System.out.print(composer[i] + " ");
        }
    }

}
