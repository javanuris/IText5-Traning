package examples;

import titles.TitleConstructor;
import utils.DateUtil;
import utils.FontUtil;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PdfGenerator {

    private static String FILE = "d:/test/FirstPdf.pdf";

    public static final float HEADER_X = 330f;
    public static final float HEADER_Y = 738f;

    public static final float KAZ_FOOTER_X = 57f;
    public static final float KAZ_FOOTER_Y = 160f;

    public static final float RUS_FOOTER_X = 57f;
    public static final float RUS_FOOTER_Y = 110f;

    private TitleConstructor construct = new TitleConstructor();

    public PdfGenerator() {
        createTitle(FILE);
    }

    private void createTitle(String dest) {
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
            document.open();

            createHeader(writer);
            createFooter(writer, "Astana");

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void createHeader(PdfWriter writer) {

        construct.createIdPackage(writer, "01639174");

        PdfPTable table = construct.createTable();
        Image logoImage = construct.createLogoImage();

        try {
            writer.getDirectContent().addImage(logoImage);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        Phrase prescription = new Phrase("ПРЕДПИСАНИЕ/Заказное письмо с уведомлением", FontUtil.openSansRegular(7));
        PdfPCell prescriptionCell = construct.getPdfPCell(prescription);
        prescriptionCell.setPaddingTop(1);

        Phrase prescriptionSender = new Phrase("от: УАП ДВД г.Астана, улица 20-40, д. 4/1", FontUtil.openSansRegular(7));
        PdfPCell prescriptionSenderCell = construct.getPdfPCell(prescriptionSender);

        Phrase recipient = new Phrase("КӘДЕН ТАҢАТАР БЕКСҰЛТАНҰЛЫ", FontUtil.openSansRegular(11));
        PdfPCell recipientCell = construct.getPdfPCell(recipient);
        recipientCell.setPaddingTop(1);

        Phrase location = new Phrase("ул. КОРГАЛЖЫН, д. 11, корпус -, кв. 13", FontUtil.openSansRegular(11));
        PdfPCell locationCell = construct.getPdfPCell(location);

        Phrase region = new Phrase("ЕСИЛЬСКИЙ РАЙОН", FontUtil.openSansRegular(11));
        PdfPCell regionCell = construct.getPdfPCell(region);

        Phrase cityAndIndex = new Phrase("АСТАНА, 010000", FontUtil.openSansRegular(11));
        PdfPCell cityAndIndexCell = construct.getPdfPCell(cityAndIndex);

        Phrase barcodeInCode = construct.createBarcodeInCode("DA010080119KZ");
        PdfPCell headerBarcodeCell = construct.getPdfPCell(barcodeInCode);

        Phrase shpi = construct.createShpi();
        PdfPCell shpiCell = construct.getPdfPCell(shpi);
        shpiCell.setPaddingTop(1);

        Phrase barcodeInText = construct.createBarcodeInText("DA010080119KZ");
        PdfPCell barcodeInTextCell = construct.getPdfPCell(barcodeInText);
        barcodeInTextCell.setPaddingLeft(45);

        table.addCell(prescriptionCell);
        table.addCell(prescriptionSenderCell);
        table.addCell(recipientCell);
        table.addCell(locationCell);
        table.addCell(regionCell);
        table.addCell(cityAndIndexCell);
        table.addCell(headerBarcodeCell);
        table.addCell(shpi);
        table.addCell(barcodeInTextCell);

        construct.tablePosition(writer, table, HEADER_X, HEADER_Y);

    }

    private void createFooter(PdfWriter writer, String f6) {
        String date = DateUtil.getDate();
        String time = DateUtil.getTime();
        createFooterKaz(writer, f6, date, time);
        createFooterRus(writer, f6, date, time);
    }

    private void createFooterKaz(PdfWriter writer, String f6, String date, String hourAndMinute) {

        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(490);

        Phrase commonInfo = new Phrase("Осы мәтін (хат, құжат) «Қазпошта» АҚ-ның WWW.POST.KZ порталы және/немесе «ГЭП» ақпараттық жүйесі арқылы алынған" +
                "және басып шығарылған және жіберушінің электрондық құжаттының қағаз көшірмесі болып табылады.", FontUtil.openSansRegular(8));
        PdfPCell cell1 = construct.getPdfPCell(commonInfo);

        Phrase documentCreator = new Phrase("Электрондық құжатты жасаған: " + f6, FontUtil.openSansRegular(8));
        PdfPCell cell2 = construct.getPdfPCell(documentCreator);

        Phrase dateAndTime = new Phrase("Хатты өңдеу күні мен уақыты: " + date + " сағат " + hourAndMinute, FontUtil.openSansRegular(8));
        PdfPCell cell3 = construct.getPdfPCell(dateAndTime);

        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        construct.tablePosition(writer, table, KAZ_FOOTER_X, KAZ_FOOTER_Y);

    }

    private void createFooterRus(PdfWriter writer, String f6, String date, String hourAndMinute) {

        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(490);
        Phrase commonInfo = new Phrase("Настоящий текст (письмо, документ) получен и распечатан с использованием портала WWW.POST.KZ и/или " +
                "информационной системой «ГЭП» АО «Казпочта» и является бумажной копией электронного документа отправителя.", FontUtil.openSansRegular(8));
        PdfPCell cell1 = construct.getPdfPCell(commonInfo);


        Phrase documentCreator = new Phrase("Электронный документ создал: " + f6, FontUtil.openSansRegular(8));
        PdfPCell cell2 = construct.getPdfPCell(documentCreator);


        Phrase dateAndTime = new Phrase("Дата и время обработки письма: " + date + " в " + hourAndMinute + " часов", FontUtil.openSansRegular(8));
        PdfPCell cell3 = construct.getPdfPCell(dateAndTime);

        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);

        construct.tablePosition(writer, table, RUS_FOOTER_X, RUS_FOOTER_Y);
    }


}
