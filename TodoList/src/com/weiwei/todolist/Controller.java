package com.weiwei.todolist;

import com.weiwei.todolist.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<TodoItem> todoItems;
    @FXML private ListView<TodoItem> todoListView;
    @FXML private TextArea itemDetailsTextArea;
    @FXML private Label deadlineLabel;

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


        // add event listener to the click
        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem todoItem, TodoItem t1) {
                if(t1 != null){
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    deadlineLabel.setText(item.getDeadLine().toString());
                }
            }
        });

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();

    }

//    @FXML
//    public void handleClickListView(){
//        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
////        System.out.println(item.getDetails());
////        StringBuilder sb = new StringBuilder(item.getDetails());
////        sb.append("\n\n\n\n");
////        sb.append("Due: ");
////        sb.append(item.getDeadLine().toString());
//        itemDetailsTextArea.setText(item.getDetails());
//        deadlineLabel.setText(item.getDeadLine().toString());
//    }

    @FXML
    public void handleEnterKey(){
        String modifiedDetail = itemDetailsTextArea.getText();
        todoListView.getSelectionModel().getSelectedItem().setDetails(modifiedDetail);
    }
}
