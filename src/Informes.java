import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/** @author David Grande */
public class Informes {

  // Informe semanal x delegación
  public static void informedelegacion(ResultSet rs, String delegacion, String provincia)
      throws SQLException {
    String part[], parts[];
    ResultSet copia = rs;
    Font font1 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD); // negrita
    Font font2 = new Font(Font.FontFamily.TIMES_ROMAN, 40, Font.BOLD); // negrita
    Calendar fecha = new GregorianCalendar();
    int amo = fecha.get(Calendar.YEAR);
    int mes = fecha.get(Calendar.MONTH);
    int dia = fecha.get(Calendar.DAY_OF_MONTH);
    String fechafin = +dia + "." + (mes + 1) + "." + amo;
    String linea = null, vc = null, estado = null, d, m, ano;
    int filas = 0;
    PdfPCell celda1 = null,
        celda2 = null,
        celda3 = null,
        celda4 = null,
        celda5 = null,
        celda6 = null,
        celda7 = null,
        celda8 = null,
        celda9 = null,
        celda10 = null,
        celda13 = null,
        celda12 = null,
        celda11 = null,
        celda14 = null,
        celda15 = null,
        celda16 = null;

    FileOutputStream ficheroPdf = null;
    try {
      do {
        filas += 1;
      } while (copia.next());
      Image imagen = Image.getInstance("..\\logo.jpg");
      Document documento = new Document(PageSize.A3.rotate());
      imagen.scalePercent(75f);
      File directorio =
          new File(
              "C:\\Users\\"
                  + System.getProperty("user.name")
                  + "\\Google Drive\\REPORTES\\"
                  + delegacion);
      directorio.mkdir();
      ficheroPdf =
          new FileOutputStream(
              "C:\\Users\\"
                  + System.getProperty("user.name")
                  + "\\Google Drive\\REPORTES\\"
                  + delegacion
                  + "\\"
                  + fechafin
                  + ".pdf");
      PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);
      documento.open();
      PdfPTable tablaimg = new PdfPTable(2);
      PdfPCell cel1 = new PdfPCell(imagen);
      cel1.setBorder(Rectangle.NO_BORDER);
      PdfPCell cel2 =
          new PdfPCell(
              new Paragraph(
                  "Informe de la Delegación de " + provincia + " a día " + fechafin, font2));
      cel2.setBorder(Rectangle.NO_BORDER);
      cel2.setVerticalAlignment(Element.ALIGN_MIDDLE);
      tablaimg.addCell(cel1);
      tablaimg.addCell(cel2);

      documento.add(tablaimg);
      documento.add(new Paragraph(" "));
      PdfPTable tabla = new PdfPTable(16);
      PdfPCell cab1 = new PdfPCell(new Phrase("Comercial", font1));
      PdfPCell cab2 = new PdfPCell(new Phrase("Cliente", font1));
      PdfPCell cab3 = new PdfPCell(new Phrase("DNI/CIF", font1));
      PdfPCell cab11 = new PdfPCell(new Phrase("Cía", font1));
      PdfPCell cab4 = new PdfPCell(new Phrase("Oferta", font1));
      PdfPCell cab14 = new PdfPCell(new Phrase("Alta Móvil", font1));
      PdfPCell cab5 = new PdfPCell(new Phrase("Porta Móvil", font1));
      PdfPCell cab6 = new PdfPCell(new Phrase("VC Móvil", font1));
      PdfPCell cab12 = new PdfPCell(new Phrase("Estado moviles", font1));
      PdfPCell cab13 = new PdfPCell(new Phrase("Fijo", font1));
      PdfPCell cab7 = new PdfPCell(new Phrase("VC Fijo", font1));
      PdfPCell cab8 = new PdfPCell(new Phrase("Instalación", font1));
      PdfPCell cab9 = new PdfPCell(new Phrase("Observ.", font1));
      PdfPCell cab15 = new PdfPCell(new Phrase("Docum.", font1));
      PdfPCell cab16 = new PdfPCell(new Phrase("Contrato.", font1));
      PdfPCell cab10 = new PdfPCell(new Phrase("Estado", font1));
      tabla.addCell(cab1);
      tabla.addCell(cab2);
      tabla.addCell(cab3);
      tabla.addCell(cab11);
      tabla.addCell(cab4);
      tabla.addCell(cab14);
      tabla.addCell(cab5);
      tabla.addCell(cab6);
      tabla.addCell(cab12);
      tabla.addCell(cab13);
      tabla.addCell(cab7);
      tabla.addCell(cab8);
      tabla.addCell(cab9);
      tabla.addCell(cab15);
      tabla.addCell(cab16);
      tabla.addCell(cab10);
      cab1.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab2.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab3.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab4.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab4.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab5.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab6.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab7.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab8.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab9.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab10.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab11.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab12.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab13.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab14.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab15.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab16.setHorizontalAlignment(Element.ALIGN_CENTER);

      cab1.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab2.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab3.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab4.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab4.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab5.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab6.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab7.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab8.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab9.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab10.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab11.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab12.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab13.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab14.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab15.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab16.setVerticalAlignment(Element.ALIGN_MIDDLE);
      tabla.setWidthPercentage(102);
      documento.add(tabla);
      rs.first();
      tabla = new PdfPTable(16);
      for (int i = 0; i < filas; i++) {
        celda1 = new PdfPCell(new Phrase(rs.getString("comercial")));
        celda2 = new PdfPCell(new Phrase(rs.getString("nombrecliente")));
        celda3 = new PdfPCell(new Phrase(rs.getString("documento")));
        celda11 = new PdfPCell(new Phrase(rs.getString("operador")));
        celda4 = new PdfPCell(new Phrase(rs.getString("oferta")));
        celda14 = new PdfPCell(new Phrase(rs.getString("numaltasmovi")));
        int n = Integer.parseInt(rs.getString("numportasmovil"));
        int n1 = Integer.parseInt(rs.getString("numaltasmovi"));
        n += n1;
        if (n > 0) {
          switch (n) {
            case 1:
              part = rs.getString("lineasmoviles").split(",");
              String parte1 = part[0];
              String parte2 = part[1];
              String parte3 = part[2];
              linea = parte1;
              vc = parte2;
              estado = parte3;

              break;

            case 2:
              part = rs.getString("lineasmoviles").split(",");
              parte1 = part[0];
              parte2 = part[1];
              parte3 = part[2];
              String parte4 = part[3];
              String parte5 = part[4];
              String parte6 = part[5];
              linea = parte1 + "\n" + parte4;
              vc = parte2 + "\n" + parte5;
              estado = parte3 + "\n" + parte6;
              break;
            case 3:
              part = rs.getString("lineasmoviles").split(",");
              parte1 = part[0];
              parte2 = part[1];
              parte3 = part[2];
              parte4 = part[3];
              parte5 = part[4];
              parte6 = part[5];
              String parte7 = part[6];
              String parte8 = part[7];
              String parte9 = part[8];
              linea = parte1 + "\n" + parte4 + "\n" + parte7;
              vc = parte2 + "\n" + parte5 + "\n" + parte8;
              estado = parte3 + "\n" + parte6 + "\n" + parte9;
              break;

            case 4:
              part = rs.getString("lineasmoviles").split(",");
              parte1 = part[0];
              parte2 = part[1];
              parte3 = part[2];
              parte4 = part[3];
              parte5 = part[4];
              parte6 = part[5];
              parte7 = part[6];
              parte8 = part[7];
              parte9 = part[8];
              String parte10 = part[9];
              String parte11 = part[10];
              String parte12 = part[11];

              linea = parte1 + "\n" + parte4 + "\n" + parte7 + "\n" + parte10;
              vc = parte2 + "\n" + parte5 + "\n" + parte8 + "\n" + parte11;
              estado = parte3 + "\n" + parte6 + "\n" + parte9 + "\n" + parte12;

              break;

            case 5:
              part = rs.getString("lineasmoviles").split(",");
              parte1 = part[0];
              parte2 = part[1];
              parte3 = part[2];
              parte4 = part[3];
              parte5 = part[4];
              parte6 = part[5];
              parte7 = part[6];
              parte8 = part[7];
              parte9 = part[8];
              parte10 = part[9];
              parte11 = part[10];
              parte12 = part[11];
              String parte13 = part[12];
              String parte14 = part[13];
              String parte15 = part[14];
              linea = parte1 + "\n" + parte4 + "\n" + parte7 + "\n" + parte10 + "\n" + parte13;
              vc = parte2 + "\n" + parte5 + "\n" + parte8 + "\n" + parte11 + "\n" + parte14;
              estado = parte3 + "\n" + parte6 + "\n" + parte9 + "\n" + parte12 + "\n" + parte15;
              break;
          }

        } else {
          linea = "";
          vc = "";
          estado = "";
        }
        celda5 = new PdfPCell(new Phrase(linea));
        celda12 = new PdfPCell(new Phrase(vc));
        celda13 = new PdfPCell(new Phrase(estado));
        celda6 = new PdfPCell(new Phrase(rs.getString("numfijo")));
        parts = rs.getString("activadofijo").split("-");
        ano = parts[0];
        m = parts[1];
        d = parts[2];
        String acfijo = d + "-" + m + "-" + ano;
        parts = rs.getString("activadofijo").split("-");
        ano = parts[0];
        m = parts[1];
        d = parts[2];
        String acmovil = d + "-" + m + "-" + ano;
        celda7 = new PdfPCell(new Phrase(acfijo));
        celda8 = new PdfPCell(new Phrase(acmovil));
        celda9 = new PdfPCell(new Phrase(rs.getString("observaciones")));
        celda15 = new PdfPCell(new Phrase(rs.getString("documentos")));
        celda16 = new PdfPCell(new Phrase(rs.getString("contrato")));
        celda10 = new PdfPCell(new Phrase(rs.getString("estado")));
        tabla.addCell(celda1);
        tabla.addCell(celda2);
        tabla.addCell(celda3);
        tabla.addCell(celda11);
        tabla.addCell(celda4);
        tabla.addCell(celda14);
        tabla.addCell(celda5);
        tabla.addCell(celda12);
        tabla.addCell(celda13);
        tabla.addCell(celda6);
        tabla.addCell(celda7);
        tabla.addCell(celda8);
        tabla.addCell(celda9);
        tabla.addCell(celda15);
        tabla.addCell(celda16);
        tabla.addCell(celda10);
        if (!rs.next()) {
          i = filas;
        }
      }
      celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
      celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
      celda3.setHorizontalAlignment(Element.ALIGN_CENTER);
      celda11.setHorizontalAlignment(Element.ALIGN_CENTER);
      celda4.setHorizontalAlignment(Element.ALIGN_CENTER);
      celda14.setHorizontalAlignment(Element.ALIGN_CENTER);
      celda5.setHorizontalAlignment(Element.ALIGN_CENTER);
      celda12.setHorizontalAlignment(Element.ALIGN_CENTER);
      celda13.setHorizontalAlignment(Element.ALIGN_CENTER);
      celda6.setHorizontalAlignment(Element.ALIGN_CENTER);
      celda7.setHorizontalAlignment(Element.ALIGN_CENTER);
      celda8.setHorizontalAlignment(Element.ALIGN_CENTER);
      celda9.setHorizontalAlignment(Element.ALIGN_CENTER);
      celda15.setHorizontalAlignment(Element.ALIGN_CENTER);
      celda16.setHorizontalAlignment(Element.ALIGN_CENTER);
      celda10.setHorizontalAlignment(Element.ALIGN_CENTER);

      celda1.setVerticalAlignment(Element.ALIGN_MIDDLE);
      celda2.setVerticalAlignment(Element.ALIGN_MIDDLE);
      celda3.setVerticalAlignment(Element.ALIGN_MIDDLE);
      celda11.setVerticalAlignment(Element.ALIGN_MIDDLE);
      celda4.setVerticalAlignment(Element.ALIGN_MIDDLE);
      celda14.setVerticalAlignment(Element.ALIGN_MIDDLE);
      celda5.setVerticalAlignment(Element.ALIGN_MIDDLE);
      celda12.setVerticalAlignment(Element.ALIGN_MIDDLE);
      celda13.setVerticalAlignment(Element.ALIGN_MIDDLE);
      celda6.setVerticalAlignment(Element.ALIGN_MIDDLE);
      celda7.setVerticalAlignment(Element.ALIGN_MIDDLE);
      celda8.setVerticalAlignment(Element.ALIGN_MIDDLE);
      celda9.setVerticalAlignment(Element.ALIGN_MIDDLE);
      celda15.setVerticalAlignment(Element.ALIGN_MIDDLE);
      celda16.setVerticalAlignment(Element.ALIGN_MIDDLE);
      celda10.setVerticalAlignment(Element.ALIGN_MIDDLE);
      tabla.setWidthPercentage(102);
      documento.add(tabla);
      documento.close();
      ficheroPdf.close();
      JOptionPane.showMessageDialog(
          null, "Informe creado correctamente", "Informe", JOptionPane.YES_NO_CANCEL_OPTION);

    } catch (FileNotFoundException | DocumentException ex) {
      Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
        ficheroPdf.close();
      } catch (IOException ex) {
        Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

  public static void generalxmes(ResultSet rs, String seleccion, String mesecito) {
    ResultSet copia = rs;
    String numfijo;
    Font font1 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Element.ALIGN_CENTER); // negrita
    Font font2 = new Font(Font.FontFamily.TIMES_ROMAN, 40, Font.BOLD); // negrita

    Calendar fecha = new GregorianCalendar();
    int amo = fecha.get(Calendar.YEAR);
    int mes = fecha.get(Calendar.MONTH);
    int dia = fecha.get(Calendar.DAY_OF_MONTH);
    String fechafin = +dia + "." + (mes + 1) + "." + amo;
    String linea = null, vc = null, estado = null, ano, m, d;
    int filas = 0;
    PdfPCell celda1,
        celda2,
        celda3,
        celda4,
        celda5,
        celda6,
        celda7,
        celda8,
        celda9,
        celda10,
        celda11,
        celda12,
        celda13,
        celda14,
        celda15,
        celda16,
        celda17,
        celda18,
        celda19,
        celda21,
        celda22,
        celda23;

    FileOutputStream ficheroPdf = null;
    try {
      do {
        filas += 1;
      } while (copia.next());
      Image imagen = Image.getInstance("..\\logo.jpg");
      Document documento = new Document(PageSize.A2.rotate());
      ficheroPdf =
          new FileOutputStream(
              "C:\\Users\\"
                  + System.getProperty("user.name")
                  + "\\Google Drive\\REPORTES\\"
                  + mesecito
                  + "-"
                  + fechafin
                  + ".pdf");
      imagen.scalePercent(75f);
      PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(10);
      documento.open();
      PdfPTable tablaimg = new PdfPTable(2);
      PdfPCell cel1 = new PdfPCell(imagen);
      cel1.setBorder(Rectangle.NO_BORDER);
      PdfPCell cel2 =
          new PdfPCell(new Paragraph("Informe de " + mesecito + " a día " + fechafin, font2));
      cel2.setBorder(Rectangle.NO_BORDER);
      cel2.setVerticalAlignment(Element.ALIGN_MIDDLE);
      tablaimg.addCell(cel1);
      tablaimg.addCell(cel2);

      documento.add(tablaimg);
      documento.add(new Paragraph(" "));

      // cabecera
      PdfPTable tabla = new PdfPTable(22);
      tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
      PdfPCell cab1 = new PdfPCell(new Paragraph("Fecha de Carga", font1));
      PdfPCell cab2 = new PdfPCell(new Paragraph("Delegación", font1));
      PdfPCell cab3 = new PdfPCell(new Paragraph("Comercial", font1));
      PdfPCell cab4 = new PdfPCell(new Paragraph("Segmento", font1));
      PdfPCell cab5 = new PdfPCell(new Paragraph("Cía", font1));
      PdfPCell cab23 = new PdfPCell(new Paragraph("Distribuidor", font1));
      PdfPCell cab17 = new PdfPCell(new Paragraph("Cliente", font1));
      PdfPCell cab6 = new PdfPCell(new Paragraph("Oferta", font1));
      PdfPCell cab7 = new PdfPCell(new Paragraph("ID Oferta", font1));
      PdfPCell cab8 = new PdfPCell(new Paragraph("Fijo", font1));
      PdfPCell cab9 = new PdfPCell(new Paragraph("Visita Técnico", font1));
      PdfPCell cab10 = new PdfPCell(new Paragraph("Activación Fijo", font1));
      PdfPCell cab11 = new PdfPCell(new Paragraph("Alta Móviles", font1));
      PdfPCell cab12 = new PdfPCell(new Paragraph("Portas Móviles", font1));
      PdfPCell cab13 = new PdfPCell(new Paragraph("VC Movil", font1));
      PdfPCell cab14 = new PdfPCell(new Paragraph("Estado Activación Movil", font1));
      PdfPCell cab19 = new PdfPCell(new Paragraph("VAP", font1));
      PdfPCell cab15 = new PdfPCell(new Paragraph("Comisión Oficina", font1));
      PdfPCell cab21 = new PdfPCell(new Paragraph("Ptos Oficina", font1));
      PdfPCell cab18 = new PdfPCell(new Paragraph("Comisión Agente", font1));
      PdfPCell cab22 = new PdfPCell(new Paragraph("Ptos Agente", font1));
      PdfPCell cab16 = new PdfPCell(new Paragraph("Pdte Comisión", font1));
      cab1.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab2.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab3.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab4.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab4.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab5.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab6.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab7.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab8.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab9.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab10.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab11.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab12.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab13.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab14.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab15.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab16.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab17.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab18.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab19.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab21.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab22.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab23.setHorizontalAlignment(Element.ALIGN_CENTER);

      cab1.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab2.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab3.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab4.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab4.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab5.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab6.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab7.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab8.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab9.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab10.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab11.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab12.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab13.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab14.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab15.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab16.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab17.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab18.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab19.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab21.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab22.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab23.setVerticalAlignment(Element.ALIGN_MIDDLE);

      tabla.addCell(cab1);
      tabla.addCell(cab2);
      tabla.addCell(cab3);
      tabla.addCell(cab4);
      tabla.addCell(cab5);
      tabla.addCell(cab23);
      tabla.addCell(cab17);
      tabla.addCell(cab6);
      tabla.addCell(cab7);
      tabla.addCell(cab8);
      tabla.addCell(cab9);
      tabla.addCell(cab10);
      tabla.addCell(cab11);
      tabla.addCell(cab12);
      tabla.addCell(cab13);
      tabla.addCell(cab14);
      tabla.addCell(cab19);
      tabla.addCell(cab15);
      tabla.addCell(cab21);
      tabla.addCell(cab18);
      tabla.addCell(cab22);
      tabla.addCell(cab16);
      tabla.setWidthPercentage(102);
      documento.add(tabla);
      rs.first();
      tabla = new PdfPTable(22);
      tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
      for (int i = 0; i < filas; i++) {
        String parts[] = rs.getString("fechacreacion").split("-");
        ano = parts[0];
        m = parts[1];
        d = parts[2];
        String f = d + "-" + m + "-" + ano;
        celda1 = new PdfPCell(new Paragraph(f));
        celda2 = new PdfPCell(new Paragraph(rs.getString("delegacion")));
        celda3 = new PdfPCell(new Paragraph(rs.getString("comercial")));
        celda4 = new PdfPCell(new Paragraph(rs.getString("segmento")));
        celda5 = new PdfPCell(new Paragraph(rs.getString("operador")));
        celda23 = new PdfPCell(new Paragraph(rs.getString("distribuidor")));
        celda17 = new PdfPCell(new Paragraph(rs.getString("nombrecliente")));
        celda6 = new PdfPCell(new Paragraph(rs.getString("oferta")));
        celda7 = new PdfPCell(new Paragraph(rs.getString("idoferta")));
        String cadena[] = rs.getString("oferta").split(",");

        if (cadena[0].equalsIgnoreCase("-")) {
          numfijo = "N/A";
        } else {
          if (!rs.getString("numfijo").equalsIgnoreCase("N/A")) {
            numfijo = "Porta";
          } else {
            numfijo = "Alta";
          }
        }
        celda8 = new PdfPCell(new Paragraph(numfijo));
        parts = rs.getString("activadofijo").split("-");
        ano = parts[0];
        m = parts[1];
        d = parts[2];
        String acfijo = d + "-" + m + "-" + ano;
        parts = rs.getString("activadofijo").split("-");
        ano = parts[0];
        m = parts[1];
        d = parts[2];
        String acmovil = d + "-" + m + "-" + ano;
        celda9 = new PdfPCell(new Paragraph(acfijo));
        celda10 = new PdfPCell(new Paragraph(acmovil));
        celda11 = new PdfPCell(new Paragraph(rs.getString("numaltasmovi")));
        int n = Integer.parseInt(rs.getString("numportasmovil"));
        int n1 = Integer.parseInt(rs.getString("numaltasmovi"));
        n += n1;
        String p1,
            p2,
            p3,
            fijo,
            movil,
            c1 = "",
            c2 = "",
            c3 = "",
            c4 = "",
            c5 = "",
            c6 = "",
            c7 = "",
            c8 = "",
            c9 = "",
            c10 = "",
            c11 = "",
            c12 = "",
            c13 = "",
            c14 = "",
            c15 = "",
            c16 = "",
            c17 = "",
            c18 = "",
            c19 = "",
            c20 = "";
        String c[];
        String comisofi = "", comisag = "", ptosofi = "", ptosag = "";
        if (n > 0) {
          switch (n) {
            case 1:
              String part[] = rs.getString("lineasmoviles").split(",");
              String parte1 = part[0];
              String parte2 = part[1];
              String parte3 = part[2];
              linea = parte1;
              vc = parte2;
              estado = parte3;
              if (parte1.equalsIgnoreCase("AC")) {
                if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                  c = rs.getString("comisiones").split(",");
                  c1 = c[0];
                  c2 = c[1];
                  c3 = c[2];
                  c4 = c[3];
                } else {
                  c1 = "";
                  c2 = "";
                  c3 = "";
                  c4 = "";
                }
              }
              comisofi = c1;
              ptosofi = c2;
              comisag = c3;
              ptosag = c4;
              break;

            case 2:
              part = rs.getString("lineasmoviles").split(",");
              parte1 = part[0];
              parte2 = part[1];
              parte3 = part[2];
              String parte4 = part[3];
              String parte5 = part[4];
              String parte6 = part[5];
              linea = parte1 + "\n" + parte4;
              vc = parte2 + "\n" + parte5;
              estado = parte3 + "\n" + parte6;
              if (parte1.equalsIgnoreCase("AC")) {
                if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                  c = rs.getString("comisiones").split(",");
                  c1 = c[0];
                  c2 = c[1];
                  c3 = c[2];
                  c4 = c[3];
                } else {
                  c1 = "";
                  c2 = "";
                  c3 = "";
                  c4 = "";
                }
              }
              if (parte4.equalsIgnoreCase("AC")) {
                if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                  c = rs.getString("comisiones").split(",");
                  c1 = c[0];
                  c2 = c[1];
                  c3 = c[2];
                  c4 = c[3];
                  c5 = c[4];
                  c6 = c[5];
                  c7 = c[6];
                  c8 = c[7];
                } else {
                  c1 = "";
                  c2 = "";
                  c3 = "";
                  c4 = "";
                  c5 = "";
                  c6 = "";
                  c7 = "";
                  c8 = "";
                }
              }
              comisofi = c1 + "\n" + c5;
              ptosofi = c2 + "\n" + c6;
              comisag = c3 + "\n" + c7;
              ptosag = c4 + "\n" + c8;
              break;
            case 3:
              part = rs.getString("lineasmoviles").split(",");
              parte1 = part[0];
              parte2 = part[1];
              parte3 = part[2];
              parte4 = part[3];
              parte5 = part[4];
              parte6 = part[5];
              String parte7 = part[6];
              String parte8 = part[7];
              String parte9 = part[8];
              linea = parte1 + "\n" + parte4 + "\n" + parte7;
              vc = parte2 + "\n" + parte5 + "\n" + parte8;
              estado = parte3 + "\n" + parte6 + "\n" + parte9;
              if (parte1.equalsIgnoreCase("AC")) {
                if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                  c = rs.getString("comisiones").split(",");
                  c1 = c[0];
                  c2 = c[1];
                  c3 = c[2];
                  c4 = c[3];
                } else {
                  c1 = "";
                  c2 = "";
                  c3 = "";
                  c4 = "";
                }
              }
              if (parte4.equalsIgnoreCase("AC")) {
                if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                  c = rs.getString("comisiones").split(",");
                  c1 = c[0];
                  c2 = c[1];
                  c3 = c[2];
                  c4 = c[3];
                  c5 = c[4];
                  c6 = c[5];
                  c7 = c[6];
                  c8 = c[7];
                } else {
                  c1 = "";
                  c2 = "";
                  c3 = "";
                  c4 = "";
                  c5 = "";
                  c6 = "";
                  c7 = "";
                  c8 = "";
                }
              }
              if (parte7.equalsIgnoreCase("AC")) {
                if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                  c = rs.getString("comisiones").split(",");
                  c1 = c[0];
                  c2 = c[1];
                  c3 = c[2];
                  c4 = c[3];
                  c5 = c[4];
                  c6 = c[5];
                  c7 = c[6];
                  c8 = c[7];
                  c9 = c[8];
                  c10 = c[9];
                  c11 = c[10];
                  c12 = c[11];
                } else {
                  c1 = "";
                  c2 = "";
                  c3 = "";
                  c4 = "";
                  c5 = "";
                  c6 = "";
                  c7 = "";
                  c8 = "";
                  c9 = "";
                  c10 = "";
                  c11 = "";
                  c12 = "";
                }
              }
              comisofi = c1 + "\n" + c5 + "\n" + c9;
              ptosofi = c2 + "\n" + c6 + "\n" + c10;
              comisag = c3 + "\n" + c7 + "\n" + c11;
              ptosag = c4 + "\n" + c8 + "\n" + c12;
              break;

            case 4:
              part = rs.getString("lineasmoviles").split(",");
              parte1 = part[0];
              parte2 = part[1];
              parte3 = part[2];
              parte4 = part[3];
              parte5 = part[4];
              parte6 = part[5];
              parte7 = part[6];
              parte8 = part[7];
              parte9 = part[8];
              String parte10 = part[9];
              String parte11 = part[10];
              String parte12 = part[11];
              linea = parte1 + "\n" + parte4 + "\n" + parte7 + "\n" + parte10;
              vc = parte2 + "\n" + parte5 + "\n" + parte8 + "\n" + parte11;
              estado = parte3 + "\n" + parte6 + "\n" + parte9 + "\n" + parte12;
              if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                c = rs.getString("comisiones").split(",");
                c1 = c[0];
                c2 = c[1];
                c3 = c[2];
                c4 = c[3];
                c5 = c[4];
                c6 = c[5];
                c7 = c[6];
                c8 = c[7];
                c9 = c[8];
                c10 = c[9];
                c11 = c[10];
                c12 = c[11];
                c13 = c[12];
                c14 = c[13];
                c15 = c[14];
                c16 = c[15];
              } else {
                c1 = "";
                c2 = "";
                c3 = "";
                c4 = "";
                c5 = "";
                c6 = "";
                c7 = "";
                c8 = "";
                c9 = "";
                c10 = "";
                c11 = "";
                c12 = "";
                c13 = "";
                c14 = "";
                c15 = "";
                c16 = "";
              }
              comisofi = c1 + "\n" + c5 + "\n" + c9 + "\n" + c13;
              ptosofi = c2 + "\n" + c6 + "\n" + c10 + "\n" + c14;
              comisag = c3 + "\n" + c7 + "\n" + c11 + "\n" + c15;
              ptosag = c4 + "\n" + c8 + "\n" + c12 + "\n" + c16;
              break;

            case 5:
              part = rs.getString("lineasmoviles").split(",");
              parte1 = part[0];
              parte2 = part[1];
              parte3 = part[2];
              parte4 = part[3];
              parte5 = part[4];
              parte6 = part[5];
              parte7 = part[6];
              parte8 = part[7];
              parte9 = part[8];
              parte10 = part[9];
              parte11 = part[10];
              parte12 = part[11];
              String parte13 = part[12];
              String parte14 = part[13];
              String parte15 = part[14];
              linea = parte1 + "\n" + parte4 + "\n" + parte7 + "\n" + parte10 + "\n" + parte13;
              vc = parte2 + "\n" + parte5 + "\n" + parte8 + "\n" + parte11 + "\n" + parte14;
              estado = parte3 + "\n" + parte6 + "\n" + parte9 + "\n" + parte12 + "\n" + parte15;
              if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                c = rs.getString("comisiones").split(",");
                c1 = c[0];
                c2 = c[1];
                c3 = c[2];
                c4 = c[3];
                c5 = c[4];
                c6 = c[5];
                c7 = c[6];
                c8 = c[7];
                c9 = c[8];
                c10 = c[9];
                c11 = c[10];
                c12 = c[11];
                c13 = c[12];
                c14 = c[13];
                c15 = c[14];
                c16 = c[15];
                c17 = c[16];
                c18 = c[17];
                c19 = c[18];
                c20 = c[19];
              } else {
                c1 = "";
                c2 = "";
                c3 = "";
                c4 = "";
                c5 = "";
                c6 = "";
                c7 = "";
                c8 = "";
                c9 = "";
                c10 = "";
                c11 = "";
                c12 = "";
                c13 = "";
                c14 = "";
                c15 = "";
                c16 = "";
                c17 = "";
                c18 = "";
                c19 = "";
                c20 = "";
              }
              comisofi = c1 + "\n" + c5 + "\n" + c9 + "\n" + c13 + "\n" + c17;
              ptosofi = c2 + "\n" + c6 + "\n" + c10 + "\n" + c14 + "\n" + c18;
              comisag = c3 + "\n" + c7 + "\n" + c11 + "\n" + c15 + "\n" + c19;
              ptosag = c4 + "\n" + c8 + "\n" + c12 + "\n" + c16 + "\n" + c20;
              break;
          }

        } else {
          linea = "";
          vc = "";
          estado = "";
          comisag = "";
          comisofi = "";
          ptosag = "";
          ptosofi = "";
        }
        celda12 = new PdfPCell(new Paragraph(linea));
        celda13 = new PdfPCell(new Paragraph(vc));
        celda14 = new PdfPCell(new Paragraph(estado));
        celda19 = new PdfPCell(new Paragraph(estado));
        celda15 = new PdfPCell(new Paragraph(comisofi));
        celda21 = new PdfPCell(new Paragraph(ptosofi));
        celda18 = new PdfPCell(new Paragraph(comisag));
        celda22 = new PdfPCell(new Paragraph(ptosag));
        celda16 = new PdfPCell(new Paragraph(" "));
        celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda3.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda4.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda5.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda23.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda6.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda7.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda8.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda9.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda10.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda11.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda12.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda13.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda14.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda19.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda15.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda21.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda18.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda16.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda22.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda17.setHorizontalAlignment(Element.ALIGN_CENTER);

        celda1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda4.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda5.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda6.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda7.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda8.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda9.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda10.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda11.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda12.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda13.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda14.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda19.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda15.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda21.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda22.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda18.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda16.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda17.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda23.setVerticalAlignment(Element.ALIGN_MIDDLE);
        tabla.addCell(celda1);
        tabla.addCell(celda2);
        tabla.addCell(celda3);
        tabla.addCell(celda4);
        tabla.addCell(celda5);
        tabla.addCell(celda23);
        tabla.addCell(celda17);
        tabla.addCell(celda6);
        tabla.addCell(celda7);
        tabla.addCell(celda8);
        tabla.addCell(celda9);
        tabla.addCell(celda10);
        tabla.addCell(celda11);
        tabla.addCell(celda12);
        tabla.addCell(celda13);
        tabla.addCell(celda14);
        tabla.addCell(celda19);
        tabla.addCell(celda15);
        tabla.addCell(celda21);
        tabla.addCell(celda18);
        tabla.addCell(celda22);
        tabla.addCell(celda16);
        if (!rs.next()) {
          i = filas;
        }
      }
      tabla.setWidthPercentage(102);

      documento.add(tabla);
      documento.close();
      JOptionPane.showMessageDialog(
          null, "Informe creado correctamente", "Informe", JOptionPane.YES_NO_CANCEL_OPTION);

    } catch (FileNotFoundException | DocumentException | SQLException ex) {
      Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
        ficheroPdf.close();
      } catch (IOException ex) {
        Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

  public static void generalxmesycia(ResultSet rs, String mesecito, String cia) {
    ResultSet copia = rs;
    String numfijo;
    Font font1 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Element.ALIGN_CENTER); // negrita
    Font font2 = new Font(Font.FontFamily.TIMES_ROMAN, 40, Font.BOLD); // negrita

    Calendar fecha = new GregorianCalendar();
    int amo = fecha.get(Calendar.YEAR);
    int mes = fecha.get(Calendar.MONTH);
    int dia = fecha.get(Calendar.DAY_OF_MONTH);
    String fechafin = +dia + "." + (mes + 1) + "." + amo;
    String linea = null, vc = null, estado = null, ano, m, d;
    int filas = 0;
    PdfPCell celda1,
        celda2,
        celda3,
        celda4,
        celda5,
        celda6,
        celda7,
        celda8,
        celda9,
        celda10,
        celda11,
        celda12,
        celda13,
        celda14,
        celda15,
        celda16,
        celda17,
        celda18,
        celda19,
        celda21,
        celda22,
        celda23;

    FileOutputStream ficheroPdf = null;
    try {
      do {
        filas += 1;
      } while (copia.next());
      Image imagen = Image.getInstance("..\\logo.jpg");
      Document documento = new Document(PageSize.A2.rotate());
      ficheroPdf =
          new FileOutputStream(
              "C:\\Users\\"
                  + System.getProperty("user.name")
                  + "\\Google Drive\\REPORTES\\\\"
                  + cia
                  + "\\"
                  + mesecito
                  + "-"
                  + fechafin
                  + ".pdf");
      imagen.scalePercent(75f);
      PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(10);
      documento.open();
      PdfPTable tablaimg = new PdfPTable(2);
      PdfPCell cel1 = new PdfPCell(imagen);
      cel1.setBorder(Rectangle.NO_BORDER);
      PdfPCell cel2 =
          new PdfPCell(new Paragraph("Informe de " + mesecito + " a día " + fechafin, font2));
      cel2.setBorder(Rectangle.NO_BORDER);
      cel2.setVerticalAlignment(Element.ALIGN_MIDDLE);
      tablaimg.addCell(cel1);
      tablaimg.addCell(cel2);

      documento.add(tablaimg);
      documento.add(new Paragraph(" "));

      // cabecera
      PdfPTable tabla = new PdfPTable(22);
      tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
      PdfPCell cab1 = new PdfPCell(new Paragraph("Fecha de Carga", font1));
      PdfPCell cab2 = new PdfPCell(new Paragraph("Delegación", font1));
      PdfPCell cab3 = new PdfPCell(new Paragraph("Comercial", font1));
      PdfPCell cab4 = new PdfPCell(new Paragraph("Segmento", font1));
      PdfPCell cab5 = new PdfPCell(new Paragraph("Cía", font1));
      PdfPCell cab23 = new PdfPCell(new Paragraph("Distribuidor", font1));
      PdfPCell cab17 = new PdfPCell(new Paragraph("Cliente", font1));
      PdfPCell cab6 = new PdfPCell(new Paragraph("Oferta", font1));
      PdfPCell cab7 = new PdfPCell(new Paragraph("ID Oferta", font1));
      PdfPCell cab8 = new PdfPCell(new Paragraph("Fijo", font1));
      PdfPCell cab9 = new PdfPCell(new Paragraph("Visita Técnico", font1));
      PdfPCell cab10 = new PdfPCell(new Paragraph("Activación Fijo", font1));
      PdfPCell cab11 = new PdfPCell(new Paragraph("Alta Móviles", font1));
      PdfPCell cab12 = new PdfPCell(new Paragraph("Portas Móviles", font1));
      PdfPCell cab13 = new PdfPCell(new Paragraph("VC Movil", font1));
      PdfPCell cab14 = new PdfPCell(new Paragraph("Estado Activación Movil", font1));
      PdfPCell cab19 = new PdfPCell(new Paragraph("VAP", font1));
      PdfPCell cab15 = new PdfPCell(new Paragraph("Comisión Oficina", font1));
      PdfPCell cab21 = new PdfPCell(new Paragraph("Ptos Oficina", font1));
      PdfPCell cab18 = new PdfPCell(new Paragraph("Comisión Agente", font1));
      PdfPCell cab22 = new PdfPCell(new Paragraph("Ptos Agente", font1));
      PdfPCell cab16 = new PdfPCell(new Paragraph("Pdte Comisión", font1));
      cab1.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab2.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab3.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab4.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab4.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab5.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab6.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab7.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab8.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab9.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab10.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab11.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab12.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab13.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab14.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab15.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab16.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab17.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab18.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab19.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab21.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab22.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab23.setHorizontalAlignment(Element.ALIGN_CENTER);

      cab1.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab2.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab3.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab4.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab4.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab5.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab6.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab7.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab8.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab9.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab10.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab11.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab12.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab13.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab14.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab15.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab16.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab17.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab18.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab19.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab21.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab22.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab23.setVerticalAlignment(Element.ALIGN_MIDDLE);

      tabla.addCell(cab1);
      tabla.addCell(cab2);
      tabla.addCell(cab3);
      tabla.addCell(cab4);
      tabla.addCell(cab5);
      tabla.addCell(cab23);
      tabla.addCell(cab17);
      tabla.addCell(cab6);
      tabla.addCell(cab7);
      tabla.addCell(cab8);
      tabla.addCell(cab9);
      tabla.addCell(cab10);
      tabla.addCell(cab11);
      tabla.addCell(cab12);
      tabla.addCell(cab13);
      tabla.addCell(cab14);
      tabla.addCell(cab19);
      tabla.addCell(cab15);
      tabla.addCell(cab21);
      tabla.addCell(cab18);
      tabla.addCell(cab22);
      tabla.addCell(cab16);
      tabla.setWidthPercentage(102);
      documento.add(tabla);
      rs.first();
      tabla = new PdfPTable(22);
      tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
      for (int i = 0; i < filas; i++) {
        String parts[] = rs.getString("fechacreacion").split("-");
        ano = parts[0];
        m = parts[1];
        d = parts[2];
        String f = d + "-" + m + "-" + ano;
        celda1 = new PdfPCell(new Paragraph(f));
        celda2 = new PdfPCell(new Paragraph(rs.getString("delegacion")));
        celda3 = new PdfPCell(new Paragraph(rs.getString("comercial")));
        celda4 = new PdfPCell(new Paragraph(rs.getString("segmento")));
        celda5 = new PdfPCell(new Paragraph(rs.getString("operador")));
        celda23 = new PdfPCell(new Paragraph(rs.getString("distribuidor")));
        celda17 = new PdfPCell(new Paragraph(rs.getString("nombrecliente")));
        celda6 = new PdfPCell(new Paragraph(rs.getString("oferta")));
        celda7 = new PdfPCell(new Paragraph(rs.getString("idoferta")));
        String cadena[] = rs.getString("oferta").split(",");

        if (cadena[0].equalsIgnoreCase("-")) {
          numfijo = "N/A";
        } else {
          if (!rs.getString("numfijo").equalsIgnoreCase("N/A")) {
            numfijo = "Porta";
          } else {
            numfijo = "Alta";
          }
        }
        celda8 = new PdfPCell(new Paragraph(numfijo));
        parts = rs.getString("activadofijo").split("-");
        ano = parts[0];
        m = parts[1];
        d = parts[2];
        String acfijo = d + "-" + m + "-" + ano;
        parts = rs.getString("activadofijo").split("-");
        ano = parts[0];
        m = parts[1];
        d = parts[2];
        String acmovil = d + "-" + m + "-" + ano;
        celda9 = new PdfPCell(new Paragraph(acfijo));
        celda10 = new PdfPCell(new Paragraph(acmovil));
        celda11 = new PdfPCell(new Paragraph(rs.getString("numaltasmovi")));
        int n = Integer.parseInt(rs.getString("numportasmovil"));
        int n1 = Integer.parseInt(rs.getString("numaltasmovi"));
        n += n1;
        String p1,
            p2,
            p3,
            fijo,
            movil,
            c1 = "",
            c2 = "",
            c3 = "",
            c4 = "",
            c5 = "",
            c6 = "",
            c7 = "",
            c8 = "",
            c9 = "",
            c10 = "",
            c11 = "",
            c12 = "",
            c13 = "",
            c14 = "",
            c15 = "",
            c16 = "",
            c17 = "",
            c18 = "",
            c19 = "",
            c20 = "";
        String c[];
        String comisofi = "", comisag = "", ptosofi = "", ptosag = "";
        if (n > 0) {
          switch (n) {
            case 1:
              String part[] = rs.getString("lineasmoviles").split(",");
              String parte1 = part[0];
              String parte2 = part[1];
              String parte3 = part[2];
              linea = parte1;
              vc = parte2;
              estado = parte3;
              if (parte1.equalsIgnoreCase("AC")) {
                if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                  c = rs.getString("comisiones").split(",");
                  c1 = c[0];
                  c2 = c[1];
                  c3 = c[2];
                  c4 = c[3];
                } else {
                  c1 = "";
                  c2 = "";
                  c3 = "";
                  c4 = "";
                }
              }
              comisofi = c1;
              ptosofi = c2;
              comisag = c3;
              ptosag = c4;
              break;

            case 2:
              part = rs.getString("lineasmoviles").split(",");
              parte1 = part[0];
              parte2 = part[1];
              parte3 = part[2];
              String parte4 = part[3];
              String parte5 = part[4];
              String parte6 = part[5];
              linea = parte1 + "\n" + parte4;
              vc = parte2 + "\n" + parte5;
              estado = parte3 + "\n" + parte6;
              if (parte1.equalsIgnoreCase("AC")) {
                if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                  c = rs.getString("comisiones").split(",");
                  c1 = c[0];
                  c2 = c[1];
                  c3 = c[2];
                  c4 = c[3];
                } else {
                  c1 = "";
                  c2 = "";
                  c3 = "";
                  c4 = "";
                }
              }
              if (parte4.equalsIgnoreCase("AC")) {
                if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                  c = rs.getString("comisiones").split(",");
                  c1 = c[0];
                  c2 = c[1];
                  c3 = c[2];
                  c4 = c[3];
                  c5 = c[4];
                  c6 = c[5];
                  c7 = c[6];
                  c8 = c[7];
                } else {
                  c1 = "";
                  c2 = "";
                  c3 = "";
                  c4 = "";
                  c5 = "";
                  c6 = "";
                  c7 = "";
                  c8 = "";
                }
              }
              comisofi = c1 + "\n" + c5;
              ptosofi = c2 + "\n" + c6;
              comisag = c3 + "\n" + c7;
              ptosag = c4 + "\n" + c8;
              break;
            case 3:
              part = rs.getString("lineasmoviles").split(",");
              parte1 = part[0];
              parte2 = part[1];
              parte3 = part[2];
              parte4 = part[3];
              parte5 = part[4];
              parte6 = part[5];
              String parte7 = part[6];
              String parte8 = part[7];
              String parte9 = part[8];
              linea = parte1 + "\n" + parte4 + "\n" + parte7;
              vc = parte2 + "\n" + parte5 + "\n" + parte8;
              estado = parte3 + "\n" + parte6 + "\n" + parte9;
              if (parte1.equalsIgnoreCase("AC")) {
                if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                  c = rs.getString("comisiones").split(",");
                  c1 = c[0];
                  c2 = c[1];
                  c3 = c[2];
                  c4 = c[3];
                } else {
                  c1 = "";
                  c2 = "";
                  c3 = "";
                  c4 = "";
                }
              }
              if (parte4.equalsIgnoreCase("AC")) {
                if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                  c = rs.getString("comisiones").split(",");
                  c1 = c[0];
                  c2 = c[1];
                  c3 = c[2];
                  c4 = c[3];
                  c5 = c[4];
                  c6 = c[5];
                  c7 = c[6];
                  c8 = c[7];
                } else {
                  c1 = "";
                  c2 = "";
                  c3 = "";
                  c4 = "";
                  c5 = "";
                  c6 = "";
                  c7 = "";
                  c8 = "";
                }
              }
              if (parte7.equalsIgnoreCase("AC")) {
                if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                  c = rs.getString("comisiones").split(",");
                  c1 = c[0];
                  c2 = c[1];
                  c3 = c[2];
                  c4 = c[3];
                  c5 = c[4];
                  c6 = c[5];
                  c7 = c[6];
                  c8 = c[7];
                  c9 = c[8];
                  c10 = c[9];
                  c11 = c[10];
                  c12 = c[11];
                } else {
                  c1 = "";
                  c2 = "";
                  c3 = "";
                  c4 = "";
                  c5 = "";
                  c6 = "";
                  c7 = "";
                  c8 = "";
                  c9 = "";
                  c10 = "";
                  c11 = "";
                  c12 = "";
                }
              }
              comisofi = c1 + "\n" + c5 + "\n" + c9;
              ptosofi = c2 + "\n" + c6 + "\n" + c10;
              comisag = c3 + "\n" + c7 + "\n" + c11;
              ptosag = c4 + "\n" + c8 + "\n" + c12;
              break;

            case 4:
              part = rs.getString("lineasmoviles").split(",");
              parte1 = part[0];
              parte2 = part[1];
              parte3 = part[2];
              parte4 = part[3];
              parte5 = part[4];
              parte6 = part[5];
              parte7 = part[6];
              parte8 = part[7];
              parte9 = part[8];
              String parte10 = part[9];
              String parte11 = part[10];
              String parte12 = part[11];
              linea = parte1 + "\n" + parte4 + "\n" + parte7 + "\n" + parte10;
              vc = parte2 + "\n" + parte5 + "\n" + parte8 + "\n" + parte11;
              estado = parte3 + "\n" + parte6 + "\n" + parte9 + "\n" + parte12;
              if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                c = rs.getString("comisiones").split(",");
                c1 = c[0];
                c2 = c[1];
                c3 = c[2];
                c4 = c[3];
                c5 = c[4];
                c6 = c[5];
                c7 = c[6];
                c8 = c[7];
                c9 = c[8];
                c10 = c[9];
                c11 = c[10];
                c12 = c[11];
                c13 = c[12];
                c14 = c[13];
                c15 = c[14];
                c16 = c[15];
              } else {
                c1 = "";
                c2 = "";
                c3 = "";
                c4 = "";
                c5 = "";
                c6 = "";
                c7 = "";
                c8 = "";
                c9 = "";
                c10 = "";
                c11 = "";
                c12 = "";
                c13 = "";
                c14 = "";
                c15 = "";
                c16 = "";
              }
              comisofi = c1 + "\n" + c5 + "\n" + c9 + "\n" + c13;
              ptosofi = c2 + "\n" + c6 + "\n" + c10 + "\n" + c14;
              comisag = c3 + "\n" + c7 + "\n" + c11 + "\n" + c15;
              ptosag = c4 + "\n" + c8 + "\n" + c12 + "\n" + c16;
              break;

            case 5:
              part = rs.getString("lineasmoviles").split(",");
              parte1 = part[0];
              parte2 = part[1];
              parte3 = part[2];
              parte4 = part[3];
              parte5 = part[4];
              parte6 = part[5];
              parte7 = part[6];
              parte8 = part[7];
              parte9 = part[8];
              parte10 = part[9];
              parte11 = part[10];
              parte12 = part[11];
              String parte13 = part[12];
              String parte14 = part[13];
              String parte15 = part[14];
              linea = parte1 + "\n" + parte4 + "\n" + parte7 + "\n" + parte10 + "\n" + parte13;
              vc = parte2 + "\n" + parte5 + "\n" + parte8 + "\n" + parte11 + "\n" + parte14;
              estado = parte3 + "\n" + parte6 + "\n" + parte9 + "\n" + parte12 + "\n" + parte15;
              if (!rs.getString("comisiones").equalsIgnoreCase("NULL")) {
                c = rs.getString("comisiones").split(",");
                c1 = c[0];
                c2 = c[1];
                c3 = c[2];
                c4 = c[3];
                c5 = c[4];
                c6 = c[5];
                c7 = c[6];
                c8 = c[7];
                c9 = c[8];
                c10 = c[9];
                c11 = c[10];
                c12 = c[11];
                c13 = c[12];
                c14 = c[13];
                c15 = c[14];
                c16 = c[15];
                c17 = c[16];
                c18 = c[17];
                c19 = c[18];
                c20 = c[19];
              } else {
                c1 = "";
                c2 = "";
                c3 = "";
                c4 = "";
                c5 = "";
                c6 = "";
                c7 = "";
                c8 = "";
                c9 = "";
                c10 = "";
                c11 = "";
                c12 = "";
                c13 = "";
                c14 = "";
                c15 = "";
                c16 = "";
                c17 = "";
                c18 = "";
                c19 = "";
                c20 = "";
              }
              comisofi = c1 + "\n" + c5 + "\n" + c9 + "\n" + c13 + "\n" + c17;
              ptosofi = c2 + "\n" + c6 + "\n" + c10 + "\n" + c14 + "\n" + c18;
              comisag = c3 + "\n" + c7 + "\n" + c11 + "\n" + c15 + "\n" + c19;
              ptosag = c4 + "\n" + c8 + "\n" + c12 + "\n" + c16 + "\n" + c20;
              break;
          }

        } else {
          linea = "";
          vc = "";
          estado = "";
          comisag = "";
          comisofi = "";
          ptosag = "";
          ptosofi = "";
        }
        celda12 = new PdfPCell(new Paragraph(linea));
        celda13 = new PdfPCell(new Paragraph(vc));
        celda14 = new PdfPCell(new Paragraph(estado));
        celda19 = new PdfPCell(new Paragraph(estado));
        celda15 = new PdfPCell(new Paragraph(comisofi));
        celda21 = new PdfPCell(new Paragraph(ptosofi));
        celda18 = new PdfPCell(new Paragraph(comisag));
        celda22 = new PdfPCell(new Paragraph(ptosag));
        celda16 = new PdfPCell(new Paragraph(" "));
        celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda3.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda4.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda5.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda6.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda7.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda8.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda9.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda10.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda11.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda12.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda13.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda14.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda19.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda15.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda21.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda18.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda16.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda22.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda17.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda23.setHorizontalAlignment(Element.ALIGN_CENTER);

        celda1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda4.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda5.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda6.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda7.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda8.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda9.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda10.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda11.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda12.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda13.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda14.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda19.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda15.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda21.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda22.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda18.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda16.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda17.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda23.setVerticalAlignment(Element.ALIGN_MIDDLE);

        tabla.addCell(celda1);
        tabla.addCell(celda2);
        tabla.addCell(celda3);
        tabla.addCell(celda4);
        tabla.addCell(celda5);
        tabla.addCell(celda23);
        tabla.addCell(celda17);
        tabla.addCell(celda6);
        tabla.addCell(celda7);
        tabla.addCell(celda8);
        tabla.addCell(celda9);
        tabla.addCell(celda10);
        tabla.addCell(celda11);
        tabla.addCell(celda12);
        tabla.addCell(celda13);
        tabla.addCell(celda14);
        tabla.addCell(celda19);
        tabla.addCell(celda15);
        tabla.addCell(celda21);
        tabla.addCell(celda18);
        tabla.addCell(celda22);
        tabla.addCell(celda16);
        if (!rs.next()) {
          i = filas;
        }
      }
      tabla.setWidthPercentage(102);

      documento.add(tabla);
      documento.close();
      JOptionPane.showMessageDialog(
          null, "Informe creado correctamente", "Informe", JOptionPane.YES_NO_CANCEL_OPTION);

    } catch (FileNotFoundException | DocumentException | SQLException ex) {
      Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
        ficheroPdf.close();
      } catch (IOException ex) {
        Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

  public static void generalxdeleymes(ResultSet rs, String mesecito, String dele, String cod) {
    ResultSet copia = rs;
    String numfijo;
    Font font1 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Element.ALIGN_CENTER); // negrita
    Font font2 = new Font(Font.FontFamily.TIMES_ROMAN, 40, Font.BOLD); // negrita

    Calendar fecha = new GregorianCalendar();
    int amo = fecha.get(Calendar.YEAR);
    int mes = fecha.get(Calendar.MONTH);
    int dia = fecha.get(Calendar.DAY_OF_MONTH);
    String fechafin = +dia + "." + (mes + 1) + "." + amo;
    String linea = null, vc = null, estado = null, ano, m, d;
    int filas = 0;
    PdfPCell celda1,
        celda2,
        celda3,
        celda4,
        celda5,
        celda6,
        celda7,
        celda8,
        celda9,
        celda10,
        celda11,
        celda12,
        celda13,
        celda14,
        celda15,
        celda16,
        celda17,
        celda18,
        celda19,
        celda21,
        celda22,
        celda23;

    FileOutputStream ficheroPdf = null;
    try {
      do {
        filas += 1;
      } while (copia.next());
      Image imagen = Image.getInstance("..\\logo.jpg");
      Document documento = new Document(PageSize.A2.rotate());
      ficheroPdf =
          new FileOutputStream(
              "C:\\Users\\"
                  + System.getProperty("user.name")
                  + "\\Google Drive\\REPORTES\\\\"
                  + cod
                  + "-"
                  + mesecito
                  + "-"
                  + fechafin
                  + ".pdf");
      imagen.scalePercent(75f);
      PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(10);
      documento.open();
      PdfPTable tablaimg = new PdfPTable(2);
      PdfPCell cel1 = new PdfPCell(imagen);
      cel1.setBorder(Rectangle.NO_BORDER);
      PdfPCell cel2 =
          new PdfPCell(new Paragraph("Informe de " + mesecito + " a día " + fechafin, font2));
      cel2.setBorder(Rectangle.NO_BORDER);
      cel2.setVerticalAlignment(Element.ALIGN_MIDDLE);
      tablaimg.addCell(cel1);
      tablaimg.addCell(cel2);

      documento.add(tablaimg);
      documento.add(new Paragraph(" "));

      // cabecera
      PdfPTable tabla = new PdfPTable(22);
      tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
      PdfPCell cab1 = new PdfPCell(new Paragraph("Fecha de Carga", font1));
      PdfPCell cab2 = new PdfPCell(new Paragraph("Delegación", font1));
      PdfPCell cab3 = new PdfPCell(new Paragraph("Comercial", font1));
      PdfPCell cab4 = new PdfPCell(new Paragraph("Segmento", font1));
      PdfPCell cab5 = new PdfPCell(new Paragraph("Cía", font1));
      PdfPCell cab23 = new PdfPCell(new Paragraph("Distribuidor", font1));
      PdfPCell cab17 = new PdfPCell(new Paragraph("Cliente", font1));
      PdfPCell cab6 = new PdfPCell(new Paragraph("Oferta", font1));
      PdfPCell cab7 = new PdfPCell(new Paragraph("ID Oferta", font1));
      PdfPCell cab8 = new PdfPCell(new Paragraph("Fijo", font1));
      PdfPCell cab9 = new PdfPCell(new Paragraph("Visita Técnico", font1));
      PdfPCell cab10 = new PdfPCell(new Paragraph("Activación Fijo", font1));
      PdfPCell cab11 = new PdfPCell(new Paragraph("Alta Móviles", font1));
      PdfPCell cab12 = new PdfPCell(new Paragraph("Portas Móviles", font1));
      PdfPCell cab13 = new PdfPCell(new Paragraph("VC Movil", font1));
      PdfPCell cab14 = new PdfPCell(new Paragraph("Estado Activación Movil", font1));
      PdfPCell cab19 = new PdfPCell(new Paragraph("VAP", font1));
      PdfPCell cab15 = new PdfPCell(new Paragraph("Comisión Oficina", font1));
      PdfPCell cab21 = new PdfPCell(new Paragraph("Ptos Oficina", font1));
      PdfPCell cab18 = new PdfPCell(new Paragraph("Comisión Agente", font1));
      PdfPCell cab22 = new PdfPCell(new Paragraph("Ptos Agente", font1));
      PdfPCell cab16 = new PdfPCell(new Paragraph("Pdte Comisión", font1));
      cab1.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab2.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab3.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab4.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab4.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab5.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab6.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab7.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab8.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab9.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab10.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab11.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab12.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab13.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab14.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab15.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab16.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab17.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab18.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab19.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab21.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab22.setHorizontalAlignment(Element.ALIGN_CENTER);
      cab23.setHorizontalAlignment(Element.ALIGN_CENTER);

      cab1.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab2.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab3.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab4.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab4.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab5.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab6.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab7.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab8.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab9.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab10.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab11.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab12.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab13.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab14.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab15.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab16.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab17.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab18.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab19.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab21.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab22.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cab23.setVerticalAlignment(Element.ALIGN_MIDDLE);

      tabla.addCell(cab1);
      tabla.addCell(cab2);
      tabla.addCell(cab3);
      tabla.addCell(cab4);
      tabla.addCell(cab5);
      tabla.addCell(cab23);
      tabla.addCell(cab17);
      tabla.addCell(cab6);
      tabla.addCell(cab7);
      tabla.addCell(cab8);
      tabla.addCell(cab9);
      tabla.addCell(cab10);
      tabla.addCell(cab11);
      tabla.addCell(cab12);
      tabla.addCell(cab13);
      tabla.addCell(cab14);
      tabla.addCell(cab19);
      tabla.addCell(cab15);
      tabla.addCell(cab21);
      tabla.addCell(cab18);
      tabla.addCell(cab22);
      tabla.addCell(cab16);
      tabla.setWidthPercentage(102);
      documento.add(tabla);
      rs.first();
      tabla = new PdfPTable(22);
      tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
      for (int i = 0; i < filas; i++) {
        String parts[] = rs.getString("fechacreacion").split("-");
        ano = parts[0];
        m = parts[1];
        d = parts[2];
        String f = d + "-" + m + "-" + ano;
        celda1 = new PdfPCell(new Paragraph(f));
        celda2 = new PdfPCell(new Paragraph(rs.getString("delegacion")));
        celda3 = new PdfPCell(new Paragraph(rs.getString("comercial")));
        celda4 = new PdfPCell(new Paragraph(rs.getString("segmento")));
        celda5 = new PdfPCell(new Paragraph(rs.getString("operador")));
        celda23 = new PdfPCell(new Paragraph(rs.getString("distribuidor")));
        celda17 = new PdfPCell(new Paragraph(rs.getString("nombrecliente")));
        celda6 = new PdfPCell(new Paragraph(rs.getString("oferta")));
        celda7 = new PdfPCell(new Paragraph(rs.getString("idoferta")));
        String cadena[] = rs.getString("oferta").split(",");

        if (cadena[0].equalsIgnoreCase("-")) {
          numfijo = "N/A";
        } else {
          if (!rs.getString("numfijo").equalsIgnoreCase("N/A")) {
            numfijo = "Porta";
          } else {
            numfijo = "Alta";
          }
        }
        celda8 = new PdfPCell(new Paragraph(numfijo));
        parts = rs.getString("activadofijo").split("-");
        ano = parts[0];
        m = parts[1];
        d = parts[2];
        String acfijo = d + "-" + m + "-" + ano;
        parts = rs.getString("activadofijo").split("-");
        ano = parts[0];
        m = parts[1];
        d = parts[2];
        String acmovil = d + "-" + m + "-" + ano;
        celda9 = new PdfPCell(new Paragraph(acfijo));
        celda10 = new PdfPCell(new Paragraph(acmovil));
        celda11 = new PdfPCell(new Paragraph(rs.getString("numaltasmovi")));
        int n = Integer.parseInt(rs.getString("numportasmovil"));
        int n1 = Integer.parseInt(rs.getString("numaltasmovi"));
        n += n1;
        String p1,
            p2,
            p3,
            fijo,
            movil,
            c1 = "",
            c2 = "",
            c3 = "",
            c4 = "",
            c5 = "",
            c6 = "",
            c7 = "",
            c8 = "",
            c9 = "",
            c10 = "",
            c11 = "",
            c12 = "",
            c13 = "",
            c14 = "",
            c15 = "",
            c16 = "",
            c17 = "",
            c18 = "",
            c19 = "",
            c20 = "";
        String c[];
        String comisofi = null, comisag = null, ptosofi = null, ptosag = null;
        if (n > 0) {
          switch (n) {
            case 1:
              String part[] = rs.getString("lineasmoviles").split(",");
              String parte1 = part[0];
              String parte2 = part[1];
              String parte3 = part[2];
              linea = parte1;
              vc = parte2;
              estado = parte3;
              if (rs.getString("comisiones") != null) {
                c = rs.getString("comisiones").split(",");
                c1 = c[0];
                c2 = c[1];
                c3 = c[2];
                c4 = c[3];
              } else {
                c1 = "";
                c2 = "";
                ;
                c3 = "";
                ;
                c4 = "";
                ;
              }
              comisofi = c1;
              ptosofi = c2;
              comisag = c3;
              ptosag = c4;
              break;

            case 2:
              part = rs.getString("lineasmoviles").split(",");
              parte1 = part[0];
              parte2 = part[1];
              parte3 = part[2];
              String parte4 = part[3];
              String parte5 = part[4];
              String parte6 = part[5];
              linea = parte1 + "\n" + parte4;
              vc = parte2 + "\n" + parte5;
              estado = parte3 + "\n" + parte6;
              if (rs.getString("comisiones") != null) {
                c = rs.getString("comisiones").split(",");
                c1 = c[0];
                c2 = c[1];
                c3 = c[2];
                c4 = c[3];
                c5 = c[4];
                c6 = c[5];
                c7 = c[6];
                c8 = c[7];
              } else {
                c1 = "";
                c2 = "";
                c3 = "";
                c4 = "";
                c5 = "";
                c6 = "";
                c7 = "";
                c8 = "";
              }
              comisofi = c1 + "\n" + c5;
              ptosofi = c2 + "\n" + c6;
              comisag = c3 + "\n" + c7;
              ptosag = c4 + "\n" + c8;
              break;
            case 3:
              part = rs.getString("lineasmoviles").split(",");
              parte1 = part[0];
              parte2 = part[1];
              parte3 = part[2];
              parte4 = part[3];
              parte5 = part[4];
              parte6 = part[5];
              String parte7 = part[6];
              String parte8 = part[7];
              String parte9 = part[8];
              linea = parte1 + "\n" + parte4 + "\n" + parte7;
              vc = parte2 + "\n" + parte5 + "\n" + parte8;
              estado = parte3 + "\n" + parte6 + "\n" + parte9;
              if (rs.getString("comisiones") != null) {
                c = rs.getString("comisiones").split(",");
                c1 = c[0];
                c2 = c[1];
                c3 = c[2];
                c4 = c[3];
                c5 = c[4];
                c6 = c[5];
                c7 = c[6];
                c8 = c[7];
                c9 = c[8];
                c10 = c[9];
                c11 = c[10];
                c12 = c[11];
              } else {
                c1 = "";
                c2 = "";
                c3 = "";
                c4 = "";
                c5 = "";
                c6 = "";
                c7 = "";
                c8 = "";
                c9 = "";
                c10 = "";
                c11 = "";
                c12 = "";
              }
              comisofi = c1 + "\n" + c5 + "\n" + c9;
              ptosofi = c2 + "\n" + c6 + "\n" + c10;
              comisag = c3 + "\n" + c7 + "\n" + c11;
              ptosag = c4 + "\n" + c8 + "\n" + c12;
              break;

            case 4:
              part = rs.getString("lineasmoviles").split(",");
              parte1 = part[0];
              parte2 = part[1];
              parte3 = part[2];
              parte4 = part[3];
              parte5 = part[4];
              parte6 = part[5];
              parte7 = part[6];
              parte8 = part[7];
              parte9 = part[8];
              String parte10 = part[9];
              String parte11 = part[10];
              String parte12 = part[11];
              linea = parte1 + "\n" + parte4 + "\n" + parte7 + "\n" + parte10;
              vc = parte2 + "\n" + parte5 + "\n" + parte8 + "\n" + parte11;
              estado = parte3 + "\n" + parte6 + "\n" + parte9 + "\n" + parte12;
              if (rs.getString("comisiones") != null) {
                c = rs.getString("comisiones").split(",");
                c1 = c[0];
                c2 = c[1];
                c3 = c[2];
                c4 = c[3];
                c5 = c[4];
                c6 = c[5];
                c7 = c[6];
                c8 = c[7];
                c9 = c[8];
                c10 = c[9];
                c11 = c[10];
                c12 = c[11];
                c13 = c[12];
                c14 = c[13];
                c15 = c[14];
                c16 = c[15];
              } else {
                c1 = "";
                c2 = "";
                c3 = "";
                c4 = "";
                c5 = "";
                c6 = "";
                c7 = "";
                c8 = "";
                c9 = "";
                c10 = "";
                c11 = "";
                c12 = "";
                c13 = "";
                c14 = "";
                c15 = "";
                c16 = "";
              }
              comisofi = c1 + "\n" + c5 + "\n" + c9 + "\n" + c13;
              ptosofi = c2 + "\n" + c6 + "\n" + c10 + "\n" + c14;
              comisag = c3 + "\n" + c7 + "\n" + c11 + "\n" + c15;
              ptosag = c4 + "\n" + c8 + "\n" + c12 + "\n" + c16;
              break;

            case 5:
              part = rs.getString("lineasmoviles").split(",");
              parte1 = part[0];
              parte2 = part[1];
              parte3 = part[2];
              parte4 = part[3];
              parte5 = part[4];
              parte6 = part[5];
              parte7 = part[6];
              parte8 = part[7];
              parte9 = part[8];
              parte10 = part[9];
              parte11 = part[10];
              parte12 = part[11];
              String parte13 = part[12];
              String parte14 = part[13];
              String parte15 = part[14];
              linea = parte1 + "\n" + parte4 + "\n" + parte7 + "\n" + parte10 + "\n" + parte13;
              vc = parte2 + "\n" + parte5 + "\n" + parte8 + "\n" + parte11 + "\n" + parte14;
              estado = parte3 + "\n" + parte6 + "\n" + parte9 + "\n" + parte12 + "\n" + parte15;
              if (rs.getString("comisiones") != null) {
                c = rs.getString("comisiones").split(",");
                c1 = c[0];
                c2 = c[1];
                c3 = c[2];
                c4 = c[3];
                c5 = c[4];
                c6 = c[5];
                c7 = c[6];
                c8 = c[7];
                c9 = c[8];
                c10 = c[9];
                c11 = c[10];
                c12 = c[11];
                c13 = c[12];
                c14 = c[13];
                c15 = c[14];
                c16 = c[15];
                c17 = c[16];
                c18 = c[17];
                c19 = c[18];
                c20 = c[19];
              } else {
                c1 = "";
                c2 = "";
                c3 = "";
                c4 = "";
                c5 = "";
                c6 = "";
                c7 = "";
                c8 = "";
                c9 = "";
                c10 = "";
                c11 = "";
                c12 = "";
                c13 = "";
                c14 = "";
                c15 = "";
                c16 = "";
                c17 = "";
                c18 = "";
                c19 = "";
                c20 = "";
              }
              comisofi = c1 + "\n" + c5 + "\n" + c9 + "\n" + c13 + "\n" + c17;
              ptosofi = c2 + "\n" + c6 + "\n" + c10 + "\n" + c14 + "\n" + c18;
              comisag = c3 + "\n" + c7 + "\n" + c11 + "\n" + c15 + "\n" + c19;
              ptosag = c4 + "\n" + c8 + "\n" + c12 + "\n" + c16 + "\n" + c20;
              break;
          }

        } else {
          linea = "";
          vc = "";
          estado = "";
          comisag = "";
          comisofi = "";
          ptosag = "";
          ptosofi = "";
        }
        celda12 = new PdfPCell(new Paragraph(linea));
        celda13 = new PdfPCell(new Paragraph(vc));
        celda14 = new PdfPCell(new Paragraph(estado));
        celda19 = new PdfPCell(new Paragraph(estado));
        celda15 = new PdfPCell(new Paragraph(comisofi));
        celda21 = new PdfPCell(new Paragraph(ptosofi));
        celda18 = new PdfPCell(new Paragraph(comisag));
        celda22 = new PdfPCell(new Paragraph(ptosag));
        celda16 = new PdfPCell(new Paragraph(" "));
        celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda3.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda4.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda5.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda6.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda7.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda8.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda9.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda10.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda11.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda12.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda13.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda14.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda19.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda15.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda21.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda18.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda16.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda22.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda17.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda23.setHorizontalAlignment(Element.ALIGN_CENTER);

        celda1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda4.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda5.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda6.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda7.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda8.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda9.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda10.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda11.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda12.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda13.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda14.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda19.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda15.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda21.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda22.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda18.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda16.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda17.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celda23.setVerticalAlignment(Element.ALIGN_MIDDLE);
        tabla.addCell(celda1);
        tabla.addCell(celda2);
        tabla.addCell(celda3);
        tabla.addCell(celda4);
        tabla.addCell(celda5);
        tabla.addCell(celda23);
        tabla.addCell(celda17);
        tabla.addCell(celda6);
        tabla.addCell(celda7);
        tabla.addCell(celda8);
        tabla.addCell(celda9);
        tabla.addCell(celda10);
        tabla.addCell(celda11);
        tabla.addCell(celda12);
        tabla.addCell(celda13);
        tabla.addCell(celda14);
        tabla.addCell(celda19);
        tabla.addCell(celda15);
        tabla.addCell(celda21);
        tabla.addCell(celda18);
        tabla.addCell(celda22);
        tabla.addCell(celda16);
        if (!rs.next()) {
          i = filas;
        }
      }
      tabla.setWidthPercentage(102);

      documento.add(tabla);
      documento.close();
      JOptionPane.showMessageDialog(
          null, "Informe creado correctamente", "Informe", JOptionPane.YES_NO_CANCEL_OPTION);

    } catch (FileNotFoundException | DocumentException | SQLException ex) {
      Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
        ficheroPdf.close();
      } catch (IOException ex) {
        Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

  public static void visitasindividuales(ResultSet rs)
      throws InstantiationException, IllegalAccessException {
    ResultSet copia = rs;
    Font font1 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Element.ALIGN_CENTER); // negrita
    Font font2 = new Font(Font.FontFamily.TIMES_ROMAN, 9); // negrita

    FileOutputStream ficheroPdf = null;
    try {
      do {

        Image imagen = Image.getInstance("..\\logo.jpg");
        Document documento = new Document(PageSize.A5);
        String[] parts = rs.getString("fecha").split("-");
        String ano = parts[0];
        String mes = parts[1];
        String dia = parts[2];
        String fecha = dia + "-" + mes + "-" + ano;

        ficheroPdf =
            new FileOutputStream(
                "C:\\Users\\"
                    + System.getProperty("user.name")
                    + "\\Google Drive\\Visitas\\\\"
                    + rs.getString("distribuidor")
                    + "-"
                    + fecha
                    + "-"
                    + rs.getString("visita")
                    + ".pdf");
        imagen.scalePercent(75f);
        PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(10);
        documento.open();

        PdfPTable tablaimg = new PdfPTable(1);
        PdfPCell cel1 = new PdfPCell(imagen);
        cel1.setBorder(Rectangle.NO_BORDER);
        tablaimg.addCell(cel1);

        documento.add(tablaimg);
        documento.add(new Paragraph(" "));

        PdfPTable tabla = new PdfPTable(2);
        tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
        PdfPCell cab1 = new PdfPCell(new Paragraph("Código", font1));
        PdfPCell cab2 = new PdfPCell(new Paragraph("Razon Social", font1));
        cab1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        tabla.addCell(cab1);
        tabla.addCell(cab2);
        tabla.setWidthPercentage(102);
        documento.add(tabla);
        tabla = new PdfPTable(2);
        tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab1 = new PdfPCell(new Paragraph(rs.getString("visita"), font2));
        cab2 = new PdfPCell(new Paragraph(rs.getString("razonsocial"), font2));
        cab1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        tabla.addCell(cab1);
        tabla.addCell(cab2);
        tabla.setWidthPercentage(102);
        documento.add(tabla);

        tabla = new PdfPTable(2);
        tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab1 = new PdfPCell(new Paragraph("Teléfono", font1));
        cab2 = new PdfPCell(new Paragraph("Persona de Contacto", font1));
        cab1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        tabla.addCell(cab1);
        tabla.addCell(cab2);
        tabla.setWidthPercentage(102);
        documento.add(tabla);
        tabla = new PdfPTable(2);
        tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab1 = new PdfPCell(new Paragraph(rs.getString("telefono"), font2));
        cab2 = new PdfPCell(new Paragraph(rs.getString("persona"), font2));
        cab1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        tabla.addCell(cab1);
        tabla.addCell(cab2);
        tabla.setWidthPercentage(102);
        documento.add(tabla);

        tabla = new PdfPTable(1);
        tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab1 = new PdfPCell(new Paragraph("Dirección", font1));
        cab1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        tabla.addCell(cab1);
        tabla.setWidthPercentage(102);
        documento.add(tabla);
        tabla = new PdfPTable(1);
        tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab1 = new PdfPCell(new Paragraph(rs.getString("direccion"), font2));
        cab1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        tabla.addCell(cab1);
        tabla.setWidthPercentage(102);
        documento.add(tabla);

        tabla = new PdfPTable(2);
        tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab1 = new PdfPCell(new Paragraph("Fecha", font1));
        cab2 = new PdfPCell(new Paragraph("Hora", font1));
        cab1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        tabla.addCell(cab1);
        tabla.addCell(cab2);
        tabla.setWidthPercentage(102);
        documento.add(tabla);
        tabla = new PdfPTable(2);
        tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
        String partesf[] = rs.getString("fecha").split("-");
        cab1 = new PdfPCell(new Paragraph(partesf[2] + "-" + partesf[1] + "-" + partesf[0], font2));
        cab2 = new PdfPCell(new Paragraph(rs.getString("hora"), font2));
        cab1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        tabla.addCell(cab1);
        tabla.addCell(cab2);
        tabla.setWidthPercentage(102);
        documento.add(tabla);

        tabla = new PdfPTable(1);
        tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab1 = new PdfPCell(new Paragraph("Observaciones", font1));
        cab1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        tabla.addCell(cab1);
        tabla.setWidthPercentage(102);
        documento.add(tabla);
        tabla = new PdfPTable(1);
        tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab1 = new PdfPCell(new Paragraph(rs.getString("observaciones"), font2));
        cab1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        tabla.addCell(cab1);
        tabla.setWidthPercentage(102);
        documento.add(tabla);
        documento.close();
        try {
          Connection con;
          Statement st;
          String driver = "com.mysql.jdbc.Driver";
          String urlMysql = "jdbc:mysql://sencitel.ddns.net:3306/";
          Class.forName(driver).newInstance();
          con = DriverManager.getConnection(urlMysql + "Clientes", "sencitel", "Ludwig1753");
          st = con.createStatement();
          st.executeUpdate(
              "update visitas set estado='ENVIADA' where visita='" + rs.getString("visita") + "' ");
          con.close();
        } catch (ClassNotFoundException ex) {
          Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
        }

      } while (copia.next());

      JOptionPane.showMessageDialog(
          null, "Informe creado correctamente", "Informe", JOptionPane.YES_NO_CANCEL_OPTION);

    } catch (FileNotFoundException | DocumentException | SQLException ex) {
      Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
        ficheroPdf.close();
      } catch (IOException ex) {
        Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

  public static void visitasmensuales(ResultSet rs, String messelec) {
    ResultSet copia = rs;

    Font font1 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Element.ALIGN_CENTER); // negrita
    Font font2 = new Font(Font.FontFamily.TIMES_ROMAN, 9); // negrita

    FileOutputStream ficheroPdf = null;
    PdfPCell celda1,
        celda2,
        celda3,
        celda4,
        celda5,
        celda6,
        celda7,
        celda8,
        celda9,
        celda10,
        celda11,
        celda12,
        celda13,
        celda14,
        celda15,
        celda16,
        celda17,
        celda18,
        celda19,
        celda21,
        celda22;

    try {
      do {

        Image imagen = Image.getInstance("..\\logo.jpg");
        Document documento = new Document(PageSize.A4.rotate());
        File directorio =
            new File(
                "C:\\Users\\"
                    + System.getProperty("user.name")
                    + "\\Google Drive\\Visitas\\"
                    + messelec);
        directorio.mkdir();
        ficheroPdf =
            new FileOutputStream(
                "C:\\Users\\"
                    + System.getProperty("user.name")
                    + "\\Google Drive\\Visitas\\"
                    + messelec
                    + "\\"
                    + messelec
                    + ".pdf");
        imagen.scalePercent(75f);
        PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(10);
        documento.open();

        PdfPTable tablaimg = new PdfPTable(1);
        PdfPCell cel1 = new PdfPCell(imagen);
        cel1.setBorder(Rectangle.NO_BORDER);
        tablaimg.addCell(cel1);

        documento.add(tablaimg);
        documento.add(new Paragraph(" "));

        PdfPTable tabla = new PdfPTable(10);
        tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
        PdfPCell cab1 = new PdfPCell(new Paragraph("Cod_Visita", font1));
        PdfPCell cab9 = new PdfPCell(new Paragraph("Distribuidor", font1));
        PdfPCell cab2 = new PdfPCell(new Paragraph("Razon Social", font1));
        PdfPCell cab3 = new PdfPCell(new Paragraph("Fecha", font1));
        PdfPCell cab4 = new PdfPCell(new Paragraph("Hora", font1));
        PdfPCell cab5 = new PdfPCell(new Paragraph("Estado Visita", font1));
        PdfPCell cab10 = new PdfPCell(new Paragraph("Comision Visita", font1));
        PdfPCell cab6 = new PdfPCell(new Paragraph("Venta", font1));
        PdfPCell cab7 = new PdfPCell(new Paragraph("Comision Venta", font1));
        PdfPCell cab8 = new PdfPCell(new Paragraph("Agente", font1));
        cab1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab9.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab3.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab4.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab5.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab6.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab7.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab8.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab10.setHorizontalAlignment(Element.ALIGN_CENTER);

        cab1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab9.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab4.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab5.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab6.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab7.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab8.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab10.setVerticalAlignment(Element.ALIGN_MIDDLE);

        tabla.addCell(cab1);
        tabla.addCell(cab9);
        tabla.addCell(cab2);
        tabla.addCell(cab3);
        tabla.addCell(cab4);
        tabla.addCell(cab5);
        tabla.addCell(cab10);
        tabla.addCell(cab6);
        tabla.addCell(cab7);
        tabla.addCell(cab8);
        tabla.setWidthPercentage(102);
        documento.add(tabla);
        do {
          tabla = new PdfPTable(10);
          tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda1 = new PdfPCell(new Paragraph(rs.getString("visita"), font2));
          celda10 = new PdfPCell(new Paragraph(rs.getString("distribuidor"), font2));
          celda2 = new PdfPCell(new Paragraph(rs.getString("razonsocial"), font2));
          celda3 = new PdfPCell(new Paragraph(rs.getString("fecha"), font2));
          celda4 = new PdfPCell(new Paragraph(rs.getString("hora"), font2));
          celda5 = new PdfPCell(new Paragraph(rs.getString("estado"), font2));
          celda6 = new PdfPCell(new Paragraph(rs.getString("comisionvisita"), font2));
          celda7 = new PdfPCell(new Paragraph(rs.getString("venta"), font2));
          celda8 = new PdfPCell(new Paragraph(rs.getString("comisionventa"), font2));
          celda9 = new PdfPCell(new Paragraph(rs.getString("teleoperadora"), font2));
          celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda3.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda4.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda5.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda6.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda7.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda8.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda9.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda10.setHorizontalAlignment(Element.ALIGN_CENTER);

          celda1.setVerticalAlignment(Element.ALIGN_MIDDLE);
          celda2.setVerticalAlignment(Element.ALIGN_MIDDLE);
          celda3.setVerticalAlignment(Element.ALIGN_MIDDLE);
          celda4.setVerticalAlignment(Element.ALIGN_MIDDLE);
          celda5.setVerticalAlignment(Element.ALIGN_MIDDLE);
          celda6.setVerticalAlignment(Element.ALIGN_MIDDLE);
          celda7.setVerticalAlignment(Element.ALIGN_MIDDLE);
          celda8.setVerticalAlignment(Element.ALIGN_MIDDLE);
          celda9.setVerticalAlignment(Element.ALIGN_MIDDLE);
          celda10.setVerticalAlignment(Element.ALIGN_MIDDLE);

          tabla.addCell(celda1);
          tabla.addCell(celda10);
          tabla.addCell(celda2);
          tabla.addCell(celda3);
          tabla.addCell(celda4);
          tabla.addCell(celda5);
          tabla.addCell(celda6);
          tabla.addCell(celda7);
          tabla.addCell(celda8);
          tabla.addCell(celda9);
          tabla.setWidthPercentage(102);
          documento.add(tabla);
        } while (rs.next());

        documento.close();
      } while (copia.next());

      JOptionPane.showMessageDialog(
          null, "Informe creado correctamente", "Informe", JOptionPane.YES_NO_CANCEL_OPTION);

    } catch (FileNotFoundException | DocumentException | SQLException ex) {
      Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
        ficheroPdf.close();
      } catch (IOException ex) {
        Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

  public static void visitasmensualesxagente(ResultSet rs, String messelec, String agente) {
    ResultSet copia = rs;

    Font font1 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Element.ALIGN_CENTER); // negrita
    Font font2 = new Font(Font.FontFamily.TIMES_ROMAN, 9); // negrita

    FileOutputStream ficheroPdf = null;
    PdfPCell celda1,
        celda2,
        celda3,
        celda4,
        celda5,
        celda6,
        celda7,
        celda8,
        celda9,
        celda10,
        celda11,
        celda12,
        celda13,
        celda14,
        celda15,
        celda16,
        celda17,
        celda18,
        celda19,
        celda21,
        celda22;

    try {
      do {

        Image imagen = Image.getInstance("..\\logo.jpg");
        Document documento = new Document(PageSize.A4.rotate());
        File directorio =
            new File(
                "C:\\Users\\"
                    + System.getProperty("user.name")
                    + "\\Google Drive\\Visitas\\"
                    + agente);
        directorio.mkdir();
        ficheroPdf =
            new FileOutputStream(
                "C:\\Users\\"
                    + System.getProperty("user.name")
                    + "\\Google Drive\\Visitas\\"
                    + agente
                    + "\\"
                    + messelec
                    + ".pdf");
        imagen.scalePercent(75f);
        PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(10);
        documento.open();

        PdfPTable tablaimg = new PdfPTable(1);
        PdfPCell cel1 = new PdfPCell(imagen);
        cel1.setBorder(Rectangle.NO_BORDER);
        tablaimg.addCell(cel1);

        documento.add(tablaimg);
        documento.add(new Paragraph(" "));

        PdfPTable tabla = new PdfPTable(9);
        tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
        PdfPCell cab1 = new PdfPCell(new Paragraph("Cod_Visita", font1));
        PdfPCell cab2 = new PdfPCell(new Paragraph("Distribuidor", font1));
        PdfPCell cab3 = new PdfPCell(new Paragraph("Razon Social", font1));
        PdfPCell cab4 = new PdfPCell(new Paragraph("Fecha", font1));
        PdfPCell cab5 = new PdfPCell(new Paragraph("Hora", font1));
        PdfPCell cab6 = new PdfPCell(new Paragraph("Estado Visita", font1));
        PdfPCell cab7 = new PdfPCell(new Paragraph("Comision Visita", font1));
        PdfPCell cab8 = new PdfPCell(new Paragraph("Venta", font1));
        PdfPCell cab9 = new PdfPCell(new Paragraph("Comision Venta", font1));
        cab1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab3.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab4.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab4.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab5.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab6.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab7.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab8.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab9.setHorizontalAlignment(Element.ALIGN_CENTER);

        cab1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab4.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab4.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab5.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab6.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab7.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab8.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab9.setVerticalAlignment(Element.ALIGN_MIDDLE);

        tabla.addCell(cab1);
        tabla.addCell(cab2);
        tabla.addCell(cab3);
        tabla.addCell(cab4);
        tabla.addCell(cab5);
        tabla.addCell(cab6);
        tabla.addCell(cab7);
        tabla.addCell(cab8);
        tabla.addCell(cab9);
        tabla.setWidthPercentage(102);
        documento.add(tabla);
        do {
          tabla = new PdfPTable(9);
          tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda1 = new PdfPCell(new Paragraph(rs.getString("visita"), font2));
          celda10 = new PdfPCell(new Paragraph(rs.getString("distribuidor"), font2));
          celda2 = new PdfPCell(new Paragraph(rs.getString("razonsocial"), font2));
          celda3 = new PdfPCell(new Paragraph(rs.getString("fecha"), font2));
          celda4 = new PdfPCell(new Paragraph(rs.getString("hora"), font2));
          celda5 = new PdfPCell(new Paragraph(rs.getString("estado"), font2));
          celda6 = new PdfPCell(new Paragraph(rs.getString("comisionvisita"), font2));
          celda7 = new PdfPCell(new Paragraph(rs.getString("venta"), font2));
          celda8 = new PdfPCell(new Paragraph(rs.getString("comisionventa"), font2));
          celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda3.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda4.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda5.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda6.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda7.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda8.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda10.setHorizontalAlignment(Element.ALIGN_CENTER);

          celda1.setVerticalAlignment(Element.ALIGN_MIDDLE);
          celda2.setVerticalAlignment(Element.ALIGN_MIDDLE);
          celda3.setVerticalAlignment(Element.ALIGN_MIDDLE);
          celda4.setVerticalAlignment(Element.ALIGN_MIDDLE);
          celda5.setVerticalAlignment(Element.ALIGN_MIDDLE);
          celda6.setVerticalAlignment(Element.ALIGN_MIDDLE);
          celda7.setVerticalAlignment(Element.ALIGN_MIDDLE);
          celda8.setVerticalAlignment(Element.ALIGN_MIDDLE);
          celda10.setVerticalAlignment(Element.ALIGN_MIDDLE);

          tabla.addCell(celda1);
          tabla.addCell(celda10);
          tabla.addCell(celda2);
          tabla.addCell(celda3);
          tabla.addCell(celda4);
          tabla.addCell(celda5);
          tabla.addCell(celda6);
          tabla.addCell(celda7);
          tabla.addCell(celda8);
          tabla.setWidthPercentage(102);
          documento.add(tabla);
        } while (rs.next());

        documento.close();
      } while (copia.next());

      JOptionPane.showMessageDialog(
          null, "Informe creado correctamente", "Informe", JOptionPane.YES_NO_CANCEL_OPTION);

    } catch (FileNotFoundException | DocumentException | SQLException ex) {
      Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
        ficheroPdf.close();
      } catch (IOException ex) {
        Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

  public static void visitasmensualesxdistri(ResultSet rs, String messelec, String distri) {
    ResultSet copia = rs;

    Font font1 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Element.ALIGN_CENTER); // negrita
    Font font2 = new Font(Font.FontFamily.TIMES_ROMAN, 9); // negrita

    FileOutputStream ficheroPdf = null;
    PdfPCell celda1,
        celda2,
        celda3,
        celda4,
        celda5,
        celda6,
        celda7,
        celda8,
        celda9,
        celda10,
        celda11,
        celda12,
        celda13,
        celda14,
        celda15,
        celda16,
        celda17,
        celda18,
        celda19,
        celda21,
        celda22;

    try {
      do {

        Image imagen = Image.getInstance("..\\logo.jpg");
        Document documento = new Document(PageSize.A4.rotate());
        File directorio =
            new File(
                "C:\\Users\\"
                    + System.getProperty("user.name")
                    + "\\Google Drive\\Visitas\\"
                    + distri);
        directorio.mkdir();
        ficheroPdf =
            new FileOutputStream(
                "C:\\Users\\"
                    + System.getProperty("user.name")
                    + "\\Google Drive\\Visitas\\"
                    + distri
                    + "\\"
                    + messelec
                    + ".pdf");
        imagen.scalePercent(75f);
        PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(10);
        documento.open();

        PdfPTable tablaimg = new PdfPTable(1);
        PdfPCell cel1 = new PdfPCell(imagen);
        cel1.setBorder(Rectangle.NO_BORDER);
        tablaimg.addCell(cel1);

        documento.add(tablaimg);
        documento.add(new Paragraph(" "));

        PdfPTable tabla = new PdfPTable(8);
        tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
        PdfPCell cab1 = new PdfPCell(new Paragraph("Cod_Visita", font1));
        PdfPCell cab3 = new PdfPCell(new Paragraph("Razon Social", font1));
        PdfPCell cab4 = new PdfPCell(new Paragraph("Fecha", font1));
        PdfPCell cab5 = new PdfPCell(new Paragraph("Hora", font1));
        PdfPCell cab6 = new PdfPCell(new Paragraph("Estado Visita", font1));
        PdfPCell cab7 = new PdfPCell(new Paragraph("Comision Visita", font1));
        PdfPCell cab8 = new PdfPCell(new Paragraph("Venta", font1));
        PdfPCell cab9 = new PdfPCell(new Paragraph("Comision Venta", font1));
        cab1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab3.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab4.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab4.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab5.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab6.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab7.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab8.setHorizontalAlignment(Element.ALIGN_CENTER);
        cab9.setHorizontalAlignment(Element.ALIGN_CENTER);

        cab1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab3.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab4.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab4.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab5.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab6.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab7.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab8.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cab9.setVerticalAlignment(Element.ALIGN_MIDDLE);

        tabla.addCell(cab1);
        tabla.addCell(cab3);
        tabla.addCell(cab4);
        tabla.addCell(cab5);
        tabla.addCell(cab6);
        tabla.addCell(cab7);
        tabla.addCell(cab8);
        tabla.addCell(cab9);
        tabla.setWidthPercentage(102);
        documento.add(tabla);
        do {
          tabla = new PdfPTable(8);
          tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda1 = new PdfPCell(new Paragraph(rs.getString("visita"), font2));
          celda2 = new PdfPCell(new Paragraph(rs.getString("razonsocial"), font2));
          celda3 = new PdfPCell(new Paragraph(rs.getString("fecha"), font2));
          celda4 = new PdfPCell(new Paragraph(rs.getString("hora"), font2));
          celda5 = new PdfPCell(new Paragraph(rs.getString("estado"), font2));
          celda6 = new PdfPCell(new Paragraph(rs.getString("comisionvisita"), font2));
          celda7 = new PdfPCell(new Paragraph(rs.getString("venta"), font2));
          celda8 = new PdfPCell(new Paragraph(rs.getString("comisionventa"), font2));
          celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda3.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda4.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda5.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda6.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda7.setHorizontalAlignment(Element.ALIGN_CENTER);
          celda8.setHorizontalAlignment(Element.ALIGN_CENTER);

          celda1.setVerticalAlignment(Element.ALIGN_MIDDLE);
          celda2.setVerticalAlignment(Element.ALIGN_MIDDLE);
          celda3.setVerticalAlignment(Element.ALIGN_MIDDLE);
          celda4.setVerticalAlignment(Element.ALIGN_MIDDLE);
          celda5.setVerticalAlignment(Element.ALIGN_MIDDLE);
          celda6.setVerticalAlignment(Element.ALIGN_MIDDLE);
          celda7.setVerticalAlignment(Element.ALIGN_MIDDLE);
          celda8.setVerticalAlignment(Element.ALIGN_MIDDLE);

          tabla.addCell(celda1);
          tabla.addCell(celda2);
          tabla.addCell(celda3);
          tabla.addCell(celda4);
          tabla.addCell(celda5);
          tabla.addCell(celda6);
          tabla.addCell(celda7);
          tabla.addCell(celda8);
          tabla.setWidthPercentage(102);
          documento.add(tabla);
        } while (rs.next());

        documento.close();
      } while (copia.next());

      JOptionPane.showMessageDialog(
          null, "Informe creado correctamente", "Informe", JOptionPane.YES_NO_CANCEL_OPTION);

    } catch (FileNotFoundException | DocumentException | SQLException ex) {
      Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
        ficheroPdf.close();
      } catch (IOException ex) {
        Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}
