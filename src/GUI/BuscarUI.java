package GUI;

import java.awt.*;
import javax.swing.*;

public class BuscarUI extends JFrame {

    public JButton btnBuscar;
    public JTextField txtnombre;
    public JTextField txtcodigo;
    public JTextArea txtdescripcion;
    public JLabel labelImagen;

    private JLabel nombre;
    private JLabel codigo;
    Color AzulB = new Color(25, 68, 241); 
    Color LionB = new Color(245, 243, 243); 

    public BuscarUI() {
        setSize(520, 600);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle("Buscar");
        getContentPane().setBackground(LionB);
    }

    public void contenedor() {
        
        nombre = new JLabel("NOMBRE:");
        nombre.setForeground(AzulB);
        nombre.setFont(new Font("Arial", Font.BOLD, 16));
        nombre.setBounds(30, 20, 180, 24);
        add(nombre);

        txtnombre = new JTextField("");
        txtnombre.setBounds(30, 50, 260, 34);
        txtnombre.setFont(new Font("Arial", Font.PLAIN, 14));
        add(txtnombre);

        codigo = new JLabel("CODIGO:");
        codigo.setForeground(AzulB);
        codigo.setFont(new Font("Arial", Font.BOLD, 16));
        codigo.setBounds(30, 100, 180, 24);
        add(codigo);

        txtcodigo = new JTextField("");
        txtcodigo.setBounds(30, 130, 160, 34);
        txtcodigo.setFont(new Font("Arial", Font.PLAIN, 14));
        add(txtcodigo);

        btnBuscar = new JButton("BUSCAR");
        btnBuscar.setBounds(200, 130, 90, 34);
        btnBuscar.setBackground(AzulB);
        btnBuscar.setForeground(LionB);
        btnBuscar.setFocusPainted(false);
        add(btnBuscar);

        labelImagen = new JLabel();
        labelImagen.setBounds(320, 50, 160, 160);
        labelImagen.setOpaque(true);
        labelImagen.setBackground(new Color(230,230,230));
        labelImagen.setBorder(BorderFactory.createLineBorder(AzulB, 2));
        labelImagen.setHorizontalAlignment(SwingConstants.CENTER);
        labelImagen.setText("Previsualización");
        labelImagen.setFont(new Font("Arial", Font.PLAIN, 12));
        add(labelImagen);

        txtdescripcion = new JTextArea();
        txtdescripcion.setLineWrap(true);
        txtdescripcion.setWrapStyleWord(true);
        txtdescripcion.setBackground(LionB);
        txtdescripcion.setForeground(AzulB);
        txtdescripcion.setFont(new Font("Arial", Font.PLAIN, 14));
        txtdescripcion.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtdescripcion);
        scroll.setBounds(30, 220, 450, 300);
        scroll.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(AzulB), "Descripción"));
        add(scroll);

    }
}
