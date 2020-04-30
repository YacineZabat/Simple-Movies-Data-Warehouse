package ied.model;


import java.util.List;

import ied.model.LinkedMovieDataBase;

public class Main {
    static public void main(String...argv) {

        LinkedMovieDataBase lMDB = new LinkedMovieDataBase();  
        //List<String> res = lMDB.getProducersByTitle("Ed Wood"); 
        List<String> res = lMDB.getTitleByActor("Johnny Depp"); 

        System.out.println(res);
    }
}