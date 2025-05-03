public class Observer {

    //Observer Design Pattern: How to Stay Updated Without Constantly Checking 📲🔔
    //Imagine you’re watching your favorite YouTube channel. Every time they upload a new video, you get a notification. 
    //You don’t have to keep checking the channel to see if there’s something new.
    
    // Basic Code 
    import java.util.ArrayList;
    import java.util.List;
    class YouTubeChannel {
        private List<String> subscribers = new ArrayList<>();
        private String video;

        // Method to add a new subscriber
        public void addSubscriber(String subscriber) {
            subscribers.add(subscriber);
        }

        // Method to upload a new video
        public void uploadNewVideo(String video) {
            this.video = video;
            notifySubscribers(); // Notify all subscribers about the new video
        }

        // Notify all subscribers
        public void notifySubscribers() {
            for (String subscriber : subscribers) {
                System.out.println(
                    "Notifying " + subscriber + " about new video: " + video);
            }
        }
    }

    class YouTubeSubscriber {
        private String name;
        public YouTubeSubscriber(String name) {
            this.name = name;
        }
        public void subscribe(YouTubeChannel channel) {
            channel.addSubscriber(name);
        }
        public void watchVideo(YouTubeChannel channel) {
            System.out.println(name + " is watching the video: " + channel.video);
        }
    }
    // Adding a new notification method (e.g., email, SMS) requires modifying the YouTubeChannel class, which leads to tight coupling and difficult maintenance.

    //===================================================================================================================
    // Using observer Design pattern

    public interface Subscriber {
        void update(String video); // This is the method the observer will use to get updated with the new video
    }
    public class YouTubeSubscriber implements Subscriber {
        private String name; // Name of the subscriber
      
        public YouTubeSubscriber(String name) {
            this.name = name; // Initialize the subscriber with their name
        }
      
        @Override
        public void update(String video) {
            // When notified, this method will execute, and the subscriber watches the
            // new video
            System.out.println(name + " is watching the video: " + video);
        }
    }
    public class EmailSubscriber implements Subscriber {
        private String email;
        public EmailSubscriber(String email) {
            this.email = email;
        }
      
        @Override
        public void update(String video) {
            System.out.println(
                "Sending email to " + email + ": New video uploaded: " + video);
        }
    }
      
    public class PushNotificationSubscriber implements Subscriber {
        private String userDevice;
        public PushNotificationSubscriber(String userDevice) {
            this.userDevice = userDevice;
        }
      
        @Override
        public void update(String video) {
            System.out.println("Sending push notification to " + userDevice
                + ": New video uploaded: " + video);
        }
    }

    public interface YouTubeChannel {
        void addSubscriber(Subscriber subscriber); // Method to add a new subscriber
        void removeSubscriber(Subscriber subscriber); // Method to remove a subscriber
        void notifySubscribers(); // Method to notify all subscribers
    }

    public class YouTubeChannelImpl implements YouTubeChannel {
        private List<Subscriber> subscribers =
            new ArrayList<>(); // List of subscribers
        private String video; // The video that will be uploaded

        @Override
        public void addSubscriber(Subscriber subscriber) {
            subscribers.add(subscriber); // Add a subscriber to the channel
        }

        @Override
        public void removeSubscriber(Subscriber subscriber) {
            subscribers.remove(subscriber); // Remove a subscriber from the channel
        }

        @Override
        public void notifySubscribers() {
            // Notify all subscribers about the new video
            for (Subscriber subscriber : subscribers) {
                subscriber.update(video); // Call update() for each subscriber
            }
        }

        public void uploadNewVideo(String video) {
            this.video = video; // Set the video that is being uploaded
            notifySubscribers(); // Notify all subscribers about the new video
        }
    }

    public class Main {
        public static void main(String[] args) {
            // Create a YouTube channel
            YouTubeChannelImpl channel = new YouTubeChannelImpl();
            // Create subscribers
            YouTubeSubscriber alice = new YouTubeSubscriber("Alice");
            YouTubeSubscriber bob = new YouTubeSubscriber("Bob");
            // Subscribe to the channel
            channel.addSubscriber(alice);
            channel.addSubscriber(bob);
            // Upload a new video and notify subscribers
            channel.uploadNewVideo("Java Design Patterns Tutorial");
            // Output:
            // Alice is watching the video: Java Design Patterns Tutorial
            // Bob is watching the video: Java Design Patterns Tutorial
            // You can also remove a subscriber and upload another video
            channel.removeSubscriber(bob);
            channel.uploadNewVideo("Observer Pattern in Action");
            // Output:
            // Alice is watching the video: Observer Pattern in Action
        }
    }

}
