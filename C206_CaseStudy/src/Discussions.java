import java.util.ArrayList;

public class Discussions {
	
	private String title;
	private String content;
	private String username;
	private String postDate;
	private boolean deleted;

	public Discussions(String title, String content, String postDate, String username) {
		this.title = title;
		this.username = username;
		this.content = content;
		this.postDate = postDate; 
	}
	
	
	
	public String getUsername() {
		return username;
	}
	public String getTitle() {
		return title;
	}
	public String getpostDate() {
		return postDate;
	}
	
	public String getContent() {
		return content;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void display() {
		System.out.println("Title: " + title);
		System.out.println("Discussion: " + content);
	}
	
	public boolean getDeleted() {
		return deleted;
	}
	public void setIsDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	public static final String shorten(String text, int length) {
	    if (text.length() >= length) {
	      return text.substring(0, length) + "...";
	    }
	    return text;
	  }
	
	public static void viewAllDiscussions(ArrayList<Discussions> discussionList) {
		Helper.line(82, "-");
		System.out.println("------------------------------ All Discussions -----------------------------------");
		Helper.line(82, "-");
		System.out.println();
		System.out.printf("%-20s %-22s %-15s %-15s\n", "TITLE", "CONTENT", "POST DATE", "BY");
		Helper.line(82, "=");
		
		for (Discussions d : discussionList) {
			System.out.printf("%-20s %-22s %-15s %-15s\n", d.getTitle(), shorten(d.getContent(), 10), d.getpostDate(), d.getUsername());
		}
		
	}
	

	public static void deleteDiscussion(ArrayList<Discussions> discussionList, String username) {
		
		Helper.line(80, "-");
		System.out.println("------------------------------ Delete Discussions ------------------------------");
		Helper.line(80, "-");
		System.out.printf("%-20s %-22s %-15s %-15s\n", "TITLE", "CONTENT", "POST DATE", "BY");
		
		for (int d = 0; d < discussionList.size(); d++) {
			if (username.equals(discussionList.get(d).getUsername())) {
				System.out.printf("%-20s %-22s %-15s %-15s\n", discussionList.get(d).getTitle(), shorten(discussionList.get(d).getContent(), 10), discussionList.get(d).getpostDate(), discussionList.get(d).getUsername());
				System.out.println();
				String title = Helper.readString("Enter the title of the discussion to be deleted > ");
				if (title.equals(discussionList.get(d).getTitle())) {
					char delete = Helper.readChar("Are you sure you want to delete the discussion enter? (Y/N) > ");
					if (delete == 'Y' || delete == 'y') {
						discussionList.remove(discussionList.get(d));
						System.out.println("Discussion Successfully deleted!");
					}
					
					else {
						System.out.println("Discussion not deleted");
					}
				}
			}
		}
	}
	
	public static void addDiscussion(ArrayList<Discussions> discussionList) {
	    Helper.line(80, "-");
	    System.out.println("----------------------------- Add Discussion -----------------------------");
	    Helper.line(80, "-");

	    String title = Helper.readString("Enter discussion title: ");
	    String content = Helper.readString("Enter discussion content: ");
	    String postDate = Helper.readString("Enter post date: ");
	    String username = Helper.readString("Enter username: ");

	    if (title.isEmpty() || content.isEmpty()) {
	        System.out.println("Discussion not added - title and content cannot be empty.");
	    } else {
	        Discussions newDiscussion = new Discussions(title, content, postDate, username);
	        discussionList.add(newDiscussion);
	        System.out.println("Discussion Successfully Added!");
	    }
	}
}
	
