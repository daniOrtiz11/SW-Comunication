package swComunicacion;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jdom2.Document;         // |
import org.jdom2.Element;          // |\ Librerías
import org.jdom2.JDOMException;    // |/ JDOM
import org.jdom2.input.SAXBuilder; // |
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class TratarXML {
	
	private static HashMap<Integer,ArrayList<String>> results;
	private static ArrayList<String> lista;
	
	public static HashMap<Integer,ArrayList<String>> cargarXml()
	{
	    //Se crea un SAXBuilder para poder parsear el archivo
	    SAXBuilder builder = new SAXBuilder();
	    File xmlFile = new File( "tv.xml" );
	    try
	    {
	        //Se crea el documento a traves del archivo
	        Document document = (Document) builder.build( xmlFile );
	 
	        //Se obtiene la raiz 'peliculas'
	        Element rootNode = document.getRootElement();
	 
	        //Se obtiene la lista de hijos de la raiz 'peliculas'
	        List<Element> list = rootNode.getChildren( "peli" );
	        
	        results = new HashMap<Integer,ArrayList<String>>();
	        //Se recorre la lista de hijos de 'tables'
	        for ( int i = 0; i < list.size(); i++ )
	        {
	            //Se obtiene el elemento 'tabla'
	            Element peli = (Element) list.get(i);
//				Se obtiene el atributo 'nombre' que esta en el tag 'tabla'
//	            String nombreTabla = tabla.getAttributeValue("id");
//	            System.out.println( "Tabla: " + nombreTabla );
	           
	            lista = new ArrayList<String>();
	            
	            lista.add(peli.getChildTextTrim("titulo"));
	       	 
                //Se obtiene el valor que esta entre los tags '<director></director>'
                lista.add(peli.getChildTextTrim("director"));
 
                //Se obtiene el valor que esta entre los tags '<genero></genero>'
                lista.add(peli.getChildTextTrim("genero"));
                
                lista.add(peli.getChildTextTrim("imagen"));
 
                results.put(i, lista);
                //System.out.println( "\t"+titulo+"\t\t"+director+"\t\t"+genero);
	        }
	    }catch ( IOException io ) {
	        System.out.println( io.getMessage() );
	    }catch ( JDOMException jdomex ) {
	        System.out.println( jdomex.getMessage() );
	    }
	    return results;
	}
	
	public static boolean escribirXML(String args[]){
		//Si no se hace esto del principio y se crea directamente el elemento, el archivo .xml anterior no se 
		//mantiene y solo se guardaría esto último que estamos metiendolo.
			  try {
				  SAXBuilder builder = new SAXBuilder();
				    File xmlFile = new File( "tv.xml" );
				    try
				    {
				        Document document = (Document) builder.build( xmlFile );
				        Element rootNode = document.getRootElement();
				        rootNode.detach(); //Hay que hacer esto para desechar la relación.
				    
				Document doc = new Document();
				doc.setRootElement(rootNode);
		 
				Element peli = new Element("peli");
				peli.addContent(new Element("titulo").setText(args[0]));
				peli.addContent(new Element("director").setText(args[1]));
				peli.addContent(new Element("genero").setText(args[2]));
				peli.addContent(new Element("imagen").setText(args[3]));
				doc.getRootElement().addContent(peli);
		 
				// new XMLOutputter().output(doc, System.out);
				XMLOutputter xmlOutput = new XMLOutputter();
		 
				// display nice nice
				xmlOutput.setFormat(Format.getPrettyFormat());
				xmlOutput.output(doc, new FileWriter("tv.xml"));
				
				return true;
				
				}catch( JDOMException jdomex ) {
			        System.out.println( jdomex.getMessage() );
			        return false;
			    }
			  } catch (IOException io) {
				System.out.println(io.getMessage());
					return false;
			  }
	}
}
