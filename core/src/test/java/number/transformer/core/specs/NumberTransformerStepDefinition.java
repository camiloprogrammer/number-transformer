package number.transformer.core.specs;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import number.transformer.core.NumberToEnglishTextTransformer;
import number.transformer.core.NumberToTextTransformer;

public class NumberTransformerStepDefinition {

    private NumberToTextTransformer transformer;

    private String numberToTransform;

    private String transformedNumber;

    @Before
    public void setup() {
        this.numberToTransform = null;
        this.transformedNumber = null;
    }

    @Given("I want to transform numbers in English")
    public void givenIWantToTransformNumbersInEnglish() throws Throwable {
        this.transformer = new NumberToEnglishTextTransformer();
    }
    
    @Given("I want to transform number {string}")
    public void givenIWantToTransformNumber(String number) throws Throwable {
        this.numberToTransform = number;
    }

    @When("I transform the number to english")
    public void whenITransformTheNumberToEnglish() throws Throwable {
        this.transformedNumber = transformer.transformNumber(numberToTransform);
    }

    @Then("I get {string} as the transformed number")
    public void thenIGetTheExpectedTransformedNumber(String expectedResult) throws Throwable {
        assertEquals("Unexpected result for " + numberToTransform, expectedResult, this.transformedNumber);
    }

}
