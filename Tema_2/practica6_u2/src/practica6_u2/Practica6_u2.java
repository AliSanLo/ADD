package practica6_u2;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Practica6_u2 {

    public static void main(String[] args) {
        try {
            // Importamos los documentos, creamos el fichero en memoria y decimos donde está el XML
            DocumentBuilderFactory fabricaFich = DocumentBuilderFactory.newInstance();
            DocumentBuilder creaFich = fabricaFich.newDocumentBuilder();
            Document fichero = creaFich.parse("C:\\Users\\Alicia\\Documents\\NetBeansProjects\\practica6_u2\\src\\practica6_u2\\empleados.xml");

            // Obtenemos el elemento raíz
            Element raiz = fichero.getDocumentElement();

            // Obtenemos la lista de nodos que tiene la etiqueta empleado
            NodeList empleados = raiz.getElementsByTagName("EMPLEADO");

            // Recorremos la lista de empleados mediante un bucle for
            for (int i = 0; i < empleados.getLength(); i++) {
                // Obtenemos mediante el bucle un empleado tras otro
                Node empleado = empleados.item(i);
                System.out.println("Empleado " + i);

                // Obtenemos la lista de los datos que contiene ese empleado
                NodeList empleadodatos = empleado.getChildNodes();

                // Recorremos la lista de los datos que tiene el empleado
                for (int j = 0; j < empleadodatos.getLength(); j++) {
                    // Obtenemos la lista de los datos
                    Node dato = empleadodatos.item(j);

                    // Comprobamos que el dato se trata de un nodo del tipo Element
                    if (dato.getNodeType() == Node.ELEMENT_NODE) {
                        System.out.print(dato.getNodeName() + ": ");
                        // El valor está contenido en un hijo del nodo Element
                        Node contenidodato = dato.getFirstChild();

                        // Mostraremos el valor contenido en el nodo que debe ser del tipo Text
                        if (contenidodato != null && contenidodato.getNodeType() == Node.TEXT_NODE) {
                            System.out.println(contenidodato.getNodeValue());
                        }
                    }
                }
                System.out.println(); // Salto de línea entre empleado y empleado
            }
        } catch (SAXException ex) {
            System.out.print("Formato XML del fichero no es correcto \n " + ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error al leer el fichero \n " + ex.getMessage());
            ex.printStackTrace();
        } catch (ParserConfigurationException ex) {
            System.out.print("ERROR: No se ha podido crear el generador de documentos XML\n" + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
