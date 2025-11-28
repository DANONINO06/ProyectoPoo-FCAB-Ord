package Control;
import java.io.*;

public class Items implements Serializable{
    private static final long serialVersionUID = 1L;
    public String NombreProd, Marca;
    public String Categoria;
    public float Precio;
    public short Cantidad;
    public String Talla;
    public String Sexo;
    public String Proveedor;
    public String CodigoProd;
    public float Oferta;
    public String Caracteristicas;
    public String DirImagen;
    public String MostrarInfo(){
        String info=
        "NombreProd = " + NombreProd+"\n"+
        "Categoria = " + Categoria+"\n"+
        "Talla = " + Talla+"\n"+
        "Sexo = " + Sexo+"\n"+
        "Precio = " + Precio+"\n"+
        "Marca = " + Marca+"\n"+
        "Proveedor = " + Proveedor+"\n"+
        "CodigoProd = " + CodigoProd+"\n"+
        "Caracteristicas = "+ Caracteristicas+"\n"+
        "Cantidad = " + Cantidad+"\n"+
        "ruta = " + DirImagen;
        
        return info;
    }
}
