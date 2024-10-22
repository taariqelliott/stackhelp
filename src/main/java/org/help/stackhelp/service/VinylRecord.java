package org.help.stackhelp.service;

public class VinylRecord {
    private String albumTitle;
    private String artist;
    private long releaseYear;
    private String format;  // e.g., 12-inch, 7-inch, etc.

    public VinylRecord(String albumTitle, String artist, long releaseYear, String format) {
        this.albumTitle = albumTitle;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.format = format;
    }

    // Getters and Setters
    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public long getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(long releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "VinylRecord{" +
                "albumTitle='" + albumTitle + '\'' +
                ", artist='" + artist + '\'' +
                ", releaseYear=" + releaseYear +
                ", format='" + format + '\'' +
                '}';
    }
}
