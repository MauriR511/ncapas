package com.example.api.services.implementations;

import com.example.api.models.entities.QR;
import com.example.api.models.entities.Ticket;
import com.example.api.models.entities.User;
import com.example.api.models.entities.dtos.GetTicketDTO;
import com.example.api.models.entities.dtos.SaveTicketDTO;
import com.example.api.repositories.TicketRepository;
import com.example.api.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void save(SaveTicketDTO ticket) throws Exception {

        Ticket newTicket = new Ticket(
                ticket.getUser(),
                ticket.getTier(),
                ticket.getPurchaseDate()
        );

        ticketRepository.save(newTicket);
    }

    @Override
    public void deleteByTicketNumber(int value) throws Exception {

    }

    @Override
    public void deleteById(String id) throws Exception {

    }

    @Override
    public Ticket findOneByTicketNumber(int value) {
        return null;
    }

    @Override
    public List<GetTicketDTO> findAll(User user) {

        List<Ticket> tickets = ticketRepository.findAllByUser(user);

        List<GetTicketDTO> ticketsDTO = new ArrayList<>();

        for (Ticket ticket : tickets) {
            ticketsDTO.add(new GetTicketDTO(
                    ticket.getTier().getEvent().getTitle(),
                    ticket.getTier().getName(),
                    ticket.getTier().getEvent().getDate().toString()
            ));
        }

        return ticketsDTO;
    }

    @Override
    public void updateTicketNumber(int ticket_number, String id) {

    }

    @Override
    public void updatePurchaseDate(Timestamp purchaseDate, String id) {

    }

    @Override
    public void updateIsValid(Boolean isValid, String id) {

    }

    @Override
    public void updatePriority(String priority, String id) {

    }

    @Override
    public void updateQR(QR qr, String id) {

    }
}
