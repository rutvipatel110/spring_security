package com.example.demo.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.user.Device;
import com.example.demo.user.DeviceRepository;

@Service
public class DeviceService {

	@Autowired
	private DeviceRepository repository;
	
	public Device createDevice(Device device) {
		return repository.save(device);
	}
	
	public List<Device> getAllDevice(){
		return repository.findAll();
	}
	
	public ResponseEntity<Device> getDeviceById(int id) throws Exception{
        Device device = repository.findById(id)
                .orElseThrow(() -> new Exception("Device not exist with id:" + id));
        return ResponseEntity.ok(device);
	}
	
	public ResponseEntity<Device> updateDevice(int id,Device device) throws Exception{
		Device updateDevice =repository.findById(id)
				.orElseThrow(()-> new Exception("Device not found with id:" +id));
		
		updateDevice.setDevice(device.getDevice());
		updateDevice.setStatus(device.getStatus());
		repository.save(updateDevice);
		return ResponseEntity.ok(updateDevice);
	}
	
	public String deleteDevice(int id) throws Exception {
		Device device =repository.findById(id)
				.orElseThrow(()-> new Exception("Device not found with id:" +id));
		repository.delete(device);
		return "Device deleted succesfully";
	}
}
