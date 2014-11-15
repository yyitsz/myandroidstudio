package org.yy.geoquiz;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
public class CheatActivity extends ActionBarActivity {
	
	public static final String ANSWER_SHOWN_RESULT_KEY = "org.yy.geoquiz.answershownresult";
	private boolean answer;
	private TextView answerTextView;
	private Button showAnswerButton;
	private boolean shownResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cheat);
		
		
		answer = getIntent().getBooleanExtra(QuizActivity.EXTRA_ANSWER_KEY, false);
		
		answerTextView = (TextView) findViewById(R.id.answer_text_view);
		showAnswerButton = (Button) findViewById(R.id.show_answer_button);
		showAnswerButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(answer){
					answerTextView.setText(R.string.true_button);
				} else {
					answerTextView.setText(R.string.false_button);
				}
				shownResult = true;
				setAnswerShownResult(shownResult);
			}
		});
		shownResult = false;
		if(savedInstanceState != null) {
			shownResult = savedInstanceState.getBoolean(ANSWER_SHOWN_RESULT_KEY, false);
		} 
		setAnswerShownResult(shownResult);
	}

	private void setAnswerShownResult(boolean answerIsShown) {
		Intent i = new Intent();
		i.putExtra(ANSWER_SHOWN_RESULT_KEY, answerIsShown);
		setResult(RESULT_OK, i);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putBoolean(ANSWER_SHOWN_RESULT_KEY, shownResult);
	}
	
	
}
