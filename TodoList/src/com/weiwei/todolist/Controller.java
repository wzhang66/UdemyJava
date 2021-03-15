package com.weiwei.todolist;

import com.weiwei.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<TodoItem> todoItems;
    @FXML private ListView todoListView;

    public void initialize(){
        TodoItem item1 = new TodoItem("Shopping", "Go to shoppers", LocalDate.of(2021, Month.MARCH, 15));
        TodoItem item2 = new TodoItem("working", "Go to work", LocalDate.of(2021, Month.MARCH, 15));
        TodoItem item3 = new TodoItem("orthodontics", "Go to Hamilton", LocalDate.of(2021, Month.MARCH, 18));
        TodoItem item4 = new TodoItem("Sleep", "Go to bed", LocalDate.of(2021, Month.MARCH, 14));
        TodoItem item5 = new TodoItem("Laundry", "Go to wash cloth", LocalDate.of(2021, Month.MARCH, 14));
        todoItems = new ArrayList<TodoItem>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
}
