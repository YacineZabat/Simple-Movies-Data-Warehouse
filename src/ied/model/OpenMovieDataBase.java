package ied.model;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

public class OpenMovieDataBase 
{

    private static final String API_KEY = "c57dce32";
    private XPath xpath;
    private final XPathFactory xfabrique;
    private final DocumentBuilderFactory fabrique;
    private Document document;

    public OpenMovieDataBase()
    {
        this.fabrique = DocumentBuilderFactory.newInstance();
        this.xfabrique = XPathFactory.newInstance();
    }

    public String searchPlot(String title) {
        try{
            DocumentBuilder parseur = fabrique.newDocumentBuilder();
            this.document = parseur.parse("http://www.omdbapi.com/?t="+title+"&apikey=" + API_KEY + "&r=xml");
        }
        catch (Exception e )
        {
            e.printStackTrace();
        }
        this.xpath = xfabrique.newXPath();
        return getPlot();
    }

    private String getPlot()
    {
        try
        {
            XPathExpression exp = xpath.compile("/root/movie/@plot");
            return (String) exp.evaluate(document, XPathConstants.STRING);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
