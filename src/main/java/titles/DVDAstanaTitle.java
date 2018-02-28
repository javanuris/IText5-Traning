package titles;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import utils.DateUtil;
import utils.FontUtil;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class DVDAstanaTitle implements Title {

    private TitleConstructor construct = new TitleConstructor();

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

        construct.createIdPackage(writer, String.valueOf(form103.getIdPackage()));

        PdfPTable table = construct.createHeaderTable();
        Image logoImage = construct.createLogoImage();

        try {
            writer.getDirectContent().addImage(logoImage);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        Phrase prescription = new Phrase("ПРЕДПИСАНИЕ/Заказное письмо с уведомлением", FontUtil.openSansRegular(7));
        PdfPCell prescriptionCell = construct.getPdfPCell(prescription);
        prescriptionCell.setPaddingTop(1);
        table.addCell(prescriptionCell);

        Phrase prescriptionSender = new Phrase("от: " + form103.getF6() + ", " + form103.getF7(), FontUtil.openSansRegular(7));
        PdfPCell prescriptionSenderCell = construct.getPdfPCell(prescriptionSender);
        table.addCell(prescriptionSenderCell);

        if (form103.getF1() != null) {
            Phrase f1 = new Phrase(form103.getF1().toUpperCase(), FontUtil.openSansRegular(11));
            PdfPCell f1Cell = construct.getPdfPCell(f1);
            f1Cell.setPaddingTop(1);
            table.addCell(f1Cell);
        }

        Phrase f2 = new Phrase(form103.getF2(), FontUtil.openSansRegular(11));
        PdfPCell f2Cell = construct.getPdfPCell(f2);
        f2Cell.setPaddingTop(1);
        table.addCell(f2Cell);

        if (form103.getF3() != null && !form103.getF3().equals("")) {
            Phrase f3 = new Phrase(form103.getF3(), FontUtil.openSansRegular(11));
            PdfPCell f3Cell = construct.getPdfPCell(f3);
            table.addCell(f3Cell);
        }

        Phrase cityAndIndex = new Phrase(form103.getF4() + ", " + form103.getF5(), FontUtil.openSansRegular(11));
        PdfPCell cityAndIndexCell = construct.getPdfPCell(cityAndIndex);
        table.addCell(cityAndIndexCell);

        Phrase barcodeInCode = construct.createBarcodeInCode(form103.getBarcode());
        PdfPCell headerBarcodeCell = construct.getPdfPCell(barcodeInCode);
        table.addCell(headerBarcodeCell);

        Phrase shpi = construct.createShpi();
        PdfPCell shpiCell = construct.getPdfPCell(shpi);
        shpiCell.setPaddingTop(1);
        table.addCell(shpi);

        Phrase barcodeInText = construct.createBarcodeInText(form103.getBarcode());
        PdfPCell barcodeInTextCell = construct.getPdfPCell(barcodeInText);
        barcodeInTextCell.setPaddingLeft(45);
        table.addCell(barcodeInTextCell);

        construct.tablePosition(writer, table, TitleConstructor.HEADER_X, TitleConstructor.HEADER_Y);
    }

    @Override
    public void createBody(PdfWriter writer, Form103 form103) {

    }

    @Override
    public void createFooter(PdfWriter writer, Form103 form103) {
        String date = DateUtil.getDate();
        String time = DateUtil.getTime();
        createFooterKaz(writer, form103.getF6(), date, time);
        createFooterRus(writer, form103.getF6(), date, time);
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
        construct.tablePosition(writer, table, TitleConstructor.KAZ_FOOTER_X, TitleConstructor.KAZ_FOOTER_Y);

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

        construct.tablePosition(writer, table, TitleConstructor.RUS_FOOTER_X, TitleConstructor.RUS_FOOTER_Y);
    }

}
