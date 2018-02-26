package examples;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PdfGenerator {
    private static String FILE = "d:/test/FirstPdf.pdf";


    public PdfGenerator() {

        System.out.println(this.getClass().getClassLoader().getResource("images/logo_hybrid.png"));
        createTitle(FILE);
    }

    public void createTitle(String dest) {
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));

            document.open();
            createDocumentNumber(writer, "01020304", 520, 810);
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
        table.setTotalWidth(170);
        table.getDefaultCell().setBorder(0);

        Image logoImage = createLogoImage();
        Phrase prescription = createHeaderPrescription("ПРЕДПИСАНИЕ/Заказное письмо с уведомлением");
        Phrase prescriptionSender = createHeaderPrescriptionSender("от: УАП ДВД г.Астана, улица 20-40, д. 4/1");
        Phrase barcode = createHeaderBarcode("DA010080119KZ");
        Phrase recipient = createHeaderAdditionInfo("КӘДЕН ТАҢАТАР БЕКСҰЛТАНҰЛЫ");
        Phrase location = createHeaderAdditionInfo("ул. КОРГАЛЖЫН, д. 11, корпус -, кв. 13");
        Phrase region = createHeaderAdditionInfo("ЕСИЛЬСКИЙ РАЙОН");
        Phrase cityAndIndex = createHeaderAdditionInfo("АСТАНА, 010000");
        Phrase shpi = createHeaderAdditionInfo("ШПИ");
        Phrase barcodeInText = createHeaderAdditionInfo("DA010080119KZ");

        table.addCell(logoImage);
        table.addCell(prescription);
        table.addCell(prescriptionSender);
        table.addCell(recipient);
        table.addCell(location);
        table.addCell(region);
        table.addCell(cityAndIndex);
        table.addCell(barcode);
        table.addCell(shpi);
        table.addCell(barcodeInText);

        headerTablePosition(writer, table);

    }

    private Phrase createHeaderAdditionInfo(String info) {
        Phrase phrase = new Phrase(info, headerInfoFont());
        return phrase;
    }

    private Phrase createHeaderPrescription(String prescription) {
        Phrase phrase = new Phrase(prescription, headerInfoFont());
        return phrase;
    }

    private Phrase createHeaderPrescriptionSender(String sender) {
        Phrase phrase = new Phrase("от: " + sender,  headerInfoFont());
        return phrase;
    }

    private Phrase createHeaderBarcode(String barcode) {
        BaseFont bfSPI = null;
        try {
            bfSPI = BaseFont.createFont(this.getClass().getClassLoader().getResource("fonts/fre3of9x.ttf").toString(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Font fontSPI = new Font(bfSPI, 20);
        Phrase phrase2 = new Phrase("*" + barcode + "*", fontSPI);
        return phrase2;
    }

    private void createFooterKaz(PdfWriter writer) {
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(490);

        Phrase commonInfo = createFooterCommonInfo("Осы мәтін (хат, құжат) «Қазпошта» АҚ-ның WWW.POST.KZ порталы және/немесе «ГЭП» ақпараттық жүйесі арқылы алынған\n" +
                "және басып шығарылған және жіберушінің электрондық құжаттының қағаз көшірмесі болып табылады.");
        PdfPCell cell1 = new PdfPCell(commonInfo);
        cell1.setBorder(0);
        cell1.setPadding(0);

        Phrase documentCreator = createFooterCommonInfo("Электрондық құжатты жасаған: УАП ДВД г.Астана");
        PdfPCell cell2 = new PdfPCell(documentCreator);
        cell2.setBorder(0);
        cell2.setPadding(0);

        Phrase dateAndTime = createFooterCommonInfo("Хатты өңдеу күні мен уақыты: 19-02-2018 сағат 09:00");
        PdfPCell cell3 = new PdfPCell(dateAndTime);
        cell3.setBorder(0);
        cell3.setPadding(0);
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);

        footerTablePosition(writer, table, 50, 170);

    }

    private void createFooterRus(PdfWriter writer) {
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(490);
        Phrase commonInfo = createFooterCommonInfo("Настоящий текст (письмо, документ) получен и распечатан с использованием портала WWW.POST.KZ и/или" +
                "информационной системой «ГЭП» АО «Казпочта» и является бумажной копией электронного документа отправителя.");
        PdfPCell cell1 = new PdfPCell(commonInfo);
        cell1.setBorder(0);
        cell1.setPadding(0);

        Phrase documentCreator = createFooterCommonInfo("Электронный документ создал: УАП ДВД г.Астана");
        PdfPCell cell2 = new PdfPCell(documentCreator);
        cell2.setBorder(0);
        cell2.setPadding(0);

        Phrase dateAndTime = createFooterCommonInfo("Дата и время обработки письма: 23-02-2018 в 09:00 часов");
        PdfPCell cell3 = new PdfPCell(dateAndTime);
        cell3.setBorder(0);
        cell3.setPadding(0);
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);

        footerTablePosition(writer, table, 50, 120);

    }

    private void footerTablePosition(PdfWriter writer, PdfPTable table, int xPos, int yPos) {
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
            cb.setFontAndSize(bf, 12);
            cb.showText(text);
            cb.endText();
            cb.restoreState();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Image createLogoImage() {
        Image image = null;
        try {
            image = Image.getInstance(this.getClass().getClassLoader().getResource("images/logo_hybrid.png"));
            image.scaleToFit(90, 80);


        } catch (BadElementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

    private Font headerInfoFont(){
        Font font = fontLoader(this.getClass().getClassLoader().getResource("fonts/OpenSans-Bold.ttf").toString());
        font.setSize(10);
        return font;
    }

    private Font footerFont(){
        Font font = fontLoader(this.getClass().getClassLoader().getResource("fonts/OpenSans-Bold.ttf").toString());
        font.setSize(8);
        return font;
    }

    private Phrase createFooterCommonInfo(String info) {
        Phrase phrase = new Phrase(info, footerFont());
        return phrase;
    }

    private Font fontLoader(String fontPath) {

        BaseFont bf = null;
        try {
            bf = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Font font = new Font(bf);

        return font;
    }

}
