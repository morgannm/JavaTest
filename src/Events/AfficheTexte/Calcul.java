package Events.AfficheTexte;

import java.util.ArrayList;

/**
 * Created by morgannm on 12/09/2016.
 */
public class Calcul {
    private ArrayList<MessageListener> messageListenerList = new ArrayList<MessageListener>();

    public Calcul()
    {
    }

    public void Calculate() {

        for (int i = 0 ; i < 100000; i++ ) {
            processMessageEvent("Itération : " + i);
        }
    }

    // Register an event listener
    public synchronized void addMessageListener(MessageListener listener) {
        if (!messageListenerList.contains(listener)) {
            messageListenerList.add(listener);
        }
    }

    private void processMessageEvent(String message) {
        ArrayList<MessageListener> tempMessageListenerList;

        synchronized (this) {
            if (messageListenerList.size() == 0) {
                return;
            }
            tempMessageListenerList = (ArrayList<MessageListener>) messageListenerList.clone();
        }

        for (MessageListener listener : tempMessageListenerList) {
            listener.displayMessage(message);
        }
    }
}
