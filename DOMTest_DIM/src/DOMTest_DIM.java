import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class DOMTest_DIM {

	public static void main(String[] args) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document c = db.parse("class.xml");
			NodeList studentList = c.getElementsByTagName("student");
			for(int i=0; i<studentList.getLength(); i++){
				Node student = studentList.item(i);
				NamedNodeMap attrs = student.getAttributes();
				for(int j=0; j<attrs.getLength(); j++){
					Node attr = attrs.item(j);
					System.out.print("属性名："+attr.getNodeName());
					System.out.println("属性值：" + attr.getNodeValue());
				}
				
				NodeList childNodes = student.getChildNodes();
				for(int k = 0; k<childNodes.getLength(); k++){
					if(childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
						System.out.print(childNodes.item(k).getNodeName() + "--->");
						System.out.println(childNodes.item(k).getFirstChild().getNodeValue());
					}
				}
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
