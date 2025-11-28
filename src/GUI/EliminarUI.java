/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class EliminarUI extends JFrame{
    public JButton btneliminar;
    public JButton btnbuscar;
    public JTextField txtcodigo;
    public JComboBox box;
    public JLabel Img;
    
    private JLabel labelcodigo;
    private JLabel labelbcodigo;
    public JTextArea txtdescripcion;
    
    Color rojo = new Color(102, 136, 255); 
    Color RWhite = new Color(245, 243, 243);
    
    public EliminarUI(){
        setTitle("Eliminar Producto");
        setLayout(null);
        setSize(520, 700); 
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(RWhite);
    }

    public void contenedor(){
        labelcodigo = new JLabel("Ingresar código:");
        labelcodigo.setForeground(rojo);
        labelcodigo.setFont(new Font("Arial", Font.BOLD, 16));
        labelcodigo.setBounds(30, 20, 180, 24);
        add(labelcodigo);
        
        txtcodigo = new JTextField();
        txtcodigo.setBounds(30, 50, 220, 34);
        txtcodigo.setFont(new Font("Arial", Font.PLAIN, 14));
        add(txtcodigo);
        
        btnbuscar = new JButton("Buscar");
        btnbuscar.setBounds(260, 50, 100, 34);
        btnbuscar.setBackground(rojo);
        btnbuscar.setForeground(RWhite);
        btnbuscar.setFocusPainted(false);
        add(btnbuscar);
        
        labelbcodigo = new JLabel("Catálogo de códigos:");
        labelbcodigo.setForeground(rojo);
        labelbcodigo.setFont(new Font("Arial", Font.BOLD, 14));
        labelbcodigo.setBounds(30, 100, 200, 20);
        add(labelbcodigo);
        
        box = new JComboBox();
        box.setBounds(30, 125, 220, 30);
        add(box); 
        
        Img = new JLabel();
        Img.setBounds(320, 110, 160, 160);
        Img.setOpaque(true);
        Img.setBackground(new Color(230,230,230));
        Img.setBorder(BorderFactory.createLineBorder(rojo, 2));
        Img.setHorizontalAlignment(SwingConstants.CENTER);
        Img.setText("Previsualización");
        Img.setFont(new Font("Arial", Font.PLAIN, 12));
        add(Img);
        
        txtdescripcion = new JTextArea();
        txtdescripcion.setLineWrap(true);
        txtdescripcion.setWrapStyleWord(true);
        txtdescripcion.setBackground(RWhite);
        txtdescripcion.setForeground(rojo);
        txtdescripcion.setFont(new Font("Arial", Font.PLAIN, 14));
        txtdescripcion.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtdescripcion);
        scroll.setBounds(30, 175, 450, 300);
        scroll.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(rojo), "Descripción"));
        add(scroll);
        
        btneliminar = new JButton("Eliminar");
        btneliminar.setBackground(rojo);
        btneliminar.setForeground(RWhite);
        btneliminar.setBounds(160, 495, 200, 40);
        btneliminar.setFocusPainted(false);
        add(btneliminar);
    }
}
