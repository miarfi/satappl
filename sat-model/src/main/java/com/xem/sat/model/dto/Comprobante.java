
package com.xem.sat.model.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

/**
 *
 * @author miguel
 */
@Component
@Entity
@Table(name = "FILE_CFDI")
public class Comprobante implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPROBANTE_ID")
    private long comprobanteId;  
    @Column(name = "VERSION")
    private String version;
    @Column(name = "SERIE")
    private String serie;
    @Column(name = "FOLIO")
    private String folio;
    @Column(name = "FECHA")
    private String fecha;
    @Column(name = "SELLO")
    private String sello;
    @Column(name = "FORMA_PAGO")
    private String formaPago;
    @Column(name = "NO_CERTIFICADO")
    private String noCertificado;
    @Column(name = "CERTIFICADO")
    private String certificado;
    @Column(name = "CONDICIONES_PAGO")
    private String condicionesDePago;
    @Column(name = "SUBTOTAL")
    private double subTotal;
    @Column(name = "DESCUENTO")
    private String descuento;
    @Column(name = "MONEDA")
    private String moneda;
    @Column(name = "TIPO_CAMBIO")
    private String tipoCambio;
    @Column(name = "TOTAL")
    private double total;
    @Column(name = "TIPO_COMPROBANTE")
    private String tipoDeComprobante;
    @Column(name = "METODO_PAGO")
    private String metodoPago;
    @Column(name = "LUGAR_EXPEDICION")
    private String lugarExpedicion;
    @Column(name = "CONFIRMACION")
    private String confirmacion;
}
