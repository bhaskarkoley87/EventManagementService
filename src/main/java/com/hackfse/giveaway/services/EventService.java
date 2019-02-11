package com.hackfse.giveaway.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.hackfse.giveaway.bean.EventBean;
import com.hackfse.giveaway.dao.EventRepository;
import com.hackfse.giveaway.dto.Event;

public class EventService {

	@Autowired
	EventRepository eventRepo;
	
	public EventBean createEvent(List<MultipartFile> files, EventBean eventBean) {
		Event objEvent = new Event();
		objEvent.setAddress(eventBean.getAddress());
		objEvent.setCity(eventBean.getCity());
		objEvent.setContactName(eventBean.getContactName());
		objEvent.setContactno(eventBean.getContactno());
		objEvent.setStartDate(eventBean.getStartDate());
		objEvent.setEndDate(eventBean.getEndDate());
		objEvent.setPic_url_1(eventBean.getPic_url_1());
		objEvent.setPic_url_2(eventBean.getPic_url_2());
		objEvent.setPic_url_3(eventBean.getPic_url_3());
		objEvent.setPic_url_4(eventBean.getPic_url_4());
		eventRepo.save(objEvent);
		return eventBean;
	}

	public List<EventBean> getEvent() {
		List<EventBean> lstEventBean = new ArrayList<>();
		List<Event> lstEvent = eventRepo.findAllByOrderByStartDate();
		for(Event event : lstEvent) {
			EventBean objEventBean = new EventBean();
			objEventBean.setAddress(event.getAddress());
			objEventBean.setCity(event.getCity());
			objEventBean.setContactName(event.getContactName());
			objEventBean.setContactno(event.getContactno());
			objEventBean.setStartDate(event.getStartDate());
			objEventBean.setEndDate(event.getEndDate());
			objEventBean.setPic_url_1(event.getPic_url_1());
			objEventBean.setPic_url_2(event.getPic_url_2());
			objEventBean.setPic_url_3(event.getPic_url_3());
			objEventBean.setPic_url_4(event.getPic_url_4());
			lstEventBean.add(objEventBean);
		}
		return lstEventBean;
	}

}
