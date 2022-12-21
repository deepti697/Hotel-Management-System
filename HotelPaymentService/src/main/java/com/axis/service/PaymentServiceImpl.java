package com.axis.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.feignclient.PaymentClient;
import com.axis.model.Customer;
import com.axis.model.Payment;
import com.axis.model.Room;
import com.axis.repository.PaymentRepository;

@Service
public class PaymentServiceImpl {
	
	@Autowired
	PaymentClient paymentClient;
	
	
    @Autowired
    PaymentRepository paymentRepository;
    
    //@Override
    public Payment getPayment(int id, double roomPrice) {
    	Customer customer=paymentClient.getCustomer(id);
        Room room=paymentClient.getRoomPrice(roomPrice);
        
        double balance=room.getRoomPrice() - customer.getDeposit();
        int roomNo = room.getRoomNo();
        
        String name=customer.getFirstName()+" "+customer.getLastName();
        LocalDateTime customerInTime= customer.getCheckInTime();
        Payment payment=new Payment(name,LocalDateTime.now(),customerInTime,balance,roomNo);
    	
        paymentRepository.insert(payment);
		return payment;
    }
    
    
}
