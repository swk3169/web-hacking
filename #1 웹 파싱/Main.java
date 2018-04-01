import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main
{
	public static void main(String[] args) throws Exception 
	{
		String target = "http://www.president.go.kr/";
		HttpURLConnection con = (HttpURLConnection) new URL(target).openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		FileWriter fw = null;
		String temp;
		while((temp = br.readLine()) != null)
		{
			if(temp.contains("class=\"fullheight\""))
			{
				System.out.println(temp.split("rel=\"")[1].split("\"")[0]);
			}
		}
		con.disconnect();
		br.close();
	}
}