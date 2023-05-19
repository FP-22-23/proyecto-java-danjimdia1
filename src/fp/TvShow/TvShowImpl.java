package fp.TvShow;

import java.time.LocalDate;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fp.common.AgeRestriction;
import fp.utils.Checkers;

/**
 * @author danjimdia1
 * Tipo base para el proyecto del segundo cuatrimestre de FP.
 */

public class TvShowImpl implements TvShow, Comparable<TvShowImpl>{
	
	private Integer id;
	private String name;
	private LocalDate releaseDate;
	private Integer numSeasons;
	private String language;
	private List<String> genres;
	private Double imdbRating;
	private AgeRestriction ageRestriction;
	private Boolean worldPremiere;

	
	//CONSTRUCTORES
	
	public TvShowImpl(Integer id, String name, LocalDate releaseDate, Integer numSeasons, String language, List<String> genres, Double imdbRating,
			AgeRestriction ageRestriction, Boolean worldPremiere) {
		
		Checkers.check("EL número de temporadas debe ser mayor que cero." , numSeasons > 0);
		Checkers.checkNoNull(genres);

		this.id = id;
		this.name = name;
		this.releaseDate = releaseDate;
		this.numSeasons = numSeasons;
		this.language = language;
		this.genres = genres;
		this.imdbRating = imdbRating;
		this.ageRestriction = ageRestriction;
		this.worldPremiere = worldPremiere;
	}
	
	public TvShowImpl(Integer id, String name, LocalDate releaseDate, Integer numSeasons) {
		
		Checkers.check("EL número de temporadas debe ser mayor que cero." , numSeasons > 0);
		
		this.id = id;
		this.name = name;
		this.releaseDate = releaseDate;
		this.numSeasons = numSeasons;
		language = null;
		genres = new ArrayList<String>();
		imdbRating = null;
		ageRestriction = null;
		worldPremiere = null;
		
	}
	
	//PROPIEDADES DERIVADAS
	
	/**
	 @return Representación corta como cadena del show, con el fomato nombre[dia/mes/año] --> nota.
	 *  
	 */
	public String getShortFormat() {
		return getName() + "[" + getReleaseDate().getDayOfMonth() + "/" + getReleaseDate().getMonth() + "/" + getReleaseDate().getYear() + "] --> " + getImdbRating();
	}

	 
	//GETTERS Y SETTERS
						
	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	
	public void addGenre(String genre) {
		Checkers.checkNoNull(genre);
		Checkers.check("El género ya esta en la lista", !this.genres.contains(genre));
		this.genres.add(genre);
	}
	
	public void delGenre(String genre) {
		Checkers.check("El género debe estar en la lista", this.genres.contains(genre));
		this.genres.remove(genre);
	}
	
	public Integer getNumSeasons() {
		return numSeasons;
	}

	public void setNumSeasons(Integer numSeasons) {
		Checkers.check("EL número de temporadas debe ser mayor que cero." , numSeasons > 0);
		this.numSeasons = numSeasons;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Double getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(Double imdbRating) {
		this.imdbRating = imdbRating;
	}

	public Boolean getWorldPremiere() {
		return worldPremiere;
	}

	public void setWorldPremiere(Boolean worldPremiere) {
		this.worldPremiere = worldPremiere;
	}

	public AgeRestriction getAgeRestriction() {
		return ageRestriction;
	}

	public void setAgeRestriction(AgeRestriction ageRestriction) {
		this.ageRestriction = ageRestriction;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	
	public Integer getReleaseYear() {
		return this.releaseDate.getYear();
	}
	
	
	//CRITERIO DE ORDEN NATURAL
	
	public int compareTo(TvShowImpl t) {
		int r = this.getId().compareTo(t.getId());
		if (r == 0 ) {
			r = this.getName().compareTo(t.getName());
			if (r == 0) {
				r = this.getReleaseDate().compareTo(t.getReleaseDate());
			}
		}
		return r; 
	}
	

	//HASH CODE Y EQUALS

	public int hashCode() {
		return Objects.hash(id, name, releaseDate);
	}

	public boolean equals(Object o) {
		boolean r = false;
		if (o instanceof TvShowImpl) {
			TvShowImpl t = (TvShowImpl) o;
			r = this.getId().equals(t.getId()) &&
					this.getName().equals(t.getName()) &&
						this.getReleaseDate().equals(t.getReleaseDate());
		}
		return r;
	}
	
	
	//REPRESENTACIÓN COMO CADENA

	public String toString() {
		return "TvShowImpl [id=" + id + ", name=" + name + ", releaseDate=" + releaseDate + ", numSeasons=" + numSeasons
				+ ", language=" + language + ", genres=" + genres + ", imdbRating=" + imdbRating + ", ageRestriction="
				+ ageRestriction + ", worldPremiere=" + worldPremiere + "]";
	}	
}
