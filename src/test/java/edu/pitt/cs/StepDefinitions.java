package edu.pitt.cs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class StepDefinitions {
	private RentACat r;
	private String listResult;
	private boolean operationResult;
	private boolean returnResult;
	

	@Given("a rent-a-cat facility")
	public void aRentACatFacility() {
		r = RentACat.createInstance(InstanceType.IMPL);
	}
	
	@Given("no cats")
	public void noCats() {
		// nothing to do really
	}
	
	@Given("a cat with ID {int} and name {string}")
	public void aCatWithIDAndName(Integer id, String name) {
		r.addCat(Cat.createInstance(InstanceType.IMPL, id, name));
		System.out.println("Created cat " + id + ". " + name);
	}
	
	@When("I list the cats")
	public void iListTheCats() {
		listResult = r.listCats();
	}
	
	@When("I rent cat number {int}")
	public void iRentCatNumber(Integer id) {
		operationResult = r.rentCat(id);
	}

	@When("I return cat number {int}")
	public void iReturncatNumber(int id){
		returnResult = r.returnCat(id);
	}
	
	@Then("the listing is: {string}")
	public void theListingIs(String result) {
		assertEquals(result.replaceAll("\\\\n", "\n"), listResult);
	}
	
	@Then("the rent is successful")
	public void theRentIsSuccessful() {
		assertEquals(operationResult, true);
	}

	@Then("the rent is unsuccessful")
	public void theRentIsUnsuccessful() {
		assertEquals(operationResult, false);
	}

	@Then("the return is unsuccessful")
	public void theReturnIsUnsuccessful(){
		assertEquals(returnResult, false);
	}

	@Then("the return is successful")
	public void theReturnIsSuccessful(){
		assertEquals(returnResult, true);
	}

}