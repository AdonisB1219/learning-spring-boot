package com.abecerra.learningspring.util;
import com.abecerra.learningspring.data.Room;
import com.abecerra.learningspring.data.RoomRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;



@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent>{

	private final RoomRepository roomRepository;
	

	
	public AppStartupEvent(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}


	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		Iterable<Room> rooms = this.roomRepository.findAll();
		rooms.forEach(System.out::println);
	}
	
}
