package poll.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="poll")
public class Poll {
	private int pollid;
	private String pollname;
	private String pollcreatedby;
	private String question;
	private String category;
	private String option1;
	private String option2;
	
	public Poll(int pollid, String pollname, String pollcreatedby, String question, String category, String option1,
			String option2) {
		super();
		this.pollid = pollid;
		this.pollname = pollname;
		this.pollcreatedby = pollcreatedby;
		this.question = question;
		this.category = category;
		this.option1 = option1;
		this.option2 = option2;
	}

	public int getPollid() {
		return pollid;
	}

	public void setPollid(int id) {
		this.pollid = pollid;
	}

	public String getPollname() {
		return pollname;
	}

	public void setPollname(String pollname) {
		this.pollname = pollname;
	}

	public String getPollcreatedby() {
		return pollcreatedby;
	}

	public void setPollcreatedby(String pollcreatedby) {
		this.pollcreatedby = pollcreatedby;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}
	
	
}