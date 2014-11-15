package org.yy.geoquiz;

public class TrueFalse {
	private int question;
	private boolean trueQuestion;
	public int getQuestion() {
		return question;
	}
	public void setQuestion(int question) {
		this.question = question;
	}
	public boolean isTrueQuestion() {
		return trueQuestion;
	}
	public void setTrueQuestion(boolean trueQuestion) {
		this.trueQuestion = trueQuestion;
	}
	public TrueFalse(int question, boolean trueQuestion) {
		super();
		this.question = question;
		this.trueQuestion = trueQuestion;
	}
	
	
}
