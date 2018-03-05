package titles;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import utils.FontUtil;
import utils.ImageUtil;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public abstract class AbstractTitle implements Title {
    private static final float HEADER_X = 330f;
    private static final float HEADER_Y = 738f;

    @Override
    public ByteArrayOutputStream createTitle(Form103 form103) {
        String FILE = "d:/test/FirstPdf.pdf";

        try {
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();

            createHeader(writer, form103);
            createBody(writer, form103);
            createFooter(writer, form103);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createHeader(PdfWriter writer, Form103 form103) {
        createIdPackage(writer, String.valueOf(form103.getIdPackage()));
        PdfPTable table = createHeaderTable();
        Image logoImage = createLogoImage();

        try {
            writer.getDirectContent().addImage(logoImage);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        createHeaderMiddle(writer, table, form103);

        Phrase barcodeInCode = createBarcodeInCode(form103.getBarcode());
        PdfPCell headerBarcodeCell = getPdfPCell(barcodeInCode);
        table.addCell(headerBarcodeCell);

        Phrase shpi = createSHPI();
        PdfPCell shpiCell = getPdfPCell(shpi);
        shpiCell.setPaddingTop(1);
        table.addCell(shpi);

        Phrase barcodeInText = createBarcodeInText(form103.getBarcode());
        PdfPCell barcodeInTextCell = getPdfPCell(barcodeInText);
        barcodeInTextCell.setPaddingLeft(45);
        table.addCell(barcodeInTextCell);

        setTablePosition(writer, table, HEADER_X, HEADER_Y);
    }

    protected abstract void createHeaderMiddle(PdfWriter writer, PdfPTable table, Form103 form103);

    private PdfPTable createHeaderTable() {
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(210);
        table.getDefaultCell().setBorder(0);
        return table;
    }

    private Image createLogoImage() {
        Image image = ImageUtil.getLogoHybrid();
        image.setAbsolutePosition(329f, 740f);
        image.scaleAbsolute(80f, 23f);
        return image;
    }

    private Phrase createBarcodeInCode(String barcode) {
        return new Phrase("*" + barcode + "*", FontUtil.fre3of9x(24.5f));
    }

    private void createIdPackage(PdfWriter writer, String text) {
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

    private Phrase createSHPI() {
        return new Phrase("ШПИ", FontUtil.openSansRegular(4));
    }

    private Phrase createBarcodeInText(String text) {
        return new Phrase(text, FontUtil.helvetica(7));
    }

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
