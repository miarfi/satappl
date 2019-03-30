
package com.xem.sat.model.dao;

import com.xem.sat.model.dto.FileCfdi;
import java.util.List;

/**
 *
 * @author arria
 */
public interface FileCfdiDAO {
    boolean create(FileCfdi activity);
    boolean update(FileCfdi activity);
    boolean delete(FileCfdi activity);
    
    List<FileCfdi> getActiveActivities();
    List<FileCfdi> getAllActivities();    
    FileCfdi getFileCfdiById(int id);
}