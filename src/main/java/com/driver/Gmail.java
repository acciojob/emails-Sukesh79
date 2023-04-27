package com.driver;

import java.util.ArrayList;
import java.util.Date;

class Mail{
    String message;
    String sender;
    Date date;
    public Mail(String message, Date date, String sender){
        this.message = message;
        this.date = date;
        this.sender = sender;
    }
}
public class Gmail extends Email {

    ArrayList<Mail> list;
    ArrayList<Mail> trash;
    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        list = new ArrayList<>();
        trash = new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        list.add(new Mail(message, date, sender));
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        for(Mail mail : list){
            if(mail.message.equals(message)){
                trash.add(mail);
                list.remove(mail);
                break;
            }
        }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        return list.get(list.size()-1).message;
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        return list.get(0).message;
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        Integer startidx = null;
        Integer endidx = null;
        int i = 0;

        for(Mail mail : list){
            if(mail.date == start){
                startidx = i;
            }
            else if(mail.date == end){
                endidx = i;
            }
            i++;
        }

        if(startidx != null && endidx !=null) return endidx - startidx + 1;
        return 0;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return list.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        trash.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return this.inboxCapacity;
    }

    public ArrayList<Mail> getList() {
        return list;
    }

    public void setList(ArrayList<Mail> list) {
        this.list = list;
    }

    public ArrayList<Mail> getTrash() {
        return trash;
    }

    public void setTrash(ArrayList<Mail> trash) {
        this.trash = trash;
    }

    public void setInboxCapacity(int inboxCapacity) {
        this.inboxCapacity = inboxCapacity;
    }
}
