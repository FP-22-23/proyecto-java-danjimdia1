package fp.TvShow;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.common.AgeRestriction;

public class TvShows {
	
	private List<TvShowImpl> shows;
	
	////////////////////////
	
	public TvShows() {
		shows = new ArrayList<TvShowImpl>();
	}
	
	public TvShows(List<TvShowImpl> shows) {
		this.shows = new ArrayList<>(shows);	
	}
	
	public TvShows(Stream<TvShowImpl> shows) {
		this.shows= shows.collect(Collectors.toList());
	}
	////////////////////////
	
	public List<TvShowImpl> getShows() {
		return shows;
	}

	public void setShows(List<TvShowImpl> shows) {
		this.shows = new ArrayList<>(shows);
	}

	////////////////////////
	
	
	public int hashCode() {
		return Objects.hash(shows);
	}

	public boolean equals(Object o) {
		boolean r = false;
		if (o instanceof TvShows) {
			TvShows t = (TvShows) o;
			r = this.shows.equals(t.shows);
		}
		return r;
	}
	
	////////////////////////
	
	public Integer numShows() {
		return shows.size();
	}

	public void addShow(TvShowImpl show) {
		shows.add(show);
	}
	
	public void addShows(Collection<TvShowImpl> shows) {
		this.shows.addAll(shows);
	}
	
	public void delShow(TvShowImpl show) {
		shows.remove(show);
	}
	
	public Boolean containsShow(TvShowImpl show) {
		return shows.contains(show);
	}
	
	////////////////////////
	
	public Boolean existShowReleasedBetween(LocalDate f1, LocalDate f2) {
		Boolean res = false;
		for(TvShowImpl s:shows) {
			if(s.getReleaseDate().isAfter(f1) && s.getReleaseDate().isBefore(f2)) {
				res = true;
				break;
			}
		}
		return res;
	}
	
	public Double totalRating() {
		Double res = 0.0;
		for(TvShowImpl s: shows) {
			res += s.getImdbRating();
		}
		return res;
	}
	
	public Double ratingMean() {
		return this.totalRating()/this.numShows();
	}
	
	public Set<String> genreSet(){
		Set<String> res = new HashSet<>();
		for(TvShowImpl s: shows) {
			res.addAll(s.getGenres());
		}
		return res;
	}
	
	public Integer countGenres() {
		return this.genreSet().size();
	}
	
	public TvShows showsInLanguages(Collection<String> languages){
		TvShows res = new TvShows();
		for(TvShowImpl s: shows) {
			if(languages.contains(s.getLanguage())) {
				res.addShow(s);
			}
		}
		return res;	
	}
	
	
	public Map<TvShowImpl, AgeRestriction> showsByAgeRestriction(){
		Map<TvShowImpl, AgeRestriction> res = new HashMap<>();
		for(TvShowImpl s: shows){
			TvShowImpl key = s;
			if(!res.containsKey(key)) {
				res.put(key, s.getAgeRestriction());
			}
		}
		return res;
	}
	
	public Map<AgeRestriction, List<TvShowImpl>> listShowsByAgeRestriction(){
		Map<AgeRestriction, List<TvShowImpl>> res = new HashMap<>();
		for(Map.Entry<TvShowImpl,AgeRestriction> pareja: showsByAgeRestriction().entrySet()) {
		AgeRestriction key = pareja.getValue();
		if(res.containsKey(key)) {
			res.get(key).add(pareja.getKey());
			}else {
				List<TvShowImpl> lista = new ArrayList<>();
				lista.add(pareja.getKey());
				res.put(key,lista);
			}
		}
		return res;
	}

	public Map<Integer,Integer> numWorldPremiereShowsPorAño(){
		Map<Integer,Integer> res = new HashMap<>();
		for(TvShowImpl s:shows) {
			Integer key = s.getReleaseDate().getYear();
			if(s.getWorldPremiere()) {
				if(res.containsKey(key)) {
					res.put(key, res.get(key) + 1);
				}else {
					res.put(key, 1);
				}
			}
		}
		return res;
	}
	
	//////////////////////
	
	public String toString() {
		return "TvShows [shows=" + shows + "]";
	}
	
	
	
	
	
	
}
