package ir.freeland.spring.initialspringboot;

import org.springframework.stereotype.Service;

/**
 * Simple Printer
 *
 * Used only for demonstration purposes :P
 */
@Service
public class Print {
  public void doPrint(String value) {
    System.out.println(value);
  }
}
