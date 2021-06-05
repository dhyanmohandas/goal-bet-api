package com.app.goalbet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.app.goalbet.api.GetUserDetailsApi;
import com.app.goalbet.api.InfoApi;
import com.app.goalbet.models.UserData;


@RestController
@CrossOrigin
public class GoalBetController implements GetUserDetailsApi, InfoApi{

	@Override
	 public ResponseEntity<List<UserData>> getUserDetails(){
		 List<UserData> userList = new ArrayList<UserData>();
		 UserData ud1 = new UserData();
		 ud1.setId(2);
		 ud1.setName("Vishak");
		 userList.add(ud1);
		 UserData ud2 = new UserData();
		 ud2.setId(4);
		 ud2.setName("Yuvraj");
		 userList.add(ud2);
		 UserData ud3 = new UserData();
		 ud3.setId(5);		 
		 ud3.setName("Ramu");
		 userList.add(ud3);
		 UserData ud4 = new UserData();
		 ud4.setId(7);
		 ud4.setName("Barko");
		 userList.add(ud4);
		return new ResponseEntity<List<UserData>>(userList,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> getInfo() {
		return new ResponseEntity<String>("Goal-Bet Version1", HttpStatus.OK);
	}
	
}
