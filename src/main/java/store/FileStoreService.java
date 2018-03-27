package store;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.ByteArrayOutputStream;
import java.util.Map;

public interface FileStoreService {

    void saveFile(Map<String , ByteArrayOutputStream> file);
}
