package com.qa.base;
import io.appium.java_client.screenrecording.CanRecordScreen;
import org.apache.commons.codec.binary.Base64;
import java.io.File;
import java.io.FileOutputStream;

public class TestBase extends BasePage {
    public void waitFor3Seconds(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startRecording() {
        ((CanRecordScreen) driver).startRecordingScreen();
    }

    public void stopRecording(String scenarioName) {
        String media = ((CanRecordScreen) driver).stopRecordingScreen();
        String dirPath = "screenshots";
        File videoDir = new File(dirPath);

        synchronized (videoDir) {
            if (!videoDir.exists()) {
                videoDir.mkdirs();
            }
        }

        try (FileOutputStream stream = new FileOutputStream(videoDir + File.separator + scenarioName + ".mp4")) {
            stream.write(Base64.decodeBase64(media));
        } catch (Exception e) {
        }
    }









}
