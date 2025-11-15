package DAO;

import BEAN.Empresa;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class EmpresaDAO {

    public EmpresaDAO() {
    }
    
    public Vector<Empresa> listaEmpresas(String cad){
        DbBean con;
        con = new DbBean();
        Vector<Empresa> listaEmpresas;
        listaEmpresas = new Vector<Empresa>();
        String sql;
        sql = "select * from Empresa";
        if(!cad.isEmpty()){
            sql = sql + " where RazoSoci like '"+cad + "%' or RUC like '"+ cad +"%'";
        }
        try{
            ResultSet result;
            result = con.resultadoSQL(sql);
            while (result.next()){
                Empresa emp = new Empresa();
                emp.setIDEmpresa(result.getInt(1));
                emp.setRazoSoci(result.getString(2));
                emp.setRUC(result.getString(3));
                emp.setDireccion(result.getString(4));
                emp.setTelefono(result.getString(5));
                emp.setEstado(result.getInt(6));
                listaEmpresas.addElement(emp);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaEmpresas;
    }
    
    public void insertaEmpresa(Empresa emp){
        DbBean con = new DbBean();
        String sql;
        try{
            sql = "insert into Empresa values( ";
            sql += ""+ emp.getIDEmpresa() +", ";
            sql += "'"+ emp.getRazoSoci() +"', ";
            sql += "'"+ emp.getRUC() +"', ";
            sql += "'"+ emp.getDireccion() +"', ";
            sql += "'"+ emp.getTelefono() +"', ";
            sql += ""+ emp.getEstado() +") ";
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
    
    public void actualizaEmpresa(Empresa emp){
        DbBean con = new DbBean();
        String sql;
        try{
            sql = "update Empresa set ";
            sql += "RazoSoci = '"+ emp.getRazoSoci() +"', ";
            sql += "RUC = '"+ emp.getRUC() +"', ";
            sql += "Direccion = '"+ emp.getDireccion() +"', ";
            sql += "Telefono = '"+ emp.getTelefono() +"', ";
            sql += "Estado = "+ emp.getEstado() +" ";
            sql += " where IDEmpresa = "+ emp.getIDEmpresa() +"";
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
    
    public void eliminaEmpresa(){
    }
}
