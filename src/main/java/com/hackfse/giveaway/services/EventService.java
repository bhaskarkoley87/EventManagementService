package com.hackfse.giveaway.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hackfse.giveaway.bean.EventBean;
import com.hackfse.giveaway.dao.EventRepository;
import com.hackfse.giveaway.dto.Event;

@Service
public class EventService {

	@Autowired
	EventRepository eventRepo;
	
	@Autowired
	FileUploadService objFileUploadService;
	
	boolean isFileSaved;
	
	public EventBean uploadEventImage(MultipartFile files) {
		List<String> lnsFilePath = objFileUploadService.uploadFiles(files);
		if(lnsFilePath != null) {
			if(lnsFilePath.size() > 0) {
				Event objEvent = new Event();
				objEvent.setPic_url_1(lnsFilePath.get(0));
				objEvent.setStatus(0L);				
				objEvent = eventRepo.save(objEvent);
				
				EventBean eventBean = new EventBean();
				eventBean.setPic_url_1(objEvent.getPic_url_1());
				eventBean.setId(objEvent.getId());
				return eventBean;
			}else {
				return null;
			}
		}else {
			return null;
		}	
		
	}

	public List<EventBean> getEvent() {
		List<EventBean> lstEventBean = new ArrayList<>();
		List<Event> lstEvent = eventRepo.findAllByOrderByStartDate();
		for(Event event : lstEvent) {
			EventBean objEventBean = new EventBean();
			objEventBean.setAddress(event.getAddress());
			objEventBean.setEventName(event.getEventName());
			objEventBean.setEventDescription(event.getEventDescription());
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

	public void deleteEvent(String eventId) {		
		eventRepo.deleteById(Long.valueOf(eventId));;
	}

	public EventBean createEvent(EventBean eventBean) {
		Event objEvent = new Event();
		objEvent.setId(eventBean.getId());
		objEvent.setAddress(eventBean.getAddress());
		objEvent.setCity(eventBean.getCity());
		objEvent.setEventName(eventBean.getEventName());
		objEvent.setEventDescription(eventBean.getEventDescription());
		objEvent.setContactName(eventBean.getContactName());
		objEvent.setContactno(eventBean.getContactno());
		objEvent.setStartDate(new Date());
		objEvent.setEndDate(eventBean.getEndDate());
		objEvent.setPic_url_1(eventBean.getPic_url_1());
		objEvent.setPic_url_2(eventBean.getPic_url_2());
		objEvent.setPic_url_3(eventBean.getPic_url_3());
		objEvent.setPic_url_4(eventBean.getPic_url_4());
		eventRepo.save(objEvent);
		return eventBean;
	}

}
