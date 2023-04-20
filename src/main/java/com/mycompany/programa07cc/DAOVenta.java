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
public class DAOVenta implements IDAOGeneral<Venta, Long>{

    @Override
    public Venta create(Venta p) {
         try ( Session session = HibernateUtil.getSession()) {

            Transaction t = session.beginTransaction();

            session.save(p);
            Logger.getLogger(DAOVenta.class.getName()).log(Level.INFO, "Se guardó la venta");

            t.commit();
            session.close();

        } catch (HibernateException ex) {
            Logger.getLogger(DAOVenta.class.getName());

        }
        return p;
    }

    @Override
    public boolean delete(Long id) {
        boolean b = false;

        Venta venta = findByID(id);

        try ( Session session = HibernateUtil.getSession()) {

            Transaction t = session.beginTransaction();

            if (venta != null) {
                session.delete(venta);
                Logger.getLogger(DAOVenta.class.getName()).log(Level.INFO, "Se eliminó la venta");
                b = true;
            }

        } catch (HibernateException ex) {
            Logger.getLogger(DAOVenta.class.getName());
        }

        return b;
    }

    @Override
    public Venta update(Long id, Venta p) {
        Venta venta;

        try ( Session session = HibernateUtil.getSession()) {

            Transaction t = session.beginTransaction();
            venta = findByID(id);
            if(venta != null && p.getClave() == id){
                session.update(p);
            }
            t.commit();
            session.close();

        } catch (HibernateException ex) {
            Logger.getLogger(DAOVenta.class.getName());
        }

        return p;
    }

    @Override
    public List<Venta> findAll() {
        List<Venta> ventas = null;
        try ( Session session = HibernateUtil.getSession()) {
            Transaction t = session.beginTransaction();
           
            ventas = session.createQuery("from Empleado", Venta.class).list();
            t.commit();
            
            session.close();
            
            
        } catch (HibernateException ex) {
            Logger.getLogger(DAOVenta.class.getName());
        }
        return ventas;
    }

    @Override
    public Venta findByID(Long id) {
        Venta venta = null;

        try ( Session session = HibernateUtil.getSession()) {
            Transaction t = session.beginTransaction();

            venta = session.get(Venta.class, id);

            t.commit();
            session.close();

        } catch (HibernateException ex) {
            Logger.getLogger(DAOVenta.class.getName());
        }

        return venta;
    }
    
    
    
}
