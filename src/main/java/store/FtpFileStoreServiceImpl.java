package store;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;


public class FtpFileStoreServiceImpl implements FileStoreService {

    @Override
    public void saveFile(Map<String, ByteArrayOutputStream> fileAndName) {
         FTPClient ftpClient = new FTPClient();
        try {
            connect(ftpClient);

            fileAndName.forEach((pathAndName, fileStream) -> {
                try (InputStream file = new ByteArrayInputStream(fileStream.toByteArray())) {
                    ftpClient.storeFile(pathAndName, file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            disconnect(ftpClient);
        }
    }


    private void connect(FTPClient ftp) throws IOException {
        ftp.connect("172.30.75.125", 21);
        ftp.login("gepadmin", "6Wh6gzLX");
        ftp.enterLocalPassiveMode();
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
    }

    private void disconnect(FTPClient ftp) {
        if (ftp.isConnected()) {
            try {
                ftp.logout();
                ftp.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
