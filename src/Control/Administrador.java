package Control;
import GUI.AgregarUI;
import GUI.ModificarUI;
import javax.swing.JOptionPane;

/**
 *
 * @author fabri
 */
public class Administrador extends Usuario{ 
    public Administrador(String usuario,String contrasenia){
        super(usuario,contrasenia);
    }
    public Items Agregar(AgregarUI agreg){
        Items articulo=new Items();
        String talla=(String)agreg.comboTalla.getSelectedItem();
        String sex=(String)agreg.comboSexo.getSelectedItem();
        
        articulo.NombreProd=agreg.txtNombre.getText();
        articulo.CodigoProd=agreg.campoCodigo.getText();
        articulo.Precio=Float.parseFloat(agreg.campoPrecio.getText());
        articulo.Talla=talla;
        articulo.Sexo=sex;
        articulo.Precio=Float.parseFloat(agreg.campoPrecio.getText());
        articulo.Marca=agreg.campoMarca.getText();
        articulo.Proveedor=agreg.campoProveedor.getText();
        articulo.Caracteristicas=agreg.campoCaracteristicas.getText();
        articulo.Cantidad=Short.parseShort(agreg.campoCantidad.getText());
        articulo.DirImagen=agreg.ruta;
        return articulo;
    }
    public void Modificar(Items[][] inventario,ModificarUI ui,String direccion,String categoria){
        Items tem=new Items();
        int contador=0;
        tem.NombreProd=ui.txtNombre.getText();
        tem.CodigoProd=ui.campoCodigo.getText();
        tem.Precio=Float.parseFloat(ui.campoPrecio.getText());
        tem.Talla=(String)ui.comboTalla.getSelectedItem();
        tem.Sexo=(String)ui.comboSexo.getSelectedItem();
        tem.Precio=Float.parseFloat(ui.campoPrecio.getText());
        tem.Marca=ui.campoMarca.getText();
        tem.Proveedor=ui.campoProveedor.getText();
        tem.Caracteristicas=ui.campoCaracteristicas.getText();
        tem.Cantidad=Short.parseShort(ui.campoCantidad.getText());
        String codigo=ui.txtcodigo.getText();
        
        tem.Categoria=categoria;
        tem.DirImagen=direccion;
        System.out.println(tem.MostrarInfo());
        for (int i = 0; i < inventario.length; i++) {
            for (int j = 0; j < inventario[i].length; j++) {
                if (inventario[i][j]!=null && inventario[i][j].CodigoProd.equals(codigo)) {
                    tem.Categoria=inventario[i][j].Categoria;
                    inventario[i][j]=tem;
                    JOptionPane.showMessageDialog(ui, "SE MODIFICO CORRECTAMENTE");
                    contador++;
                    break;
                }
            }
        }
        if (contador==0) {
            JOptionPane.showMessageDialog(null, "NO SE PURO HACER", "ERROR", 0);
        }
    }
    public boolean Eliminar(Items []inventario,int codigo,int fin){
        Items encontrado=new Items();
        int j;
        int k;
        boolean eliminado=false;
        encontrado=Consultar(inventario,codigo);
        if(encontrado==null){
            JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR");
        } else {
            for (short i = 0; i < fin; i++) {
                if (inventario[i].equals(encontrado)){
                    j=i;
                    k=j+1;
                    while(k<=inventario.length-1){
                        inventario[j]=inventario[k];
                        j++;
                        k++;
                    }
                    inventario[inventario.length-1]=null;
                    eliminado=true;
                    JOptionPane.showMessageDialog(null, "ELIMINADO EXITOSAMENTE");
                    break;
                }
            }
        }
        return eliminado;
    }
}
