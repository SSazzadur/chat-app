package users;

public class UserOne extends SetUser {
    public UserOne() {
        topBar();
        messageSection();
        bottomBar();
        sendMessage("Tony Stark");
        setFrameLocation(20, 50);
        setFrame();
        connect();
    }
}