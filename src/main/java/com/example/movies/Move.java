package com.example.movies;

import java.io.Serializable;

public class Move implements Serializable{

	private String start;
	private String end;
	/**
	 * @return the end
	 */
	public String getEnd() {
		return end;
	}
	/**
	 * @param end the end to set
	 */
	public void setEnd(String end) {
		this.end = end;
	}
	/**
	 * @return the start
	 */
	public String getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(String start) {
		this.start = start;
	}
	public Move(String start, String end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public String toString() {
		return start+" "+end;
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof Move && o != null)
			return start.equals(((Move) o).getStart()) && end.equals(((Move) o).getEnd());
		return false;
	}
	
}
