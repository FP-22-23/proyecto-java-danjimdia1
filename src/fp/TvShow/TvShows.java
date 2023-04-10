package fp.TvShow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fp.common.AgeRestriction;

public class TvShows {
	
	private List<TvShowImpl> shows;
	
	////////////////////////
	
	public TvShows() {
		setShows(new ArrayList<TvShowImpl>());
	}
	
	public TvShows(Collection<TvShowImpl> shows) {
		this.setShows(new ArrayList<>(shows));	
	}

	////////////////////////
	
	public List<TvShowImpl> getShows() {
		return shows;
	}

	public void setShows(Collection<TvShowImpl> shows) {
		this.shows = new ArrayList<>(shows);
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
	
	////////////////////////

	public Boolean containsShow(TvShowImpl show) {
		Boolean res = false;
		for(TvShowImpl s : shows) {
			if(s.equals(show)) {
				res = true;
				break;
				}
		}
		return res;
	}
	
	public Boolean containsShow2(TvShowImpl show) {
		return shows.contains(show);
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

	//////////////////////
	
	public String toString() {
		return "TvShows [shows=" + shows + "]";
	}
	
	
	
	
	
	
}
