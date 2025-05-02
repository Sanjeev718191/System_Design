public class Singleton {

    // without using design pattern
    class Logger {
        public void log(String message) {
            System.out.println("Log: " + message);
        }
    }
    class Application {
        public void run() {
            Logger logger = new Logger();  // New instance created every time
            logger.log("Application started.");
        }
    }
    class UserService {
        public void login(String username) {
            Logger logger = new Logger();  // Another new instance created
            logger.log("User " + username + " logged in.");
        }
    }

    //=========================================================
    // Using the Singleton Design pattern
    public class Logger {
        // 1. Private static variable to hold the single instance
        private static Logger instance;
      
        // 2. Private constructor to prevent instantiation
        private Logger() {}
      
        // 3. Public method to provide access to the instance
        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger(); // Create a new instance only if it doesn't exist
            }
            return instance; // Return the existing instance
        }
        public void log(String message) {
            System.out.println("Log: " + message);
        }
    }
    public class Application {
        public void run() {
            // 4. Fetch the single instance of the Logger
            Logger logger = Logger.getInstance();
            logger.log("Application started.");
        }
    }


    //===================================================================================
    // More optimized
    public class Logger {
        private static volatile Logger
            instance; // volatile keyword ensures visibility across threads
        private Logger() {} // Private constructor to prevent instantiation
      
        public static Logger getInstance() {
            if (instance == null) { // First check (no synchronization needed here)
                synchronized (
                    Logger.class) { // Synchronize only when creating the instance
                    if (instance == null) { // Second check (inside synchronized block)
                        instance = new Logger(); // Create the instance if it's still null
                    }
                }
            }
            return instance; // Return the single instance
        }
      
        public void log(String message) {
          System.out.println("Log: " + message);
        }
    }

}
