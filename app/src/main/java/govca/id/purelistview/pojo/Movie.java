package govca.id.purelistview.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "year",
        "movie_name"
})

public class Movie implements Parcelable {
    @JsonProperty("name")
    private String movie_name;
    @JsonProperty("production_house")
    private String production_house;
    @JsonProperty("director")
    private String director;
    @JsonProperty("synopsis")
    private String synopsis;
    @JsonProperty("year")
    private String year;
    @JsonProperty("poster")
    private String poster;

    @JsonProperty("name")
    public String getMovie_name() {
        return movie_name;
    }

    @JsonProperty("name")
    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    @JsonProperty("production_house")
    public String getProduction_house() {
        return production_house;
    }

    @JsonProperty("production_house")
    public void setProduction_house(String production_house) {
        this.production_house = production_house;
    }

    @JsonProperty("director")
    public String getDirector() {
        return director;
    }

    @JsonProperty("director")
    public void setDirector(String director) {
        this.director = director;
    }

    @JsonProperty("synopsis")
    public String getSynopsis() {
        return synopsis;
    }

    @JsonProperty("synopsis")
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @JsonProperty("year")
    public String getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(String year) {
        this.year = year;
    }

    @JsonProperty("poster")
    public String getPoster() {
        return poster;
    }

    @JsonProperty("poster")
    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.movie_name);
        dest.writeString(this.production_house);
        dest.writeString(this.director);
        dest.writeString(this.synopsis);
        dest.writeString(this.year);
        dest.writeString(this.poster);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.movie_name = in.readString();
        this.production_house = in.readString();
        this.director = in.readString();
        this.synopsis = in.readString();
        this.year = in.readString();
        this.poster = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
