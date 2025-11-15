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
            sql = sql + " where descEmpresa like '"+cad + "%' or RUC like '"+ cad +"%'";
        }
        try{
            ResultSet result;
            result = con.resultadoSQL(sql);
            while (result.next()){
                Empresa emp = new Empresa();
                emp.setEmpresaID(result.getInt(1));
                emp.setDescEmpresa(result.getString(2));
                emp.setRUC(result.getString(3));
                emp.setContacto(result.getString(4));
                emp.setTlfConta(result.getString(5));
                emp.setWeb(result.getString(6));
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
            sql += ""+ emp.getEmpresaID() +", ";
            sql += "'"+ emp.getDescEmpresa() +"', ";
            sql += "'"+ emp.getRUC() +"', ";
            sql += "'"+ emp.getContacto() +"', ";
            sql += "'"+ emp.getTlfConta() +"', ";
            sql += "'"+ emp.getWeb() +"') ";
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
            sql += "descEmpresa = '"+ emp.getDescEmpresa() +"', ";
            sql += "RUC = '"+ emp.getRUC() +"', ";
            sql += "contacto = '"+ emp.getContacto() +"', ";
            sql += "tlfConta = '"+ emp.getTlfConta() +"', ";
            sql += "web = '"+ emp.getWeb() +"' ";
            sql += " where EmpresaID = "+ emp.getEmpresaID() +"";
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
