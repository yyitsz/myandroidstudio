package org.yy.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {
	private UUID id;
	private String title;
	private Date date;
	private boolean isResolved;
	
	
	public Crime() {
		id = UUID.randomUUID();
		date = new Date();
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isResolved() {
		return isResolved;
	}
	public void setResolved(boolean isResolved) {
		this.isResolved = isResolved;
	}

    @Override
    public String toString() {
        return  title;
    }
}
