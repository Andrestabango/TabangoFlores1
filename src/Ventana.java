import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Ventana {
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField1codigo;
    private JList list1;
    private JButton agregarVehiculoButton;
    private JTextField textField2precio;
    private JPanel Ventana;
    private JTabbedPane tabbedPane1;
    private JComboBox comboBox3;
    private JButton ordenarButton;
    private JList list2;
    private JButton calcularPrecioPorMarcaButton;

    private Lista vehiculos =new Lista();

    public Ventana(){
        quemarDatos();
        llenarJlist();

        agregarVehiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vehiculos.adicionarVehiculos( new Vehiculo(Integer.parseInt(textField1codigo.getText()),comboBox1.getSelectedItem().toString(),Integer.parseInt(comboBox2.getSelectedItem().toString()),Float.parseFloat(textField2precio.getText())));
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
                 llenarJlist();
            }
        });


        ordenarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marcaSeleccionada = (String) comboBox3.getSelectedItem();
                List<Vehiculo> vehiculosFiltrados = vehiculos.filtrarYOrdenarVehiculosPorMarca(marcaSeleccionada);
                llenarJlistFiltrada(vehiculosFiltrados);
            }
        });
        calcularPrecioPorMarcaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marcaSeleccionada = (String) comboBox3.getSelectedItem();
                float totalPrecio = vehiculos.sumarTotalPrecioPorMarca(marcaSeleccionada);
                JOptionPane.showMessageDialog(null, "El total del precio de los vehículos de la marca " + marcaSeleccionada + " es: " + totalPrecio);
            }
        });
    }
    public void llenarJlist(){
        DefaultListModel dlm= new DefaultListModel<>();
        dlm.removeAllElements();
        for(Vehiculo v: vehiculos.getVehiculos()){
            dlm.addElement(v);
        }
        list1.setModel(dlm);
    }

    public void llenarJlistFiltrada(List<Vehiculo> vehiculosFiltrados) {
        DefaultListModel<Vehiculo> dlm = new DefaultListModel<>();
        dlm.removeAllElements();
        for (Vehiculo v : vehiculosFiltrados) {
            dlm.addElement(v);
        }
        list2.setModel(dlm);
    }


    public void quemarDatos(){
        try{
            vehiculos.adicionarVehiculos(new Vehiculo(1,"KIA",1300, 28.999F));
            vehiculos.adicionarVehiculos(new Vehiculo(2,"BMW",1600, 50.999F));
            vehiculos.adicionarVehiculos(new Vehiculo(3,"TOYOTA",2000, 40.999F));
            vehiculos.adicionarVehiculos(new Vehiculo(4,"JAC",24000, 22.000F));
            vehiculos.adicionarVehiculos(new Vehiculo(5,"CHEVROLET",2700, 22.000F));
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
