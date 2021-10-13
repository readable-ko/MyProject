package com.todo.menu;
public class Menu {

    public static void displaymenu()
    {
        System.out.println();
        System.out.println("<ToDoList 관리 명령어 사용법>");
        System.out.println("ADD - 항목 추가");
        System.out.println("DEL - 항목 삭제");
        System.out.println("EDIT - 항목 수정");
        System.out.println("ls - 전체 목록");
        System.out.println("ls_name - 오름차순 정렬");
        System.out.println("ls_name_desc - 내림차순 정렬");
        System.out.println("ls_date - 날짜순 정렬");
        System.out.println("ls_date_desc - 날짜역순 정렬");
        System.out.println("ls_cate - 카테고리순 정렬");
        System.out.println("ls_comp - 완료항목만 정렬");
        System.out.println("comp <키워드> - <키워드> 항목 완료 체크");
        System.out.println("find <키워드> - <키워드>를 포함하고 있는 항목을 출력");
        System.out.println("find_cate <키워드> - <키워드>를 포함하고 있는 카테고리를 출력");
        System.out.println("exit - 종료");
    }
    
    public static void prompt() {
    	System.out.print("\nCommand > ");
    }
}
