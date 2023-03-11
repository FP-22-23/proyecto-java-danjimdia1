package fp.TvShow;

import java.time.LocalDate;
import java.util.List;

public class TvShowImpl implements TvShow{
	
	public Integer id;
	public String name;
	public LocalDate releaseYear;
	public Integer numSeasons;
	public String language;
	public List<String> genres;
	public Double imdbRating;
	public String stringAgeRestriction;
	
	//CONSTRUCTORES
	
	public TvShowImpl() {
		
	}
	
	
	//PROPIEDADES DERIVADAS
	
	public AgeRestriction getAgeRestriction(String stringAgeRestriction) {
		AgeRestriction res = null;
		switch(stringAgeRestriction) {
		case "All":
			res = AgeRestriction.ALL;
			break;
		case "7+":
			res = AgeRestriction.SIETE;
		case "13+":
			res = AgeRestriction.TRECE;
			break;
		case "16+":
			res = AgeRestriction.DIECISEIS;
			break;
		case "18+":
			res = AgeRestriction.DIECIOCHO;
		}
		return res;
	}
	
	public Boolean getIsForMinors(AgeRestriction ageRestriction) {
		Boolean res = true;
		if (ageRestriction == AgeRestriction.DIECIOCHO){
			res = false;
		}
		return res;
	}
	
	//GETTERS AND SETTERS
	
	
	
}
