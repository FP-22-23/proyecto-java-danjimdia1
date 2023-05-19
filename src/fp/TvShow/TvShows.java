package fp.TvShow;

import java.time.LocalDate; 
import java.util.ArrayList;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
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
	
	public String toString() {
		return "TvShows [shows=" + shows + "]";
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
	
	public List<String> showsInLanguages(Collection<String> languages){
		List<String> res = new ArrayList<>();
		for(TvShowImpl s: shows) {
			if(languages.contains(s.getLanguage())) {
				res.add(s.getName());
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
	
	/////////// BLOQUE 3 (Streams) ///////////

	public Boolean existShowInLanguage(String languaje) {
		return shows.stream()
				.anyMatch(s -> s.getLanguage().equals(languaje));
	}
	
	public Boolean existShowReleasedBetween2(LocalDate f1, LocalDate f2) {
		return shows.stream()
				.anyMatch(s -> s.getReleaseDate().isAfter(f1) && s.getReleaseDate().isBefore(f2));
	}
	
	
	public Double totalRating2() {
		return shows.stream()
				.mapToDouble(TvShowImpl::getImdbRating)
				.sum();
	}
	
	public Double ratingMean2() {
		return shows.stream()
				.collect(Collectors.averagingDouble(TvShowImpl::getImdbRating));
	}
	
	public Integer countGenres2() {
		return shows.stream()
			.flatMap(s -> s.getGenres().stream())
			.distinct()
			.collect(Collectors.collectingAndThen(Collectors.counting(), Long::intValue));	
	}
	
	public List<String> showsInLanguages2(Collection<String> languages) {
		return shows.stream()
				.filter(s -> languages.contains(s.getLanguage()))
				.map(s -> s.getName())
				.toList();
	}
	
	public TvShowImpl MaxWorldPremiereScoreShow() {
		return shows.stream()
				.filter(s -> s.getWorldPremiere())
				.max(Comparator.comparing(TvShowImpl::getImdbRating))
				.get();
	}
	
	public TvShowImpl MinWorldPremiereScoreShow() {
		return shows.stream()
				.filter(s -> s.getWorldPremiere())
				.min(Comparator.comparing(TvShowImpl::getImdbRating))
				.get();
	}
	
	public List<String> TopNWorldPremieresByRating(Integer n){
		return shows.stream()
				.filter(s -> s.getWorldPremiere())
				.sorted(Comparator.comparing(TvShowImpl::getImdbRating).reversed())
				.limit(n)
				.map(s -> s.getName())
				.toList();
	}
	
	public Map<AgeRestriction, List<TvShowImpl>> listShowsByAgeRestriction2(){
		return shows.stream()
				.collect(Collectors.groupingBy(TvShowImpl::getAgeRestriction));
	}		
	
	public Map<Integer,Integer> numWorldPremiereShowsPorAño2(){
		return shows.stream()
				.filter(s -> s.getWorldPremiere())
				.collect(Collectors.groupingBy(s -> s.getReleaseDate().getYear(),Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
	}
	
	
	public Map<AgeRestriction, String> mostRecentShowByAgeRestriction(){
		return shows.stream()
				.collect(Collectors.groupingBy(TvShowImpl::getAgeRestriction,
						Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(TvShowImpl::getReleaseDate).thenComparing(Comparator.naturalOrder())),
								s -> s.map(TvShowImpl::getName).get())));
	}
	
	
	public SortedMap<Integer, List<TvShowImpl>> TopNScoredShowsbyYear(Integer n){
		return shows.stream()
				.collect(Collectors.groupingBy(TvShowImpl::getReleaseYear, TreeMap::new, Collectors.collectingAndThen(Collectors.toList(), l -> calculaTop(l,n))));
	}
	
	private static List<TvShowImpl> calculaTop(List<TvShowImpl> l, Integer n) {
		return l.stream()
				.sorted(Comparator.comparing(TvShowImpl::getImdbRating).reversed())
				.limit(n)
				.toList();
	}

	public Integer AnyoMasRatingMedio() {
		Map<Integer,Double> aux = shows.stream()
				.collect(Collectors.groupingBy(TvShowImpl::getReleaseYear,
						Collectors.averagingDouble(TvShowImpl::getImdbRating)));
		return aux.entrySet().stream()
				.max(Comparator.comparing(Map.Entry::getValue))
				.map(e -> e.getKey())
				.get();
	}
		
	
	
}
