package com.example.kuranikerimm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Veriler {

    @SerializedName("qari_id")
    @Expose
    private int qariId;
    @SerializedName("surah_id")
    @Expose
    private int surahId;
    @SerializedName("main_id")
    @Expose
    private long mainId;
    @SerializedName("recitation_id")
    @Expose
    private long recitationId;
    @SerializedName("filenum")
    @Expose
    private Object filenum;
    @SerializedName("file_name")
    @Expose
    private String fileName;
    @SerializedName("extension")
    @Expose
    private String extension;
    @SerializedName("stream_count")
    @Expose
    private long streamCount;
    @SerializedName("download_count")
    @Expose
    private long downloadCount;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("qari")
    @Expose
    private Qari qari;

    public long getQariId() {
        return qariId;
    }

    public void setQariId(int qariId) {
        this.qariId = qariId;
    }

    public Veriler withQariId(int qariId) {
        this.qariId = qariId;
        return this;
    }

    public long getSurahId() {
        return surahId;
    }

    public void setSurahId(int surahId) {
        this.surahId = surahId;
    }

    public Veriler withSurahId(int surahId) {
        this.surahId = surahId;
        return this;
    }

    public long getMainId() {
        return mainId;
    }

    public void setMainId(long mainId) {
        this.mainId = mainId;
    }

    public Veriler withMainId(long mainId) {
        this.mainId = mainId;
        return this;
    }

    public long getRecitationId() {
        return recitationId;
    }

    public void setRecitationId(long recitationId) {
        this.recitationId = recitationId;
    }

    public Veriler withRecitationId(long recitationId) {
        this.recitationId = recitationId;
        return this;
    }

    public Object getFilenum() {
        return filenum;
    }

    public void setFilenum(Object filenum) {
        this.filenum = filenum;
    }

    public Veriler withFilenum(Object filenum) {
        this.filenum = filenum;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Veriler withFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Veriler withExtension(String extension) {
        this.extension = extension;
        return this;
    }

    public long getStreamCount() {
        return streamCount;
    }

    public void setStreamCount(long streamCount) {
        this.streamCount = streamCount;
    }

    public Veriler withStreamCount(long streamCount) {
        this.streamCount = streamCount;
        return this;
    }

    public long getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(long downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Veriler withDownloadCount(long downloadCount) {
        this.downloadCount = downloadCount;
        return this;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Veriler withMetadata(Metadata metadata) {
        this.metadata = metadata;
        return this;
    }

    public Qari getQari() {
        return qari;
    }

    public void setQari(Qari qari) {
        this.qari = qari;
    }

    public Veriler withQari(Qari qari) {
        this.qari = qari;
        return this;
    }

}