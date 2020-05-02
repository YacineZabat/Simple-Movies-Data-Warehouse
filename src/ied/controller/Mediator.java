package ied.controller;

import java.util.ArrayList;
import ied.model.business.Movie;
import ied.model.sources.LinkedMovieDataBase;
import ied.model.sources.OpenMovieDataBase;
import ied.model.sources.relationalDB.RelationalDataBase;

public class Mediator
{
	private LinkedMovieDataBase linkedMovieDataBase; 
	private OpenMovieDataBase openMovieDataBase;
	private RelationalDataBase relationalDataBase;
	
	public Mediator() 
	{
		linkedMovieDataBase = new LinkedMovieDataBase(); 
		openMovieDataBase = new OpenMovieDataBase();
		relationalDataBase = new RelationalDataBase();
	}
	
	public Movie searchMovieByTitle(String title)
	{
		title = title.trim(); 
		Movie movie = relationalDataBase.getMovie(title.trim());
		movie.setProducers(linkedMovieDataBase.searchProducersByTitle(title));
		movie.setActors(linkedMovieDataBase.searchActorsByTitle(title));
		movie.setDirector(linkedMovieDataBase.searchDirectorByTitle(title));
		movie.setResume(openMovieDataBase.searchPlot(title));		
		return movie;
	}
	
	
	public ArrayList<Movie> searchMoviesByActor(String actor){
			
		actor = actor.trim(); 
		ArrayList<Movie> movies = new ArrayList<Movie>(); 
		ArrayList<String> titles = (ArrayList<String>) linkedMovieDataBase.searchTitleByActor(actor); 
		System.out.println(titles);
		
		for (String title : titles) {
			movies.add(this.searchMovieByTitle(title));
		}
		return movies; 
		
	}

	
}

