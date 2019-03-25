package com.xem.sat.model;

import com.xem.sat.model.cfdi.Cfdi33;
import java.io.InputStream;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author miguel
 */
public class Cfdi33Test {

    @Test
    public void testReadFile() {
        Cfdi33 cfdi33 = new Cfdi33();
        String expectedData = "Hello World from fileTest.txt!!!";
        Class clazz = Cfdi33.class;
        
        String  a = cfdi33.readFilesFromPath("a");
        try {
            InputStream inputStream = clazz.getResourceAsStream("/xml/cfd3Ej1.xml");
            String data = cfdi33.readFromInputStream(inputStream);
            Assert.assertThat(data, containsString(expectedData));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
