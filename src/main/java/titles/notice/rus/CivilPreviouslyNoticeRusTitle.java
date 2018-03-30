package titles.notice.rus;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.notice.AbstractNoticeRusTitle;
import utils.FontUtil;
//id 5
public class CivilPreviouslyNoticeRusTitle extends AbstractNoticeRusTitle{

    protected void setBodyDescriptionBeforePovestka(PdfPTable table) {
        String additionalTextStr = String.format("(назначение по предварительному рассмотрению ходатайства по гражданскому делу)");
        Phrase additionalText = new Phrase(additionalTextStr, FontUtil.openSansBold(10));
        PdfPCell additionalTextCell = getPdfPCell(additionalText);
        additionalTextCell.setPaddingLeft(6f);
        table.addCell(additionalTextCell);
    }

    protected void setBodyAdditionalInfo(PdfPTable table, Form103 form103) {

        String demandTwoStr = String.format("     Верховный Суд Республики Казахстан извещает Вас о том, что в соответствии со ст. 393 ГПК РК предварительное рассмотрение Вашего ходатайства  назначено на %s по адресу: г. Астана, ул. Д. Кунаева, д.39 (Левый берег р. Ишим).", form103.getF6());
        Phrase demandTwo = new Phrase(demandTwoStr, FontUtil.openSansRegular(10));
        addCellParagraph(table, demandTwo, 1);

        String demandOneStr = String.format("     На основании ч.3 ст. 393 ГПК РК Ваша неявка не препятствует  решению вопроса о наличии или отсутствии оснований для возбуждения  производства  по делу  в порядке судебного надзора.");
        Phrase demandOne = new Phrase(demandOneStr, FontUtil.openSansRegular(10));
        addCellParagraph(table, demandOne, 15);

        String demandThreeStr = String.format("     В соответствии со ст.ст. 59, 62  ГПК РК представителям лиц, участвующих в деле, необходимо представить: 1) доверенность, выданную и оформленную в соответствии с законом, адвокатам  - дополнительно ордер; 2) документы, удостоверяющие поручение на осуществление представительства по данному делу; 3) документ, подтверждающий наличие высшего юридического образования представителя (копия диплома).");
        Phrase demandThree = new Phrase(demandThreeStr, FontUtil.openSansRegular(10));
        addCellParagraph(table, demandThree, 1);

        String demandFourStr = String.format("     Регистрация сторон по делу с %s %s.", form103.getF7(), form103.getF8());
        Phrase demandFour = new Phrase(demandFourStr, FontUtil.openSansRegular(10));
        addCellParagraph(table, demandFour, 1);

        String demandFiveStr = String.format("     По результатам будет принято постановление о наличии либо отсутствии основании для возбуждения надзорного производства и направлено в Ваш адрес.");
        Phrase demandFive = new Phrase(demandFiveStr, FontUtil.openSansRegular(10));
        addCellParagraph(table, demandFive, 1);

        String demandSixStr = String.format("     В соответствии с действующим законодательством для применения фотосъемки, видеозаписи в зале судебного заседания, участникам судебного процесса необходимо заранее получить разрешение председательствующего до начала судебного разбирательства путем подачи заявления в электронном или письменном виде.");
        Phrase demandSix = new Phrase(demandSixStr, FontUtil.openSansRegular(10));
        addCellParagraph(table, demandSix, 1);
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
        String descriptionStr = String.format("              Если Вы являетесь пользователем электронного сервиса «Судебный кабинет»,\n" +
                "      Вы можете ознакомиться с постановлением в онлайн-режиме на www.oficce.sud.kz.\n" +
                "В случае отсутствия регистрации в «Судебном кабинете» - Вы имеете возможность просмотра судебных документов на www.sud.gov.kz " +
                "в разделе «Просмотр судебных документов», указанных в судебном извещении.\n" +
                "                        Список слушаний дел Вы можете просмотреть на www.sud.gov.kz\n"+
                "             По возникшим вопросам звонить в Сall-центр судебных органов - с городских\n" +
                "                                                    телефонов на номер 1401(бесплатно),\n" +
                "                                  с мобильных телефонов на номер 8-7172-710000 (платно).");
        Phrase description = new Phrase(descriptionStr, FontUtil.openSansBold(10));
        addCell(table, description, 1);

    }

    protected void setQRCode(PdfWriter writer, String text) {
        getQRCode(writer, text);
    }

}
