
package com.xem.sat.model;

import com.xem.sat.model.dao.FileCfdiDAO;
import com.xem.sat.model.dto.FileCfdi;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author arria
 */
public class FileCfdiTestCase {
    private static AnnotationConfigApplicationContext context;
    private static FileCfdiDAO fileCfdiDAO;
    private FileCfdi fileCfdi = null;

    @BeforeClass
    public static void init() {
            context = new AnnotationConfigApplicationContext();
            context.scan("com.xem.sat.model");
            context.refresh();

            fileCfdiDAO = (FileCfdiDAO) context.getBean("fileCfdiDAO");
    }
    
    @Test    
    public void testFileCfdi()
    {
        fileCfdi = new FileCfdi();
        
        fileCfdi.setFileName("archivo.txt");
        fileCfdi.setPath("C://file_path");
        fileCfdi.setFileSize(100);
        fileCfdi.setStatusCode(0);
//        fileCfdi.setStatusMessage("NEW");
//        fileCfdi.setCfdiVersion("3.3"); 
        assertEquals("Failed to add person!", true,  fileCfdiDAO.create(fileCfdi));
    }
}
