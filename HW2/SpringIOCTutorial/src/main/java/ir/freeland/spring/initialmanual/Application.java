package ir.freeland.spring.initialmanual;

public class Application {
  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    Display display = new Display();
    Print print = new Print();

    CalculationSetterInjection calculationSetterInjection = new CalculationSetterInjection();
    calculationSetterInjection.setCalculator(calculator);
    calculationSetterInjection.setDisplay(display);
    calculationSetterInjection.setPrint(print);
    calculationSetterInjection.complexCalculation();

    CalculationConstructorInjection calculationConstructorInjection =
        new CalculationConstructorInjection(calculator, display, print);
    calculationConstructorInjection.complexCalculation();
  }
}
