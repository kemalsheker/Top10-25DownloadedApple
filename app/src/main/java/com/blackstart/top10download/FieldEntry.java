package com.blackstart.top10download;

import androidx.recyclerview.widget.RecyclerView;

public class FieldEntry {

    private String title;
    private String artist;
    private String releaseDate;
    private String rights;
    private String imageURL;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "FieldEntry{" +
                "title='" + title + '\n' +
                ", artist='" + artist + '\n' +
                ", releaseDate='" + releaseDate + '\n' +
                ", rights='" + rights + '\n' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
