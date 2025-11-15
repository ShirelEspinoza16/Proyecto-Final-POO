package DAO;

import BEAN.Cliente;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class EmpleadosDAO {
        Empleado  = new Vector();
    }
    
    public Vector<Empleado> listaEmpleado(String cad){
        DbBean con;
        con = new DbBean();
        Vector<Empleado> listaEmpleados;
        listaEmpleados = new Vector<Empleado>();
        String sql; // Se crea recien el sql que se enviara a ejecutar
        sql = "select * from Cliente";
        if(!cad.isEmpty()){
            sql = sql + " where apellidos like '"+cad + "%' or nombres like '"+ cad +"%'";
        }
        try{
            ResultSet result;
            result = con.resultadoSQL(sql);
            while (result.next()){
                Empleado emp = new Empleado();
                emp.setEmpleadoID(result.getInt(1));
                emp.setNombre(result.getString(2));
                emp.setApellido(result.getString(3));
                emp.setCargo(result.getString(4));
                emp.setFechaContratacion(result.getString(5));
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
