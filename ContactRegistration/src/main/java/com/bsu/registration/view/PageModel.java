package com.bsu.registration.view;

import com.bsu.registration.handler.Action;
import com.bsu.registration.handler.PaginationDirection;
import com.bsu.registration.model.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gbondarchuk
 */
public class PageModel {
    private Contact current = new Contact();
    private Action action;
    private String requestUrl;
    private List<Contact> contacts = new ArrayList<>();
    private PaginationDirection direction;

    public PaginationDirection getDirection() {
        return direction;
    }

    public void setDirection(PaginationDirection direction) {
        this.direction = direction;
    }

    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Contact getCurrent() {
        return current;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
