package com.xem.sat.model.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
/**
 *
 * @author arria
 */
@Component
@Entity
@Table(name = "FILE_CFDI")
public class FileCfdi implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FILE_CFDI_ID")
    private int fileCfdiId;
    @Column(name = "PATH")
    private String _path;
    @Basic(optional = false)
    @Column(name = "FILE_NAME")
    private String fileName;
    @Column(name = "FILE_EXTENSION")
    private String fileExtension;  
    @Column(name = "FILE_SIZE")
    private int fileSize;  
    @Column(name = "CFDI_VERSION")
    private String cfdiVersion;   
    @Column(name = "uuid")
    private String uuid;  
    @Column(name = "XSD_VALID")    
    private boolean xsdValid;
    @Column(name = "CFDI_VALID")
    private boolean cfdiValid;
    @Column(name = "STATUS_CODE")
    private int statusCode;   
    @Column(name = "STATUS_MESSAGE")
    private String statusMessage;
    @Column(name = "IS_ACTIVE")
    private boolean active;
    @Temporal(javax.persistence.TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "CREATION_DATE")
    private Date creationDate;

    public FileCfdi() {
        this.creationDate = new java.sql.Date(System.currentTimeMillis());
        this.active = true;
        this.statusCode = 0;
        this.statusMessage = "NEW";
    }
    
    public int getFileCfdiId() {
        return fileCfdiId;
    }

    public void setFileCfdiId(int fileCfdiId) {
        this.fileCfdiId = fileCfdiId;
    }

    public String getPath() {
        return _path;
    }

    public void setPath(String path) {
        this._path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    
    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getCfdiVersion() {
        return cfdiVersion;
    }

    public void setCfdiVersion(String cfdiVersion) {
        this.cfdiVersion = cfdiVersion;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isXsdValid() {
        return xsdValid;
    }

    public void setXsdValid(boolean xsdValid) {
        this.xsdValid = xsdValid;
    }

    public boolean isCfdiValid() {
        return cfdiValid;
    }

    public void setCfdiValid(boolean cfdiValid) {
        this.cfdiValid = cfdiValid;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "FileCfdi{" + "id=" + fileCfdiId + ", path=" + _path + ", fileName=" + fileName + ", fileSize=" + fileSize + ", cfdiVersion=" + cfdiVersion + ", xsdValid=" + xsdValid + ", cfdiValid=" + cfdiValid + ", statusCode=" + statusCode + ", statusMessage=" + statusMessage + ", creationDate=" + creationDate + '}';
    }

    public void getStatusCode(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
}