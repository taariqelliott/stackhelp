package org.help.stackhelp.service;

public class CdRecord {
    private String albumTitle;
    private String artist;
    private int releaseYear;
    private long totalTracks;
    private String label;

    public CdRecord(String albumTitle, String artist, int releaseYear, long totalTracks, String label) {
        this.albumTitle = albumTitle;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.totalTracks = totalTracks;
        this.label = label;
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

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public long getTotalTracks() {
        return totalTracks;
    }

    public void setTotalTracks(long totalTracks) {
        this.totalTracks = totalTracks;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "CdRecord{" +
                "albumTitle='" + albumTitle + '\'' +
                ", artist='" + artist + '\'' +
                ", releaseYear=" + releaseYear +
                ", totalTracks=" + totalTracks +
                ", label='" + label + '\'' +
                '}';
    }
}
