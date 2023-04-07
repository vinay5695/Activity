package com.stepDefinitions;

import java.text.*;
import java.util.Calendar;
import java.util.Date;

import io.cucumber.java.en.*;

public class DateTest {
	
    static final DateFormat format=new SimpleDateFormat("yyyy/MM/dd");
    Date currentDate;
    Date addDate;
    Calendar cal;
    
    @Given("I want to get and print the current date")
    public void i_want_to_get_and_print_the_current_date() {
    	currentDate=new Date();
	    System.out.println("Current date:"+format.format(currentDate));
    }
    @When("I have to add the current date with one date")
    public void i_have_to_add_the_current_date_with_one_date() {
    	cal=Calendar.getInstance();
	    cal.setTime(currentDate);
	    cal.add(Calendar.YEAR, 1);
	    cal.add(Calendar.MONTH, 1);
	    cal.add(Calendar.DATE, 1);
    }
    @Then("I print the current date with added one date")
    public void i_print_the_current_date_with_added_one_date() {
    	addDate=cal.getTime();
	    System.out.println("One date added to current date:"+format.format(addDate));
    }


}
