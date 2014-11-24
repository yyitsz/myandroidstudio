package org.yy.criminalintent;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CrimeListFragment extends ListFragment {
	private ArrayList<Crime> crimes;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.crimes_title);
		crimes = CrimeLab.get(getActivity()).getCrimes();
	}
	
	
}
