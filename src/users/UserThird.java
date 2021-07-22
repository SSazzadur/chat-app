package users;

public class UserThird extends SetUser {
    public UserThird() {
        topBar();
        messageSection();
        bottomBar();
        sendMessage("Thor");
        setFrameLocation(960, 50);
        setFrame();
        connect();
    }
}
