package com.hackfse.giveaway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hackfse.giveaway.bean.EventBean;
import com.hackfse.giveaway.services.EventService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/event")
public class EventController {
	
	@Autowired
	EventService eventService;
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public EventBean create(@RequestBody EventBean eventBean) {		
		return eventService.createEvent(eventBean);
	}
	
	@RequestMapping(value="/uploadimage", method = RequestMethod.POST)
	public EventBean uploadimage(@RequestParam("file") MultipartFile file) {		
		return eventService.uploadEventImage(file);
	}
	
	@RequestMapping(value="/get", method = RequestMethod.GET)
	public List<EventBean> getEvent() {		
		return eventService.getEvent();
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public void deleteEvent(@RequestParam String eventId) {		
		eventService.deleteEvent(eventId);
	}

}
