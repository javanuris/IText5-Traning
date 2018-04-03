package titles.single.notice.kaz;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.single.notice.AbstractNoticeKazTitle;
import utils.FontUtil;

//id 5
public class CivilPreviouslyNoticeKazTitle extends AbstractNoticeKazTitle {

    protected void setBodyDescriptionBeforePovestka(PdfPTable table) {
        String additionalTextStr = String.format("(Азаматтық іс бойынша өтінішхатты алдын ала қарауға тағайындау)");
        Phrase additionalText = new Phrase(additionalTextStr, FontUtil.openSansBold(10));
        PdfPCell additionalTextCell = getPdfPCell(additionalText);
        additionalTextCell.setPaddingLeft(49f);
        table.addCell(additionalTextCell);
    }

    protected void setBodyAdditionalInfo(PdfPTable table, Form103 form103) {
        String text1 = String.format("     Қазақстан Республикасының Жоғарғы Соты Сізге АІЖК-нің 393-бабына сәйкес, Сіздің өтінішхатыңызды алдын ала қарау Астана қаласы, Есіл өзенінің сол жақ жағалауы, Д. Қонаев көшесі, 39-үй мекенжайы бойынша %s тағайындалғанын хабарлайды.", form103.getF6());
        addTextToPart(table, text1, 1);

        String text2 = String.format("     АІЖК-нің 393-бабының 3-бөлігіне сәйкес, Сіздің келмеуіңіз iс бойынша сот қадағалауы тәртiбiмен iс жүргiзудi қозғауға негiз бар немесе жоқ екенi туралы мәселенi шешуге кедергi болмайды.");
        addTextToPart(table, text2, 15);

        String text3 = String.format("     Қазақстан Республикасы Азаматтық іс жүргізу кодексінің 59, 62-баптарына сәйкес, іске қатысушы адамдардың өкілдері: 1) заңға сәйкес берілген және ресімделген сенімхатты, адвокаттар – қосымша ордерді; 2) өкілдікті жүзеге асыруға арналған тапсырманы куәландыратын құжаттарды; 3) жоғары заңгерлік білімі бар екенін растайтын құжатты (дипломның көшірмесін) ұсынулары қажет.");
        addTextToPart(table, text3, 1);

        String text4 = String.format("     Іс бойынша тараптарды тіркеу сағат %s %s дейін жүргізіледі.", form103.getF7(), form103.getF8());
        addTextToPart(table, text4, 1);

        String text5 = String.format("     Қолданыстағы заңнамаға сәйкес, сот отырысы залында фотоға түсіру, бейнежазба жасау үшін сот ісіне қатысушылар төрағалық етушінің рұқсатын электрондық немесе жазбаша түрде өтініш беру арқылы сот ісін қарау басталғанға дейін алдын ала алулары қажет.");
        addTextToPart(table, text5, 1);

        String text6 = String.format("      Азаматтық және әкімшілік істер жөніндегі қадағалаушы сот алқасының хатшылығы.");
        addTextToPart(table, text6, 1);
    }

    @Override
    public void createFooter(PdfWriter writer, Form103 form103) {
        setQRCode(writer, form103.getF10());

        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(490f);

        createFooterAdditionalInfo(table, form103);

        setTablePosition(writer, table, 64f, 210f);
        gepContacts(writer);
        gepCopyright(writer);
    }

    @Override
    protected void createFooterAdditionalInfo(PdfPTable table, Form103 form103) {
        String text1 = String.format("          Егер Сіз «Сот кабинеті» электрондық сервисін пайдаланушы болып табылсаңыз\n" +
                "              www.oficce.sud.kz сайтында қаулымен онлайн режимінде таныса аласыз.\n" +
                "Туындаған сұрақтар бойынша сот органдарының Сall-орталығына қалалық телефоннан \n" +
                "  1401 нөміріне (тегін), ұялы телефоннан 8-7172-71000 нөміріне (ақылы) қоңырау шалуға\n" +
                "                                                                                  болады.");
        addTextToPart(table, text1, 1);
    }

    protected void setQRCode(PdfWriter writer, String text) {
        getQRCode(writer, text);
    }
}
