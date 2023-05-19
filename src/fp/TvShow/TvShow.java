package fp.TvShow;

import java.time.LocalDate;
import java.util.List;

import fp.common.AgeRestriction;


public interface TvShow {
	public List<String> getGenres();

	public void setGenres(List<String> genres);
	
	public void addGenre(String genre);
	
	public void delGenre(String genre);
	
	public Integer getNumSeasons();

	public void setNumSeasons(Integer numSeasons);

	public String getLanguage();

	public void setLanguage(String language);
	
	public Double getImdbRating();

	public void setImdbRating(Double imdbRating);

	public Boolean getWorldPremiere();

	public void setWorldPremiere(Boolean worldPremiere);

	public AgeRestriction getAgeRestriction();
	
	public void setAgeRestriction(AgeRestriction ageRestriction);

	public Integer getId();
	
	public String getName();

	public LocalDate getReleaseDate();
}
