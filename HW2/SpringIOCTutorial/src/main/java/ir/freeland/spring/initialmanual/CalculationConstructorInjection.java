package ir.freeland.spring.initialmanual;

public class CalculationConstructorInjection {
  private final Calculator calculator;
  private final Display display;
  private final Print print;


  public CalculationConstructorInjection(Calculator calculator, Display display, Print print) {
    this.calculator = calculator;
    this.display = display;
    this.print = print;
  }

  public void complexCalculation() {
    int result = calculator.plus(2, 3);

    display.output(String.format("2 + 3 = %d", result));

    print.doPrint("Printing was done successfully!");
  }
}
