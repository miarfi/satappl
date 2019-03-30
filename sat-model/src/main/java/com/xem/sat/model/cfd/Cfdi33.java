package com.xem.sat.model.cfd;

import com.xem.sat.model.dto.Comprobante;
import com.xem.sat.model.dao.FileCfdiDAO;
import com.xem.sat.model.dto.FileCfdi;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author miguel
 */
public class Cfdi33 {


    private static FileCfdiDAO fileCfdiDAO;  
     //   @Autowired
    private static AnnotationConfigApplicationContext context;
        
    public static void init() {
        context = new AnnotationConfigApplicationContext();
        context.scan("com.xem.sat.model");
        context.refresh();

        fileCfdiDAO = (FileCfdiDAO) context.getBean("fileCfdiDAO");
    }

    public Cfdi33() {
        init();        
    }
        
    public String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;        
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
    
    public String readFileFromAbsPath(String absolutePath){
        Class clazz = Cfdi33.class;
        InputStream inputStream = null;
        String xmlStr = null;
        
        try {
            inputStream = new FileInputStream(absolutePath);
            
//            if (inputStream != null) {
                xmlStr = readFromInputStream(inputStream);
                System.out.println(xmlStr);
//            }                    
        } catch (Exception e) {
                e.printStackTrace();
        }
//         finally {
//            inputStream.close();
//        }
        
        return xmlStr;
    }
    
    public String readFilesFromPath(String path) {
        final File folder = new File(path);
        String xmlStr = null;
        List<FileCfdi> fileCfdiList = new ArrayList<>();

        System.out.println("En readFilesFromPath");
        searchPath(".*\\.xml", folder, fileCfdiList);
       
        for (FileCfdi fileCfdi : fileCfdiList) {
            System.out.println("Path "+ fileCfdi.getPath());
            
            xmlStr = readFileFromAbsPath(fileCfdi.getPath());
            
            loadDom(xmlStr);                        
        }
        
        return "OK";
    }
            
    public void load(String xmlStr){
     JAXBContext jaxbContext;
        try
        {   
            System.out.println("En load");
            jaxbContext = JAXBContext.newInstance(Comprobante.class);             

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            Comprobante comprob = (Comprobante) unmarshaller.unmarshal(new StringReader(xmlStr));

            System.out.println(comprob);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
    
    public void loadDom(String xmlStr) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;

        try {
            builder = factory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new InputSource(new StringReader(xmlStr)));
            System.out.println("version " + doc.getXmlVersion());
            Element eElement = doc.getDocumentElement();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            System.out.println("version : " + eElement.getAttribute("version"));
            System.out.println("serie : " + eElement.getAttribute("serie"));
            System.out.println("folio : " + eElement.getAttribute("folio"));
            System.out.println("fecha : " + eElement.getAttribute("fecha"));

            NodeList nList = doc.getElementsByTagName("cfdi:Concepto");

            System.out.println("length ->" + nList.getLength());

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName() + " NodeType: " + nNode.getNodeType());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    //Element 
                    eElement = (Element) nNode;

                    System.out.println("cantidad : " + eElement.getAttribute("cantidad"));
                    System.out.println("descripcion : " + eElement.getAttribute("descripcion"));
                    System.out.println("valorUnitario : " + eElement.getAttribute("valorUnitario"));
                    System.out.println("importe : " + eElement.getAttribute("importe"));
//			System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
//			System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
//			System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
//			System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
        
    public static void searchPath(final String pattern, final File folder, List<FileCfdi> fileCfdiLst) {
        for (final File f : folder.listFiles()) {
            
            if (f.isDirectory()) {
                searchPath(pattern, f, fileCfdiLst);
            }
            
            if (f.isFile()) {
                if (f.getName().matches(pattern)) {
//                    result.add(f.getAbsolutePath());
                    FileCfdi fileCfdi = new FileCfdi();
                    fileCfdi.setFileName(f.getName());
                    fileCfdi.setPath(f.getPath());
                    fileCfdi.setFileSize((int) f.length()); 
                    fileCfdiLst.add(fileCfdi);

//                    fileCfdiDAO = (FileCfdiDAO) context.getBean("fileCfdiDAO");
//                    fileCfdiDAO.create(fileCfdi);
                }
            }            
        }
    }
}
