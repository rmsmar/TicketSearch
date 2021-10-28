package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

@AllArgsConstructor
@Data
public class TicketManager {
    private TicketRepository repository;

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] findFromTo(String from, String to) {
        Ticket[] result = new Ticket[0];

        for (Ticket ticket : repository.getAll()) {
            int length = result.length;
            if (ticket.getDeparture().equals(from) && ticket.getArrival().equals(to)) {
                Ticket[] tmp = new Ticket[length + 1];
                System.arraycopy(result, 0, tmp, 0, length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Ticket[] findFrom(String from) {
        Ticket[] result = new Ticket[0];

        for (Ticket ticket : repository.getAll()) {
            int length = result.length;
            if (ticket.getDeparture().equals(from)) {
                Ticket[] tmp = new Ticket[length + 1];
                System.arraycopy(result, 0, tmp, 0, length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}