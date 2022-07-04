package com.example.kuranikerimm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metadata {

    @SerializedName("album")
    @Expose
    private String album;
    @SerializedName("genre")
    @Expose
    private String genre;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("track")
    @Expose
    private String track;
    @SerializedName("artist")
    @Expose
    private String artist;

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Metadata withAlbum(String album) {
        this.album = album;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Metadata withGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Metadata withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public Metadata withTrack(String track) {
        this.track = track;
        return this;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Metadata withArtist(String artist) {
        this.artist = artist;
        return this;
    }

}
