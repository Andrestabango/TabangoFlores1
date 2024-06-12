public class Vehiculo {

    private int codigo;
    private String marca;
    private int cilindraje;
     private float precio;

    public Vehiculo(int codigo, String marca, int cilindraje, float precio) {
        this.codigo = codigo;
        this.marca = marca;
        this.cilindraje = cilindraje;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString(){
        return  "\nCodigo: "+ codigo+
                "\nMarca: "+ marca+
                "\nCilindraje: "+ cilindraje+
                "\nPrecio: "+ precio;
    }


}
