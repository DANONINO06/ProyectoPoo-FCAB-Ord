package GUI;
import Control.Administrador;
import MAIN.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class IniciodeSesion extends JFrame /*implements ActionListener*/{
    Color AzulB = new Color(102, 136, 255); 
    Color LionB = new Color(245, 243, 243); 
    Color Azulbr = new Color(102, 136, 255); 
    public JButton btnLogin;
    public JButton btnSignup;
    public JButton btnIgnore;
    
    public JButton borrar;
    
    public JTextField txtUser;
    public JTextField txtPass;
    
    public JLabel error;
    public static ActionEvent Eventos;
    static Administrador user=new Administrador("ADMIN","12345");
    public IniciodeSesion() {
        setTitle("Inicio de Sesión");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridLayout(1, 2)); // dos paneles lado a lado
    }
    
    public void Contenedor(){
        // Panel Izquierdo (Login)
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBackground(LionB);

        JLabel lblLogin = new JLabel("Inicio de Sesion");
        lblLogin.setForeground(AzulB);
        lblLogin.setFont(new Font("Arial", Font.BOLD, 16));
        lblLogin.setBounds(60, 30, 200, 30);
        loginPanel.add(lblLogin);
        
        txtUser = new JTextField("Ingresa tu Usuario");
        txtUser.setBounds(60, 80, 250, 35);
        loginPanel.add(txtUser);

        borrar = new JButton("Limpiar Campos");
        borrar.setBounds(60, 180, 130, 20);
        borrar.setBackground(Azulbr);
        borrar.setForeground(LionB);
        loginPanel.add(borrar);
        txtPass = new JTextField("Ingresa la Contraseña");
        txtPass.setBounds(60, 130, 250, 35);
        loginPanel.add(txtPass);

        btnLogin = new JButton("Iniciar Sesion");
        btnLogin.setBounds(110, 230, 150, 40);
        btnLogin.setBackground(AzulB);
        btnLogin.setForeground(LionB);
        loginPanel.add(btnLogin);
        //btnLogin.addActionListener(this);
        
        error=new JLabel("");
        error.setBounds(110, 200, 150, 40);
        error.setForeground(new Color(250,0,0));
        loginPanel.add(error);

        // Panel Derecho (Bienvenida)
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(AzulB);
        rightPanel.setLayout(new GridBagLayout());

        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        innerPanel.setBackground(AzulB);
        
        JLabel lblWelcome = new JLabel("Bienvenido Usuario!");
        lblWelcome.setForeground(LionB);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 22));
        lblWelcome.setBackground(AzulB);
        lblWelcome.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblText = new JLabel("Da clic para comenzar");
        lblText.setForeground(LionB);
        lblText.setFont(new Font("Arial", Font.PLAIN, 14));
        lblText.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        btnIgnore = new JButton("INICIAR ");
        btnIgnore.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnIgnore.setBackground(LionB);
        
        innerPanel.add(lblWelcome);
        innerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        innerPanel.add(lblText);
        innerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        innerPanel.add(btnIgnore);

        rightPanel.add(innerPanel);

        // Agregar paneles al frame
        add(loginPanel);
        add(rightPanel);
    }
}