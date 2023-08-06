

public class Discussions {
	private String title;
	private String content;
	private String user;
	private String postDate;

	public Discussions(String t, String a) {
		title = t;
		user = a;
	}
	public String getUser() {
		return user;
	}
	public String getTitle() {
		return title;
	}
	public String getpostDate() {
		return postDate;
	}
	public void display() {
		System.out.println("Title: " + title);
		System.out.println("Discussion: " + content);
	}
}