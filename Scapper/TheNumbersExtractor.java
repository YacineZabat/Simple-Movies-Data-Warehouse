import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class TheNumbersExtractor {

    public static void main(String[] args) throws IOException {

        List<String> categopries = Arrays.asList("Adventure","Comedy","Drama","Action","Thriller-or-Suspense","Romantic-Comedy");


        for(String cat : categopries) // for each category
        {
            File file = new File("/Users/hakim/Documents/movies/"+cat+".csv");
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);

            //écriture du header
            String[] header = { "Movie","Distributor"};
            writer.writeNext(header);


            for (int j = 2000; j<=2015; j++) // for each year between 2000 and 2015
            {
                String url = "https://www.the-numbers.com/market/"+j+"/genre/"+cat;
                Document doc = Jsoup.parse(new URL(url).openStream(), "ISO-8859-1", url);

                Elements table = doc.select("body").select("#wrap").select("#main").select("#page_filling_chart").select("center").select("table").select("tr");
                String title  = "";
                String distributor  = "";

                for(int i = 0; i<table.size(); i++) // table iterate
                {
                    if(i == 0 || (i == table.size() - 1) || (i == table.size() - 2) )
                    {
                        continue;
                    }
                    else
                    {
                        title = table.get(i).select("td").get(1).text();
                        distributor = table.get(i).select("td").get(3).text();
                        String[] line = {title,distributor};
                        writer.writeNext(line);
                    }
                }
            }
            writer.close();
        }
    }
}
