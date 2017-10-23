package com.ntc.gaia.voice;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.log4j.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import com.iflytek.cloud.speech.ErrorCode;
import com.iflytek.cloud.speech.GrammarListener;
import com.iflytek.cloud.speech.RecognizerListener;
import com.iflytek.cloud.speech.RecognizerResult;
import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechRecognizer;
import com.iflytek.cloud.speech.SpeechSynthesizer;
import com.iflytek.cloud.speech.SpeechUtility;
import com.iflytek.cloud.speech.SynthesizerListener;

/**
 * 
 * @author William
 * @date 2017/09/29
 * 
 */
public class VoiceSpeechView extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	protected static Logger log = Logger.getLogger(VoiceSpeechView.class);

	private JButton jbtnRecognizer;
	private JLabel labelWav;
	// 语音服务端返回的语法id
	private String grammarId = null;
	// 语音识别器
	private SpeechRecognizer mAsr = null;
	// 语音合成器
	private SpeechSynthesizer mTts = null;
	// 语法规则
	private final static String grammar = "#ABNF 1.0 UTF-8;\nlanguage zh-CN;\nmode voice;\nroot $main;\n$main = 车辆$place1;\n$place1=浙EC6505|浙EC6888|浙EC7856;";
	// 服务器地址
	private String serverAddress="";
	
	public VoiceSpeechView() {

		getServerAddress();
		log.info("服务器地址:"+serverAddress);
		SpeechUtility.createUtility("appid=59c08329");
		mTts = SpeechSynthesizer.createSynthesizer();
		mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");// 设置发音人
		mTts.setParameter(SpeechConstant.SPEED, "50");// 设置语速
		mTts.setParameter(SpeechConstant.VOLUME, "80");// 设置音量，范围0~100

		mAsr = SpeechRecognizer.createRecognizer();
		uploadGrammar();
		ImageIcon img = new ImageIcon("res/mic_01.png");
		labelWav = new JLabel(img);
		labelWav.setBounds(0, 0, img.getIconWidth(),
				img.getIconHeight() * 4 / 5);
		jbtnRecognizer = addButton("res/button.png", "开始识别", 0, 320, 330, -1,
				"res/button");
		jbtnRecognizer.add(labelWav, BorderLayout.WEST);
		jbtnRecognizer.setEnabled(true);
		jbtnRecognizer.addActionListener(this);
		add(jbtnRecognizer);
		setSize(600, 200);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == jbtnRecognizer) {

			if (grammarId != null) {
				mAsr.setParameter(SpeechConstant.RESULT_TYPE, "json");
				mAsr.setParameter(SpeechConstant.ASR_AUDIO_PATH,
						"./asr_test.pcm");
				mAsr.setParameter(SpeechConstant.CLOUD_GRAMMAR, grammarId);
				if (!mAsr.isListening())
					mAsr.startListening(recognizerListener);
				else {
					mAsr.stopListening();
				}
			}
			

		}
	}

	public void uploadGrammar() {

		mAsr.setParameter(SpeechConstant.ENGINE_TYPE, "cloud");
		mAsr.setParameter(SpeechConstant.TEXT_ENCODING, "utf-8");
		int ret = mAsr.buildGrammar("abnf", grammar, grammarListener);
		if (ret != ErrorCode.SUCCESS) {
			log.info("司机语法构建失败," + ret);
		}
		
	}

	public void getServerAddress(){
		
		try {  
            FileInputStream in = new FileInputStream("./url.txt");  
            InputStreamReader inReader = new InputStreamReader(in, "UTF-8");  
            BufferedReader bufReader = new BufferedReader(inReader);  
            String line = bufReader.readLine();  
            if(null!=line&&(!"".equals(line))){
            	serverAddress=line.trim();
            }
            bufReader.close();  
            inReader.close();  
            in.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
            log.info("读取" + "./url.txt" + "出错！");  
        }  
	}
	
	/**
	 * 构建语法监听器
	 */
	private GrammarListener grammarListener = new GrammarListener() {

		public void onBuildFinish(String mgrammarId, SpeechError error) {
			if (error == null) {
				grammarId = mgrammarId;
				log.info("语法构建成功，语法id：" + grammarId);
			} else {
				log.info("司机语法构建失败," + error.getErrorDescription(true));
			}
		}
	};

	private void handling(String text) {

		log.info("语音识别结果:"+text);
		
		if ("".equals(text) || null == text) {

			System.out.println();

			return;
		}

		String result = "";

		if (text.startsWith("车辆")) {

			String param = formatParam(text.substring(2));

			try {

				param = URLEncoder.encode(param, "UTF-8");

			} catch (UnsupportedEncodingException e) {

				log.info(e.getStackTrace());

				e.printStackTrace();
			}

			param = "licenseplate=" + param;

			param = "?" + param;

			log.info("http request:"+serverAddress + param);
			
			result = HttpUtil.getJsonByInternet(serverAddress + param);
			
			log.info("http response:"+result);

			if (null == result) {

				log.info("连接服务器异常,请确认"+serverAddress+"是否可用");

				return;
			}

			try {

				JSONTokener tokener = new JSONTokener(result);
				JSONObject joResult;

				joResult = new JSONObject(tokener);

				String res = joResult.getString("result");

				if ("success".equals(res)) {

					JSONObject data = joResult.getJSONObject("data");

					String licensePlate = data.getString("licensePlate");

					String carType = data.getString("carType");

					String carDesc = data.getString("carDesc");

					String gpsTime = data.getString("gpsTime");

					String carStatus = data.getString("carStatus");

					String curSpeed = data.getString("curSpeed");

					String curDrivingKMs = data.getString("curDrivingKMs");

					String curdrivingTime = data.getString("curdrivingTime");

					String curdrivingHours = data.getString("curdrivingHours");

					String averageSpeed = data.getString("averageSpeed");

					String maxSpeed = data.getString("maxSpeed");

					String powerStorage = data.getString("powerStorage");

					JSONObject bnormalAlarm = data
							.getJSONObject("bnormalAlarm");

					int fastLane = bnormalAlarm.getInt("fastLane");

					int fastBrake = bnormalAlarm.getInt("fastBrake");

					int sharpTurn = bnormalAlarm.getInt("sharpTurn");

					int exceedSpeed = bnormalAlarm.getInt("exceedSpeed");

					int malfunction = bnormalAlarm.getInt("malfunction");

					int accident = bnormalAlarm.getInt("accident");

					JSONObject driver = data.getJSONObject("driver");

					String name = driver.getString("name");

					String cellPhone = driver.getString("cellPhone");

					String say=licensePlate+"  "+carStatus+"  "+"行驶时长"+curdrivingHours+"   最高车速"+maxSpeed+"千米每小时";
					
					if(fastLane==0&&fastBrake==0&&sharpTurn==0&&exceedSpeed==0&&malfunction==0&&accident==0){
						
						say=say+"  无异常";
						
					}else{
						
						if(fastLane!=0){
							
							say=say+"  快速变道"+fastLane+"次";
						}
						
						if(fastBrake!=0){
							
							say=say+"  急刹车"+fastBrake+"次";
						}
						
						if(sharpTurn!=0){
							
							say=say+"  急转弯"+sharpTurn+"次";
						}
						
						if(exceedSpeed!=0){
							
							say=say+"  超速"+exceedSpeed+"次";
						}
						if(malfunction!=0){
							
							say=say+"  故障"+malfunction+"次";
						}
						
						if(accident!=0){
							
							say=say+"  事故"+accident+"次";
						}
					}
					
					log.info("语音播报："+say);
					
					mTts.startSpeaking(say, mSynListener);
				}

				if ("fail".equals(res)) {

					String msg = joResult.getString("msg");
					
					log.info("语音播报："+msg);

					mTts.startSpeaking(msg, mSynListener);

				}

			} catch (JSONException e) {
				
				log.info(e.getStackTrace());
				
				e.printStackTrace();
			}

		}else{
			
			String say="语音输入错误，请遵循语法规则，例如说出车辆浙EC6505，系统将查询出车辆浙EC6505的相关信息";
			
			log.info("语音播报："+say);
			
			mTts.startSpeaking(say, mSynListener);
		}
	}

	/**
	 * @description 去除接口返回回来的字符串中的空格
	 * @param param
	 * @return
	 */
	private String formatParam(String param) {

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < param.length(); i++) {

			String temp = param.substring(i, i + 1);
			if (!" ".equals(temp)) {
				sb.append(temp);
			}

		}

		return sb.toString();
	}

	private RecognizerListener recognizerListener = new RecognizerListener() {

		/**
		 * 获取识别结果. 获取RecognizerResult类型的识别结果，并对结果进行累加，显示到Area里
		 */

		public void onResult(RecognizerResult results, boolean islast) {

			String text = JsonParser.parseResult(results.getResultString());

			handling(text);

			if (islast) {
				((JLabel) jbtnRecognizer.getComponent(0)).setText("开始识别");
			}

		}

		public void onVolumeChanged(int volume) {
			if (volume == 0)
				volume = 1;
			else if (volume >= 6)
				volume = 6;
			labelWav.setIcon(new ImageIcon("res/mic_0" + volume + ".png"));
		}

		public void onError(SpeechError error) {

			if (null != error) {
				System.out.println("onError Code：" + error.getErrorDesc());
				System.out.println(error.getErrorDescription(true));
			}

		}

		public void onEvent(int eventType, int arg1, int agr2, String msg) {

		}

		public void onBeginOfSpeech() {
			((JLabel) jbtnRecognizer.getComponent(0)).setText("请说话...");
		}

		public void onEndOfSpeech() {
			((JLabel) jbtnRecognizer.getComponent(0)).setText("等待结果");
		}
	};

	public JButton addButton(String imgName, String btnName, int x, int y,
			int imgWidth, int imgHeight, String iconPath) {

		JButton btn = null;
		ImageIcon img = new ImageIcon(imgName);
		btn = DrawableUtils.createImageButton(btnName, img, "center");
		int width = imgWidth, height = imgHeight;
		if (width == 1)
			width = img.getIconWidth();
		else if (width == -1)
			width = img.getIconHeight() * 4 / 5;

		if (height == 1)
			height = img.getIconWidth();
		else if (height == -1)
			height = img.getIconHeight() * 4 / 5;

		btn.setBounds(x, y, width, height);

		DrawableUtils.setMouseListener(btn, iconPath);

		return btn;
	}

	// 合成监听器
	private SynthesizerListener mSynListener = new SynthesizerListener() {
		// 会话结束回调接口，没有错误时，error为null
		public void onCompleted(SpeechError error) {
		}

		// 缓冲进度回调
		// percent为缓冲进度0~100，beginPos为缓冲音频在文本中开始位置，endPos表示缓冲音频在文本中结束位置，info为附加信息。
		public void onBufferProgress(int percent, int beginPos, int endPos,
				String info) {
		}

		// 开始播放
		public void onSpeakBegin() {
		}

		// 暂停播放
		public void onSpeakPaused() {
		}

		// 播放进度回调
		// percent为播放进度0~100,beginPos为播放音频在文本中开始位置，endPos表示播放音频在文本中结束位置.
		public void onSpeakProgress(int percent, int beginPos, int endPos) {
		}

		// 恢复播放回调接口
		public void onSpeakResumed() {
		}

		public void onEvent(int arg0, int arg1, int arg2, int arg3,
				Object arg4, Object arg5) {
			// TODO Auto-generated method stub

		}
	};

}
