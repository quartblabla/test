package convertToMp4;




import java.io.File;
import ws.schild.jave.VideoAttributes;
import ws.schild.jave.VideoAttributes.X264_PROFILE;
import ws.schild.jave.VideoSize;
import ws.schild.jave.AudioAttributes;
import ws.schild.jave.EncodingAttributes;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.Encoder;


public class AviToMp4 {
public void videoConverter() {
	
	
	File source = new File("bla.avi");
	MultimediaObject multimediaObject= new MultimediaObject(source); 
	File target = new File("target.mp4");

	/* Step 2. Set Audio Attrributes for conversion*/
	AudioAttributes audio = new AudioAttributes();
//	
	audio.setCodec("aac");
//	// here 64kbit/s is 64000
	audio.setBitRate(64000);
	audio.setChannels(2);
	audio.setSamplingRate(44100);

	/* Step 3. Set Video Attributes for conversion*/
	VideoAttributes video = new VideoAttributes();
	
	
	video.setCodec("h264");
	video.setX264Profile(X264_PROFILE.BASELINE);
	// Here 160 kbps video is 160000
	video.setBitRate(160000);
	// More the frames more quality and size, but keep it low based on devices like mobile
	
	video.setFrameRate(15);
	video.setSize(new VideoSize(400, 300));

	/* Step 4. Set Encoding Attributes*/
	EncodingAttributes attrs = new EncodingAttributes();
	
	attrs.setFormat("mp4");
	attrs.setAudioAttributes(audio);
	attrs.setVideoAttributes(video);
	Encoder encoder = new Encoder();

	/* Step 5. Do the Encoding*/
	try {
	  
	  
	  encoder.encode(multimediaObject, target, attrs);
	} catch (Exception e) {
	  /*Handle here the video failure*/ 
	  e.printStackTrace();
	}
}
}
