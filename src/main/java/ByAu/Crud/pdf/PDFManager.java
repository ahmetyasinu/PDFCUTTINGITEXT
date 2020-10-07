package ByAu.Crud.pdf;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDFManager {

    private PDFParser parser;
    private PDFTextStripper pdfStripper;
    private PDDocument pdDoc;
    private COSDocument cosDoc;

    private String Text;
    private String filePath;
    private File file;

    public PDFManager() {

    }

    public String toText() throws IOException {
        this.pdfStripper = null;
        this.pdDoc = null;
        this.cosDoc = null;

        file = new File(filePath);
        parser = new PDFParser(new RandomAccessFile(file, "r")); // update for PDFBox V 2.0

        parser.parse();
        cosDoc = parser.getDocument();
        pdfStripper = new PDFTextStripper();
        pdDoc = new PDDocument(cosDoc);
        pdDoc.getNumberOfPages();
        pdfStripper.setStartPage(0);
        pdfStripper.setEndPage(pdDoc.getNumberOfPages());
        Text = pdfStripper.getText(pdDoc);
        return Text;
    }


    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public PDDocument getPdDoc() {
        return pdDoc;
    }

    public PDFParser getParser() {
        return parser;
    }

    public void setParser(PDFParser parser) {
        this.parser = parser;
    }

    public PDFTextStripper getPdfStripper() {
        return pdfStripper;
    }

    public void setPdfStripper(PDFTextStripper pdfStripper) {
        this.pdfStripper = pdfStripper;
    }

    public void setPdDoc(PDDocument pdDoc) {
        this.pdDoc = pdDoc;
    }

    public COSDocument getCosDoc() {
        return cosDoc;
    }

    public void setCosDoc(COSDocument cosDoc) {
        this.cosDoc = cosDoc;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getFilePath() {
        return filePath;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
