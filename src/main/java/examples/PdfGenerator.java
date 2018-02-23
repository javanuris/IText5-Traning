package examples;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PdfGenerator {
    private static String FILE = "d:/test/FirstPdf.pdf";

    public PdfGenerator() {
        createTitle(FILE);
    }


    public void createTitle(String dest) {
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));

            document.open();

            createDocumentNumber(writer, "01020304", 535, 820);
            createHeader(writer);
            createFooterKaz(writer);
            createFooterRus(writer);
            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void createHeader(PdfWriter writer) {
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(150);

        Phrase phrase = new Phrase();
        phrase.add("Title title title title");
        PdfPCell cell = new PdfPCell(phrase);
        cell.setBorder(PdfPCell.BOX);


        table.addCell(cell);
        table.addCell(cell);
        table.addCell(cell);
        table.addCell(cell);
        table.addCell(cell);
        table.addCell(cell);
        table.addCell(cell);
        table.addCell(cell);
        table.addCell(cell);

        headerTablePosition(writer, table);

    }


    private void createFooterKaz(PdfWriter writer) {
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(490);

        BaseFont bf = null;
        try {
            bf = BaseFont.createFont("C:\\Windows\\Fonts\\ARIAL.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Font font1 = new Font(bf, 8);

        Phrase phrase1 = new Phrase("Осы мәтін (хат, құжат) «Қазпошта» АҚ-ның WWW.POST.KZ порталы және/немесе «ГЭП» ақпараттық жүйесі арқылы алынған\n" +
                "және басып шығарылған және жіберушінің электрондық құжаттының қағаз көшірмесі болып табылады." , font1);
        phrase1.setFont(font1);
        PdfPCell cell1 = new PdfPCell(phrase1);
        cell1.setBorder(0);
        cell1.setPadding(0);
        cell1.setBorder(PdfPCell.BOX);

        Phrase phrase2 = new Phrase();
        phrase2.setFont(font1);
        phrase2.add("Электрондық құжатты жасаған: УАП ДВД г.Астана");
        PdfPCell cell2 = new PdfPCell(phrase2);
        cell2.setBorder(0);
        cell2.setPadding(0);
        cell2.setBorder(PdfPCell.BOX);

        Phrase phrase3 = new Phrase();
        phrase3.setFont(font1);
        phrase3.add("Хатты өңдеу күні мен уақыты: 23-02-2018 сағат 09:00");
        PdfPCell cell3 = new PdfPCell(phrase3);
        cell3.setBorder(0);
        cell3.setPadding(0);
        cell3.setBorder(PdfPCell.BOX);


        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);

        footerTablePosition(writer, table , 50 ,170);

    }

    private void createFooterRus(PdfWriter writer) {
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(490);

        BaseFont bf = null;
        try {
             bf = BaseFont.createFont("C:\\Windows\\Fonts\\ARIAL.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Font font1 = new Font(bf, 8);

        Phrase phrase1 = new Phrase("Настоящий текст (письмо, документ) получен и распечатан с использованием портала WWW.POST.KZ и/или" +
                "информационной системой «ГЭП» АО «Казпочта» и является бумажной копией электронного документа отправителя." , font1);
        phrase1.setFont(font1);
        PdfPCell cell1 = new PdfPCell(phrase1);
        cell1.setBorder(0);
        cell1.setPadding(0);
        cell1.setBorder(PdfPCell.BOX);

        Phrase phrase2 = new Phrase();
        phrase2.setFont(font1);
        phrase2.add("Электронный документ создал: УАП ДВД г.Астана");
        PdfPCell cell2 = new PdfPCell(phrase2);
        cell2.setBorder(0);
        cell2.setPadding(0);
        cell2.setBorder(PdfPCell.BOX);

        Phrase phrase3 = new Phrase();
        phrase3.setFont(font1);
        phrase3.add("Дата и время обработки письма: 23-02-2018 в 09:00 часов");
        PdfPCell cell3 = new PdfPCell(phrase3);
        cell3.setBorder(0);
        cell3.setPadding(0);
        cell3.setBorder(PdfPCell.BOX);


        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);

        footerTablePosition(writer, table , 50 ,120);

    }


    private void footerTablePosition(PdfWriter writer, PdfPTable table , int xPos, int yPos) {
        final int FIRST_ROW = 0;
        final int LAST_ROW = -1;
        PdfContentByte contentByte = writer.getDirectContent();
        table.writeSelectedRows(FIRST_ROW, LAST_ROW, xPos, yPos, contentByte);
    }

    private void headerTablePosition(PdfWriter writer, PdfPTable table) {
        final int FIRST_ROW = 0;
        final int LAST_ROW = -1;
        PdfContentByte contentByte = writer.getDirectContent();
        table.writeSelectedRows(FIRST_ROW, LAST_ROW, 380, 760, contentByte);
    }

    private void createDocumentNumber(PdfWriter writer, String text, int x, int y) {
        PdfContentByte cb = writer.getDirectContent();
        BaseFont bf = null;
        try {
            bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            cb.saveState();
            cb.beginText();
            cb.moveText(x, y);
            cb.setFontAndSize(bf, 9);
            cb.showText(text);
            cb.endText();
            cb.restoreState();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
