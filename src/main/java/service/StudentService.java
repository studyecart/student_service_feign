package service;

import entity.Student;
import feignclients.AddressFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.StudentRepository;
import request.CreateStudentRequest;
import response.StudentResponse;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

/*	@Autowired
	WebClient webclient;*/

	@Autowired
	AddressFeignClient addressFeignClient;

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());
		
		student.setAddressId(createStudentRequest.getAddressId());
		student = studentRepository.save(student);
		StudentResponse studentResponse=new StudentResponse(student);
		//studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));
		return studentResponse;
	}
	
	public StudentResponse getById (long id) {

		Student student=studentRepository.findById(id).get();

		StudentResponse studentResponse=new StudentResponse(student);
		//studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));
		return studentResponse;
	}

/*	public AddressResponse getAddressById(long addressId){
		Mono<AddressResponse> addressResponse=  webclient.get().uri("/getById/"+addressId).retrieve().bodyToMono(AddressResponse.class);
return  addressResponse.block();
}*/

}
