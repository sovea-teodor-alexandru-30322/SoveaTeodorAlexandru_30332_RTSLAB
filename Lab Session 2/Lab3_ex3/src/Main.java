public class Main {

    private static boolean stopThreads = false;

    public static void main(String[] args) {
        FileService service = new FileService("messages.txt");

        WThread writer = new WThread(service);
        RThread reader = new RThread(service);

        writer.start();
        reader.start();
    }

    public static boolean isStopThreads() {
        return stopThreads;
    }
}