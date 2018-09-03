package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Person;

public class PersonView {

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public PersonView(){
        personList.add(new Person("asdf1","aaa","aaa","aaa","aaa","aaa"));
        personList.add(new Person("asdf2","bbb","bbb","bbb","bbb","bbb"));
        personList.add(new Person("asdf3","ccc","ccc","ccc","ccc","ccc"));
        personList.add(new Person("asdf4","ddd","ddd","ddd","ddd","ddd"));
        personList.add(new Person("asdf5","eee","eee","eee","eee","eee"));
        personList.add(new Person("asdf6","fff","fff","fff","fff","fff"));
        personList.add(new Person("asdf7","ggg","ggg","ggg","ggg","ggg"));
        personList.add(new Person("asdf8","hhh","hhh","hhh","hhh","hhh"));

    }
}
