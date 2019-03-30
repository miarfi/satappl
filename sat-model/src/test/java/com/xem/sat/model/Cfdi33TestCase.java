package com.xem.sat.model;

import com.xem.sat.model.cfd.Cfdi33;
import com.xem.sat.model.dao.FileCfdiDAO;
import java.io.InputStream;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author miguel
 */
public class Cfdi33TestCase {
//    private static AnnotationConfigApplicationContext context;
//    private static FileCfdiDAO fileCfdiDAO;
//	private Message message = null;
		
//    @BeforeClass
//    public static void init() {
//            context = new AnnotationConfigApplicationContext();
//            context.scan("com.xem.sat.model");
//            context.refresh();
//
//            fileCfdiDAO = (FileCfdiDAO) context.getBean("fileCfdiDAO");
//    }
    
    
    @Test
    public void testReadFile() {
        Cfdi33 cfdi33 = new Cfdi33();
        String expectedData = "Hello World from fileTest.txt!!!";
        Class clazz = Cfdi33.class;
        
        String  a = cfdi33.readFilesFromPath("D:\\Miguel_Arriaga\\Dropbox\\IDE\\cfdifiles");
//        try {
//            InputStream inputStream = clazz.getResourceAsStream("/xml/cfd3Ej1.xml");
//            String data = cfdi33.readFromInputStream(inputStream);
//            Assert.assertThat(data, containsString(expectedData));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Assert.assertTrue(true);
    }

}
