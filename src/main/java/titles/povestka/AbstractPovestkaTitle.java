package titles.povestka;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.AbstractTitle;
import titles.povestka.lang.AbstractLangTemplate;
import utils.FontUtil;
import utils.ImageUtil;


public abstract class AbstractPovestkaTitle extends AbstractTitle {


    protected abstract AbstractLangTemplate templ();

    @Override
    protected void createHeaderMiddle(PdfWriter writer, PdfPTable table, Form103 form103) {
        Image image = createSudImage();
        try {
            writer.getDirectContent().addImage(image);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        Phrase sudPovestka = new Phrase(templ().getSudPovestka(), FontUtil.openSansBold(7));
        addCell(table, sudPovestka, 10);

        String senderAndFromStr = String.format(templ().getSenderAndFrom(), form103.getF6(), form103.getF10());
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
            String recipientPhoneStr = String.format("тел: %s", form103.getResipientPhone());
            Phrase recipientPhone = new Phrase(recipientPhoneStr, FontUtil.openSansBold(8));
            addCell(table, recipientPhone, 2);
        }
    }

    @Override
    public void createBody(PdfWriter writer, Form103 form103) {
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(490);

        String povestkaStr = String.format(templ().getPovestka());
        Phrase povestka = new Phrase(povestkaStr, FontUtil.openSansBold(15));
        PdfPCell povestkaCell = getPdfPCell(povestka);
        povestkaCell.setPaddingLeft(106f);
        table.addCell(povestkaCell);

        String receiverStr = String.format(templ().getReceiver(), form103.getF1());
        Phrase receiver = new Phrase(receiverStr, FontUtil.openSansLight(10));
        addCell(table, receiver, 32);

        String addressStr = String.format(templ().getAddress(), form103.getF2(), form103.getF3(), form103.getF4(), form103.getF5());
        Phrase address = new Phrase(addressStr, FontUtil.openSansLight(10));
        addCell(table, address, 2);

        String sudStr = String.format(templ().getSud(), form103.getF6());
        Phrase sud = new Phrase(sudStr, FontUtil.openSansLight(10));
        addCell(table, sud, 10f);

        String callYouStr = String.format(templ().getCallYou(), form103.getF10());
        Phrase callYou = new Phrase(callYouStr, FontUtil.openSansLight(10));
        addCell(table, callYou, 2);

        String toStr = String.format(templ().getTo(), form103.getF7());
        Phrase to = new Phrase(toStr, FontUtil.openSansLight(10));
        addCell(table, to, 2);

        String dealStr = String.format(templ().getDeal(), form103.getF8());
        Phrase deal = new Phrase(dealStr, FontUtil.openSansLight(10));
        addCell(table, deal, 2);

        String asStr = String.format(templ().getAs(), form103.getF9());
        Phrase as = new Phrase(asStr, FontUtil.openSansLight(10));
        PdfPCell asCell = getPdfPCell(as);
        asCell.setPaddingTop(2f);
        asCell.setPaddingBottom(10f);
        table.addCell(asCell);

        setDemandThree(table);

        String demandOneStr = String.format(templ().getDemandOne());
        Phrase demandOne = new Phrase(demandOneStr, FontUtil.openSansRegular(10));
        addCell(table, demandOne, 1);

        String demandTwoStr = String.format(templ().getDemandTwo());
        Phrase demandTwo = new Phrase(demandTwoStr, FontUtil.openSansRegular(10));
        addCell(table, demandTwo, 2);

        String secretaryStr = String.format(templ().getSecretary(), form103.getF13());
        Phrase secretary = new Phrase(secretaryStr, FontUtil.openSansLight(10));
        addCell(table, secretary, 10);

        String phoneNumberStr = String.format(templ().getPhoneNumber(), form103.getF12());
        Phrase phoneNumber = new Phrase(phoneNumberStr, FontUtil.openSansLight(10));
        addCell(table, phoneNumber, 1);

        String officePhoneNumberStr = String.format(templ().getOfficePhoneNumber(), form103.getF19());
        Phrase officePhoneNumber = new Phrase(officePhoneNumberStr, FontUtil.openSansLight(10));
        addCell(table, officePhoneNumber, 1);

        if (form103.getF18() != null) {
            String judgeStr = String.format(templ().getJudge(), form103.getF18().toUpperCase());
            Phrase judge = new Phrase(judgeStr, FontUtil.openSansLight(10));
            addCell(table, judge, 1);

        }
        setTablePosition(writer, table, 57f, 594f);
    }


    protected abstract void setDemandThree(PdfPTable table);

    @Override
    public void createFooter(PdfWriter writer, Form103 form103) {
        setQRCode(writer, form103);

        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(490);

        String descriptionStr = String.format(templ().getDescription());
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

        String text1Str = String.format(templ().getText1());
        Phrase text1 = new Phrase(text1Str, FontUtil.openSansLight(8));
        addCell(table, text1, 1);

        String text2Str = String.format(templ().getText2());
        Phrase text2 = new Phrase(text2Str, FontUtil.openSansLight(8));
        addCell(table, text2, 2);

        String text3Str = String.format(templ().getText3());
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


    protected void addCell(PdfPTable table, Phrase phrase, float paddingTop) {
        PdfPCell toCell = getPdfPCell(phrase);
        toCell.setPaddingTop(paddingTop);
        table.addCell(toCell);
    }

}
