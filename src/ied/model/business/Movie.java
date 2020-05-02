package ied.model.business;

import java.util.List;
import java.util.ArrayList;;

public class Movie {
	
	private String title;
	private String genre;
	private String distributor; 
	private String releaseDate; 
	private String productionBudget; 
	private String DomesticGross; 
	private String WorldwideGross; 
	private String resume;
	private String director;	
	private List<String> actors; 
	private List<String> producers; 
	
	public Movie() {
		this.actors = new ArrayList<String>(); 
		this.producers = new ArrayList<String>(); 
	}
	
	public String getTitle() {
		if(title == null ) return ""; 
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		if(genre == null ) return ""; 
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getDistributor() {
		if(distributor == null ) return ""; 
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

	public String getReleaseDate() {
		if(releaseDate == null ) return ""; 
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getProductionBudget() {
		if(productionBudget == null ) return ""; 
		return productionBudget;
	}

	public void setProductionBudget(String productionBudget) {
		this.productionBudget = productionBudget;
	}

	public String getDomesticGross() {
		if(DomesticGross == null ) return ""; 
		return DomesticGross;
	}

	public void setDomesticGross(String domesticGross) {
		DomesticGross = domesticGross;
	}

	public String getWordWideGross() {
		if(WorldwideGross == null ) return ""; 
		return WorldwideGross;
	}

	public void setWorldwideGross(String wordWideGross) {
		this.WorldwideGross = wordWideGross;
	}

	public String getResume() {
		if(resume == null ) return ""; 
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getDirector() {
		if(director == null ) return ""; 
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	public List<String> getProducers() {
		return producers;
	}

	public void setProducers(List<String> producers) {
		this.producers = producers;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", genre=" + genre + ", distributor=" + distributor + ", releaseDate="
				+ releaseDate + ", productionBudget=" + productionBudget + ", DomesticGross=" + DomesticGross
				+ ", WorldwideGross=" + WorldwideGross + ", resume=" + resume + ", director=" + director + ", actors="
				+ actors + ", producers=" + producers + "]";
	}

	public Movie(String title, String genre, String distributor, String releaseDate, String productionBudget,
			String domesticGross, String worldwideGross, String resume, String director, List<String> actors,
			List<String> producers) {
		super();
		this.title = title;
		this.genre = genre;
		this.distributor = distributor;
		this.releaseDate = releaseDate;
		this.productionBudget = productionBudget;
		DomesticGross = domesticGross;
		WorldwideGross = worldwideGross;
		this.resume = resume;
		this.director = director;
		this.actors = actors;
		this.producers = producers;
	}

}
