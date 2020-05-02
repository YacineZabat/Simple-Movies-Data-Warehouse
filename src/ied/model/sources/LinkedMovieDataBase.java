package ied.model.sources;

import java. util.ArrayList;
import java.util.List;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;


public class LinkedMovieDataBase {
	
	private final String prefix = "PREFIX owl: <http://www.w3.org/2002/07/owl#>" + 
    		"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" + 
    		"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" + 
    		"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" + 
    		"PREFIX foaf: <http://xmlns.com/foaf/0.1/>" + 
    		"PREFIX dc: <http://purl.org/dc/elements/1.1/>" + 
    		"PREFIX : <http://dbpedia.org/resource/>" + 
    		"PREFIX dbpedia2: <http://dbpedia.org/property/>" + 
    		"PREFIX dbpedia: <http://dbpedia.org/>" + 
    		"PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"+
    		"PREFIX dbo: <http://dbpedia.org/ontology/>"+
    		"PREFIX p: <http://dbpedia.org/property/> "; 
	
	
	public List<String> searchActorsByTitle(String title) {
		String req =   String.format("SELECT ?colname WHERE { ?film a dbo:Film ; foaf:name \"%s\"@en ; dbo:starring ?actor . ?actor foaf:name ?colname . }",title); 
		return executeQuery(req); 
	}
	public String searchDirectorByTitle(String title) {
		String req = String.format("SELECT ?colname WHERE { ?film a dbo:Film ; foaf:name \"%s\"@en ; dbo:director ?director . ?director foaf:name ?colname . }",title);
		ArrayList<String> res = (ArrayList<String>) executeQuery(req); 
		if(res.size() > 0)
			return res.get(0); 
		else
			return ""; 
	}
	public List<String> searchProducersByTitle(String title) {
		String req =   String.format("SELECT ?colname WHERE { ?film a dbo:Film ; foaf:name \"%s\"@en ; dbo:producer ?producer . ?producer foaf:name ?colname . }",title); 
		return executeQuery(req); 
	}
	
	public List<String> searchTitleByActor(String actor) {
		String req =   String.format("SELECT ?colname WHERE { ?film a dbo:Film ; foaf:name ?colname ; dbo:starring ?actor. ?actor foaf:name \"%s\"@en . }",actor); 
		return executeQuery(req); 
	}
	
	
	private List<String> executeQuery(String queryStr) {
		  // Remote execution.
		 Query query = QueryFactory.create(this.prefix + queryStr);
        try ( QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query) ) {
    		List<String> results = new ArrayList<String>(); 
            // Set the DBpedia specific timeout.
            ((QueryEngineHTTP)qexec).addParam("timeout", "10000") ;

            // Execute.
            ResultSet rs = qexec.execSelect();

            for ( ; rs.hasNext() ; )
            {
            	QuerySolution soln = rs.nextSolution() ;
                RDFNode x = soln.get("colname") ;       // Get a result variable by name.
                results.add(x.toString().split("@")[0].toString());           
            }
            return results; 

        } catch (Exception e) {
            e.printStackTrace();
            return null;  
        }
        
            
	}
	
	
}
