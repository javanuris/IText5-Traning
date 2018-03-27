package titles.povestka;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.AbstractTitle;
import utils.FontUtil;
import utils.ImageUtil;


public class CriminalPovestkaTitle extends AbstractTitle {

    @Override
    protected void createHeaderMiddle(PdfWriter writer, PdfPTable table, Form103 form103) {
        Image image = createSudImage();
        try {
            writer.getDirectContent().addImage(image);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        Phrase prescriptionSender = new Phrase("Судебная повестка", FontUtil.openSansBold(7));
        PdfPCell prescriptionSenderCell = getPdfPCell(prescriptionSender);
        prescriptionSenderCell.setPaddingTop(10);
        table.addCell(prescriptionSenderCell);

        Phrase f6 = new Phrase("от: " + form103.getF6() + " " + form103.getF10(), FontUtil.openSansRegular(7));
        PdfPCell f6Cell = getPdfPCell(f6);
        table.addCell(f6Cell);

        Phrase f1 = new Phrase(form103.getF1().toUpperCase(), FontUtil.openSansBold(8));
        PdfPCell f1Cell = getPdfPCell(f1);
        f1Cell.setPaddingTop(3);
        table.addCell(f1Cell);

        Phrase f2 = new Phrase(form103.getF2(), FontUtil.openSansBold(8));
        PdfPCell f2Cell = getPdfPCell(f2);
        table.addCell(f2Cell);

        Phrase f3 = new Phrase(form103.getF3(), FontUtil.openSansBold(8));
        PdfPCell f3Cell = getPdfPCell(f3);
        table.addCell(f3Cell);

        Phrase f4Andf5 = new Phrase(form103.getF4() + ", " + form103.getF5(), FontUtil.openSansBold(8));
        PdfPCell f4Andf5Cell = getPdfPCell(f4Andf5);
        f4Andf5Cell.setPaddingTop(2);
        table.addCell(f4Andf5Cell);

        if (form103.getResipientPhone() != null) {
            Phrase resipientPhone = new Phrase("тел: " + form103.getResipientPhone(), FontUtil.openSansBold(8));
            PdfPCell resipientPhoneCell = getPdfPCell(resipientPhone);
            resipientPhoneCell.setPaddingTop(2);
            table.addCell(resipientPhoneCell);
        }
    }

    @Override
    public void createBody(PdfWriter writer, Form103 form103) {
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(490);

        Phrase sudPovestka = new Phrase("СУДЕБНАЯ ПОВЕСТКА/ИЗВЕЩЕНИЕ", FontUtil.openSansBold(15));
        PdfPCell sudPovestkaCell = getPdfPCell(sudPovestka);
        sudPovestkaCell.setPaddingLeft(106f);
        table.addCell(sudPovestkaCell);

        Phrase receiver = new Phrase("  Кому: " + form103.getF1(), FontUtil.openSansLight(10));
        PdfPCell receiverCell = getPdfPCell(receiver);
        receiverCell.setPaddingTop(32);
        table.addCell(receiverCell);

        Phrase address = new Phrase("  Куда: " + form103.getF2() + " " + form103.getF3() + " " + form103.getF4() + " " + form103.getF5(), FontUtil.openSansLight(10));
        PdfPCell addressCell = getPdfPCell(address);
        addressCell.setPaddingTop(2);
        table.addCell(addressCell);

        Phrase sud = new Phrase("  Суд: " + form103.getF6(), FontUtil.openSansLight(10));
        PdfPCell sudCell = getPdfPCell(sud);
        sudCell.setPaddingTop(10);
        table.addCell(sudCell);

        Phrase callYou = new Phrase("  вызывает Вас по адресу: " + form103.getF10(), FontUtil.openSansLight(10));
        PdfPCell callYouCell = getPdfPCell(callYou);
        callYouCell.setPaddingTop(2);
        table.addCell(callYouCell);

        Phrase to = new Phrase("  на: " + form103.getF7(), FontUtil.openSansLight(10));
        PdfPCell toCell = getPdfPCell(to);
        toCell.setPaddingTop(2);
        table.addCell(toCell);

        Phrase deal = new Phrase("  по делу: " + form103.getF8(), FontUtil.openSansLight(10));
        PdfPCell dealCell = getPdfPCell(deal);
        dealCell.setPaddingTop(2);
        table.addCell(dealCell);

        Phrase as = new Phrase("  в качестве: " + form103.getF9(), FontUtil.openSansLight(10));
        PdfPCell asCell = getPdfPCell(as);
        asCell.setPaddingTop(2);
        table.addCell(asCell);

        Phrase firstRole = new Phrase("   Лицо, принявшее повестку, обязано при первой возможности вручить её адресату.\n" +
                "   Уклонение без уважительных причин участников процесса и иных лиц от явки в суд влечет административную ответственность (ст.513 КоАП).\n", FontUtil.openSansRegular(10));
        PdfPCell firstRoleCell = getPdfPCell(firstRole);
        firstRoleCell.setPaddingTop(10);
        table.addCell(firstRoleCell);

        Phrase demand = new Phrase("   При себе иметь документ, удостоверяющий личность." + form103.getF9(), FontUtil.openSansRegular(10));
        PdfPCell demandCell = getPdfPCell(demand);
        demandCell.setPaddingTop(2);
        table.addCell(demandCell);


        Phrase secretary = new Phrase("     Секретарь судебного заседания: " + form103.getF13(), FontUtil.openSansLight(10));
        PdfPCell secretaryCell = getPdfPCell(secretary);
        secretaryCell.setPaddingTop(10);
        table.addCell(secretaryCell);

        Phrase phoneNumber = new Phrase("     Телефон: " + form103.getF12(), FontUtil.openSansLight(10));
        PdfPCell phoneNumberCell = getPdfPCell(phoneNumber);
        table.addCell(phoneNumberCell);

        Phrase officePhoneNumber = new Phrase("     Телефон заведующего канцелярии: " + form103.getF19(), FontUtil.openSansLight(10));
        PdfPCell officePhoneNumberCell = getPdfPCell(officePhoneNumber);
        table.addCell(officePhoneNumberCell);

        if (form103.getF18() != null) {
            Phrase judje = new Phrase("     Судья: " + form103.getF18().toUpperCase(), FontUtil.openSansLight(10));
            PdfPCell judjeCell = getPdfPCell(judje);
            table.addCell(judjeCell);
        }

        setTablePosition(writer, table, 57f, 594f);
    }

    @Override
    public void createFooter(PdfWriter writer, Form103 form103) {
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(490);
        Phrase description = new Phrase("       На сайте Верховного Суда www.sud.gov.kz для граждан и юридических лиц реализованы:\n" +
                "- возможность подачи обращения, заявления (жалобы) и ходатайства в онлайн режиме через электронный сервис «Судебный кабинет»;\n" +
                "- ознакомление с судебными документами в электронном сервисе «Ознакомление с судебными документами»;\n" +
                "- ознакомление со списком слушаний судебных дел;\n" +
                "- распечатка электронной судебной повестки в модуле «Судебная повестка» по коду, полученному СМС-сообщением на сотовый телефон.\n" +
                "По возникшим вопросам звонить в Сall-центр судебных органов с городских телефонов на номер 1401(бесплатно), с мобильных телефонов на номер 8-7172-710000 (платно).\n", FontUtil.openSansBold(8));
        description.setLeading(10);
        PdfPCell descriptionCell = getPdfPCell(description);

        table.addCell(descriptionCell);
        setTablePosition(writer, table, 57f, 182f);
        Phrase officePhoneNumber = new Phrase("Телефон заведующего канцелярии: " + form103.getF19(), FontUtil.openSansLight(8));
        PdfPCell officePhoneNumberCell = getPdfPCell(officePhoneNumber);
        table.addCell(officePhoneNumberCell);

        gepContacts(writer);
        gepCopyright(writer);

    }

    private void gepContacts(PdfWriter writer) {
        PdfPTable tableSecond = new PdfPTable(1);
        tableSecond.setTotalWidth(150);

        Phrase text1 = new Phrase("Контакт-Центр ВС:", FontUtil.openSansLight(8));
        PdfPCell text1Cell = getPdfPCell(text1);
        tableSecond.addCell(text1Cell);

        Phrase text2 = new Phrase("1401 ( бесплатно по всему РК )", FontUtil.openSansLight(8));
        PdfPCell text2Cell = getPdfPCell(text2);
        text2Cell.setPaddingTop(2);
        tableSecond.addCell(text2Cell);

        Phrase text3 = new Phrase("8 (7172) 710 000", FontUtil.openSansLight(8));
        PdfPCell text3Cell = getPdfPCell(text3);
        text3Cell.setPaddingTop(2);
        tableSecond.addCell(text3Cell);

        setTablePosition(writer, tableSecond, 110f, 79f);
    }

    private void gepCopyright(PdfWriter writer) {
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(490);
        Font font = FontUtil.openSansLight(6);
        font.setColor(BaseColor.GRAY);
        Phrase text = new Phrase("© 2014 Copyright АО Казпочта. Распечатано в ИС ГЭП™ - Гибридная Электронная Почта. http://gep.kazpost.kz/", font);
        PdfPCell textCell = getPdfPCell(text);
        table.addCell(textCell);
        setTablePosition(writer, table, 165f, 32f);

    }


    private Image createSudImage() {
        Image image = ImageUtil.getLogoSud();
        image.setAbsolutePosition(44f, 720f);
        image.scaleAbsolute(151f, 100f);
        return image;
    }
}
