package mk.finki.ukim.mk.lab3.service.impl;

import mk.finki.ukim.mk.lab3.model.EventBooking;
import mk.finki.ukim.mk.lab3.repository.impl.InMemoryBookingRepository;
import mk.finki.ukim.mk.lab3.service.EventBookingService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventBookingImpl implements EventBookingService {
    private InMemoryBookingRepository eventBookings;

    public EventBookingImpl(InMemoryBookingRepository eventBookings) {
        this.eventBookings = eventBookings;
    }

    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets) {
        EventBooking tmp = new EventBooking(eventName,attendeeName,attendeeAddress,(long)numberOfTickets);
        eventBookings.addBooking(attendeeName,eventName,numberOfTickets,attendeeAddress);
        return tmp;
    }

    @Override
    public List<EventBooking> search(String text) {
        return eventBookings.search(text);
    }
}
