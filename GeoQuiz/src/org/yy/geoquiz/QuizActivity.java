package org.yy.geoquiz;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends ActionBarActivity {

	private static final String INDEX_KEY = "index";
	
	private Button trueButton;
	private Button falseButton;
	private Button nextButton;
	private Button previousButton;
	
	private TextView questionTextView;
	private TrueFalse[] questions = new TrueFalse[] {
			new TrueFalse(R.string.question_1, true),
			new TrueFalse(R.string.question_2, false),
			new TrueFalse(R.string.question_3, true)

	};
	private int currentIndex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(QuizActivity.class.getName(), "onCreate(Bundle) called");
		setContentView(R.layout.activity_quiz);
		trueButton = (Button) findViewById(R.id.true_button);
		trueButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				checkAnswer(true);

			}
		});
		falseButton = (Button) findViewById(R.id.false_button);
		falseButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				checkAnswer(false);

			}
		});

		nextButton = (Button) findViewById(R.id.next_button);
		nextButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				currentIndex = (currentIndex + 1) % questions.length;
				showQuestion();
			}
		});
		
		previousButton = (Button) findViewById(R.id.previous_button);
		previousButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				currentIndex = (questions.length + currentIndex - 1) % questions.length;
				showQuestion();
			}
		});
		
		questionTextView = (TextView) findViewById(R.id.question_text_view);
		if(savedInstanceState != null) {
			currentIndex = savedInstanceState.getInt(INDEX_KEY, 0);
		}
		showQuestion();
	}

	private void showQuestion() {
		questionTextView.setText(questions[currentIndex].getQuestion());
	}

	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		Log.d(QuizActivity.class.getName(), "onSaveInstanceState() called");
		outState.putInt(INDEX_KEY, currentIndex);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quiz, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void checkAnswer(boolean userAnswer) {
		int msg;
		if (userAnswer == questions[currentIndex].isTrueQuestion()) {
			msg = R.string.correct_toast;
		} else {
			msg = R.string.incorrect_toast;
		}
		Toast.makeText(QuizActivity.this, msg, Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d(QuizActivity.class.getName(), "onDestroy() called");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d(QuizActivity.class.getName(), "onStop() called");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d(QuizActivity.class.getName(), "onPause() called");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d(QuizActivity.class.getName(), "onResume() called");
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d(QuizActivity.class.getName(), "onStart called");
	}
	
	
}
