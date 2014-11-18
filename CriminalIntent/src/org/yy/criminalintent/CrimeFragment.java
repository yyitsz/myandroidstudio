package org.yy.criminalintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class CrimeFragment extends Fragment {
	private Crime crime;
	private EditText titleEditText;
	private Button dateButton;
	private CheckBox solvedCheckBox;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		crime = new Crime();
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_crime, container, false);
		titleEditText = (EditText) view.findViewById(R.id.crime_title);
		titleEditText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				crime.setTitle(s.toString());
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
		
		dateButton = (Button) view.findViewById(R.id.crime_date);
		dateButton.setText(crime.getDate().toString());
		dateButton.setEnabled(false);
		
		solvedCheckBox = (CheckBox) view.findViewById(R.id.crime_solved);	
		solvedCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				crime.setResolved(isChecked);				
			}
		});
		
		return view;
	}
	
	
}
