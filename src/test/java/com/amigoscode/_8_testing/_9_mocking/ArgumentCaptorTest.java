package com.amigoscode._8_testing._9_mocking;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Exercise: Mockito ArgumentCaptor
 * <p>
 * Practice capturing arguments passed to mocked methods so you can inspect
 * them in detail. This is useful when the argument is constructed inside the
 * method under test.
 */
@DisplayName("Argument Captor Tests")
@ExtendWith(MockitoExtension.class)
class ArgumentCaptorTest {

    @Mock
    private PaymentService paymentService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private EmailService emailService;

    @Captor
    ArgumentCaptor<Order> annotatedCaptor;

    @InjectMocks
    private OrderService orderService;

    // TODO: 1 - Create an ArgumentCaptor<Order> and capture the argument passed to save().
    //  Create a captor: ArgumentCaptor<Order> orderCaptor = ArgumentCaptor.forClass(Order.class);
    //  Stub paymentService.charge to return true.
    //  Place an order.
    //  Capture: verify(orderRepository).save(orderCaptor.capture());
    //  Get the captured value: Order savedOrder = orderCaptor.getValue();
    @Test
    void canCaptureArgumentPassedToSave() {
        ArgumentCaptor<Order> orderCaptor = ArgumentCaptor.forClass(Order.class);
        when(paymentService.charge("CUST-1", 34.50)).thenReturn(true);
        Order order = new Order("Ord-1", "CUST-1", 34.50);
        Order actual = orderService.placeOrder(order);

        verify(orderRepository).save(orderCaptor.capture());
        Order captorValue = orderCaptor.getValue();

        assertEquals("COMPLETED", captorValue.getStatus());
        assertEquals("CUST-1", captorValue.getCustomerId());
        assertEquals(34.50, captorValue.getAmount());

    }

    // TODO: 2 - Assert that the captured Order has the correct fields.
    //  Using the captured order from TODO 1:
    //  assertEquals("COMPLETED", savedOrder.getStatus());
    //  assertEquals("CUST-1", savedOrder.getCustomerId());
    //  assertEquals(99.99, savedOrder.getAmount());


    // TODO: 3 - Capture multiple invocations.
    //  Stub paymentService.charge to return true.
    //  Place 3 different orders (with different IDs and amounts).
    //  Capture all: verify(orderRepository, times(3)).save(orderCaptor.capture());
    //  Get all values: List<Order> savedOrders = orderCaptor.getAllValues();
    //  Assert that savedOrders has size 3.
    //  Assert each order has status "COMPLETED".
    @Test
    void capturingMultipleInvocations() {
        when(paymentService.charge("CUST-1", 23.90)).thenReturn(true);
        when(paymentService.charge("CUST-2", 65.90)).thenReturn(true);
        when(paymentService.charge("CUST-3", 12.90)).thenReturn(true);

        Order order1 = new Order("ORD-1", "CUST-1", 23.90);
        Order order2 = new Order("ORD-2", "CUST-2", 65.90);
        Order order3 = new Order("ORD-3", "CUST-3", 12.90);

        orderService.placeOrder(order1);
        orderService.placeOrder(order2);
        orderService.placeOrder(order3);

        ArgumentCaptor<Order> orderCaptor = ArgumentCaptor.forClass(Order.class);

        verify(orderRepository, times(3)).save(orderCaptor.capture());

        List<Order> savedOrders = orderCaptor.getAllValues();

        assertThat(savedOrders.size()).isEqualTo(3);
        assertThat(savedOrders).extracting(Order::getStatus).containsOnly("COMPLETED");

//        assertEquals("COMPLETED", savedOrders.getFirst().getStatus());
//        assertEquals("COMPLETED", savedOrders.get(1).getStatus());
//        assertEquals("COMPLETED", savedOrders.getLast().getStatus());


    }


    // TODO: 4 - Use @Captor annotation instead of manually creating the captor.
    //  Declare a field: @Captor ArgumentCaptor<Order> annotatedCaptor;
    //  Write a test that places an order and captures the saved order using annotatedCaptor.
    //  Verify the captured order's fields.
    //  Note: @Captor is cleaner than calling ArgumentCaptor.forClass() in each test.
    @Test
    void canCaptureWithAnnotatedCapture(){
        when(paymentService.charge("CUST-1", 23.90)).thenReturn(true);
        Order order1 = new Order("ORD-1", "CUST-1", 23.90);

        orderService.placeOrder(order1);

        verify(orderRepository).save(annotatedCaptor.capture());
        Order savedValue = annotatedCaptor.getValue();

        assertThat(savedValue.getCustomerId()).isEqualTo("CUST-1");
        assertThat(savedValue.getAmount()).isEqualTo(23.90);
        assertThat(savedValue.getStatus()).isEqualTo("COMPLETED");
        assertThat(savedValue.getId()).isEqualTo("ORD-1");

    }


    // TODO: 5 - Capture arguments passed to EmailService.
    //  Create a NotificationService with the mocked EmailService.
    //  Create an order and call notificationService.notifyOrderPlaced(order).
    //  Capture all 3 arguments passed to emailService.send():
    //  ArgumentCaptor<String> toCaptor = ArgumentCaptor.forClass(String.class);
    //  ArgumentCaptor<String> subjectCaptor = ArgumentCaptor.forClass(String.class);
    //  ArgumentCaptor<String> bodyCaptor = ArgumentCaptor.forClass(String.class);
    //  verify(emailService).send(toCaptor.capture(), subjectCaptor.capture(), bodyCaptor.capture());
    //  Assert the captured subject contains "Order Confirmation".
    @Test
    void canCaptureArgumentsPassedToEmailService(){
        NotificationService notificationService = new NotificationService(emailService);
        Order order1 = new Order("ORD-1", "CUST-1", 23.90);
        notificationService.notifyOrderPlaced(order1);

        ArgumentCaptor<String> toCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> subjectCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> bodyCaptor = ArgumentCaptor.forClass(String.class);
        verify(emailService).send(toCaptor.capture(), subjectCaptor.capture(), bodyCaptor.capture());
        String toCaptorValue = toCaptor.getValue();
        String subjectCaptorValue = subjectCaptor.getValue();
        String bodyCaptorValue = bodyCaptor.getValue();
        assertThat(subjectCaptorValue).containsIgnoringCase("Order Confirmation");
    }


    // TODO: 6 - Combine captor with verify to check interaction details.
    //  Stub paymentService.charge to return true.
    //  Place an order.
    //  Use ArgumentCaptor<String> to capture the customerId passed to charge().
    //  Use ArgumentCaptor<Double> to capture the amount passed to charge().
    //  ArgumentCaptor<String> customerCaptor = ArgumentCaptor.forClass(String.class);
    //  ArgumentCaptor<Double> amountCaptor = ArgumentCaptor.forClass(Double.class);
    //  verify(paymentService).charge(customerCaptor.capture(), amountCaptor.capture());
    //  Assert customerCaptor.getValue() equals the order's customer ID.
    //  Assert amountCaptor.getValue() equals the order's amount.
    @Test
    void combineCaptureWithVerifyToCHeckInteractionDetails(){
        when(paymentService.charge("CUST-1", 23.90)).thenReturn(true);
        Order order1 = new Order("ORD-1", "CUST-1", 23.90);

        orderService.placeOrder(order1);
        ArgumentCaptor<String> capturedCustomerId = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Double> capturedAmount = ArgumentCaptor.forClass(Double.class);

        verify(paymentService).charge(capturedCustomerId.capture(),capturedAmount.capture());
        String savedCustomerId = capturedCustomerId.getValue();
        Double savedAmount = capturedAmount.getValue();
        assertThat(savedCustomerId).isEqualTo(order1.getCustomerId());
        assertThat(savedAmount).isEqualTo(order1.getAmount());
    }

}
