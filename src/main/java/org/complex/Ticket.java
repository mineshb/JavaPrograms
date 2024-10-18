package org.complex;


import java.util.HashMap;
        import java.util.Map;

class Ticket {
    private String type;
    private double price;
    private int available;

    public Ticket(String type, double price, int available) {
        this.type = type;
        this.price = price;
        this.available = available;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailable() {
        return available;
    }

    public void bookTicket() {
        if (available > 0) {
            available--;
        } else {
            System.out.println("No tickets available for " + type);
        }
    }
}

class TicketingSystem {
    private Map<String, Ticket> tickets;

    public TicketingSystem() {
        tickets = new HashMap<>();
        // Initialize with some ticket types
        tickets.put("Regular", new Ticket("Regular", 50.0, 100));
        tickets.put("VIP", new Ticket("VIP", 150.0, 50));
        tickets.put("Early Bird", new Ticket("Early Bird", 30.0, 30));
    }

    public void listAvailableTickets() {
        for (Map.Entry<String, Ticket> entry : tickets.entrySet()) {
            Ticket ticket = entry.getValue();
            System.out.println(ticket.getType() + ": $" + ticket.getPrice() + " - Available: " + ticket.getAvailable());
        }
    }

    public void bookTicket(String type) {
        Ticket ticket = tickets.get(type);
        if (ticket != null) {
            ticket.bookTicket();
            System.out.println("Booked a " + type + " ticket. Remaining: " + ticket.getAvailable());
        } else {
            System.out.println("Ticket type " + type + " not found.");
        }
    }

    public static void main(String[] args) {
        TicketingSystem ts = new TicketingSystem();
        ts.listAvailableTickets();

        // Simulate booking
        ts.bookTicket("VIP");
        ts.bookTicket("Early Bird");
        ts.bookTicket("Regular");

        // List again to see the updated availability
        ts.listAvailableTickets();
    }
}
