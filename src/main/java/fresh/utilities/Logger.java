package fresh.utilities;

import fresh.Fresh;

public class Logger {

    public static void log(String message) {
        Fresh.callbacks.printOutput(message);
    }

    public static void error(String errorMessage) {
        Fresh.callbacks.printError(errorMessage);
    }
}
