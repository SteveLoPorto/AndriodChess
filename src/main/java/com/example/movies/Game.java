package com.example.movies;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Game implements Serializable, Comparable{

	private String name;
	private Date date;
	private String winner;
	ArrayList<Move> moves;

	public Game(String name, Date date, ArrayList<Move> moves) {
		this.name=name;
		this.date=date;
		this.moves = moves;
		winner=null;
	}
	
	public Game() {
		moves=new ArrayList<Move>();
		winner=null;
	}

	public void setName(String name){
		this.name=name;
	}
	public void setDate(){
		date = new Date();
	}

	public Date getDate(){
		return date;
	}

	public ArrayList<Move> getMoves(){
		return moves;
	}
	
	public void addMove(Move m) {
		moves.add(m);
	}
	
	public void undo() {
		moves.remove(moves.size()-1);
	}

	@Override
	public int compareTo(Object o) {
		return date.compareTo(((Game)o).getDate());
	}

	public String toString(){
		return name+" "+date;
	}
}
