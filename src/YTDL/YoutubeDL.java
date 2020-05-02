package YTDL;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author JoshuaSL
 */
public class YoutubeDL implements Runnable {

    private String directory;
    private String link;
    private int quality;
    private volatile boolean running = true;
    private boolean buffReaderIsNull = false;
    private InputStreamReader inputStrReader = null;
    private ProcessBuilder pBuilder = null;
    private BufferedReader buffRdr = null;
//    private BufferedReader buffRdrErr = null;

    public void setQuality(int quality) {
        this.quality = quality;
    }

    /**
     *
     * @param link download link
     * @param directory path of the directory to save downloads
     */
    public void setValues(String link, String directory) {
        this.directory = directory;
        this.link = link;
    }

    public void terminate() {
        running = false;
    }

    /**
     *
     * @param b set true to make the buffered reader null
     */
    public void setBuffReaderNull(boolean b) {
        buffReaderIsNull = b;
        if (b == true) {
            buffRdr = null;
//            buffRdrErr = null;
        }
    }

    /**
     *
     * @return true if buffered reader is null
     */
    public boolean isBuffReaderNull() {
        return buffReaderIsNull;
    }

    @Override
    public void run() {
        try {

            System.out.println("starting try catch");
            pBuilder = new ProcessBuilder(/*"bash","-c",*/"youtube-dl", "-f", String.valueOf(quality), link);
            System.out.println("--------------------------------------------------" + link);

            pBuilder.redirectErrorStream(true); // this will ensure that both input and error streams will stream together, hence not needed to check streams seperately
            pBuilder.redirectOutput(ProcessBuilder.Redirect.PIPE);

            pBuilder.directory(new File(directory));
//            System.out.println("location is: " + directory);

            Process process = pBuilder.start();

            InputStream inputStr = process.getInputStream();
            inputStrReader = new InputStreamReader(inputStr);
            buffRdr = new BufferedReader(inputStrReader);

            String out;
//            String errLine;

            while ((out = buffRdr.readLine()) != null) {
                System.out.println(out);
                if (out.startsWith("ERROR:") & out.contains("is not a valid URL")) {

                    YTDL.UI.listModel_output.addElement("Invalid URL or error connecting to internet.");
                    YTDL.UI.listModel_output.addElement("Please check the LINK or the internet connection and try again\n");
                    
                    if (YTDL.UI.listModel_queue.getSize() > 1) {
                        JOptionPane.showMessageDialog(null, link + "\nError \nProceeding to next item on queue", "Error downloading", JOptionPane.ERROR_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, link + "\nError downloading", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } else if (out.startsWith("[download] 100%")) {
                    YTDL.UI.listModel_output.addElement(out);
                    JOptionPane.showMessageDialog(null, link + "\nDownload completed.\nProceeding to next item on queue");

                } else {
                    YTDL.UI.listModel_output.addElement(out);
                }
            }
//            if (buffRdr.readLine() == null) {
//                System.out.println("NOTHING TO READ*********************************************");
//            }

            /*            while ((errLine = buffRdrErr.readLine()) != null) {
            System.out.println(errLine);
            YTDL.UI.listModel_output.addElement(errLine);
            if (errLine.startsWith("ERROR:") & errLine.contains("is not a valid URL")) {
            YTDL.UI.listModel_output.addElement("Invalid URL or error connecting to internet.");
            YTDL.UI.listModel_output.addElement("Please check the LINK or the internet connection and try again\n");
            
            } else {
            YTDL.UI.listModel_output.addElement(errLine);
            YTDL.UI.list_output.setModel(YTDL.UI.listModel_output);
            YTDL.UI.listModel_output.addElement("\nUnknown error occured.");
            YTDL.UI.listModel_output.addElement("Please report the error to sfthelp at gmail dot com");
            }
            
            }
             */
//            int waitForsubProcess = process.waitFor();
//            if(process.isAlive()){
//                process.waitFor();
//            }
//            if (process.isAlive()) {
//                System.out.println("********************PROCESS IS ALIVE");
//                System.out.println("*****************************PROCESS COMPLETED**************__11__" + process.waitFor());
//                if (process.waitFor() != 0) {
//                    process.destroyForcibly();
//                    System.out.println("*****************************PROCESS COMPLETED**************__22__" + process.waitFor());
//                }
//            }
            //setting buffReaderIsNull to true, to recognize that the process has completed.
            setBuffReaderNull(true);

            System.out.println("ending try catch");
            pBuilder = null;

        } catch (IOException | IllegalArgumentException ex) {
            Logger.getLogger(YoutubeDL.class.getName()).log(Level.SEVERE, null, ex);
            running = false;
        }
    }

}
