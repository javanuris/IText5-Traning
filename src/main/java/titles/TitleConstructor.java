package titles;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class TitleConstructor {

    public PdfPCell getPdfPCell(Phrase phrase) {
        PdfPCell pdfPCell = new PdfPCell(phrase);
        pdfPCell.setPadding(0);
        pdfPCell.setBorder(0);
        return pdfPCell;
    }

    public void setTablePosition(PdfWriter writer, PdfPTable table, float xPos, float yPos) {
        final int FIRST_ROW = 0;
        final int LAST_ROW = -1;
        PdfContentByte contentByte = writer.getDirectContent();
        table.writeSelectedRows(FIRST_ROW, LAST_ROW, xPos, yPos, contentByte);
    }

}
