package Section10.Challenges.Playlist;

import java.util.ArrayList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        ArrayList<Song> songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {

        if (findSong(title) == null) {
            Song newSong = new Song(title, duration);
            songs.add(newSong);
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }

}
