package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;


class FeeCalculatorTest {

    @Test
    public void test_calculateFee_when_adult_and_halfDay() {
        //GIVEN
        double fee = 0.0;
        Visitor visitor = new Visitor(20);
        TicketType ticketType = TicketType.HALF_DAY;
        FeeCalculator feeCalculator = new FeeCalculator();

        //WHEN
        fee = feeCalculator.calculateFee(visitor, ticketType);

        //THEN
        //fais un assertequals pour vérifier que le prix est correct, sinon il renvoie une erreur
        assertEquals(60 , fee, "The fee is not correct");
    }

    @Test
    public void test_calculateFee_when_adult_and_fullDay() {
        //GIVEN
        double fee = 0.0;
        Visitor visitor = new Visitor(20);
        TicketType ticketType = TicketType.FULL_DAY;
        FeeCalculator feeCalculator = new FeeCalculator();

        //WHEN
         fee = feeCalculator.calculateFee(visitor, ticketType);

        //THEN
        assertEquals(120 , fee, "The fee is not correct");
    }

    @Test
    public void test_calculateFee_when_child_and_halfDay() {
        //GIVEN
        double fee = 0.0;
        Visitor visitor = new Visitor(10);
        TicketType ticketType = TicketType.HALF_DAY;
        FeeCalculator feeCalculator = new FeeCalculator();

        //WHEN
         fee = feeCalculator.calculateFee(visitor, ticketType);

        //THEN
        assertEquals(20 , fee, "The fee is not correct");
    }

    @Test
    public void test_calculateFee_when_child_and_fullDay() {
        //GIVEN
        double fee = 0.0;
        Visitor visitor = new Visitor(10);
        TicketType ticketType = TicketType.FULL_DAY;
        FeeCalculator feeCalculator = new FeeCalculator();

        //WHEN
         fee = feeCalculator.calculateFee(visitor, ticketType);

        //THEN
        assertEquals(50 , fee, "The fee is not correct");
    }

    @Test
    public void should_throw_exception_when_ticketType_not_supported() {
        //GIVEN
        Visitor visitor = new Visitor(14);

        //WHEN
        Throwable thrown = catchThrowable(() -> {
            double fee = FeeCalculator.calculateFee(visitor, TicketType.WEEK);
        });

        //THEN
        assertThat(thrown).isInstanceOf(RuntimeException.class).hasMessage("Ticket type not supported");
    }

}