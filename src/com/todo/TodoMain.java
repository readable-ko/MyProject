package com.todo;

import java.util.Scanner;

import com.todo.dao.TodoList;
import com.todo.menu.Menu;
import com.todo.service.TodoUtil;

public class TodoMain {
	
	public static void start() {
		
		Scanner sc = new Scanner(System.in);
		TodoList l = new TodoList();
		//l.importData("todolist.txt");
		boolean isList = false;
		boolean quit = false;
		//TodoUtil.loadList(l,"todolist.txt");
		
		Menu.displaymenu();
		do {
			Menu.prompt();
			isList = false;
			String choice = sc.next();
			switch (choice) {

			case "add":
				TodoUtil.createItem(l);
				break;
			
			case "del":
				TodoUtil.deleteItem(l);
				break;
				
			case "edit":
				TodoUtil.updateItem(l);
				break;
				
			case "ls":
				TodoUtil.listAll(l);
				break;

			case "ls_name":
				System.out.println("제목순으로 정렬하였습니다.");
				TodoUtil.listAll(l,"title", 1);
				break;

			case "ls_name_desc":
				System.out.println("제목역순으로 정렬하였습니다.");
				TodoUtil.listAll(l,"title", 0);
				break;
				
			case "ls_date":
				System.out.println("날짜순으로 정렬하였습니다.");
				TodoUtil.listAll(l,"due_date", 1);
				break;
				
			case "ls_date_desc":
				System.out.println("날짜역순으로 정렬하였습니다.");
				TodoUtil.listAll(l,"due_date", 0);
				break;
				
			case "ls_Dday":
				System.out.println("D-day순으로 정렬하였습니다.");
				TodoUtil.listDay(l,"remain_date",0);
				break;
				
			case "ls_Dday_desc":
				System.out.println("D-day역순으로 정렬하였습니다.");
				TodoUtil.listDay(l,"remain_date",1);
				break;
				
			case "ls_Month":
				System.out.println("달별로 출력하였습니다.");
				TodoUtil.listMonth(l);
				break;
				
			case "ls_cate":
				TodoUtil.listCateAll(l);
				break;
				
			case "ls_comp":
				TodoUtil.listAll(l, 1);
				break;
				
			case "comp":
				String str = sc.nextLine().trim();
				TodoUtil.completeItem(l, str);
				break;
				
			case "find":
				str = sc.nextLine().trim();
				TodoUtil.find(l, str);
				break;
				
			case "find_cate":
				str = sc.nextLine().trim();
				TodoUtil.findCateList(l, str);
				break;
				
			case "help":
				Menu.displaymenu();
				break;
				
			case "exit":
				quit = true;
				break;

			default:
				System.out.println("정확한 명령어를 입력하세요. (도움말 - help)");
				break;
			}
			
		} while (!quit);
	}
}
