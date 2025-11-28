package Archivos;
import Control.Items;
import Control.Items;
import java.io.*;
import javax.swing.JOptionPane;
/**
 *
 * @author fabri
 */
public class ControlArchivos {
    public static void crearArchivo(String dir){
        PrintWriter bsalida=null;
        try {
            File arch=new File(dir);
            bsalida = new PrintWriter(arch);
            JOptionPane.showMessageDialog(null, "SE CREO EL ARCHIVO");
            bsalida.close();
        } catch (FileNotFoundException ex) {
            System.getLogger(ControlArchivos.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    public void guardarDatos(String archivo, Items[][] inventario) {
        File datos = new File(archivo);
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(datos))) {
            salida.writeObject(inventario);
            JOptionPane.showMessageDialog(null, "SE GUARDO CORRECTAMENTE");
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    
    public Items[][] leerDatos(String archivo, int filas, int columnas) {
        File datos = new File(archivo);
        if (!datos.exists()) {
            JOptionPane.showMessageDialog(null, "NO SE ENCONTRO EL ARCHIVO");
            //MODIFICAR SEGUN
            crearArchivo("src/Archivos/DATOS.dat");
            return new Items[filas][columnas];
        }else{
            try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(datos))) {
                return (Items[][])entrada.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace(System.out);
                return new Items[filas][columnas];
            }
        }
    }
    public String copiarArchivos(File original){
        String rutaAlmacenada=null;
        File carpetaDestino = new File("src/Imagenes/");
        carpetaDestino.mkdirs();

        // Creamos el archivo destino con el mismo nombre
        File archivoDestino = new File(carpetaDestino, original.getName());

        try {
            java.nio.file.Files.copy(
                    original.toPath(),
                    archivoDestino.toPath(),
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING
            );
            // Aquí guardas SOLO el nombre del archivo o una ruta relativa
            rutaAlmacenada = "src/Imagenes/" + original.getName();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Copiar Item");
        }
        return rutaAlmacenada;
    }
}
