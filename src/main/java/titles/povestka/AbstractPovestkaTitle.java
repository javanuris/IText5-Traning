package titles.povestka;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.AbstractTitle;
import utils.FontUtil;
import utils.ImageUtil;


public abstract class AbstractPovestkaTitle extends AbstractTitle {

    @Override
    protected void createHeaderMiddle(PdfWriter writer, PdfPTable table, Form103 form103) {
        Image image = createSudImage();
        try {
            writer.getDirectContent().addImage(image);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        Phrase prescriptionSender = new Phrase("Судебная повестка", FontUtil.openSansBold(7));
        addCell(table, prescriptionSender, 10);

        String senderAndFromStr = String.format("от: %s %s", form103.getF6(), form103.getF10());
        Phrase senderAndFrom = new Phrase(senderAndFromStr, FontUtil.openSansRegular(7));
        addCell(table, senderAndFrom, 1);

        Phrase f1 = new Phrase(form103.getF1().toUpperCase(), FontUtil.openSansBold(8));
        addCell(table, f1, 3);


        Phrase f2 = new Phrase(form103.getF2(), FontUtil.openSansBold(8));
        addCell(table, f2, 1);

        Phrase f3 = new Phrase(form103.getF3(), FontUtil.openSansBold(8));
        addCell(table, f3, 1);


        String addressStr = String.format("%s, %s", form103.getF4(), form103.getF5());
        Phrase address = new Phrase(addressStr, FontUtil.openSansBold(8));
        addCell(table, address, 2);


        if (form103.getResipientPhone() != null) {
            Phrase recipientPhone = new Phrase("тел: " + form103.getResipientPhone(), FontUtil.openSansBold(8));
            addCell(table, recipientPhone, 2);

        }
    }

    @Override
    public void createBody(PdfWriter writer, Form103 form103) {
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(490);

        Phrase povestka = new Phrase("СУДЕБНАЯ ПОВЕСТКА/ИЗВЕЩЕНИЕ", FontUtil.openSansBold(15));
        PdfPCell povestkaCell = getPdfPCell(povestka);
        povestkaCell.setPaddingLeft(106f);
        table.addCell(povestkaCell);

        String receiverStr = String.format("  Кому: %s", form103.getF1());
        Phrase receiver = new Phrase(receiverStr, FontUtil.openSansLight(10));
        addCell(table, receiver, 32);

        String addressStr = String.format("  Куда: %s %s %s %s", form103.getF2(), form103.getF3(), form103.getF4(), form103.getF5());
        Phrase address = new Phrase(addressStr, FontUtil.openSansLight(10));
        addCell(table, address, 2);

        String sudStr = String.format("  Суд: %s", form103.getF6());
        Phrase sud = new Phrase(sudStr, FontUtil.openSansLight(10));
        addCell(table, sud, 10f);

        String callYouStr = String.format("  вызывает Вас по адресу: %s", form103.getF10());
        Phrase callYou = new Phrase(callYouStr, FontUtil.openSansLight(10));
        addCell(table, callYou, 2);

        String toStr = String.format("  на: %s", form103.getF7());
        Phrase to = new Phrase(toStr, FontUtil.openSansLight(10));
        addCell(table, to, 2);

        String dealStr = String.format("  по делу: %s", form103.getF8());
        Phrase deal = new Phrase(dealStr, FontUtil.openSansLight(10));
        addCell(table, deal, 2);

        String asStr = String.format("  в качестве: %s", form103.getF9());
        Phrase as = new Phrase(asStr, FontUtil.openSansLight(10));
        PdfPCell asCell = getPdfPCell(as);
        asCell.setPaddingTop(2f);
        asCell.setPaddingBottom(10f);
        table.addCell(asCell);

        setDemandThree(table);

        String demandOneStr = String.format("   Лицо, принявшее повестку, обязано при первой возможности вручить её адресату.\n   Уклонение без уважительных причин участников процесса и иных лиц от явки в суд влечет административную ответственность (ст.513 КоАП).\n");
        Phrase demandOne = new Phrase(demandOneStr, FontUtil.openSansRegular(10));
        addCell(table, demandOne, 1);


        String demandTwoStr = String.format("   При себе иметь документ, удостоверяющий личность.");
        Phrase demandTwo = new Phrase(demandTwoStr, FontUtil.openSansRegular(10));
        addCell(table, demandTwo, 2);

        String secretaryStr = String.format("     Секретарь судебного заседания: %s", form103.getF13());
        Phrase secretary = new Phrase(secretaryStr, FontUtil.openSansLight(10));
        addCell(table, secretary, 10);

        String phoneNumberStr = String.format("     Телефон: %s", form103.getF12());
        Phrase phoneNumber = new Phrase(phoneNumberStr, FontUtil.openSansLight(10));
        addCell(table, phoneNumber, 1);


        String officePhoneNumberStr = String.format("     Телефон заведующего канцелярии: %s", form103.getF19());
        Phrase officePhoneNumber = new Phrase(officePhoneNumberStr, FontUtil.openSansLight(10));
        addCell(table, officePhoneNumber, 1);


        if (form103.getF18() != null) {
            String judgeStr = String.format("     Судья: %s", form103.getF18().toUpperCase());
            Phrase judge = new Phrase(judgeStr, FontUtil.openSansLight(10));
            addCell(table, judge, 1);

        }
        setTablePosition(writer, table, 57f, 594f);
    }


    protected void addCell(PdfPTable table, Phrase phrase, float paddingTop) {
        PdfPCell toCell = getPdfPCell(phrase);
        toCell.setPaddingTop(paddingTop);
        table.addCell(toCell);
    }

    protected abstract void setDemandThree(PdfPTable table);

    @Override
    public void createFooter(PdfWriter writer, Form103 form103) {
        setQRCode(writer, form103);

        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(490);
        String descriptionStr = String.format("       На сайте Верховного Суда www.sud.gov.kz для граждан и юридических лиц реализованы:\n" +
                "- возможность подачи обращения, заявления (жалобы) и ходатайства в онлайн режиме через электронный сервис «Судебный кабинет»;\n" +
                "- ознакомление с судебными документами в электронном сервисе «Ознакомление с судебными документами»;\n" +
                "- ознакомление со списком слушаний судебных дел;\n" +
                "- распечатка электронной судебной повестки в модуле «Судебная повестка» по коду, полученному СМС-сообщением на сотовый телефон.\n" +
                "По возникшим вопросам звонить в Сall-центр судебных органов с городских телефонов на номер 1401(бесплатно), с мобильных телефонов на номер 8-7172-710000 (платно).\n");
        Phrase description = new Phrase(descriptionStr, FontUtil.openSansBold(8));
        description.setLeading(10);
        addCell(table, description, 1);

        setTablePosition(writer, table, 57f, 182f);

        gepContacts(writer);
        gepCopyright(writer);

    }

    protected abstract void setQRCode(PdfWriter writer, Form103 form103);

    protected void getQRCode(PdfWriter writer, Form103 form103) {
        if (form103.getF16() != null) {
            Image image = createQRCode(form103.getF16(), 30f, 32f, 85f, 85f);
            try {
                writer.getDirectContent().addImage(image);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }

    }

    private Image createQRCode(String text, float xPos, float yPos, float width, float height) {
        BarcodeQRCode barcodeQRCode = new BarcodeQRCode(text, (int) width, (int) height, null);
        Image codeQrImage = null;
        try {
            codeQrImage = barcodeQRCode.getImage();
            codeQrImage.setAbsolutePosition(xPos, yPos);
            codeQrImage.scaleAbsolute(width, height);
        } catch (BadElementException e) {
            e.printStackTrace();
        }
        return codeQrImage;
    }

    private void gepContacts(PdfWriter writer) {
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(150);

        String text1Str = String.format("Контакт-Центр ВС:");
        Phrase text1 = new Phrase(text1Str, FontUtil.openSansLight(8));
        addCell(table, text1, 1);


        String text2Str = String.format("1401 ( бесплатно по всему РК )");
        Phrase text2 = new Phrase(text2Str, FontUtil.openSansLight(8));
        addCell(table, text2, 2);

        String text3Str = String.format("8 (7172) 710 000");
        Phrase text3 = new Phrase(text3Str, FontUtil.openSansLight(8));
        addCell(table, text3, 2);

        setTablePosition(writer, table, 110f, 79f);
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
