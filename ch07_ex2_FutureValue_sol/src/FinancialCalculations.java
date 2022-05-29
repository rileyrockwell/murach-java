public class FinancialCalculations {
    public static double calculateFutureValue(double monthlyInvestment,
        double interestRate, int years) {
        
        // convert yearly values to monthly values
        double monthlyInterestRate = interestRate/12/100;
        int months = years * 12;
            
        double futureValue = 0.0;
        for (int i = 1; i <= months; i++) {
            futureValue = (futureValue + monthlyInvestment) *
                          (1 + monthlyInterestRate);
        }
        return futureValue;
    }
}
