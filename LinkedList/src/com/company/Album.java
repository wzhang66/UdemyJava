package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(int songNum, LinkedList<Song> playList){
        if(songNum <= this.songs.size() && songNum>0){
            playList.add(this.songs.get(songNum-1));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList){
        Song addSong = findSong(title);
        if(addSong != null){
            playList.add(addSong);
            return true;
        }
        return false;
    }

    private Song findSong(String title){
        for(int i=0; i<this.songs.size(); i++){
            Song singleSong = songs.get(i);
            if(singleSong.getTitle().equals(title)){
                return singleSong;
            }
        }
        return null;
    }
}
