package com.example.FeesDetails.FeesService;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FeesDetails.Entity.Fees;
import com.example.FeesDetails.FeesRepo.FeesRepo;
import com.example.FeesDetails.Response.FeesResponse;


@Service
public class FeesService {

	    @Autowired
	    private FeesRepo feesRepo;

	    @Autowired
	    private ModelMapper mapper;
	 
	    public FeesResponse findFeesByStudentId(int studentId) {
	        Optional<Fees> feesByStudentId = feesRepo.findFeesByStudentId((long) studentId);
	        FeesResponse feesResponse = mapper.map(feesByStudentId, FeesResponse.class);
	        return feesResponse;
	    }
	    
//	    public FeesEntity createFeesDetails(FeesEntity feesEntity) {
//			return feeDetailsRepository.save(feesEntity);
//		}
//
//		public List<FeesEntity> getFeesDetailsList() {
//			return feeDetailsRepository.findAll();
//		}
//
//		public FeesEntity getFeesDetailsById(Long studentId) {
//			return feeDetailsRepository.findById(studentId).orElse(null);
//
//		}
//
//		public FeesEntity updateFeesDetails(Long id, FeesEntity feesEntity) {
//
//			return feeDetailsRepository.save(feesEntity);
//		}
//
//		public FeesEntity deleteFeesDetails(FeesEntity feesEntity) {
//			feeDetailsRepository.delete(feesEntity);
//			return feesEntity;
//		}
}
