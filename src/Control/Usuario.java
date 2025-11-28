 package Control;
import GUI.ModificarUI;
import java.util.Scanner;
 
 
public abstract class Usuario {
    public String Usuario;
    public String Contrasenia;
    
    public Usuario(String usuario,String contrasenia){
        this.Contrasenia=contrasenia;
        this.Usuario=usuario;
    }
    public Items Consultar(Items[] inventario){
        Items item=new Items();
        Scanner sc=new Scanner(System.in);
        byte encontrado=0;
        if(inventario[0]!=null){
            String nombre=sc.nextLine();
                for (int i = 0; i < inventario.length; i++) {
                if(inventario[i]!=null && nombre.equals(inventario[i].NombreProd)){
                    inventario[i].MostrarInfo();
                    encontrado++;
                    item=inventario[i];
                    break;
                }
            }
            if(encontrado==0){
                item=null;
            }
        }else{
            item=null;
        }
        return item;
    }
    
    //SOBRECARGA DE METOSOS
    static public Items Consultar(Items[] inventario,String nombre){
        Items item=new Items();
        byte encontrado=0;
        if(inventario[0]!=null){
                for (int i = 0; i < inventario.length; i++) {
                if(inventario[i]!=null && nombre.equals(inventario[i].NombreProd)){
                    inventario[i].MostrarInfo();
                    encontrado++;
                    item=inventario[i];
                    break;
                }
            }
            if(encontrado==0){
                item=null;
            }
        }else{
            item=null;
        }
        return item;
    } 
    
    static public Items Consultar(Items[] inventario,int codigo){
        Items item=new Items();
        byte encontrado=0;
        if(inventario[0]!=null){
                for (int i = 0; i < inventario.length; i++) {
                if(inventario[i]!=null && codigo==Integer.parseInt(inventario[i].CodigoProd)){
                    encontrado++;
                    item=inventario[i];
                    break;
                }
            }
            if(encontrado==0){
                item=null;
            }
        }else{
            item=null;
        }
        return item;
    }
    
    public Items Agregar(){
        return null;
    }
    public void Eliminar(Items []inventario){
    }
    public void Modificar(Items []inventario,ModificarUI ui){
    }
}
