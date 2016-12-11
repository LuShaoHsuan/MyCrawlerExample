package crawler.example;

import com.github.abola.crawler.CrawlerPack;
import org.apache.commons.logging.impl.SimpleLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.github.abola.crawler.CrawlerPack;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSortedMap;

/**
 * 爬蟲包程式的全貌，就只有這固定的模式
 * 
 * @author Abola Lee
 *
 */
public class pttExam {
	// commit test
	public static void main(String[] args) {

		String uri = "https://www.ptt.cc/bbs/Gossiping/M.1481414061.A.1BD.html";

		Elements pushList =
				CrawlerPack.start()
						.addCookie("over18","1")
						.getFromHtml(uri)
						.select("div#main-content");

		for(Element push : pushList.select("div.push")){

			/*
			data sample
			<div class="push">
     			<span class="f1 hl push-tag">噓 </span>
     			<span class="f3 hl push-userid">rock123520</span>
     			<span class="f3 push-content">: DPP還敢說自己不是資進黨，真是「婊子還想立牌坊」</span>
     			<span class="push-ipdatetime">12/11 07:58 </span>
    		</div>
			*/

			String sign = push.select(" span:containsOwn(噓)").text();
			String content = push.select("span:containsOwn(噓)~span.f3.push-content").text();

			System.out.println(sign + " " + content );

			//System.out.println(content);
		}

		// set to debug level
		//CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_DEBUG);

		// turn off logging
		//CrawlerPack.setLoggerLevel(SimpleLog.LOG_LEVEL_OFF);

		// 遠端資料路徑


		//Elements newsList = CrawlerPack.start()
		//		.getFromHtml(uri)
		//		.select(".rtddt");

		/*
		System.out.println(
				CrawlerPack.start()

				// 參數設定
			    .addCookie("over18","1")	// 設定cookie
				//.setRemoteEncoding("big5")// 設定遠端資料文件編碼
				
				// 選擇資料格式 (三選一)
				//.getFromJson(uri)
			    .getFromHtml(uri)
			    //.getFromXml(uri)
			    
			    // 這兒開始是 Jsoup Document 物件操作
			    //.select(".css .selector ")
				//.select(".f3.push-content")
				//.select("div.push>span.f3.push-content")
				//.select("[class=push]")
			    .select("span:containsOwn(噓)~span.f3.push-content")
				// <div id="main-content" class="bbs-screen bbs-content">
		);
		*/
	}
}
