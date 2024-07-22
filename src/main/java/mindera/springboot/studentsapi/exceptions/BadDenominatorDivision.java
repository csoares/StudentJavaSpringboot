package mindera.springboot.studentsapi.exceptions;

public class BadDenominatorDivision extends RuntimeException {
    public BadDenominatorDivision(String cannotDivideByZero) {
        super(cannotDivideByZero);
    }
}
