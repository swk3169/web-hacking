import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class main
{
	public static void main(String[] args) throws Exception {
		
		String memberID = "swk";
		String memberPassword = "test";
		String target = "http://dowellcomputer.com/member/memberLoginAction.jsp?memberID=" + memberID + "&memberPassword=" + memberPassword;
		HttpURLConnection con = (HttpURLConnection) new URL(target).openConnection();
		String cookie = "";
		String temp = con.getHeaderField("Set-Cookie");
		if(temp != null)
		{
			cookie = temp;
		}
		System.out.println("현재 당신의 세션은 : " + cookie + "입니다.");
		con = (HttpURLConnection) new URL("http://dowellcomputer.com/member/memberUpdateForm.jsp?ID=" + memberID).openConnection();
		con.setRequestProperty("Cookie", cookie);
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		while((temp = br.readLine()) != null)
		{
			if(temp.contains("value=\"") && temp.contains("memberNickname"))
			{
				System.out.println("해당 사용자의 아이디 : " + temp.split("value=\"")[1].split("\">")[0]);
			}
			if(temp.contains("value=\"") && temp.contains("memberPassword"))
			{
				System.out.println("해당 사용자의 비밀번호 : " + temp.split("value=\"")[1].split("\">")[0]);
			}
			if(temp.contains("value=\"") && temp.contains("memberEmail"))
			{
				System.out.println("해당 사용자의 이메일 : " + temp.split("value=\"")[1].split("\">")[0]);
			}
		}
		con.disconnect();
		br.close();
	}
}
