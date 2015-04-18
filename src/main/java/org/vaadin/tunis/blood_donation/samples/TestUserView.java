package org.vaadin.tunis.blood_donation.samples;

import javax.annotation.PostConstruct;

import org.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name=TestUserView.VIEW_NAME)
public class TestUserView extends VerticalLayout implements View{
	
	public static final String VIEW_NAME = "users";

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void init(){
		addComponent(new Label("Users size : "+userRepository.count()));
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}
