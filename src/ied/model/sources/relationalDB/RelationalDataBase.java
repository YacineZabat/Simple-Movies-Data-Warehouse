package ied.model.sources.relationalDB;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import ied.model.business.Movie;


public class RelationalDataBase {


	public Movie getMovie(String title) {		
		try {
			
			Movie movie = new Movie(); 
			String query =String.format("select * from movies where Movie = '%s'",title);
			Connection dbConnection = JdbcConnection.getConnection();
			Statement stmt = dbConnection.createStatement(); 
			ResultSet rs;
			 
            rs = stmt.executeQuery(query);
            if ( rs.next() ) {
                movie.setGenre(rs.getString("Genre"));
                movie.setTitle(rs.getString("Movie"));
                movie.setDistributor(rs.getString("Distributor"));   
                
                movie.setReleaseDate(rs.getString("Release Date"));
                movie.setProductionBudget(rs.getString("Production Budget"));
                movie.setWorldwideGross(rs.getString("Worldwide Gross"));
                movie.setDomesticGross(rs.getString("Domestic Gross"));
            }
    		dbConnection.close();
			return movie; 
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 
	}
	public static void main(String[] args) {
		RelationalDataBase rd = new RelationalDataBase(); 
		rd.getMovie("Chicken Run"); 
	}

}
