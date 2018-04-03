package titles.single.notice.rus;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.single.notice.AbstractNoticeRusTitle;
import utils.FontUtil;

//id 6
public class CivilControlNoticeRusTitle extends AbstractNoticeRusTitle {

    protected void setBodyDescriptionBeforePovestka(PdfPTable table) {
        String additionalTextStr = String.format("(вызов на заседание надзорной судебной инстанции по гражданскому делу)");
        Phrase additionalText = new Phrase(additionalTextStr, FontUtil.openSansBold(10));
        PdfPCell additionalTextCell = getPdfPCell(additionalText);
        additionalTextCell.setPaddingLeft(20f);
        table.addCell(additionalTextCell);
    }

    protected void setBodyAdditionalInfo(PdfPTable table, Form103 form103) {

        String text1 = String.format("      Верховный Суд Республики Казахстан извещает Вас о том, что в соответствии со ст. 445 Гражданского процессуального кодекса Республики Казахстан судебное заседание суда кассационной инстанции по гражданскому делу по иску (заявлению) %s к %s о %s по ходатайству %s назначено на %s по адресу: г. Астана, ул. Д. Кунаева, д.39 (Левый берег р. Ишим).", form103.getF6(), form103.getF7(), form103.getF8(), form103.getF9(), form103.getF10());
        addTextToPart(table, text1, 1);

        String text2 = String.format("      В соответствии со ст.ст. 58, 60  ГПК РК представителям лиц, участвующих в деле, необходимо представить: 1) доверенность, выданную и оформленную в соответствии с законом, адвокатам  - дополнительно ордер; 2) документы, удостоверяющие поручение на осуществление представительства по данному делу; 3) документ, подтверждающий наличие высшего юридического образования представителя (копия диплома).");
        addTextToPart(table, text2, 1);

        String text3 = String.format("     Регистрация сторон по делу с %s %s.", form103.getF7(), form103.getF8());
        addTextToPart(table, text3, 1);

        String text4 = String.format("     В соответствии со ст. 446 ГПК РК  лицо, участвующее в деле, в срок до %s направляет отзыв на ходатайство, представление или протест о пересмотре судебного акта в кассационном порядке с приложением документов, подтверждающих возражение относительно пересмотра, другим лицам, участвующим в деле, и в Верховный Суд Республики Казахстан.", form103.getF13());
        addTextToPart(table, text4, 1);

        String text5 = String.format("     Отзыв подписывается лицом, участвующим в деле или его представителем. К отзыву, подписанному представителем, должен быть приложен документ, подтверждающий его полномочия.");
        addTextToPart(table, text5, 1);

        String text6 = String.format("      В соответствии с ч. 2 ст. 450 ГПК РК отсутствие лица, подавшего ходатайство  (протест), надлежаще уведомленного о времени и месте рассмотрения дела, не исключает возможность продолжения судебного заседания.");
        addTextToPart(table, text6, 1);

        String text7 = String.format("      В связи с этим, сторонам по делу о своем участии на заседании суда кассационной инстанции следует известить Верховный Суд по телефонам 8-7172-710133, 8-7172-710105 или по электронному адресу 707-0133@sud.kz со ссылкой на номер производства в кассационной инстанции %s.", form103.getF14());
        addTextToPart(table, text7, 1);

        String text8 = String.format("      Для ознакомления с электронными документами (копия ходатайства, копия постановления о передаче ходатайства для рассмотрения в судебном заседании кассационной инстанции) необходимо на сайте Верховного Суда в модуле «Просмотр судебных документов» ввести идентификационный номер ШПИ (в правом верхнем углу) и дату назначения судебного заседания, указанные в судебном извещении.", form103.getF14());
        addTextToPart(table, text8, 1);

        String text9 = String.format("      Секретариат надзорной судебной коллегии по гражданским и административным делам", form103.getF14());
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
        String descriptionStr = String.format("              Если Вы являетесь пользователем электронного сервиса «Судебный кабинет»,\n" +
                "      Вы можете ознакомиться с постановлением в онлайн-режиме на www.oficce.sud.kz.\n" +
                "В случае отсутствия регистрации в «Судебном кабинете» - Вы имеете возможность просмотра судебных документов на www.sud.gov.kz " +
                "в разделе «Просмотр судебных документов», указанных в судебном извещении.\n" +
                "                        Список слушаний дел Вы можете просмотреть на www.sud.gov.kz\n" +
                "             По возникшим вопросам звонить в Сall-центр судебных органов - с городских\n" +
                "                                                    телефонов на номер 1401(бесплатно),\n" +
                "                                  с мобильных телефонов на номер 8-7172-710000 (платно).");
        Phrase description = new Phrase(descriptionStr, FontUtil.openSansBold(10));
        addCell(table, description, 1);
    }

    protected void setQRCode(PdfWriter writer, String text) {
        getQRCode(writer, text);
    }

    @Override
    protected void addTextToPart(PdfPTable table, String text, int padding) {
        Phrase phrase4 = new Phrase(text, FontUtil.openSansRegular(9));
        addCellParagraph(table, phrase4, padding);
    }
}
