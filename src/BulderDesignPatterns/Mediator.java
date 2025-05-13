public class Mediator {

    // The Auction Mayhem: A Traditional Approach Gone Wild 🎯💥
    // Imagine our auction system without any mediator. 
    // Every bidder has to know about every other bidder to communicate a new bid. Let’s see how that might look:

    class Bidder {
        String name;
        int bid;
       public
        Bidder(String name) { this.name = name; }
        // Direct communication with all other bidders (messy!)
       public
        void placeBid(int amount, Bidder[] bidders) {
          this.bid = amount;
          System.out.println(name + " placed a bid: " + amount);
          for (Bidder b : bidders) {
            if (b != this) {
              b.receiveBid(this, amount);
            }
          }
        }
       public
        void receiveBid(Bidder bidder, int amount) {
          System.out.println(name + " is notified: " + bidder.name +
                             " placed a bid of " + amount);
        }
      } public class AuctionTraditionalDemo {
       public
        static void main(String[] args) {
          Bidder bidder1 = new Bidder("Alice");
          Bidder bidder2 = new Bidder("Bob");
          Bidder bidder3 = new Bidder("Charlie");
          Bidder[] bidders = {bidder1, bidder2, bidder3};
          // Each bidder directly communicates with others
          bidder1.placeBid(100, bidders);
          bidder2.placeBid(150, bidders);
          bidder3.placeBid(200, bidders);
        }
    }

    // Improved code with Mediator design

    interface AuctionMediator {
        void registerBidder(Bidder bidder);
        void placeBid(Bidder bidder, int amount);
    }

    class AuctionHouse implements AuctionMediator {
        private List<Bidder> bidders = new ArrayList<>();

        @Override public void registerBidder(Bidder bidder) {
            bidders.add(bidder);
        }

        @Override public void placeBid(Bidder bidder, int amount) {
            System.out.println(bidder.getName() + " placed a bid of " + amount);
            for (Bidder b : bidders) {
                if (b != bidder) {
                    b.receiveBid(bidder, amount);
                }
            }
        }
    }

    class Bidder {
        private String name;
        private AuctionMediator mediator;
        public Bidder(String name, AuctionMediator mediator) {
           this.name = name;
           this.mediator = mediator;
        }
        public String getName() { return name; }
        public void placeBid(int amount) { mediator.placeBid(this, amount); }
        public void receiveBid(Bidder bidder, int amount) {
           System.out.println(name + " is notified: " + bidder.getName() +
                              " placed a bid of " + amount);
        }
    }

    public class AuctionMediatorDemo {
        public static void main(String[] args) {
            AuctionMediator auctionHouse = new AuctionHouse();
            Bidder bidder1 = new Bidder("Alice", auctionHouse);
            Bidder bidder2 = new Bidder("Bob", auctionHouse);
            Bidder bidder3 = new Bidder("Charlie", auctionHouse);
            auctionHouse.registerBidder(bidder1);
            auctionHouse.registerBidder(bidder2);
            auctionHouse.registerBidder(bidder3);
            bidder1.placeBid(100);
            bidder2.placeBid(150);
            bidder3.placeBid(200);
        }
    }

}
