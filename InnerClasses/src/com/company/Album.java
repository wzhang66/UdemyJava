package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration){
        return this.songs.add(new Song(title, duration));
    }

    public boolean addToPlayList(int songNum, LinkedList<Song> playList){
        Song checkSong = this.songs.findSong(songNum);
        if(checkSong != null){
            playList.add(checkSong);
            return true;
        }
        System.out.println("This album does not have a track " + songNum);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList){
        Song addSong = songs.findSong(title);
        if(addSong != null){
            playList.add(addSong);
            return true;
        }
        return false;
    }

    private class SongList {
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<Song>();
        }

        public boolean add(Song song){
            if(songs.contains(song)){
                return false;
            }
            this.songs.add(song);
            return true;
        }

        private Song findSong(String title){
            for(Song checkSong: this.songs){
                if(checkSong.getTitle().equals(title)){
                    return checkSong;
                }
            }
            return null;
        }

        private Song findSong(int trackNumber){
            int index = trackNumber -1;
            if(index >= 0 && index < songs.size()){
                return songs.get(index);
            }
            return null;
        }
    }
}
