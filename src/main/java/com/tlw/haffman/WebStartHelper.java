package com.tlw.haffman;

import javax.jnlp.FileContents;
import javax.jnlp.FileOpenService;
import javax.jnlp.ServiceManager;
import javax.jnlp.UnavailableServiceException;
import java.io.IOException;
import java.io.InputStreamReader;

public class WebStartHelper {

    public static InputStreamReader getInputStreamReader() throws UnsupportedOperationException, IOException {
        try {
            FileOpenService fos = (FileOpenService) ServiceManager.lookup("javax.jnlp.FileOpenService");
            FileContents fc = fos.openFileDialog((String)null, new String[]{"txt"});
            return fc != null ? new InputStreamReader(fc.getInputStream()) : null;
        } catch (UnavailableServiceException var2) {
            throw new UnsupportedOperationException("FileOpenService unavailable.");
        }
    }
}
