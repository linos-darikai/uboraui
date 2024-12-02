import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCode {
    private String filepath;
    
    public static final int QR_WIDTH = 300;
    public static final int QR_HEIGHT = 300;

    public QRCode(String filepath){
        this.filepath = filepath;
    }



    public static void generateQRCode(String text, String filePath) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, QR_WIDTH, QR_HEIGHT);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

        System.out.println("QR Code generated: " + filePath);
    }
    public String getfilePath(){
        return filepath;
    }

}
