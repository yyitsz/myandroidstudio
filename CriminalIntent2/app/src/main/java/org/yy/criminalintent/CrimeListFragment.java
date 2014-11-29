package org.yy.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CrimeListFragment extends ListFragment {
    private ArrayList<Crime> crimes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crimes_title);
        crimes = CrimeLab.get(getActivity()).getCrimes();
        // ArrayAdapter<Crime> adapter = new ArrayAdapter<Crime>(getActivity(), android.R.layout.simple_list_item_1, crimes);
        CrimeAdapter adapter = new CrimeAdapter(crimes);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //Crime crime = (Crime) getListAdapter().getItem(position);
        Crime crime = ((CrimeAdapter) getListAdapter()).getItem(position);
        // Log.d(CrimeListFragment.class.getName(), crime.getTitle() + " was clicked.");
//        Intent i = new Intent(getActivity(), CrimeActivity.class);

        Intent i = new Intent(getActivity(), CrimePagerActivity.class);

        i.putExtra(CrimeFragment.EXTRA_CRIME_ID, crime.getId());
        startActivity(i);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((CrimeAdapter) getListAdapter()).notifyDataSetChanged();
    }

    private class CrimeAdapter extends ArrayAdapter<Crime> {
        public CrimeAdapter(List<Crime> crimes) {
            super(getActivity(), 0, crimes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime, null);
            }
            Crime c = getItem(position);
            TextView titleView = (TextView) convertView.findViewById(R.id.crime_list_item_titleTextView);
            titleView.setText(c.getTitle());
            TextView dateView = (TextView) convertView.findViewById(R.id.crime_list_item_dateTextView);
            dateView.setText(DateFormat.getMediumDateFormat(getActivity()).format(c.getDate()));
            CheckBox cbView = (CheckBox) convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
            cbView.setChecked(c.isResolved());
            return convertView;
        }
    }
}
