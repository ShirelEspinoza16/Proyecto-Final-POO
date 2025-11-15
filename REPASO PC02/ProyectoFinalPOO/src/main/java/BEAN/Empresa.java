package BEAN;
public class Empresa {
    private int IDEmpresa;
    private String RazoSoci;
    private String RUC;
    private String Direccion;
    private String Telefono;
    private int Estado;

    public Empresa() {
    }

    public Empresa(int IDEmpresa, String RazoSoci, String RUC, String Direccion, String Telefono, int Estado) {
        this.IDEmpresa = IDEmpresa;
        this.RazoSoci = RazoSoci;
        this.RUC = RUC;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Estado = Estado;
    }

    public int getIDEmpresa() {
        return IDEmpresa;
    }

    public void setIDEmpresa(int IDEmpresa) {
        this.IDEmpresa = IDEmpresa;
    }

    public String getRazoSoci() {
        return RazoSoci;
    }

    public void setRazoSoci(String RazoSoci) {
        this.RazoSoci = RazoSoci;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }
    
    
}
