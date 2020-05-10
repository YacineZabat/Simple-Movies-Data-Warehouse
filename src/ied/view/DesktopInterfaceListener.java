package ied.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import ied.controller.Mediator;
import ied.model.business.Movie;

public class DesktopInterfaceListener implements ActionListener, ListSelectionListener {
	DesktopInterface welcome; 
	ArrayList<Movie> movies; 
	Mediator mediator; 
	
	public DesktopInterfaceListener(DesktopInterface w) {
		this.welcome = w;
		this.movies = new ArrayList<Movie>(); 
		this.mediator = new Mediator(); 
	}
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// execute
		if (e.getSource() == welcome.getjSearch())
		{
			String input = welcome.getjUserInput().trim(); 
			this.init();

			if(welcome.getjRequestType().getSelectedIndex() == 0) {
				this.movies.add(this.mediator.searchMovieByTitle(input)); 
			}
			if(welcome.getjRequestType().getSelectedIndex() == 1) {
				this.movies = this.mediator.searchMoviesByActor(input); 
			}
		
			displayMoviesInformation(); 
		}
		//change event request 
		else if (e.getSource() == welcome.getjRequestType())
		{
			if(welcome.getjRequestType().getSelectedIndex() == 0) 
				this.welcome.setjUserInput(""); 
			
			else if(welcome.getjRequestType().getSelectedIndex() == 1) 
				this.welcome.setjUserInput("Titre de film"); 
			
			else if(welcome.getjRequestType().getSelectedIndex() == 2)
				this.welcome.setjUserInput("Nom de l'acteur"); 
		}
		
	}
	// afficher la liste des films dans la table
	private void displayMoviesInformation() {
		// vider l'interface
		
		if(this.movies.size() == 0) return; 
		
		for (Movie movie : this.movies) {
			String[] row = new String[]{
					movie.getTitle(),
					movie.getReleaseDate(),
					movie.getGenre(),
					movie.getDistributor(),
					movie.getProductionBudget(),
					movie.getDirector(),
					movie.getDomesticGross(),
					movie.getWordWideGross()}; 
			insertRow(welcome.getjMoviesTable(),row);
		}
		
		// afficher le resumé et la liste des acteurs le cas d'un seul film 
		if(this.movies.size() == 1) {
			Movie m = movies.get(0) ;
			welcome.setjResume(m.getResume());
			displayActors(m.getActors());
			displayProducers(m.getProducers()); 
		}
	}

	private void displayProducers(List<String> producers) {
		
		for (String producer : producers) {
			String[] row = new String[] {producer}; 
			insertRow(welcome.getjProducersTable(), row);
		}
	}

	private void displayActors(List<String> actors) {

		for (String actor : actors) {
			String[] row = new String[] {actor}; 
			insertRow(welcome.getjActorsTable(), row);
		}		
	}

	// selected movie
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
	    if (e.getSource() == welcome.getjMoviesTable().getSelectionModel() && welcome.getjMoviesTable().getRowSelectionAllowed()) {
			int selected = welcome.getjMoviesTable().getSelectedRow(); 
			if(selected < 0 )
			{
				return;
			}
			tableDeleteAllRows(welcome.getjActorsTable());
			tableDeleteAllRows(welcome.getjProducersTable());
			Movie m = this.movies.get(selected); 
		    this.displayActors(m.getActors());
		    this.displayProducers(m.getProducers());
		    welcome.setjResume(m.getResume());
	    }
	}
	
	private void tableDeleteAllRows(JTable table) {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		//Remove rows one by one from the end of the table
		for (int i = dm.getRowCount() - 1; i >= 0; i--) {
		    dm.removeRow(i);
		}
	}
	
	private void insertRow(JTable table, String[] row) {
	    DefaultTableModel t = (DefaultTableModel) table.getModel();
	    Vector<String> v = new Vector<String>(Arrays.asList(row)) ; 
	    t.insertRow(table.getRowCount(),  v);
	}
	private void init() {
		tableDeleteAllRows(welcome.getjMoviesTable());
		tableDeleteAllRows(welcome.getjActorsTable());		
		tableDeleteAllRows(welcome.getjProducersTable());
		welcome.setjResume("");
		movies.clear();
	}
}
