import java.util.LinkedList;
import java.util.List;

public class Lista {

    private List<Vehiculo> vehiculos;

    public Lista() {
        vehiculos = new LinkedList<>();
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public String listarVehiculos() {
        StringBuilder mensaje = new StringBuilder();
        for (Vehiculo v : vehiculos)
            mensaje.append(v).append("\n");
        return mensaje.toString();
    }

    public void adicionarVehiculos(Vehiculo vehiculo) throws Exception {
        if (vehiculos.isEmpty()) {
            vehiculos.add(vehiculo);
        } else {
            for (Vehiculo v : vehiculos) {
                if (v.getCodigo() == vehiculo.getCodigo()) {
                    throw new Exception("El vehiculo con este codigo ya existe");
                }
            }
            vehiculos.add(0, vehiculo);  // Agregar al inicio de la lista
        }
    }

    public Vehiculo buscarPersona(int codigo) {
        for (Vehiculo v : vehiculos) {
            if (v.getCodigo() == codigo) {
                return v;
            }
        }
        return null;
    }

    public float sumarTotalPrecioPorMarca(String marca) {
        return totalPrecio(marca, 0);
    }

    private float totalPrecio(String marca, int indice) {
        if (indice >= vehiculos.size()) {
            return 0;
        }
        Vehiculo vehiculo = vehiculos.get(indice);
        if (vehiculo.getMarca().equals(marca)) {
            return vehiculo.getPrecio() + totalPrecio(marca, indice + 1);
        } else {
            return totalPrecio(marca, indice + 1);
        }
    }

    public List<Vehiculo> filtrarYOrdenarVehiculosPorMarca(String marca) {
        List<Vehiculo> filtrados = new LinkedList<>();
        for (Vehiculo v : vehiculos) {
            if (!v.getMarca().equals(marca)) {
                filtrados.add(v);
            }
        }


        // Ordenar por burbuja
        int n = filtrados.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (filtrados.get(j).getCilindraje() > filtrados.get(j + 1).getCilindraje()) {
                    // Intercambiar
                    Vehiculo temp = filtrados.get(j);
                    filtrados.set(j, filtrados.get(j + 1));
                    filtrados.set(j + 1, temp);
                }
            }
        }
        return filtrados;
    }
}


