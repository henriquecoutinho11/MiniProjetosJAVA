package utils;

public class Converter {
  public static final double ZERO_ABSOLUTO_KELVIN = 0;
  public static final double ZERO_ABSOLUTO_CELSIUS = -273;
  public static final double ZERO_ABSOLUTO_FAHRENHEIT = -459;

  private Converter() {
  }

  public static double celsiusToFahrenheit(double c) {
    if (c < ZERO_ABSOLUTO_CELSIUS)
      throw new IllegalArgumentException("Valor abaixo do zero absoluto");

    return c / 5 * 9 + 32;
  }

  public static double fahrenheitToKelvin(double f) {
    if (f < ZERO_ABSOLUTO_FAHRENHEIT)
      throw new IllegalArgumentException("Valor abaixo do zero absoluto");

    return (f - 32) / 9 * 5 + 273;
  }

  public static double kelvinToCelsius(double k) {
    if (k < ZERO_ABSOLUTO_KELVIN)
      throw new IllegalArgumentException("Valor abaixo do zero absoluto");

    return k - 273;
  }

  public static double celsiusToKelvin(double c) {
    return fahrenheitToKelvin(celsiusToFahrenheit(c));
  }

  public static double fahrenheitToCelsius(double f) {
    return kelvinToCelsius(fahrenheitToKelvin(f));
  }

  public static double kelvinToFahrenheit(double k) {
    return celsiusToFahrenheit(kelvinToCelsius(k));
  }

}