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
	private List<String> produces; 
	
	public Movie() {
		this.actors = new ArrayList<String>(); 
		this.produces = new ArrayList<String>(); 
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getProductionBudget() {
		return productionBudget;
	}

	public void setProductionBudget(String productionBudget) {
		this.productionBudget = productionBudget;
	}

	public String getDomesticGross() {
		return DomesticGross;
	}

	public void setDomesticGross(String domesticGross) {
		DomesticGross = domesticGross;
	}

	public String getWordWideGross() {
		return WorldwideGross;
	}

	public void setWorldwideGross(String wordWideGross) {
		this.WorldwideGross = wordWideGross;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getDirector() {
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

	public List<String> getProduces() {
		return produces;
	}

	public void setProduces(List<String> produces) {
		this.produces = produces;
	}
}
