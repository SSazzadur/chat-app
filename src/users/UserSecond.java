package users;

public class UserSecond extends SetUser {
    public UserSecond() {
        topBar();
        messageSection();
        bottomBar();
        sendMessage("Steve Rogers");
        setFrameLocation(490, 50);
        setFrame();
        connect();
    }
}
