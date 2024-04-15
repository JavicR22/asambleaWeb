package com.demo.backend.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class CalendarService {
    private final String APPLICATION_NAME = "Your Application Name";
    private final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private final List<String> SCOPES = Collections.singletonList(CalendarScopes.CALENDAR);

    @Autowired
    private OAuth2AuthorizedClientService clientService;

    public void createEvent(String accessToken, Event event) throws IOException {
        GoogleCredential credential = new GoogleCredential().setAccessToken(accessToken);

        Calendar service = new Calendar.Builder(
                new NetHttpTransport(),
                JSON_FACTORY,
                credential)
                .setApplicationName(APPLICATION_NAME)
                .build();

        EventAttendee[] attendees = new EventAttendee[] {
                new EventAttendee().setEmail("javicr2209@gmail.com")
        };
        event.setAttendees(Arrays.asList(attendees));

        service.events().insert("primary", event).execute();
    }
}
