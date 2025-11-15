package DAO;

import BEAN.Cliente;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class ClienteDAO {

    public ClienteDAO() {
    }
    
    public Vector<Cliente> listaClientes(String cad){
        DbBean con;
        con = new DbBean();
        Vector<Cliente> listaClientes;
        listaClientes = new Vector<Cliente>();
        String sql;
        sql = "select * from Clientes";
        if(!cad.isEmpty()){
            sql = sql + " where apellido like '"+cad + "%' or nombre like '"+ cad +"%'";
        }
        try{
            ResultSet result;
            result = con.resultadoSQL(sql);
            while (result.next()){
                Cliente clin = new Cliente();
                clin.setClienteId(result.getInt(1));
                clin.setNombre(result.getString(2));
                clin.setApellido(result.getString(3));
                clin.setDireccion(result.getString(4));
                clin.setTelefono(result.getString(5));
                clin.setDni(result.getString(6));
                clin.setGenero(result.getInt(7));
                clin.setEstCivil(result.getInt(8));
                clin.setEstado(result.getInt(9));
                listaClientes.addElement(clin);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaClientes;
    }
    
    public void insertaCliente(Cliente clin){
        DbBean con = new DbBean();
        String sql;
        try{
            sql = "insert into Clientes values( ";
            sql += ""+ clin.getClienteId() +", ";
            sql += "'"+ clin.getNombre() +"', ";
            sql += "'"+ clin.getApellido() +"', ";
            sql += "'"+ clin.getDireccion() +"', ";
            sql += "'"+ clin.getTelefono() +"', ";
            sql += "'"+ clin.getDni() +"', ";
            sql += ""+ clin.getGenero() +", ";
            sql += ""+ clin.getEstCivil() +", ";
            sql += ""+ clin.getEstado() +") ";
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
    
    public void actualizaCliente(Cliente clin){
        DbBean con = new DbBean();
        String sql;
        try{
            sql = "update Clientes set ";
            sql += "Nombre = '"+ clin.getNombre() +"', ";
            sql += "Apellido = '"+ clin.getApellido() +"', ";
            sql += "Direccion = '"+ clin.getDireccion() +"', ";
            sql += "Telefono = '"+ clin.getTelefono() +"', ";
            sql += "DNI = '"+ clin.getDni() +"', ";
            sql += "Genero = "+ clin.getGenero() +", ";
            sql += "EstCivil = "+ clin.getEstCivil() +", ";
            sql += "Estado = "+ clin.getEstado() +" ";
            sql += " where ClienteID = "+ clin.getClienteId() +"";
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
    
    public void eliminaCliente(){
    }
}
