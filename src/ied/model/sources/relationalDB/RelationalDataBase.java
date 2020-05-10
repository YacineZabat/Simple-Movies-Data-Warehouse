package ied.model.sources.relationalDB;

import java.sql.*;

import ied.model.business.Movie;


public class RelationalDataBase {
	Connection dbConnection;
	public RelationalDataBase() {
		 this.dbConnection = JdbcConnection.getConnection();
	}
	public Movie getMovie(String title) {
		try {
			title = inputSanitize(title);
			Movie movie = new Movie();
			String query1 =String.format("select *"
								+ " from movies where lower(movies.Movie) like lower('%%%s%%') ",title);
			String query2 =String.format("select * from  moviesbudget  where moviesbudget.Movie like lower('%%%s%%') ",title);

			ResultSet rs;
			Statement stmt = this.dbConnection.createStatement();
            rs = stmt.executeQuery(query1);
            if ( rs.next() ) {
                movie.setGenre(rs.getString("Genre"));
                movie.setDistributor(rs.getString("Distributor"));
            }
            rs = stmt.executeQuery(query2);
            if ( rs.next() ) {
                movie.setReleaseDate(rs.getString("Release Date"));
                movie.setProductionBudget(rs.getString("Production Budget"));
                movie.setWorldwideGross(rs.getString("Worldwide Gross"));
                movie.setDomesticGross(rs.getString("Domestic Gross"));
            }
            movie.setTitle(title);
			return movie;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String inputSanitize(String input) {
		input = input.replace("''", "").replace("'", "''").trim();
		return input;
	}

}
