package videoRecorder;


import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import com.xuggle.mediatool.IMediaReader;
import com.xuggle.mediatool.IMediaViewer;
import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.MediaListenerAdapter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.mediatool.event.IAddStreamEvent;
import com.xuggle.xuggler.IStreamCoder;
import convertToMp4.AviToMp4;
import convertToMp4.NewAviToMp4;

import io.cucumber.java.Scenario;
 
public class VideoRecorder {

    private static final String inputFilename = "C:\\Users\\admin\\eclipse-workspace\\Montescreen\\bla.avi";
    private static final String outputFilename = "C:\\Users\\admin\\eclipse-workspace\\Montescreen\\bla.mp4";
 
    private final String RECORD_DIRECTORY = "C:\\Users\\admin\\eclipse-workspace\\Montescreen\\Video";
 
    private ScreenRecorder screenRecorder;
 
    public void startRecording(WebDriver driver) {
 
        try {
            GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment().getDefaultScreenDevice()
                .getDefaultConfiguration();
 
            File dir = new File(RECORD_DIRECTORY);
 
            // записываем только область окна драйвера
            // для уменьшения размера видео файла
            Point point = driver.manage().window().getPosition();
            Dimension dimension = driver.manage().window().getSize();
 
            Rectangle rectangle = new Rectangle(point.x, point.y,
                dimension.width, dimension.height);
 
            this.screenRecorder = new ScreenRecorder(gc, rectangle, 
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, 
                    MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,
                    ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                    CompressorNameKey,
                    ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey,
                    24, FrameRateKey, Rational.valueOf(15), QualityKey,
                    1.0f, KeyFrameIntervalKey, 15 * 60), new Format(
                    MediaTypeKey, MediaType.VIDEO, EncodingKey,
                    "black", FrameRateKey, Rational.valueOf(30)), null,
                dir);
 
            this.screenRecorder.start();
 
        } catch (Exception e) {
            System.out.println(e);
        }
    }
 
    public void stopRecording(/*String recordName*/ Scenario scenario) {
 
        try {
            this.screenRecorder.stop();
 
            // переименовываем созданный .avi файл,
//            if (recordName != null) {
//                SimpleDateFormat dateFormat = new SimpleDateFormat(
//                    "yyyy-MM-dd HH.mm.ss");
//                File newFileName = new File(String.format("%s%s %s.avi",
//                    RECORD_DIRECTORY, recordName,
//                    dateFormat.format(new Date())));
            	File newFileName=new File("black.avi");
            	NewAviToMp4 converter= new NewAviToMp4();
            	converter.AviToMp4(RECORD_DIRECTORY);
            	
            	File newFileName1=new File("target.mp4");

	    		  byte[] bytes = FileUtils.readFileToByteArray(newFileName1);
	    		  if(scenario.isFailed())
	    		  scenario.attach(bytes, "video/mp4", "zip_video_file");
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
 
}