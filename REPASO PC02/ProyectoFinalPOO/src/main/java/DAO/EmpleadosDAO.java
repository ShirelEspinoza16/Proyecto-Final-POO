package DAO;

import BEAN.Empleados;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class EmpleadosDAO {
     Vector Empleado;

    public EmpleadosDAO() {
        Empleado  = new Vector();
    }
    
    public Vector<Empleados> listaEmpleado(String cad){
        DbBean con;
        con = new DbBean();
        Vector<Empleados> listaEmpleados;
        listaEmpleados = new Vector<Empleados>();
        String sql; // Se crea recien el sql que se enviara a ejecutar
        sql = "select * from Cliente";
        if(!cad.isEmpty()){
            sql = sql + " where apellidos like '"+cad + "%' or nombres like '"+ cad +"%'";
        }
        try{
            ResultSet result;
            result = con.resultadoSQL(sql);
            while (result.next()){
                Empleados emp = new Empleados();
                emp.setEmpleadoID(result.getInt(1));
                emp.setNombre(result.getString(2));
                emp.setApellido(result.getString(3));
                emp.setCargo(result.getString(4));
                emp.setFechaContratacion(result.getDate(5));
                emp.setTelefono(result.getString(6));
                emp.setEstado(result.getInt(7));
                listaEmpleados.addElement(emp);
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        try{
            con.desconecta();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
        }
        return listaEmpleados;
    } 
}
