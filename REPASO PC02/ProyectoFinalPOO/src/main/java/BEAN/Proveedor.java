package BEAN;
public class Proveedor {
    private int proveedorId;
    private String nombre;
    private String nombreContacto;
    private String direccion;
    private String ciudad;
    private String telefono;
    private int estado;

    public Proveedor() {
    }

    public Proveedor(int proveedorId, String nombre, String nombreContacto, String direccion, String ciudad, String telefono, int estado) {
        this.proveedorId = proveedorId;
        this.nombre = nombre;
        this.nombreContacto = nombreContacto;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.estado = estado;
    }

    public int getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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
