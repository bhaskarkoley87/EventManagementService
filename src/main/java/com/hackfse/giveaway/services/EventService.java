package com.hackfse.giveaway.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.hackfse.giveaway.services.FileUploadService;
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
	
	public EventBean createEvent(List<MultipartFile> files, EventBean eventBean) {
		List<String> lnsFilePath = objFileUploadService.uploadFiles(files);
		if(lnsFilePath != null) {
			if(lnsFilePath.size() > 0) {
				isFileSaved = true;
				eventBean.setPic_url_1(lnsFilePath.get(0));
				eventBean.setPic_url_2(lnsFilePath.get(1));
				eventBean.setPic_url_3(lnsFilePath.get(2));
				eventBean.setPic_url_4(lnsFilePath.get(3));
			}
		}
		
		if(isFileSaved) {
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

}
