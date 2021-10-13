package com.todo.service;

import java.util.Comparator;

import com.todo.dao.TodoItem;

public class TodoSortByDateDesc implements Comparator<TodoItem> {

	@Override
	public int compare(TodoItem o1, TodoItem o2) {
		return o2.getCurrent_date().compareTo(o1.getCurrent_date());
	}

}
