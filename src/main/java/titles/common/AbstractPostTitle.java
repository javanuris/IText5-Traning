package titles.common;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.AbstractTitle;
import utils.DateUtil;
import utils.FontUtil;

public abstract class AbstractPostTitle extends AbstractTitle {

    private static final float KAZ_FOOTER_X = 57f;
    private static final float KAZ_FOOTER_Y = 160f;

    private static final float RUS_FOOTER_X = 57f;
    private static final float RUS_FOOTER_Y = 110f;

    @Override
    public void createFooter(PdfWriter writer, Form103 form103) {
        String date = DateUtil.getDate();
        String time = DateUtil.getTime();
        createFooterRusAndKaz(writer, form103, date, time, true);
        createFooterRusAndKaz(writer, form103, date, time, false);
    }

    private void createFooterRusAndKaz(PdfWriter writer, Form103 form103, String date, String hourAndMinute, boolean lang) {

        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(490);

        Phrase commonInfo;
        Phrase documentCreated;
        Phrase dateAndTime;

        if (lang) {
            commonInfo = new Phrase("Настоящий текст (письмо, документ) получен и распечатан с использованием портала WWW.POST.KZ и/или " +
                    "информационной системой «ГЭП» АО «Казпочта» и является бумажной копией электронного документа отправителя.", FontUtil.openSansRegular(8));
            documentCreated = new Phrase("Электронный документ создал: " + form103.getF6(), FontUtil.openSansRegular(8));
            dateAndTime = new Phrase("Дата и время обработки письма: " + date + " в " + hourAndMinute + " часов", FontUtil.openSansRegular(8));
        } else {
            commonInfo = new Phrase("Осы мәтін (хат, құжат) «Қазпошта» АҚ-ның WWW.POST.KZ порталы және/немесе «ГЭП» ақпараттық жүйесі арқылы алынған" +
                    "және басып шығарылған және жіберушінің электрондық құжаттының қағаз көшірмесі болып табылады.", FontUtil.openSansRegular(8));
            documentCreated = new Phrase("Электрондық құжатты жасаған: " + form103.getF6(), FontUtil.openSansRegular(8));
            dateAndTime = new Phrase("Хатты өңдеу күні мен уақыты: " + date + " сағат " + hourAndMinute, FontUtil.openSansRegular(8));
        }

        PdfPCell cell1 = getPdfPCell(commonInfo);
        PdfPCell cell2 = getPdfPCell(documentCreated);
        PdfPCell cell3 = getPdfPCell(dateAndTime);

        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);

        if (lang) {
            setTablePosition(writer, table, RUS_FOOTER_X, RUS_FOOTER_Y);
        } else {
            setTablePosition(writer, table, KAZ_FOOTER_X, KAZ_FOOTER_Y);
        }

    }

    @Override
    public void createHeaderMiddle(PdfWriter writer, PdfPTable table, Form103 form103) {
        setPresentation(writer, table, form103);

        Phrase prescriptionSender = new Phrase("от: " + form103.getF6() + ", " + form103.getF7(), FontUtil.openSansRegular(7));
        PdfPCell prescriptionSenderCell = getPdfPCell(prescriptionSender);
        table.addCell(prescriptionSenderCell);

        if (form103.getF1() != null) {
            Phrase f1 = new Phrase(form103.getF1().toUpperCase(), FontUtil.openSansRegular(11));
            PdfPCell f1Cell = getPdfPCell(f1);
            f1Cell.setPaddingTop(1);
            table.addCell(f1Cell);
        }

        Phrase f2 = new Phrase(form103.getF2(), FontUtil.openSansRegular(11));
        PdfPCell f2Cell = getPdfPCell(f2);
        f2Cell.setPaddingTop(1);
        table.addCell(f2Cell);

        if (form103.getF3() != null && !form103.getF3().equals("")) {
            Phrase f3 = new Phrase(form103.getF3(), FontUtil.openSansRegular(11));
            PdfPCell f3Cell = getPdfPCell(f3);
            table.addCell(f3Cell);
        }

        Phrase cityAndIndex = new Phrase(form103.getF4() + ", " + form103.getF5(), FontUtil.openSansRegular(11));
        PdfPCell cityAndIndexCell = getPdfPCell(cityAndIndex);
        table.addCell(cityAndIndexCell);
    }


    abstract void setPresentation(PdfWriter writer, PdfPTable table, Form103 form103);
}
