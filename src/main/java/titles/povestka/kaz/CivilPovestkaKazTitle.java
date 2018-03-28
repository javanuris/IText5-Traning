package titles.povestka.kaz;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;
import titles.povestka.AbstractPovestkaKazTitle;
import utils.FontUtil;

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
