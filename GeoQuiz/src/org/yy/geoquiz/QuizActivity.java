package org.yy.geoquiz;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends ActionBarActivity {

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
		showQuestion();
	}

	private void showQuestion() {
		questionTextView.setText(questions[currentIndex].getQuestion());
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
}
