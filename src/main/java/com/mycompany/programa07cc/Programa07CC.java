

package com.mycompany.programa07cc;

/**
 *
 * @author Ruben
 */
public class Programa07CC {

    public static void main(String[] args) {
        
        DAOVenta ventadao = new DAOVenta();
        DAODetalleVenta detalleDAO = new DAODetalleVenta();
        
        Venta venta1 = new Venta();
        venta1.setFecha("06/03/2023");
        ventadao.create(venta1);
        
        
        DetalleVenta detalleVenta1 = new DetalleVenta();
        detalleVenta1.setCantidad(2);
        detalleVenta1.setDescripcion("jugo 500ml");
        detalleVenta1.setPrecio(18);
        detalleVenta1.setVenta(venta1);
        detalleVenta1.setSubtotal();
        
        detalleDAO.create(detalleVenta1);
        
        DetalleVenta detalleVenta2 = new DetalleVenta();
        detalleVenta2.setCantidad(3);
        detalleVenta2.setDescripcion("papas");
        detalleVenta2.setPrecio(15);
        detalleVenta2.setVenta(venta1);
        detalleVenta2.setSubtotal();
        
        detalleDAO.create(detalleVenta1);
        detalleDAO.create(detalleVenta2);
        
        
        System.out.println("Hello World!");
    }
}
