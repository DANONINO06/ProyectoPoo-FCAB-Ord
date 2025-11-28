package Control;

import javax.swing.JOptionPane;
import GUI.BuscarUI;

/**
 *
 * @author fabri
 */
public class Cliente extends Usuario {
    public Cliente(String nombre,String contrasenia){
        super(nombre,contrasenia);
        
    }

    public Items Agregar(){
        JOptionPane.showMessageDialog(null, "NO PUEDES AGREGAR", "ERROR", 2);
        return null;
    }
    public void Eliminar(Items []inventario){
        JOptionPane.showMessageDialog(null, "NO PUEDES ELIMINAR", "ERROR", 2);
    }
    public void Modificar(Items []inventario){
        JOptionPane.showMessageDialog(null, "NO PUEDES MODIFICAR", "ERROR", 2);
    }
    


}
