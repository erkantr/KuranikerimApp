package com.example.kuranikerimm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Qari {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("arabic_name")
    @Expose
    private String arabicName;
    @SerializedName("relative_path")
    @Expose
    private String relativePath;
    @SerializedName("file_formats")
    @Expose
    private String fileFormats;
    @SerializedName("section_id")
    @Expose
    private long sectionId;
    @SerializedName("home")
    @Expose
    private boolean home;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("torrent_filename")
    @Expose
    private String torrentFilename;
    @SerializedName("torrent_info_hash")
    @Expose
    private String torrentInfoHash;
    @SerializedName("torrent_seeders")
    @Expose
    private long torrentSeeders;
    @SerializedName("torrent_leechers")
    @Expose
    private long torrentLeechers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Qari withId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Qari withName(String name) {
        this.name = name;
        return this;
    }

    public String getArabicName() {
        return arabicName;
    }

    public void setArabicName(String arabicName) {
        this.arabicName = arabicName;
    }

    public Qari withArabicName(String arabicName) {
        this.arabicName = arabicName;
        return this;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public Qari withRelativePath(String relativePath) {
        this.relativePath = relativePath;
        return this;
    }

    public String getFileFormats() {
        return fileFormats;
    }

    public void setFileFormats(String fileFormats) {
        this.fileFormats = fileFormats;
    }

    public Qari withFileFormats(String fileFormats) {
        this.fileFormats = fileFormats;
        return this;
    }

    public long getSectionId() {
        return sectionId;
    }

    public void setSectionId(long sectionId) {
        this.sectionId = sectionId;
    }

    public Qari withSectionId(long sectionId) {
        this.sectionId = sectionId;
        return this;
    }

    public boolean isHome() {
        return home;
    }

    public void setHome(boolean home) {
        this.home = home;
    }

    public Qari withHome(boolean home) {
        this.home = home;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Qari withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getTorrentFilename() {
        return torrentFilename;
    }

    public void setTorrentFilename(String torrentFilename) {
        this.torrentFilename = torrentFilename;
    }

    public Qari withTorrentFilename(String torrentFilename) {
        this.torrentFilename = torrentFilename;
        return this;
    }

    public String getTorrentInfoHash() {
        return torrentInfoHash;
    }

    public void setTorrentInfoHash(String torrentInfoHash) {
        this.torrentInfoHash = torrentInfoHash;
    }

    public Qari withTorrentInfoHash(String torrentInfoHash) {
        this.torrentInfoHash = torrentInfoHash;
        return this;
    }

    public long getTorrentSeeders() {
        return torrentSeeders;
    }

    public void setTorrentSeeders(long torrentSeeders) {
        this.torrentSeeders = torrentSeeders;
    }

    public Qari withTorrentSeeders(long torrentSeeders) {
        this.torrentSeeders = torrentSeeders;
        return this;
    }

    public long getTorrentLeechers() {
        return torrentLeechers;
    }

    public void setTorrentLeechers(long torrentLeechers) {
        this.torrentLeechers = torrentLeechers;
    }

    public Qari withTorrentLeechers(long torrentLeechers) {
        this.torrentLeechers = torrentLeechers;
        return this;
    }

}
