package com.amigoscode._8_testing._9_mocking;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Exercise: Mockito Argument Matchers
 * <p>
 * Practice using Mockito's argument matchers for flexible stubbing and verification.
 * Matchers let you specify patterns for arguments rather than exact values.
 */
@DisplayName("Mockito Argument Matchers Tests")
@ExtendWith(MockitoExtension.class)
class MatchersTest {

    @Mock
    private PaymentService paymentService;

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    // TODO: 1 - Use any() matcher with when().thenReturn().
    //  Stub paymentService.charge to return true for ANY String and ANY double:
    //  when(paymentService.charge(any(), anyDouble())).thenReturn(true);
    //  Place an order and assert it completes successfully.
    @Test
    void canOrderCompletesSuccessfully() {
        Order order = new Order("ORD-1", "CUST-1", 45.55);
        when(paymentService.charge(any(), anyDouble())).thenReturn(true);
        Order actual = orderService.placeOrder(order);
        assertThat(actual.getStatus()).isEqualTo("COMPLETED");

    }


    // TODO: 2 - Use anyString() matcher.
    //  Stub paymentService.charge to return true when called with
    //  anyString() for customer ID and eq(99.99) for amount.
    //  Place an order with amount 99.99 and verify it works.
    //  Place another order with a different customer ID but same amount and verify.
    @Test
    void anyCustomerIdMatchesStubbedCharge() {
        Order order = new Order("ORD-2", "CUST-2", 99.99);
        when(paymentService.charge(anyString(), eq(99.99))).thenReturn(true);
        orderService.placeOrder(order);
        verify(orderRepository).save(order);
        verify(paymentService).charge("CUST-2", 99.99);
        Order order1 = new Order("ORD-3", "CUST-3", 99.99);
        orderService.placeOrder(order1);
        verify(orderRepository).save(order1);
        verify(paymentService).charge("CUST-3", 99.99);
    }


    // TODO: 3 - Use eq() for exact match combined with other matchers.
    //  Stub paymentService.charge to return true for eq("VIP-CUSTOMER") and anyDouble().
    //  Create an order with customerId "VIP-CUSTOMER" and place it.
    //  Assert the order status is "COMPLETED".
    //  Important: When using any matcher in a call, ALL arguments must use matchers.
    @Test
    void vipCustomerOrderIsCompleted() {
        when(paymentService.charge(eq("VIP-CUSTOMER"), anyDouble())).thenReturn(true);
        Order order = new Order("ORD-1", "VIP-CUSTOMER", 199.99);
        Order actual = orderService.placeOrder(order);
        verify(paymentService).charge("VIP-CUSTOMER", 199.99);
        assertThat(actual.getStatus()).isEqualTo("COMPLETED");

    }


    // TODO: 4 - Use argThat() with a custom matcher.
    //  Stub paymentService.charge to return true when the amount is greater than 0:
    //  when(paymentService.charge(anyString(), argThat(amount -> amount > 0)))
    //      .thenReturn(true);
    //  Place an order with a positive amount and verify success.
    @Test
    void positiveAmountMatchesCustomMatcher() {
        Order order = new Order("ORD-1", "CUST-1", 29.99);
        when(paymentService.charge(anyString(), doubleThat(amount -> amount > 0)))
                .thenReturn(true);
        Order actual = orderService.placeOrder(order);
        verify(paymentService).charge("CUST-1", 29.99);
        verify(orderRepository).save(order);
        assertThat(actual.getStatus()).isEqualToIgnoringCase("completed");


    }


    // TODO: 5 - Combine matchers in verify().
    //  Place an order, then verify the interactions using matchers:
    //  verify(paymentService).charge(eq("CUST-1"), argThat(amount -> amount > 50));
    //  verify(orderRepository).save(argThat(order ->
    //      order.getStatus().equals("COMPLETED")));
    @Test
    void chargeAndSaveAreCalledWithExpectedArguments() {
        Order order1 = new Order("ORD-1", "CUST-1", 69.90);
        when(paymentService.charge(eq("CUST-1"), doubleThat(amount -> amount > 50))).thenReturn(true);
        Order actual = orderService.placeOrder(order1);
        verify(paymentService).charge(eq("CUST-1"), doubleThat(amount -> amount > 50));
        verify(orderRepository).save(argThat(order -> order.getStatus().equalsIgnoreCase("completed")));
    }


    // TODO: 6 - Use argument matchers with when() for different return values.
    //  Stub charge to return true for amounts <= 1000 and false for amounts > 1000:
    //  when(paymentService.charge(anyString(), doubleThat(a -> a <= 1000)))
    //      .thenReturn(true);
    //  when(paymentService.charge(anyString(), doubleThat(a -> a > 1000)))
    //      .thenReturn(false);
    //  Test placing an order with amount 500 (should succeed).
    //  Test placing an order with amount 1500 (should throw RuntimeException).
    @Test
    void test(){
        when(paymentService.charge(anyString(), doubleThat(amount -> amount <= 1000)))
                .thenReturn(true);
        Order order = new Order("ORD-1", "CUST-1", 69.90);
        Order actual = orderService.placeOrder(order);
        verify(paymentService).charge(eq("CUST-1"),eq( 69.90));
        verify(orderRepository).save(order);
        assertThat(actual.getStatus()).isEqualToIgnoringCase("completed");


        when(paymentService.charge(anyString(), doubleThat(amount -> amount > 1000)))
                .thenReturn(false);
        Order secondOrder = new Order("ORD-2", "CUST-2", 1069.90);
        assertThrows(RuntimeException.class, () -> orderService.placeOrder(secondOrder));
    }


}
