package com.example.kuranikerimm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Okuyanlar {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("arabic_name")
    @Expose
    private Object arabicName;
    @SerializedName("relative_path")
    @Expose
    private String relativePath;
    @SerializedName("file_formats")
    @Expose
    private String fileFormats;
    @SerializedName("section_id")
    @Expose
    private int sectionId;
    @SerializedName("home")
    @Expose
    private boolean home;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("torrent_filename")
    @Expose
    private Object torrentFilename;
    @SerializedName("torrent_info_hash")
    @Expose
    private Object torrentInfoHash;
    @SerializedName("torrent_seeders")
    @Expose
    private int torrentSeeders;
    @SerializedName("torrent_leechers")
    @Expose
    private int torrentLeechers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Okuyanlar withId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Okuyanlar withName(String name) {
        this.name = name;
        return this;
    }

    public Object getArabicName() {
        return arabicName;
    }

    public void setArabicName(Object arabicName) {
        this.arabicName = arabicName;
    }

    public Okuyanlar withArabicName(Object arabicName) {
        this.arabicName = arabicName;
        return this;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public Okuyanlar withRelativePath(String relativePath) {
        this.relativePath = relativePath;
        return this;
    }

    public String getFileFormats() {
        return fileFormats;
    }

    public void setFileFormats(String fileFormats) {
        this.fileFormats = fileFormats;
    }

    public Okuyanlar withFileFormats(String fileFormats) {
        this.fileFormats = fileFormats;
        return this;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public Okuyanlar withSectionId(int sectionId) {
        this.sectionId = sectionId;
        return this;
    }

    public boolean isHome() {
        return home;
    }

    public void setHome(boolean home) {
        this.home = home;
    }

    public Okuyanlar withHome(boolean home) {
        this.home = home;
        return this;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Okuyanlar withDescription(Object description) {
        this.description = description;
        return this;
    }

    public Object getTorrentFilename() {
        return torrentFilename;
    }

    public void setTorrentFilename(Object torrentFilename) {
        this.torrentFilename = torrentFilename;
    }

    public Okuyanlar withTorrentFilename(Object torrentFilename) {
        this.torrentFilename = torrentFilename;
        return this;
    }

    public Object getTorrentInfoHash() {
        return torrentInfoHash;
    }

    public void setTorrentInfoHash(Object torrentInfoHash) {
        this.torrentInfoHash = torrentInfoHash;
    }

    public Okuyanlar withTorrentInfoHash(Object torrentInfoHash) {
        this.torrentInfoHash = torrentInfoHash;
        return this;
    }

    public int getTorrentSeeders() {
        return torrentSeeders;
    }

    public void setTorrentSeeders(int torrentSeeders) {
        this.torrentSeeders = torrentSeeders;
    }

    public Okuyanlar withTorrentSeeders(int torrentSeeders) {
        this.torrentSeeders = torrentSeeders;
        return this;
    }

    public int getTorrentLeechers() {
        return torrentLeechers;
    }

    public void setTorrentLeechers(int torrentLeechers) {
        this.torrentLeechers = torrentLeechers;
    }

    public Okuyanlar withTorrentLeechers(int torrentLeechers) {
        this.torrentLeechers = torrentLeechers;
        return this;
    }

}