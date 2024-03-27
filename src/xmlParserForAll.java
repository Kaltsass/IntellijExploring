import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
public class xmlParserForAll {

        public static void main (String [] args){
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            try {

                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(new File("C:\\Users\\lange\\IdeaProjects\\tests\\xmlParserForAll\\src\\file.xml"));
                document.getDocumentElement().normalize();

                NodeList List = document.getElementsByTagName("child");
                for (int i= 0; i<List.getLength(); i++) {
                    Node child = List.item(i);

                    if(child.getNodeType() == Node.ELEMENT_NODE){
                        Element childElement = (Element) child;
                        System.out.println("Element Name:" + childElement.getAttribute("x"));
                    }


                    NodeList ListDetails = document.getElementsByTagName("childs_element");
                    for (int j = 0; j < ListDetails.getLength(); j++) {
                        Node childs_element = ListDetails.item(j);
                        if(childs_element.getNodeType()== Node.ELEMENT_NODE){
                            Element childs_element_element = (Element) childs_element;
                            System.out.println("         " + childs_element_element.getTagName() + ":" + childs_element_element.getAttribute("x2"));
                        }
                    }
                }



            } catch (ParserConfigurationException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (SAXException e) {
                throw new RuntimeException(e);
            }



        }
}
