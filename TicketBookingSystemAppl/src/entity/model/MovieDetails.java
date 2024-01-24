package entity.model;

public class MovieDetails {
    private String genre;
    private String actor_name;
    private String actress_name;

    public MovieDetails(String genre, String actor_name, String actress_name) {
        this.genre = genre;
        this.actor_name = actor_name;
        this.actress_name = actress_name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getActor_name() {
        return actor_name;
    }

    public void setActor_name(String actor_name) {
        this.actor_name = actor_name;
    }

    public String getActress_name() {
        return actress_name;
    }

    public void setActress_name(String actress_name) {
        this.actress_name = actress_name;
    }
}
