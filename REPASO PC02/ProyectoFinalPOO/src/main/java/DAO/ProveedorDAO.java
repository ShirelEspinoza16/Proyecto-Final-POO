package DAO;

import BEAN.Proveedor;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class ProveedorDAO {

    public ProveedorDAO() {
    }
    
    public Vector<Proveedor> listaProveedores(String cad){
        DbBean con;
        con = new DbBean();
        Vector<Proveedor> listaProveedores;
        listaProveedores = new Vector<Proveedor>();
        String sql;
        sql = "select * from Proveedores";
        if(!cad.isEmpty()){
            sql = sql + " where Nombre like '"+cad + "%' or NombreContacto like '"+ cad +"%'";
        }
        try{
            ResultSet result;
            result = con.resultadoSQL(sql);
            while (result.next()){
                Proveedor prov = new Proveedor();
                prov.setProveedorId(result.getInt(1));
                prov.setNombre(result.getString(2));
                prov.setNombreContacto(result.getString(3));
                prov.setDireccion(result.getString(4));
                prov.setCiudad(result.getString(5));
                prov.setTelefono(result.getString(6));
                prov.setEstado(result.getInt(7));
                listaProveedores.addElement(prov);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaProveedores;
    }
    
    public void insertaProveedor(Proveedor prov){
        DbBean con = new DbBean();
        String sql;
        try{
            sql = "insert into Proveedores values( ";
            sql += ""+ prov.getProveedorId() +", ";
            sql += "'"+ prov.getNombre() +"', ";
            sql += "'"+ prov.getNombreContacto() +"', ";
            sql += "'"+ prov.getDireccion() +"', ";
            sql += "'"+ prov.getCiudad() +"', ";
            sql += "'"+ prov.getTelefono() +"', ";
            sql += ""+ prov.getEstado() +") ";
            con.ejecutaSQL(sql);
        }catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void actualizaProveedor(Proveedor prov){
        DbBean con = new DbBean();
        String sql;
        try{
            sql = "update Proveedores set ";
            sql += "Nombre = '"+ prov.getNombre() +"', ";
            sql += "NombreContacto = '"+ prov.getNombreContacto() +"', ";
            sql += "Direccion = '"+ prov.getDireccion() +"', ";
            sql += "Ciudad = '"+ prov.getCiudad() +"', ";
            sql += "Telefono = '"+ prov.getTelefono() +"', ";
            sql += "estado = "+ prov.getEstado() +" ";
            sql += " where ProveedorID = "+ prov.getProveedorId() +"";
            con.ejecutaSQL(sql);
        }catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void eliminaProveedor(){
    }
}
