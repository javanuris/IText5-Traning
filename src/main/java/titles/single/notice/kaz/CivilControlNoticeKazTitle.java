package titles.single.notice.kaz;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.single.notice.AbstractNoticeKazTitle;
import utils.FontUtil;

//id 6
public class CivilControlNoticeKazTitle extends AbstractNoticeKazTitle {

    protected void setBodyDescriptionBeforePovestka(PdfPTable table) {
        String additionalTextStr = String.format("(Азаматтық іс бойынша қадағалау сот сатысының отырысына шақырту)");
        Phrase additionalText = new Phrase(additionalTextStr, FontUtil.openSansBold(10));
        PdfPCell additionalTextCell = getPdfPCell(additionalText);
        additionalTextCell.setPaddingLeft(35f);
        table.addCell(additionalTextCell);
    }

    protected void setBodyAdditionalInfo(PdfPTable table, Form103 form103) {
        String text1 = String.format("      Қазақстан Республикасының Жоғарғы Соты Сізге Қазақстан Республикасы Азаматтық процестік кодексінің 445-бабына сәйкес, %s өтінішхаты (Бас Прокурордың наразылығы, Жоғарғы Сот Төрағасының ұсынуы) бойынша талапкер %s жауапкер %s туралы талап арызына орай қозғалған азаматтық іс бойынша кассациялық сатыдағы сот отырысы Астана қаласы, Есіл өзенінің сол жақ жағалауы, Д. Қонаев көшесі, 39-үй мекенжайы бойынша %s тағайындалғанын хабарлайды.", form103.getF9(), form103.getF6(), form103.getF7(), form103.getF10());
        addTextToPart(table, text1, 1);

        String text2 = String.format("      ҚР АПК-нің 58, 60-баптарына сәйкес, іске қатысушы адамдардың өкілдері: 1) заңға сәйкес берілген және ресімделген сенімхатты, адвокаттар – қосымша ордерді; 2) өкілдікті жүзеге асыруға арналған тапсырманы куәландыратын құжаттарды; 3) жоғары заңгерлік білімі бар екенін растайтын құжатты (дипломның көшірмесін) ұсынулары қажет.");
        addTextToPart(table, text2, 1);

        String text3 = String.format("     Іс бойынша тараптарды тіркеу сағат %s %s дейін жүргізіледі.", form103.getF7(), form103.getF8());
        addTextToPart(table, text3, 1);

        String text4 = String.format("     ҚР АПК-нің 446-бабына сәйкес, іске қатысатын адам қайта қарауға қатысты қарсылықты растайтын құжаттарды қоса тіркей отырып, сот актісін кассациялық тәртібімен қайта қарау туралы өтінішхатқа, ұсынуға немесе наразылыққа пікірді іске қатысатын басқа адамдарға және Қазақстан Республикасының Жоғарғы Сотына %s дейінгі мерзімде жібереді.", form103.getF13());
        addTextToPart(table, text4, 1);

        String text5 = String.format("     Пікірге іске қатысушы адам немесе оның өкілі қол қояды. Өкілдің қолы қойылған пікірге оның өкілеттігін растайтын сенімхат немесе өзге құжат қоса тіркеледі.");
        addTextToPart(table, text5, 1);

        String text6 = String.format("       ҚР АПК-нің 450-бабының 2-бөлігіне сәйкес, істің қаралатын уақыты мен орны туралы тиісінше хабардар етілген, өтінішхат (наразылық) берген адамның болмауы сот отырысын жалғастыру мүмкіндігін жоққа шығармайды");
        addTextToPart(table, text6, 1);

        String text7 = String.format("      Осыған орай іс бойынша тараптар кассациялық өндіріс жүргізу нөміріне (№%s) сілтеме жасап, Жоғарғы Сотқа 8-(7172)-710133, 8-(7172)-710105 телефондары немесе 707-0133@sud.kz электрондық адресі бойынша касациялық сатыдағы сот отырысына өздерінің қатысатыны туралы хабарлаулары қажет.", form103.getF14());
        addTextToPart(table, text7, 1);

        String text8 = String.format("      Электрондық құжаттармен  (өтінішхаттың көшірмесімен, кассациялық сатыдағы сот отырысында қарау үшін өтінішхатты беру туралы туралы қаулының көшірмесімен) танысу үшін Жоғарғы Сот сайтындағы «Сот құжаттарын қарау» модулінде Штрихті Почталық Идентификатордың (ШПИ) сәйкестендіру нөмірін (оң жақ жоғарғы бұрышта) және сот хабарламасында көрсетілген сот отырысының белгіленген күнін енгізу қажет.", form103.getF14());
        addTextToPart(table, text8, 1);

        String text9 = String.format("      Азаматтық және әкімшілік істер жөніндегі қадағалаушы сот алқасының хатшылығы.", form103.getF14());
        addTextToPart(table, text9, 1);
    }

    @Override
    public void createFooter(PdfWriter writer, Form103 form103) {
        setQRCode(writer, form103.getF15());

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

    @Override
    protected void addTextToPart(PdfPTable table, String text, int padding) {
        Phrase phrase4 = new Phrase(text, FontUtil.openSansRegular(9));
        addCellParagraph(table, phrase4, padding);
    }

    protected void setQRCode(PdfWriter writer, String text) {
        getQRCode(writer, text);
    }
}
