/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programa07cc;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ruben
 */
public class DAODetalleVenta implements IDAOGeneral<DetalleVenta, Long> {

    @Override
    public DetalleVenta create(DetalleVenta p) {
        try ( Session session = HibernateUtil.getSession()) {

            Transaction t = session.beginTransaction();

            session.save(p);
            Logger.getLogger(DAODetalleVenta.class.getName()).log(Level.INFO, "Se guardó el detalle venta");

            t.commit();
            session.close();

        } catch (HibernateException ex) {
            Logger.getLogger(DAODetalleVenta.class.getName());

        }
        return p;
    }

    @Override
    public boolean delete(Long id) {
        boolean b = false;

        DetalleVenta detalleVenta = findByID(id);

        try ( Session session = HibernateUtil.getSession()) {

            Transaction t = session.beginTransaction();

            if (detalleVenta != null) {
                session.delete(detalleVenta);
                Logger.getLogger(DAOVenta.class.getName()).log(Level.INFO, "Se eliminó detalle venta");
                b = true;
            }

        } catch (HibernateException ex) {
            Logger.getLogger(DAODetalleVenta.class.getName());
        }

        return b;
    }

    @Override
    public DetalleVenta update(Long id, DetalleVenta p) {
        DetalleVenta detalleVenta;

        try ( Session session = HibernateUtil.getSession()) {

            Transaction t = session.beginTransaction();
            detalleVenta = findByID(id);
            if(detalleVenta != null && p.getClave() == id){
                session.update(p);
            }
            t.commit();
            session.close();

        } catch (HibernateException ex) {
            Logger.getLogger(DAODetalleVenta.class.getName());
        }

        return p;
    }

    @Override
    public List<DetalleVenta> findAll() {
        List<DetalleVenta> detalleVentas = null;
        try ( Session session = HibernateUtil.getSession()) {
            Transaction t = session.beginTransaction();
           
            detalleVentas = session.createQuery("from detalle_venta", DetalleVenta.class).list();
            t.commit();
            
            session.close();
            
            
        } catch (HibernateException ex) {
            Logger.getLogger(DAOVenta.class.getName());
        }
        return detalleVentas;
    }

    @Override
    public DetalleVenta findByID(Long id) {
        DetalleVenta detalleVenta = null;

        try ( Session session = HibernateUtil.getSession()) {
            Transaction t = session.beginTransaction();

            detalleVenta = session.get(DetalleVenta.class, id);

            t.commit();
            session.close();

        } catch (HibernateException ex) {
            Logger.getLogger(DAODetalleVenta.class.getName());
        }

        return detalleVenta;
    }
    
}
