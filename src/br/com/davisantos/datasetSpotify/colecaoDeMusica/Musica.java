package br.com.davisantos.datasetSpotify.colecaoDeMusica;

public class Musica {
    private String artist, track, danceability, energy, duration_min, views, likes;

    public Musica(String artist, String track, String danceability,
            String energy, String duration_min, String views, String likes) {

        this.artist = artist;
        this.track = track;
        this.danceability = danceability;
        this.energy = energy;
        this.duration_min = duration_min;
        this.views = views;
        this.likes = likes;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getDanceability() {
        return danceability;
    }

    public void setDanceability(String danceability) {
        this.danceability = danceability;
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public String getDuration_min() {
        return duration_min;
    }

    public void setDuration_min(String duration_min) {
        this.duration_min = duration_min;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getInfoMusica() {
        return "\nArtista: " + getArtist() +
                "\nTrack: " + getTrack() +
                "\nDancebility: " + getDanceability() +
                "\nEnergy: " + getEnergy() +
                "\nDuration_min: " + getDuration_min() +
                "\nViews: " + getViews() +
                "\nLikes: " + getLikes();
    }

    public String getLinhaMusica() {
        return getArtist() + ";" + getTrack() + ";"
                + getDanceability() + ";" + getEnergy() + ";"
                + getDuration_min() + ";" + getViews() + ";" + getLikes();
    }

}