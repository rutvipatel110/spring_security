package com.example.demo.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.Device;

@RestController
@RequestMapping("/api/v1/device")
public class DeviceController {

	@Autowired 
	DeviceService service;
	
	@PostMapping("/saveDevice")
	@PreAuthorize("hasRole('ADMIN')")
	public Device saveDevice(@RequestBody Device device) {
		return service.createDevice(device);
	}
 
	@GetMapping("/getAllDevice")
	@PreAuthorize("hasRole('USER')")
	public List<Device> getAllDevice(){
		return service.getAllDevice();
	}
	
	@GetMapping("/getDeviceById/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Device> getDeviceById(@PathVariable("id") int id) throws Exception{
		return service.getDeviceById(id);
	}
	
	@PutMapping("/updateDevice/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Device> updateDevice(@PathVariable("id") int id, @RequestBody Device device ) throws Exception{
		return service.updateDevice(id, device);
	}
	
	@DeleteMapping("/deleteDevice/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteDevice(@PathVariable("id") int id) throws Exception {
		return service.deleteDevice(id);
	}
}
