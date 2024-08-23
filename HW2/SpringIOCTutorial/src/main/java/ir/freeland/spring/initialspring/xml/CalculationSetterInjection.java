package ir.freeland.spring.initialspring.xml;

public class CalculationSetterInjection {
  private Calculator calculator;
  private Display display;
  private Print print;

  public void complexCalculation() {
    int result = calculator.plus(2, 3);

    display.output(String.format("2 + 3 = %d", result));

    print.doPrint("Printing was done successfully!");
  }

  public void setCalculator(Calculator calculator) {
    this.calculator = calculator;
  }

  public void setDisplay(Display display) {
    this.display = display;
  }

  public void setPrint(Print print) {
    this.print = print;
  }
}
