/*
JavaFX program that displays a calendar for a month. The program reads the number of
the month and the year using a dialog input textbox in JavaFX. Displays in Red color the date
number, if it is the current date number at the time of displaying the Calendar.

Note: Because I had a problem with displaying the dates as shown in the Homework 2 file, I did an alternative solution.
The days names above the dates are changing depending what day is the first day of the month
 */

package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Main extends Application {

    // fields that are accessible to all methods of this class
    private TextInputDialog firstDlg;
    private TextInputDialog secondDlg;
    private Alert errorDlg;
    private int inputMonth;
    private int inputYear;
    private Group root = new Group();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd"); //
    private DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("E");

    //method that sets the input windows
    private void readInput(){

        //first dialog
        firstDlg.setTitle("Input data");
        firstDlg.setContentText("Enter Month: ");
        firstDlg.setHeaderText(null); // null is optional, we can add header if we need to
        inputMonth = Integer.parseInt((firstDlg.showAndWait().get()));

        //second dialog
        secondDlg.setTitle("Input data");
        secondDlg.setContentText("Enter Year: ");
        secondDlg.setHeaderText(null); // null is optional, we can add header if we need to
        inputYear = Integer.parseInt((secondDlg.showAndWait().get()));
    }

    //method that sets the alert dialog
    private  void showAlert() {
        errorDlg.setTitle("Input error");
        errorDlg.setHeaderText("Wrong input");
        errorDlg.setContentText(null);
        errorDlg.showAndWait();
    }

    //method that checks the first day of the week and the outputs the arranged day names
    private void  calenderWeek(LocalDate yearHelper) {

        if(yearHelper.format(dayFormatter).equals("Mon")) {

            Text week = new Text(0, 10, "MON  TUE  WEN  THU    FRI     SAT    SUN");
            root.getChildren().addAll(week);

        } else if (yearHelper.format(dayFormatter).equals("Tue") ) {

            Text week = new Text(0, 10, "TUE  WEN  THU    FRI     SAT    SUN  MON");
            root.getChildren().addAll(week);

        } else if (yearHelper.format(dayFormatter).equals("Wen") ) {

            Text week = new Text(0, 10, "WEN  THU    FRI     SAT    SUN  MON   TUE");
            root.getChildren().addAll(week);

        }else if (yearHelper.format(dayFormatter).equals("Thu") ) {

            Text week = new Text(0, 10, "THU    FRI     SAT    SUN  MON   TUE  WEN");
            root.getChildren().addAll(week);

        } else if (yearHelper.format(dayFormatter).equals("Fri") ) {

            Text week = new Text(0, 10, "FRI     SAT    SUN  MON   TUE  WEN  THU ");
            root.getChildren().addAll(week);

        } else if (yearHelper.format(dayFormatter).equals("Sat") ) {

            Text week = new Text(0, 10, " SAT    SUN    MON   TUE  WEN  THU    FRI ");
            root.getChildren().addAll(week);

        } else if (yearHelper.format(dayFormatter).equals("Sun") ) {

            Text week = new Text(0, 10, "SUN  MON  TUE  WEN  THU    FRI     SAT ");
            root.getChildren().addAll(week);
        }
    }

    //method that displays the calendar days
    private void calenderDays(){
        Month month = Month.of(inputMonth);
        LocalDate yearHelper = LocalDate.of(inputYear, month,1); //gets the first day of the month
        LocalDate currentDate = LocalDate.now();
        Text dates;

        //helper variables that move the dates in the scene
        int mover = 0;
        int mover2 = 0;
        int mover3 = 0;
        int mover4 = 0;
        int mover5 = 0;

        calenderWeek(yearHelper);//here we call the day names because we need the year helper

        //month.length(yearHelper.isLeapYear()) - returns the length of the month depending  of year leap
        for (int counter = 1; counter <=month.length(yearHelper.isLeapYear()); counter++) {
            LocalDate output = LocalDate.of(inputYear, month,counter);
            //returns the first 7 days
            if ( counter < 8) {
                dates = new Text( mover, 25 , output.format(formatter));
                mover +=  40;

                // if the date is the current one, is colored in red
                if (currentDate.equals(output) ) {
                    dates.setFill(Color.RED);
                }

                root.getChildren().addAll(dates);
            }

            if ( counter >= 8 && counter < 15) {
                dates = new Text( mover2, 45 , output.format(formatter));
                mover2 +=  40;

                if (currentDate.equals(output) ) {
                    dates.setFill(Color.RED);
                }

                root.getChildren().addAll(dates);
            }

            if ( counter >= 15 && counter < 22) {
                dates = new Text( mover3, 65 , output.format(formatter));
                mover3 +=  40;

                if (currentDate.equals(output) ) {
                    dates.setFill(Color.RED);
                }

                root.getChildren().addAll(dates);
            }

            if ( counter >= 22 && counter < 29) {
                dates = new Text( mover4, 85 , output.format(formatter));
                mover4 +=  40;

                if (currentDate.equals(output) ) {
                    dates.setFill(Color.RED);
                }

                root.getChildren().addAll(dates);
            }
            if (counter >= 29 ){

                dates = new Text( mover5, 105 , output.format(formatter));
                mover5 +=  40;

                if (currentDate.equals(output) ) {
                    dates.setFill(Color.RED);
                }
                root.getChildren().addAll(dates);
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene  scene = new Scene(root, 300,200); // creating new Scene

        firstDlg = new TextInputDialog();
        secondDlg = new TextInputDialog();
        errorDlg = new Alert(Alert.AlertType.ERROR);

        readInput(); // here we call the input windows

        //here we check if the input data is correct
        if(inputMonth < 1 || inputMonth > 12 || inputYear < 1 ) {
            showAlert();
        }else {
            calenderDays();
        }


        primaryStage.setTitle("Calendar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
