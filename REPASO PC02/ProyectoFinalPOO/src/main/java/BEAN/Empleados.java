package BEAN;
import java.util.Date;
public class Empleados {
    private int empleadoID;
    private String nombre;
    private String apellido;
    private String cargo;
    private Date fechaContratacion;
    private String telefono;
    private int estado;
    public Empleados() {
    }
    public Empleados(int empleadoID, String nombre, String apellido, String cargo, Date fechaContratacion, String telefono, int estado) {
        this.empleadoID = empleadoID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.fechaContratacion = fechaContratacion;
        this.telefono = telefono;
        this.estado = estado;
    }

    public int getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(int empleadoID) {
        this.empleadoID = empleadoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
