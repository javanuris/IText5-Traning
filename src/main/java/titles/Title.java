package titles;

import com.itextpdf.text.pdf.PdfWriter;
import dto.Form103;

import java.io.ByteArrayOutputStream;

public interface Title {

    ByteArrayOutputStream createTitle(Form103 form103);

    void createHeader(PdfWriter writer , Form103 form103);

    void createBody(PdfWriter writer, Form103 form103);

    void createFooter(PdfWriter writer, Form103 form103);

}
