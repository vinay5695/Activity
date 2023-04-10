package com.stepDefinitions;

import java.text.*;
import java.util.Calendar;
import java.util.Date;
import io.cucumber.java.en.*;

//This class have steps for date feature which is used add date to current date
public class DateTest {
	
    static final DateFormat format=new SimpleDateFormat("yyyy/MM/dd");
    Date currentDate;
    Date addDate;
    Calendar cal;
    
//Given do to get the current date and print the current date
    @Given("I want to get and print the current date")
    public void i_want_to_get_and_print_the_current_date() {
    	currentDate=new Date();
	    System.out.println("Current date:"+format.format(currentDate));
    }
    
//When do to add one date,month,year to the current date    
    @When("I have to add the current date with one date")
    public void i_have_to_add_the_current_date_with_one_date() {
    	cal=Calendar.getInstance();
	    cal.setTime(currentDate);
	    cal.add(Calendar.YEAR, 1);
	    cal.add(Calendar.MONTH, 1);
	    cal.add(Calendar.DATE, 1);
    }
    
//Then do to get the added date with current date and print the output date    
    @Then("I print the current date with added one date")
    public void i_print_the_current_date_with_added_one_date() {
    	addDate=cal.getTime();
	    System.out.println("One date added to current date:"+format.format(addDate));
    }


}
