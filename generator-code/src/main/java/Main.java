
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Main {

    private static final long SLEEP = 5;                // Time to sleep between events (in ms)
    private static final long MAX_EVENTS = 1000000;     // Max number of events
    private static final long FEEDBACK_EVENTS = 10000;  // Number of events to print feedback
    private static final long REGISTRY_EVENTS = 15000;  // Interval between each registry copy
    private static final String REGISTRY_FILE = "c:/filebeat-rotate-test/registry.dat";

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        for (long i = 0; i < MAX_EVENTS; i++) {
            LOGGER.info(UUID.randomUUID().toString());
            TimeUnit.MILLISECONDS.sleep(SLEEP);

            if (i % FEEDBACK_EVENTS == 0) {
                System.out.println(i);
            }

            if (i % REGISTRY_EVENTS == 0) {
                File src = new File(REGISTRY_FILE);
                File dst = new File(REGISTRY_FILE + "." + i);
                try {
                    Files.copy(src.toPath(), dst.toPath(), REPLACE_EXISTING);
                } catch (IOException ex) {
                }
            }
            //Files.copy(source, target, REPLACE_EXISTING);
        }
    }
}
