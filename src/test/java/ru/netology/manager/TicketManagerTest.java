package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private Ticket testTicket1 = new Ticket(1, 1299, "SVO", "KZN", 135);
    private Ticket testTicket2 = new Ticket(2, 2199, "VKO", "KZN", 135);
    private Ticket testTicket3 = new Ticket(3, 2385, "VKO", "KZN", 130);
    private Ticket testTicket4 = new Ticket(4, 3100, "DME", "KZN", 130);
    private Ticket testTicket5 = new Ticket(5, 3100, "DME", "KZN", 135);
    private Ticket testTicket6 = new Ticket(6, 4114, "SVO", "KZN", 135);

    @BeforeEach
    void SetUp() {
        repository.save(testTicket1);
        repository.save(testTicket2);
        repository.save(testTicket3);
        repository.save(testTicket4);
        repository.save(testTicket5);
        repository.save(testTicket6);
    }

    @Test
    void shouldFindFromTo() {
        Ticket[] actual = manager.findFromTo("DME", "KZN");
        Ticket[] expected = {
                testTicket4,
                testTicket5
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindNothing() {
        Ticket[] actual = manager.findFromTo("SVO", "LED");
        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindFrom() {
        Ticket[] actual = manager.findFrom("VKO");
        Ticket[] expected = {
                testTicket2,
                testTicket3
        };
        assertArrayEquals(expected, actual);
    }
}