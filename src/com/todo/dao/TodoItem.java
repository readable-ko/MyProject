package com.todo.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public class TodoItem {
	private int ID;
	private int is_completed;
    private String title;
    private String desc;
    private String current_date;
    private String category;
    private String due_date;
    private int remain_date;
    private String todo_month;

    public TodoItem(String title, String desc, String categori, String due_date, int ID, String current_date, int is_completed){
        this.title=title;
        this.category = categori;
        this.desc=desc;
        this.due_date = due_date;
        
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        
        this.ID = ID;
        this.is_completed = is_completed;
        this.current_date = current_date;
        //this.remain_date = calDateRemain(due_date);
        
    }
    
    public int calDateRemain(String due_date) {
    	SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
        String today = f.format(new Date());
        Date now;
        Date Due;
        long calDate = 0;
        
		try {
			now = f.parse(today);
			Due = f.parse(due_date);
			calDate = (Due.getTime() - now.getTime()) / (24*60*60*1000);

	        //calDate = Math.abs(calDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return (int)calDate;
		/*
		if(calDate > 0.0)
			return "D-" + Integer.toString((int) calDate);
		else
			return "D+" + Integer.toString((int) Math.abs(calDate));*/
    }
    
    public TodoItem(String title, String desc, String categori, String due_date, int ID, String current_date){
        this.title=title;
        this.category = categori;
        this.desc=desc;
        this.due_date = due_date;
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
        this.ID = ID;
        this.is_completed = 0;
        this.current_date= current_date;
    }
    
    public TodoItem(String title, String desc, String categori, String due_date){
        this.title=title;
        this.category = categori;
        this.desc=desc;
        this.due_date = due_date;
        this.is_completed = 0;
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
        this.current_date=f.format(new Date());
    }

	public TodoItem(StringTokenizer st) {
		this.title = st.nextToken();
		this.category = st.nextToken();
		this.desc = st.nextToken();
		this.due_date = st.nextToken();
		this.current_date = st.nextToken();
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCurrent_date() {
        return current_date;
    }

    public void setCurrent_date(String current_date) {
    	this.current_date = current_date;
    }
    
    public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	@Override
    public String toString() {
		String completed = "";
		if(is_completed == 1) 
			completed = "[V]";
		
		String Dday = "[D";
		if(remain_date > 0) Dday += "-" + remain_date + "]";
		else if(remain_date == 0) Dday += "-the day]";
		else Dday += "+" + Math.abs(remain_date) + "]";
		
    	return ID + ". " + "[" + category + "] " + title + completed + " - " + desc + " - " + due_date + Dday + " - " + current_date;
    }
    
    public String toSaveString() {
    	return title + "##" + category + "##" + desc + "##" + due_date + "##" + current_date + "\n";
    }

	public int getID() {
		return ID;
	}

	public void setId(int ID) {
		this.ID = ID;
	}

	public int getIs_completed() {
		return is_completed;
	}

	public void setIs_completed(int is_completed) {
		this.is_completed = is_completed;
	}

	public int getRemain_date() {
		return remain_date;
	}

	public void setRemain_date(String due_date) {
		
		this.remain_date = calDateRemain(due_date);
        
	}

	public String getTodo_month() {
		return todo_month;
	}

	public void setTodo_month(String todo_month) {
		this.todo_month = todo_month;
	}
}