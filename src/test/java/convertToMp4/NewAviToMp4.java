package convertToMp4;




import java.io.File;
import ws.schild.jave.AudioAttributes;
import ws.schild.jave.Encoder;
import ws.schild.jave.EncoderException;
import ws.schild.jave.VideoAttributes;
import ws.schild.jave.EncodingAttributes;
import ws.schild.jave.InputFormatException;
import ws.schild.jave.MultimediaObject;


public class NewAviToMp4 {
public  void AviToMp4(String type) {
//		File source = new File("C:\\shiping\\1.avi");
// File target = new File ( "C: \\ shiping \\ 2019-06-27333333 test .mp4");
	File source = new File("bla.avi");
	 
	File target = new File("target.mp4");
//	     logger.info ( "pre-conversion path:" + oldPath);
//	     logger.info ( "converted path:" + newPath);
	    AudioAttributes audio = new AudioAttributes(); 
		 audio.setCodec ( "libmp3lame"); // audio coding format
		audio.setBitRate(new Integer(800000));
		audio.setChannels(new Integer(1)); 
		//audio.setSamplingRate(new Integer(22050)); 
		VideoAttributes video = new VideoAttributes(); 
		 video.setCodec ( "libx264"); // video encoding format
		video.setBitRate(new Integer(3200000));
		 video.setFrameRate (new Integer (15)); // small digital set, the video will Caton
		EncodingAttributes attrs = new EncodingAttributes(); 
		attrs.setFormat("mp4");
		attrs.setAudioAttributes(audio); 
		attrs.setVideoAttributes(video); 
		Encoder encoder = new Encoder();  
		MultimediaObject multimediaObject = new MultimediaObject(source);
		try {
	//		 logger.info ( "avi conversion start switch MP4 ---:" + new Date ());
			encoder.encode(multimediaObject, target, attrs);
		//	 logger.info ( "avi switch MP4 --- End Conversion:" + new Date ());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InputFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncoderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}