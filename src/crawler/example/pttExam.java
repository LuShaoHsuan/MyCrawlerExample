package crawler.example;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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

			String uid = push.select("span:containsOwn(噓)+span").text();
			String sign = push.select(" span:containsOwn(噓)").text();
			String content = push.select("span:containsOwn(噓)~span.f3.push-content").text();

			if(sign.equals("噓")) {
				System.out.println(uid + " " + sign + " " + content);
			}
			//System.out.println(content);
		}

	}
}
