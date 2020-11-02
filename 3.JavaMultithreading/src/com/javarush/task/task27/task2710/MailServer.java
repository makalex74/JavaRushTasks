package com.javarush.task.task27.task2710;

public class MailServer implements Runnable {
    private Mail mail;

    public MailServer(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        //сделайте что-то тут - do something here
        //3. В методе run класса MailServer должен присутствовать synchronized блок, монитор - mail.
        synchronized (mail){
            try {
                mail.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String name = Thread.currentThread().getName();
        long endTime = System.currentTimeMillis();
        System.out.format("%s MailServer received: [%s] in %d ms after start", name, mail.getText(), (endTime - startTime));
    }
}

