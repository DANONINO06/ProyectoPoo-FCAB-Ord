package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter; 
import Archivos.ControlArchivos;

public class AgregarUI extends JFrame{
    public JButton btnEnviar;
    public JButton btnAgregar;
    public JTextField txtNombre;
    //esto no lo toques paptu :v
    public JTextField campoPrecio;
    public JTextField campoMarca;
    public JTextField campoProveedor;
    public JTextField campoCodigo;
    public JTextField campoCaracteristicas;
    public JTextField campoCantidad; 
    public JComboBox<String> comboCategorias;
    public JComboBox<String> comboTalla;
    public JComboBox<String> comboSexo;
    private JLabel etiquetaRutaImagen;
    public JLabel etiquetaVistaPrevia;
    public String rutaImagenSeleccionada = null;
    public int posY;
    
    public File f;
    public String ruta;
    public JFileChooser selector;
    public JButton btnSeleccionarArchivo;
    Color AzulB = new Color(25, 68, 241); 
    Color LionB = new Color(245, 243, 243);

    public AgregarUI(){    
        setTitle("Agregar");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setSize(520, 840); 
        setResizable(true);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(LionB);
    }

    public void contenedor(){
        int xEtiqueta = 20;
        int xCampo = 200;
        int anchoEtiqueta = 170;
        int anchoCampo = 260;
        int alto = 28;
        posY = 10;
        int separacion = 48;

        // Nombre
        JLabel etiquetaNombre = new JLabel("Nombre:");
        etiquetaNombre.setBounds(xEtiqueta, posY, anchoEtiqueta, alto);
        etiquetaNombre.setForeground(AzulB);
        etiquetaNombre.setFont(new Font("Arial", Font.BOLD, 16));
        add(etiquetaNombre);
        txtNombre = new JTextField();
        txtNombre.setBounds(xCampo, posY, anchoCampo, alto);
        add(txtNombre);

        String[] categoriasArray = {"Seleccione", "Zapateria", "Ropa", "Productos de Belleza", "Productos del Hogar", "Accesorios"};

        // Categoria

        posY += separacion;
        JLabel etiquetaCategoria = new JLabel("Categoria:");
        etiquetaCategoria.setForeground(AzulB);
        etiquetaCategoria.setFont(new Font("Arial", Font.BOLD, 16));
        etiquetaCategoria.setBounds(xEtiqueta, posY, anchoEtiqueta, alto);
        add(etiquetaCategoria);
        comboCategorias = new JComboBox<>();
        for (String categoria : categoriasArray) {
            comboCategorias.addItem(categoria);
        }
        comboCategorias.setBounds(xCampo, posY, anchoCampo, alto);
        add(comboCategorias);

        // Talla
        
        posY += separacion;
        JLabel etiquetaTalla = new JLabel("Talla:");
        etiquetaTalla.setForeground(AzulB);
        etiquetaTalla.setFont(new Font("Arial", Font.BOLD, 16));
        etiquetaTalla.setBounds(xEtiqueta, posY, anchoEtiqueta, alto);
        add(etiquetaTalla);
        comboTalla = new JComboBox<>();
        String[] tallas = {"Seleccione talla", "XS", "S", "M", "L", "XL"};
        comboTalla.setBounds(xCampo, posY, anchoCampo, alto);
        add(comboTalla);
        
        comboCategorias.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            String[] tallas2 = {"Seleccione talla", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27"};
            String[] ctallas2;
            if (comboCategorias.getSelectedItem().equals("Zapateria") ){
                //comboCategorias.setSelectedItem(tallas2);
                comboTalla.removeAllItems();
                    for (String talla : tallas2) {
                        comboTalla.addItem(talla);
                    } 
                add(comboTalla);
                } else if(comboCategorias.getSelectedItem().equals("Ropa")){
                    comboTalla.removeAllItems();
                    for (String talla : tallas) {
                        comboTalla.addItem(talla);
                    }
                } else {
                    comboTalla.removeAllItems();
                }
            
            add(comboTalla);}
        });


        // Sexo
        posY += separacion;
        JLabel etiquetaSexo = new JLabel("Sexo:");
        etiquetaSexo.setForeground(AzulB);
        etiquetaSexo.setFont(new Font("Arial", Font.BOLD, 16));
        etiquetaSexo.setBounds(xEtiqueta, posY, anchoEtiqueta, alto);
        add(etiquetaSexo);
        comboSexo = new JComboBox<>();
        String[] sexos = {"Seleccione", "Masculino", "Femenino", "Unisex"};
        for (String sexo : sexos) {
            comboSexo.addItem(sexo);
        }
        comboSexo.setBounds(xCampo, posY, anchoCampo, alto);
        add(comboSexo);

        // Precio
        posY += separacion;
        JLabel etiquetaPrecio = new JLabel("Precio:");
        etiquetaPrecio.setForeground(AzulB);
        etiquetaPrecio.setFont(new Font("Arial", Font.BOLD, 16));
        etiquetaPrecio.setBounds(xEtiqueta, posY, anchoEtiqueta, alto);
        add(etiquetaPrecio);
        campoPrecio = new JTextField();
        campoPrecio.setBounds(xCampo, posY, anchoCampo, alto);
        add(campoPrecio);

        // Marca
        posY += separacion;
        JLabel etiquetaMarca = new JLabel("Marca:");
        etiquetaMarca.setForeground(AzulB);
        etiquetaMarca.setFont(new Font("Arial", Font.BOLD, 16));
        etiquetaMarca.setBounds(xEtiqueta, posY, anchoEtiqueta, alto);
        add(etiquetaMarca);
        campoMarca = new JTextField();
        campoMarca.setBounds(xCampo, posY, anchoCampo, alto);
        add(campoMarca);

        // Proveedor
        posY += separacion;
        JLabel etiquetaProveedor = new JLabel("Proveedor:");
        etiquetaProveedor.setForeground(AzulB);
        etiquetaProveedor.setFont(new Font("Arial", Font.BOLD, 16));
        etiquetaProveedor.setBounds(xEtiqueta, posY, anchoEtiqueta, alto);
        add(etiquetaProveedor);
        campoProveedor = new JTextField();
        campoProveedor.setBounds(xCampo, posY, anchoCampo, alto);
        add(campoProveedor);

        // Codigo del producto
        posY += separacion;
        JLabel etiquetaCodigoProducto = new JLabel("Codigo del Producto:");
        etiquetaCodigoProducto.setForeground(AzulB);
        etiquetaCodigoProducto.setFont(new Font("Arial", Font.BOLD, 16));
        etiquetaCodigoProducto.setBounds(xEtiqueta, posY, anchoEtiqueta, alto);
        add(etiquetaCodigoProducto);
        campoCodigo = new JTextField();
        campoCodigo.setBounds(xCampo, posY, anchoCampo, alto);
        add(campoCodigo);

        // Caracteristicas
        posY += separacion;
        JLabel etiquetaCaracteristicas = new JLabel("Caracteristicas del Producto:");
        etiquetaCaracteristicas.setForeground(AzulB);
        etiquetaCaracteristicas.setFont(new Font("Arial", Font.BOLD, 16));
        etiquetaCaracteristicas.setBounds(xEtiqueta, posY, anchoEtiqueta, alto);
        add(etiquetaCaracteristicas);
        campoCaracteristicas = new JTextField();
        campoCaracteristicas.setBounds(xCampo, posY, anchoCampo, alto);
        add(campoCaracteristicas);

        // Cantidad (nuevo)
        posY += separacion;
        JLabel etiquetaCantidad = new JLabel("Cantidad:");
        etiquetaCantidad.setForeground(AzulB);
        etiquetaCantidad.setFont(new Font("Arial", Font.BOLD, 16));
        etiquetaCantidad.setBounds(xEtiqueta, posY, anchoEtiqueta, alto);
        add(etiquetaCantidad);
        campoCantidad = new JTextField();
        campoCantidad.setBounds(xCampo, posY, anchoCampo, alto);
        add(campoCantidad);

        // Imagen: botón para seleccionar archivo + label con nombre + preview
        posY += separacion;
        JLabel etiquetaImagen = new JLabel("Imagen del Producto:");
        etiquetaImagen.setForeground(AzulB);
        etiquetaImagen.setFont(new Font("Arial", Font.BOLD, 16));
        etiquetaImagen.setBounds(xEtiqueta, posY, anchoEtiqueta, alto);
        add(etiquetaImagen);

        btnSeleccionarArchivo = new JButton("Seleccionar archivo...");
        btnSeleccionarArchivo.setBorder(UIManager.getBorder("Button.border"));
        btnSeleccionarArchivo.setBounds(xCampo, posY, 160, alto);
        add(btnSeleccionarArchivo);
        
        etiquetaRutaImagen = new JLabel("Ninguno");
        etiquetaRutaImagen.setForeground(AzulB);
        etiquetaRutaImagen.setFont(new Font("Arial", Font.BOLD, 16));
        etiquetaRutaImagen.setBounds(xCampo + 170, posY, 200, alto);
        add(etiquetaRutaImagen);

        etiquetaVistaPrevia = new JLabel();
        etiquetaVistaPrevia.setBounds(xCampo, posY + 36, 150, 150);
        etiquetaVistaPrevia.setForeground(AzulB);
        etiquetaVistaPrevia.setFont(new Font("Arial", Font.BOLD, 16));
        etiquetaVistaPrevia.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(etiquetaVistaPrevia);

        // Acción del botón: abrir JFileChooser y validar extensiones
        btnSeleccionarArchivo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selector = new JFileChooser();
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imágenes (jpg, jpeg, png, gif, bmp)", "jpg", "jpeg", "png", "gif", "bmp");
                selector.setFileFilter(filtro);
                int resultado = selector.showOpenDialog(AgregarUI.this);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    f = selector.getSelectedFile();
                    String name = f.getName().toLowerCase();
                    if (name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png") || name.endsWith(".gif") || name.endsWith(".bmp")) {
                        etiquetaRutaImagen.setText(f.getName());
                        rutaImagenSeleccionada = f.getAbsolutePath(); //Guarda la ruta seleccionada
                        ImageIcon ico = new ImageIcon(f.getAbsolutePath());
                        Image img = ico.getImage().getScaledInstance(etiquetaVistaPrevia.getWidth(), etiquetaVistaPrevia.getHeight(), Image.SCALE_SMOOTH);
                        etiquetaVistaPrevia.setIcon(new ImageIcon(img));
                    } else {
                        JOptionPane.showMessageDialog(AgregarUI.this, "Formato no válido. Elija jpg, png, gif o bmp.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Botón agregar al final
        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds((xCampo + xEtiqueta + anchoEtiqueta) / 2, posY + 200, 120, 30);
        add(btnAgregar);
        
    }
}
