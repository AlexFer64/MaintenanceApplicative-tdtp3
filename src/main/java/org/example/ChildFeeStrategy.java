package org.example;

public class ChildFeeStrategy implements FeeStrategy {
    private static final double CHILD_PRICE_BASE = 100;

     @Override
     public double calculate(TicketType ticketType) {
        if (TicketType.HALF_DAY == ticketType) {
            return CHILD_PRICE_BASE * 0.2;
        } else if (TicketType.FULL_DAY == ticketType) {
            return CHILD_PRICE_BASE * 0.5;
        }
         throw new RuntimeException("Ticket type not supported");
    }
}