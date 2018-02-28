package titles;

import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import utils.FontUtil;
import utils.ImageUtil;

public class TitleConstructor {

    public PdfPTable createTable() {
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(230);
        table.getDefaultCell().setBorder(0);
        return table;
    }

    public Image createLogoImage() {
        Image image = ImageUtil.getLogoHybrid();
        image.setAbsolutePosition(329f, 740f);
        image.scaleAbsolute(80f, 23f);
        return image;
    }

    public void tablePosition(PdfWriter writer, PdfPTable table, float xPos, float yPos) {
        final int FIRST_ROW = 0;
        final int LAST_ROW = -1;
        PdfContentByte contentByte = writer.getDirectContent();
        table.writeSelectedRows(FIRST_ROW, LAST_ROW, xPos, yPos, contentByte);
    }

    public PdfPCell getPdfPCell(Phrase phrase) {
        PdfPCell pdfPCell = new PdfPCell(phrase);
        pdfPCell.setPadding(0);
        pdfPCell.setBorder(0);
        return pdfPCell;
    }

    public Phrase createBarcodeInCode(String barcode) {
        return new Phrase("*" + barcode + "*", FontUtil.fre3of9x(24.5f));
    }

    public Phrase createShpi() {
        return new Phrase("ШПИ", FontUtil.openSansRegular(4));
    }

    public Phrase createBarcodeInText(String text) {
        return new Phrase(text,  FontUtil.helvetica(7));
    }

    public void createIdPackage(PdfWriter writer, String text) {
        Phrase phrase = new Phrase(text);
        phrase.setFont(FontUtil.ocrb(11));

        PdfContentByte cb = writer.getDirectContent();
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(65);
        PdfPCell cell1 = new PdfPCell(phrase);
        cell1.setPadding(0);
        cell1.setBorder(0);
        table.addCell(cell1);
        final int FIRST_ROW = 0;
        final int LAST_ROW = -1;
        table.writeSelectedRows(FIRST_ROW, LAST_ROW, 519, 813, cb);
    }

}
