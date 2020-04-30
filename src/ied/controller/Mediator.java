package ied.controller;

import java.util.HashMap;
import java.util.Map;

import ied.model.OpenMovieDataBase;
import ied.model.RelationalDataBase;
import ied.view.UserInterface;

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
