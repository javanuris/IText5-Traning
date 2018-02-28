package examples;

import utils.DateUtil;
import utils.FontUtil;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import utils.ImageUtil;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PdfGenerator {

    private static String FILE = "d:/test/FirstPdf.pdf";

    public PdfGenerator() {
        createTitle(FILE);
    }

    private void createTitle(String dest) {
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
            document.open();

            createIdPackage(writer, "01639174");
            createHeader(writer);

            String data = DateUtil.getDate();
            String time = DateUtil.getTime();

            createFooter(writer, "Astana", data, time);

            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void createFooter(PdfWriter writer, String f6, String date, String time) {
        createFooterKaz(writer, f6, date, time);
        createFooterRus(writer, f6, date, time);
    }

    private void createHeader(PdfWriter writer) {


        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(230);
        table.getDefaultCell().setBorder(0);

        Image logoImage = createLogoImage();
        Phrase prescription = createHeaderPrescription("ПРЕДПИСАНИЕ/Заказное письмо с уведомлением");
        PdfPCell prescriptionCell = getPdfPCell(prescription, 0);
        prescriptionCell.setPaddingTop(1);
        prescriptionCell.setPaddingBottom(0);

        Phrase prescriptionSender = createHeaderPrescriptionSender("от: УАП ДВД г.Астана, улица 20-40, д. 4/1");
        PdfPCell prescriptionSenderCell = new PdfPCell(prescriptionSender);
        prescriptionSenderCell.setBottom(1);
        prescriptionSenderCell.setPaddingTop(0);
        prescriptionSenderCell.setPaddingLeft(0);
        prescriptionSenderCell.setBorder(0);


        Phrase recipient = createHeaderAdditionInfo("КӘДЕН ТАҢАТАР БЕКСҰЛТАНҰЛЫ");
        PdfPCell recipientCell = getPdfPCell(recipient, 0);
        recipientCell.setPaddingTop(1);

        Phrase location = createHeaderAdditionInfo("ул. КОРГАЛЖЫН, д. 11, корпус -, кв. 13");
        PdfPCell locationCell = getPdfPCell(location, 0);


        Phrase region = createHeaderAdditionInfo("ЕСИЛЬСКИЙ РАЙОН");
        PdfPCell regionCell = getPdfPCell(region, 0);

        Phrase cityAndIndex = createHeaderAdditionInfo("АСТАНА, 010000");
        PdfPCell cityAndIndexCell = getPdfPCell(cityAndIndex, 0);

        Phrase barcode = createHeaderBarcode("DA010080119KZ");
        PdfPCell headerBarcodeCell = getPdfPCell(barcode, 0);
        headerBarcodeCell.setPaddingBottom(0);


        Phrase shpi = new Phrase("ШПИ", FontUtil.openSansRegular(4));
        PdfPCell shpiCell = getPdfPCell(shpi, 0);
        shpiCell.setPaddingBottom(0);
        shpiCell.setPaddingTop(1);

        Phrase barcodeInText = new Phrase("DA010080119KZ", FontUtil.helvetica(7));
        PdfPCell barcodeInTextCell = getPdfPCell(barcodeInText, 0);
        barcodeInTextCell.setPaddingBottom(0);
        barcodeInTextCell.setPaddingLeft(45);

        try {
            writer.getDirectContent().addImage(logoImage);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        table.addCell(prescriptionCell);
        table.addCell(prescriptionSenderCell);
        table.addCell(recipientCell);
        table.addCell(locationCell);
        table.addCell(regionCell);
        table.addCell(cityAndIndexCell);
        table.addCell(headerBarcodeCell);
        table.addCell(shpiCell);
        table.addCell(barcodeInTextCell);

        headerTablePosition(writer, table);

    }

    private PdfPCell getPdfPCell(Phrase phrase, int border) {
        PdfPCell pdfPCell = new PdfPCell(phrase);
        pdfPCell.setPadding(border);
        pdfPCell.setBorder(0);
        return pdfPCell;
    }

    private Phrase createHeaderAdditionInfo(String info) {
        Phrase phrase = new Phrase(info, FontUtil.openSansRegular(11));
        return phrase;
    }

    private Phrase createHeaderPrescription(String prescription) {
        Phrase phrase = new Phrase(prescription, FontUtil.openSansRegular(7));
        return phrase;
    }

    private Phrase createHeaderPrescriptionSender(String sender) {
        Phrase phrase = new Phrase(sender, FontUtil.openSansRegular(7));
        return phrase;
    }

    private Phrase createHeaderBarcode(String barcode) {
        Phrase phrase2 = new Phrase("*" + barcode + "*", FontUtil.fre3of9x(24.5f));
        return phrase2;
    }

    private void createFooterKaz(PdfWriter writer, String f6, String date, String hourAndMinute) {
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(490);

        Phrase commonInfo = createFooterCommonInfo("Осы мәтін (хат, құжат) «Қазпошта» АҚ-ның WWW.POST.KZ порталы және/немесе «ГЭП» ақпараттық жүйесі арқылы алынған\n" +
                "және басып шығарылған және жіберушінің электрондық құжаттының қағаз көшірмесі болып табылады.");
        PdfPCell cell1 = new PdfPCell(commonInfo);
        cell1.setBorder(0);
        cell1.setPadding(0);

        Phrase documentCreator = createFooterCommonInfo("Электрондық құжатты жасаған: " + f6);
        PdfPCell cell2 = new PdfPCell(documentCreator);
        cell2.setBorder(0);
        cell2.setPadding(0);

        Phrase dateAndTime = createFooterCommonInfo("Хатты өңдеу күні мен уақыты: " + date + " сағат " + hourAndMinute);
        PdfPCell cell3 = new PdfPCell(dateAndTime);
        cell3.setBorder(0);
        cell3.setPadding(0);
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);

        footerTablePosition(writer, table, 57, 160);

    }

    private void createFooterRus(PdfWriter writer, String f6, String date, String hourAndMinute) {
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(490);
        Phrase commonInfo = createFooterCommonInfo("Настоящий текст (письмо, документ) получен и распечатан с использованием портала WWW.POST.KZ и/или" +
                "информационной системой «ГЭП» АО «Казпочта» и является бумажной копией электронного документа отправителя.");
        PdfPCell cell1 = new PdfPCell(commonInfo);
        cell1.setBorder(0);
        cell1.setPadding(0);

        Phrase documentCreator = createFooterCommonInfo("Электронный документ создал: " + f6);
        PdfPCell cell2 = new PdfPCell(documentCreator);
        cell2.setBorder(0);
        cell2.setPadding(0);

        Phrase dateAndTime = createFooterCommonInfo("Дата и время обработки письма: " + date + " в " + hourAndMinute + " часов");
        PdfPCell cell3 = new PdfPCell(dateAndTime);
        cell3.setBorder(0);
        cell3.setPadding(0);
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);

        footerTablePosition(writer, table, 57, 110);

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
        table.writeSelectedRows(FIRST_ROW, LAST_ROW, 330, 738f, contentByte);
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

    private Image createLogoImage() {
        Image image = ImageUtil.getLogoHybrid();
        Image image1 = ImageUtil.getLogoHybrid();
        System.out.println(image+ "   ***   "+image1);
        image.setAbsolutePosition(329f, 740f);
        image.scaleAbsolute(80f, 23f);
        return image;
    }

    private Phrase createFooterCommonInfo(String info) {
        Phrase phrase = new Phrase(info, FontUtil.openSansRegular(8));
        return phrase;
    }


}
