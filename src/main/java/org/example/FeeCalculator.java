package org.example;

public class FeeCalculator {
    private static final double CHILD_PRICE_BASE = 100;
    private static final double ADULT_PRICE_BASE = 100;

    public static double calculateFee(Visitor visitor, TicketType ticketType) {
        double fee = 0;

        // calculate price for adults
        if ((visitor.getAge() > 14) && (TicketType.HALF_DAY == ticketType)) {
            fee = ADULT_PRICE_BASE * 0.6;
        } else if ((visitor.getAge() > 14) && (TicketType.FULL_DAY == ticketType)) {
            fee = ADULT_PRICE_BASE * 1.2;
        }

        // calculate price for children
        if ((visitor.getAge() <= 14) && (TicketType.HALF_DAY == ticketType)) {
            fee = ADULT_PRICE_BASE * 0.2;
        } else if ((visitor.getAge() <= 14) && (TicketType.FULL_DAY == ticketType)) {
            fee = ADULT_PRICE_BASE * 0.5;
        }
        return fee;
    }
}
