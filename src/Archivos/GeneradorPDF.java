package Archivos;

import Control.Items;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

public class GeneradorPDF {

    BaseColor AZUL_FONDO = new BaseColor(25, 68, 241);
    BaseColor GRIS_CLARO = new BaseColor(245, 243, 243);

    public void crearCatalogoPDF(Items[][] inventario, String rutaDestino) {
        Document documento = new Document(PageSize.A4, 30, 30, 100, 50);

        try {
            PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(rutaDestino));
            writer.setPageEvent(new MembreteEvento()); // Fondo
            documento.open();

            // Título del pdf a guardar
            Paragraph titulo = new Paragraph("CATÁLOGO DE PRODUCTOS", 
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24, AZUL_FONDO));
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            documento.add(titulo);

            // Tabla para alinear las imagenes
            PdfPTable tabla = new PdfPTable(3);
            tabla.setWidthPercentage(100);
            tabla.setWidths(new float[]{1f, 1f, 1f});

            for (int i = 0; i < inventario.length; i++) {
                for (int j = 0; j < inventario[i].length; j++) {
                    Items prod = inventario[i][j];
                    if (prod != null) {
                        PdfPCell celda = new PdfPCell();
                        celda.setBorderColor(BaseColor.LIGHT_GRAY);
                        celda.setPadding(10);
                        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                        celda.setFixedHeight(260f);

                        // se llaman las imagenes
                        try {
                            // se usa el  DirImagen para llamar a la clase Items
                            if (prod.DirImagen != null && !prod.DirImagen.isEmpty()) { 
                                Image imagen = Image.getInstance(prod.DirImagen); 
                                imagen.scaleToFit(110, 110);
                                imagen.setAlignment(Element.ALIGN_CENTER);
                                celda.addElement(imagen);
                            } else {
                                celda.addElement(new Paragraph("Sin Imagen"));
                            }
                        } catch (Exception e) {
                            celda.addElement(new Paragraph("Error Img"));
                        }

                        // Textos
                        celda.addElement(new Paragraph(" ", FontFactory.getFont("Arial", 4)));
                        
                        Font fNombre = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);
                        Paragraph pNombre = new Paragraph(prod.NombreProd, fNombre);
                        pNombre.setAlignment(Element.ALIGN_CENTER);
                        celda.addElement(pNombre);

                        Font fDetalle = FontFactory.getFont(FontFactory.HELVETICA, 9, BaseColor.DARK_GRAY);
                        String info = prod.Categoria;
                        if (prod.Talla != null && !prod.Talla.equals("Seleccione talla")) {
                             info += " | Talla: " + prod.Talla;
                        }
                        Paragraph pDetalle = new Paragraph(info, fDetalle);
                        pDetalle.setAlignment(Element.ALIGN_CENTER);
                        celda.addElement(pDetalle);

                        Font fPrecio = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.RED);
                        Paragraph pPrecio = new Paragraph("$" + prod.Precio, fPrecio);
                        pPrecio.setAlignment(Element.ALIGN_CENTER);
                        celda.addElement(pPrecio);
                        
                        tabla.addCell(celda);
                    }
                }
            }
            
            while(tabla.size() % 3 != 0){
                 PdfPCell vacia = new PdfPCell();
                 vacia.setBorder(Rectangle.NO_BORDER);
                 tabla.addCell(vacia);
            }

            documento.add(tabla);
            documento.close();
            JOptionPane.showMessageDialog(null, "¡PDF Guardado Correctamente!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error , no se guardo el pdf: " + e.getMessage());
        }
    }
    
    class MembreteEvento extends PdfPageEventHelper {
        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            Rectangle header = new Rectangle(0, document.getPageSize().getHeight() - 80, 
                                             document.getPageSize().getWidth(), document.getPageSize().getHeight());
            header.setBackgroundColor(AZUL_FONDO);
            header.setBorder(Rectangle.NO_BORDER);
            try {
                writer.getDirectContentUnder().rectangle(header);
                ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT, 
                        new Phrase("CATÁLOGO OFICIAL", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.WHITE)), 
                        30, document.getPageSize().getHeight() - 45, 0);

                Rectangle footer = new Rectangle(0, 0, document.getPageSize().getWidth(), 30);
                footer.setBackgroundColor(GRIS_CLARO);
                footer.setBorder(Rectangle.NO_BORDER);
                writer.getDirectContentUnder().rectangle(footer);
            } catch (Exception e) {}
        }
    }
}