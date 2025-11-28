package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class ModificarUI extends AgregarUI{
    public JButton btnbuscar;
    public JButton btnmodificar;
    
    private JLabel codigo;
    public JTextField txtcodigo;
    public JTextArea txtdescripcion;
    public JLabel vistaImagen;
    
    private JLabel lnombre;
    private JLabel ltalla;
    private JLabel lsexo;
    private JLabel lprecio;
    private JLabel lmarca;
    private JLabel lproveedor;
    private JLabel lcodigo;
    private JLabel lcaracteristicas;
    private JLabel lcantidad;

    Color rojo = new Color(25, 68, 241); 
    Color LionB = new Color(245, 243, 243); 

    public ModificarUI(){
        btnmodificar = new JButton();
        setTitle("Modificar producto");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        
        setSize(820, 700); 
        setResizable(true);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(LionB);
    }
    
    public void contenedormodi(){
        
        codigo = new JLabel("CODIGO:");
        codigo.setForeground(rojo);
        codigo.setFont(new Font("Arial", Font.BOLD, 16));
        codigo.setBounds(20, 20, 80, 24);
        add(codigo);
        
        txtcodigo = new JTextField("");
        txtcodigo.setBounds(110, 20, 180, 28);
        txtcodigo.setFont(new Font("Arial", Font.PLAIN, 14));
        add(txtcodigo);
        
        btnbuscar = new JButton("Buscar");
        btnbuscar.setBounds(300, 20, 110, 28);
        btnbuscar.setBackground(rojo);
        btnbuscar.setForeground(LionB);
        btnbuscar.setFocusPainted(false);
        add(btnbuscar);
        

        vistaImagen = new JLabel("Previsualización");
        vistaImagen.setBounds(520, 60, 240, 180);
        vistaImagen.setOpaque(true);
        vistaImagen.setBackground(new Color(230,230,230));
        vistaImagen.setBorder(BorderFactory.createLineBorder(rojo, 2));
        vistaImagen.setHorizontalAlignment(SwingConstants.CENTER);
        vistaImagen.setFont(new Font("Arial", Font.PLAIN, 12));
        add(vistaImagen);
        

        txtdescripcion = new JTextArea();
        txtdescripcion.setLineWrap(true);
        txtdescripcion.setWrapStyleWord(true);
        txtdescripcion.setBackground(LionB);
        txtdescripcion.setForeground(rojo);
        txtdescripcion.setFont(new Font("Arial", Font.PLAIN, 14));
        txtdescripcion.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtdescripcion);
        scroll.setBounds(520, 260, 240, 360);
        scroll.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(rojo), "Descripción"));
        add(scroll);
    }
    public void modifi(){

        int x = 20;
        int labelW = 120;
        int fieldX = x + labelW + 10;
        int fieldW = 360;
        int y = 70; 
        int gap = 46;

        lnombre = new JLabel("NOMBRE:");
        lnombre.setForeground(rojo);
        lnombre.setFont(new Font("Arial", Font.BOLD, 14));
        lnombre.setBounds(x, y, labelW, 24);
        txtNombre = new JTextField();
        txtNombre.setBounds(fieldX, y, fieldW, 30);
        add(lnombre);
        add(txtNombre);
        y += gap;

        ltalla = new JLabel("TALLA:");
        ltalla.setForeground(rojo);
        ltalla.setFont(new Font("Arial", Font.BOLD, 14));
        ltalla.setBounds(x, y, labelW, 24);
        comboTalla = new JComboBox<>();
        comboTalla.setBounds(fieldX, y, 180, 30);

        String[] tallas1 = {"Seleccione talla", "XS", "S", "M", "L", "XL"};
        String[] tallas2 = {"Seleccione talla", "15","16","17","18","19","20","21","22","23","24","25","26","27"};

        comboTalla=new JComboBox();
        comboTalla.setBounds(fieldX, y, 180, 30);
        add(ltalla);
        add(comboTalla);

        
        y += gap;
        

        lsexo = new JLabel("SEXO:");
        lsexo.setForeground(rojo);
        lsexo.setFont(new Font("Arial", Font.BOLD, 14));
        lsexo.setBounds(x, y, labelW, 24);
        comboSexo = new JComboBox<>();
        comboSexo.setBounds(fieldX, y, 180, 30);
        String[] sexos = {"Seleccione", "Masculino", "Femenino", "Unisex"};
        for (String sexo : sexos) comboSexo.addItem(sexo);
        add(lsexo);
        add(comboSexo);
        y += gap;

        lprecio = new JLabel("PRECIO:");
        lprecio.setForeground(rojo);
        lprecio.setFont(new Font("Arial", Font.BOLD, 14));
        lprecio.setBounds(x, y, labelW, 24);
        campoPrecio = new JTextField("");
        campoPrecio.setBounds(fieldX, y, 120, 30);
        add(lprecio);
        add(campoPrecio);
        y += gap;

        lmarca = new JLabel("MARCA:");
        lmarca.setForeground(rojo);
        lmarca.setFont(new Font("Arial", Font.BOLD, 14));
        lmarca.setBounds(x, y, labelW, 24);
        campoMarca = new JTextField();
        campoMarca.setBounds(fieldX, y, 200, 30);
        add(lmarca);
        add(campoMarca);
        y += gap;

        lproveedor = new JLabel("PROVEEDOR:");
        lproveedor.setForeground(rojo);
        lproveedor.setFont(new Font("Arial", Font.BOLD, 14));
        lproveedor.setBounds(x, y, labelW, 24);
        campoProveedor = new JTextField();
        campoProveedor.setBounds(fieldX, y, 200, 30);
        add(lproveedor);
        add(campoProveedor);
        y += gap;

        lcodigo = new JLabel("CODIGO:");
        lcodigo.setForeground(rojo);
        lcodigo.setFont(new Font("Arial", Font.BOLD, 14));
        lcodigo.setBounds(x, y, labelW, 24);
        campoCodigo = new JTextField();
        campoCodigo.setBounds(fieldX, y, 200, 30);
        add(lcodigo);
        add(campoCodigo);
        y += gap;

        lcaracteristicas = new JLabel("CARACTERISTICAS:");
        lcaracteristicas.setForeground(rojo);
        lcaracteristicas.setFont(new Font("Arial", Font.BOLD, 14));
        lcaracteristicas.setBounds(x, y, labelW, 24);
        campoCaracteristicas = new JTextField();
        campoCaracteristicas.setBounds(fieldX, y, fieldW, 30);
        add(lcaracteristicas);
        add(campoCaracteristicas);
        y += gap;

        lcantidad = new JLabel("CANTIDAD:");
        lcantidad.setForeground(rojo);
        lcantidad.setFont(new Font("Arial", Font.BOLD, 14));
        lcantidad.setBounds(x, y, labelW, 24);
        campoCantidad = new JTextField();
        campoCantidad.setBounds(fieldX, y, 120, 30);
        add(lcantidad);
        add(campoCantidad);
        y += gap;


        btnmodificar.setText("MODIFICAR");
        btnmodificar.setBounds(140, Math.min(y + 10, 560), 220, 40);
        btnmodificar.setBackground(rojo);
        btnmodificar.setForeground(LionB);
        btnmodificar.setFocusPainted(false);
        add(btnmodificar);
    }
    public void limpiarCampos(){
        campoCantidad.setText("");
        campoCaracteristicas.setText("");
        campoCodigo.setText("");
        campoProveedor.setText("");
        campoMarca.setText("");
        campoPrecio.setText("");
        if (comboSexo!=null) comboSexo.setSelectedIndex(0);
        if (comboTalla!=null) comboTalla.setSelectedIndex(0);
        txtNombre.setText("");
        txtcodigo.setText("");
    }
}