package titles.single.povestka.kaz;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.single.povestka.AbstractPovestkaKazTitle;
import utils.FontUtil;

//id_type_doc = 1, id_subtype_doc = 2, lang = 2;
public class CivilPovestkaKazTitle extends AbstractPovestkaKazTitle {
    @Override
    protected void setDemandThree(PdfPTable table) {
        Phrase demandThree = new Phrase("   Іске қатысатын тұлғалар істің материалдарымен танысуға, өтініштер мен өтінішхаттарды, құжаттарды жазбаша нысанда немесе электрондық құжат түрінде беру арқылы дәлелдемелер ұсынуға құқылы.", FontUtil.openSansRegular(10));
        PdfPCell demandThreeCell = getPdfPCell(demandThree);
        table.addCell(demandThreeCell);
    }

    @Override
    protected void setQRCode(PdfWriter writer, Form103 form103) {

    }
}
