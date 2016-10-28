package ru.kostikov;

import java.io.*;

/**
 * Created by Алексей on 28.10.2016.
 */
public class CacheTxt {
    PrintStream output;
    Cache<String, File> fileCache = new Cache<>();

    public CacheTxt(OutputStream output) {
        this.output = new PrintStream(new BufferedOutputStream(output), true);
    }

    /**
     * Gets File from cache, if file not found, add it to cache
     * @param fileName - name of File
     */
    public void getTxt(String fileName){
        File file = fileCache.get(fileName);

        if (file == null){
            file = new File(CacheTxt.class.getClassLoader().getResource(fileName).getFile());
            fileCache.add(fileName, file);
        }

        printFile(file);
    }

    /**
     * Prints File to output
     * @param file reference to File
     */
    private void printFile(File file){
        BufferedReader br = null;

        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(file));

            while ((sCurrentLine = br.readLine()) != null) {
                this.output.println(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
