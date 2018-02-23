package utils;

import java.io.*;


public class FileDownloader {
    private String fileName;

    public FileDownloader(String filename) {
        this.fileName = filename;
    }

    public String getFile() {
        String line = null;
        InputStream is = getClass().getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }


    public byte[] getFileByte() throws IOException {
        InputStream is = getClass().getResourceAsStream(fileName);
        byte[] buffer = new byte[8192];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int bytesRead;
        while ((bytesRead = is.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }


        return baos.toByteArray();

    }

}
