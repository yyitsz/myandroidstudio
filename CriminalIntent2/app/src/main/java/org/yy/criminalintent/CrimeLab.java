package org.yy.criminalintent;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;

public class CrimeLab {
    private static CrimeLab crimeLab;
    private Context appContext;
    private ArrayList<Crime> crimes;

    public CrimeLab(Context appContext) {
        this.appContext = appContext;
        crimes = new ArrayList<Crime>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setResolved(i % 2 == 0);

            crimes.add(crime);
        }
    }

    public static CrimeLab get(Context ctx) {
        if (crimeLab == null) {
            crimeLab = new CrimeLab(ctx.getApplicationContext());
        }
        return crimeLab;
    }

    public Crime getCrime(UUID id) {
        for (Crime c : crimes) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Crime> getCrimes() {
        return crimes;
    }


}
