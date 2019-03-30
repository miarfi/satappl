
package com.xem.sat.model.cfd.v33;

import java.io.Serializable;

/**
 *
 * @author miguel
 */
public class Traslado implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private String base;
    private String impuesto;
    private String tipoFactor;
    private double tasaOCuota;
    private double importe;
}
