package titles.single.povestka.rus;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.single.povestka.AbstractPovestkaRusTitle;
import utils.FontUtil;

//id_type_doc = 1, id_subtype_doc = 1, lang = 1;
public class AdministrativePovestkaRusTitle extends AbstractPovestkaRusTitle {
    @Override
    protected void setDemandThree(PdfPTable table) {
        Phrase demandThree = new Phrase("   Лица, участвующие в деле, вправе знакомиться с материалами дела, представить суду доказательства посредством подачи заявлений и ходатайств, документов в письменной форме, либо в форме электронного документа.", FontUtil.openSansRegular(10));
        PdfPCell demandThreeCell = getPdfPCell(demandThree);
        table.addCell(demandThreeCell);
    }

    @Override
    protected void setQRCode(PdfWriter writer, Form103 form103) {
        getQRCode(writer, form103.getF16());

    }
}
