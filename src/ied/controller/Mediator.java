package ied.controller;


import java.util.HashMap;

import ied.model.sources.OpenMovieDataBase;
import ied.model.sources.relationalDB.RelationalDataBase;

public class Mediator
{

	private OpenMovieDataBase openMovieDataBase;
	private RelationalDataBase relationalDataBase;
	
	public Mediator() 
	{
		openMovieDataBase = new OpenMovieDataBase();
		relationalDataBase = new RelationalDataBase();
	}
	
	public HashMap<String,String> searchMovie(String query)
	{
		String plot = openMovieDataBase.searchPlot(query);
		
		HashMap<String,String> movieData = new HashMap<>();
		movieData.put("plot",plot);
		
		return movieData;
	}
}

