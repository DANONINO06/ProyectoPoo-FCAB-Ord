package Control;

//import static Control.Usuario.Consultar;//LO PUSO NEATBEANS
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import GUI.BuscarUI;
import GUI.MenuPrincipal;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author fabri
 */
public class ControlUICliente implements ActionListener{
    Cliente cliente;
    MenuPrincipal men;
    BuscarUI ui;
    Items[][] matriz;
    
    public ControlUICliente(BuscarUI ui,Items[][] matriz,Cliente cliente,MenuPrincipal men){
        this.matriz=matriz;
        this.ui=ui;
        this.men=men;
        this.cliente=cliente;
    }
    
    private void AdaptarImagen(JLabel label, String ruta) {
        ImageIcon icon = new ImageIcon(ruta);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(newImg));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Items itemtemp=new Items();
        Items temp=new Items();
        if (e.getSource()==ui.btnBuscar) {
            if (!ui.txtcodigo.getText().equals("")&&ui.txtnombre.getText().equals("")) {
                for (int i = 0; i < matriz.length; i++) {
                   itemtemp=cliente.Consultar(matriz[i],Integer.parseInt(ui.txtcodigo.getText()));
                   if (itemtemp!=null) {
                        ui.txtdescripcion.setText(itemtemp.MostrarInfo());
                        AdaptarImagen(ui.labelImagen, itemtemp.DirImagen);
                        break;
                    }
                }
                if (itemtemp==null) {
                    JOptionPane.showMessageDialog(ui, "NO SE ENCONTRO UN ITEM CON EL CODIGO "+ui.txtcodigo.getText(), "ERROR", 2);
                }
            }
            if (ui.txtcodigo.getText().equals("")&&!ui.txtnombre.getText().equals("")) {
                for (int i = 0; i < matriz.length; i++) {
                   itemtemp=cliente.Consultar(matriz[i],ui.txtnombre.getText());
                   if (itemtemp!=null) {
                        ui.txtdescripcion.setText(itemtemp.MostrarInfo());
                        AdaptarImagen(ui.labelImagen, itemtemp.DirImagen);
                        break;
                    }
                }
                if (itemtemp==null) {
                    JOptionPane.showMessageDialog(ui, "NO SE ENCONTRO UN ITEM CON EL NOMBRE "+ui.txtnombre.getText(), "ERROR", 2);
                }
            }
            if (!ui.txtcodigo.getText().equals("")&&!ui.txtnombre.getText().equals("")) {
                for (int i = 0; i < matriz.length; i++) {
                   itemtemp=cliente.Consultar(matriz[i],Integer.parseInt(ui.txtcodigo.getText()));
                   temp=cliente.Consultar(matriz[i],ui.txtnombre.getText());
                   if (itemtemp!=null&&itemtemp==temp) {
                        ui.txtdescripcion.setText(itemtemp.MostrarInfo());
                        AdaptarImagen(ui.labelImagen, itemtemp.DirImagen);
                        System.out.println("si paso");
                        break;
                    }
                    if (itemtemp!=temp) {
                        JOptionPane.showMessageDialog(ui, "NO SE ENCONTRO UN ITEM CON CODIGO "+ui.txtcodigo.getText()+" Y EL NOMBRE "+ui.txtnombre.getText(), "ERROR", 2);
                    }
                }
            }
        }
        if (e.getSource()==men.itemCalzadoH) {
            men.mostrarItems(matriz,1);
            men.revalidate();
            men.repaint();
        }
        if (e.getSource()==men.itemRopaH) {
            men.mostrarItems(matriz,0);
            men.revalidate();
            men.repaint();
        }
        if (e.getSource()==men.itemBellezaH) {
            men.mostrarItems(matriz,3);
            men.revalidate();
            men.repaint();
        }
        if (e.getSource()==men.itemHogarH) {
            men.mostrarItems(matriz,2);
            men.revalidate();
            men.repaint();
        }
        if (e.getSource()==men.itemAccesoriosH) {
            men.mostrarItems(matriz,4);
            men.revalidate();
            men.repaint();
        }
        if (e.getSource()==men.Inicio) {
            men.mostrarItems(matriz);
            men.revalidate();
            men.repaint();
        }
    }
    
}
