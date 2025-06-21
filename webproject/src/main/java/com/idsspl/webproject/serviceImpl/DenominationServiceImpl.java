package com.idsspl.webproject.serviceImpl;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.idsspl.webproject.entity.CollectionInfoEntity;
import com.idsspl.webproject.entity.CustomerEntity;
import com.idsspl.webproject.entity.Denomination;
import com.idsspl.webproject.entity.DenominationSummaryEntity;
import com.idsspl.webproject.entity.DenominationViewEntity;
import com.idsspl.webproject.entity.UserEntity;
import com.idsspl.webproject.model.CollectionInfoModel;
import com.idsspl.webproject.model.DenominationRequest;
import com.idsspl.webproject.repo.CustomerRepo;
import com.idsspl.webproject.repo.DenominationRepository;
import com.idsspl.webproject.repo.DenominationSummaryRepository;
import com.idsspl.webproject.repo.DenominationViewRepository;
import com.idsspl.webproject.repo.UserRepo;

@Service

public class DenominationServiceImpl {

	@Autowired
	private DenominationRepository denominationRepository;

	@Autowired
	private DenominationViewRepository denominationviewRepository;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private DenominationSummaryRepository denominationsummaryRepository;

	public void save(DenominationRequest request, String userName) {

		Denomination entity = new Denomination();
		///// TO GENERATE THE RANDOM UNIQUE ID
		String CHARACTERS = "0123456789";
		Random random = new Random();
		StringBuilder sb = new StringBuilder(10);
		for (int i = 0; i < 10; i++) {
			int index = random.nextInt(CHARACTERS.length());
			char randomChar = CHARACTERS.charAt(index);
			sb.append(randomChar);
		}
		String id = sb.toString();
		UserEntity userEntity = null;
		userEntity = userRepo.findByUserName(userName);

		entity.setId(Long.parseLong(id));

		System.out.println("====" + request.getAsondate());

		entity.setAmountReceived(request.getAmountReceived());
		entity.setTotalAmount(request.getTotalAmount());
		entity.setChangeReturn(request.getChangeReturn());
		entity.setCustomerId(request.getCustomerId());
		entity.setAgentId(userEntity.getAgentId());
		entity.setAgentName(userName);
		entity.setReceiptNo(request.getReceiptNo());
		entity.setCreatedAt(LocalDateTime.now());

		entity.setR2000(request.getR2000());
		entity.setR500(request.getR500());
		entity.setR200(request.getR200());
		entity.setR100(request.getR100());
		entity.setR50(request.getR50());
		entity.setR20(request.getR20());
		entity.setR10(request.getR10());
		entity.setR5(request.getR5());
		entity.setR2(request.getR2());
		entity.setR1(request.getR1());

		entity.setC2000(request.getC2000());
		entity.setC500(request.getC500());
		entity.setC200(request.getC200());
		entity.setC100(request.getC100());
		entity.setC50(request.getC50());
		entity.setC20(request.getC20());
		entity.setC10(request.getC10());
		entity.setC5(request.getC5());
		entity.setC2(request.getC2());
		entity.setC1(request.getC1());
		entity.setDenominationdate(request.getAsondate().toUpperCase());
		entity.setOnlineAmt(request.getOnlineAmt());
//			System.out.println("request.getAmountReceived()====="+request.getAmountReceived());
//			System.out.println("request.getC100()====="+request.getC100());
//			System.out.println("denomination entty====" + entity);
		denominationRepository.save(entity);

	}

	public List<DenominationRequest> getDenominationInfoList(DenominationRequest request, String userName,
			String type) {
		List<Denomination> denominationEntityList = null;
		UserEntity userEntity = null;

		userEntity = userRepo.findByUserName(userName);

		String agentId = userEntity.getAgentId();
		String agentName = userName;
//		System.out.println("agentId in collection list----------" + agentId);
		System.out.println("agentName in collection list----------" + agentName);
		System.out.println("getAsondate in denomination list----------" + request.getAsondate().toUpperCase());

//		List<Denomination> denominationEntities = denominationRepository.findAll(Sort.by("receiptNo")); // or your custom query
		List<Denomination> denominationEntities;

		// Group by receiptNo (or a composite key if needed)
//		Map<String, List<Denomination>> groupedByReceipt = denominationEntities.stream()
//		        .collect(Collectors.groupingBy(Denomination::getReceiptNo));

//		List<DenominationRequest> DenominationModelList = new ArrayList<>();

		/*
		 * for (Map.Entry<String, List<Denomination>> entry :
		 * groupedByReceipt.entrySet()) { List<Denomination> group = entry.getValue();
		 * if (group.isEmpty()) continue;
		 * 
		 * Denomination first = group.get(0); // assume all share the same meta-data
		 * (agent, customer, etc.)
		 * 
		 * DenominationRequest req = new DenominationRequest();
		 * req.setReceiptNo(first.getReceiptNo()); //
		 * req.setCustomerId(first.getCustomerId()); //
		 * req.setAccountCode(first.getAccountCode()); //
		 * req.setAgentId(first.getAgentId()); req.setAgentName(first.getAgentName());
		 * req.setAmountReceived(first.getAmountReceived());
		 * req.setTotalAmount(first.getTotalAmount());
		 * req.setChangeReturn(first.getChangeReturn());
		 * 
		 * List<DenominationRequest.NoteEntry> notes = group.stream() .map(e -> {
		 * DenominationRequest.NoteEntry note = new DenominationRequest.NoteEntry();
		 * note.setValue(e.getNoteValue()); note.setCount(e.getNoteCount()); return
		 * note; }) .collect(Collectors.toList());
		 * 
		 * req.setDenominations(notes); DenominationModelList.add(req); }
		 */

		if (type.equals("return")) {
			denominationEntityList = denominationRepository.findInfoByAgentNameReturn(agentName,
					request.getAsondate().toUpperCase());
		} else {
			denominationEntityList = denominationRepository.findInfoByAgentName(agentName,
					request.getAsondate().toUpperCase());// or your custom query
		}
//		  denominationEntityList = denominationRepository.findAll();

		List<DenominationRequest> DenominationModelList = new ArrayList<>();

		denominationEntityList.stream().forEach(denominationEntity -> {
			DenominationRequest denominationModel = new DenominationRequest();
			denominationModel.setAgentName(denominationEntity.getAgentName());
			denominationModel.setCustomerId(denominationEntity.getCustomerId());
			denominationModel.setReceiptNo(denominationEntity.getReceiptNo());
			denominationModel.setAsondate(denominationEntity.getDenominationdate());
			denominationModel.setAmountReceived(denominationEntity.getAmountReceived());
			denominationModel.setTotalAmount(denominationEntity.getTotalAmount());
			denominationModel.setChangeReturn(denominationEntity.getChangeReturn());
			denominationModel.setOnlineAmt(denominationEntity.getOnlineAmt());

			Long offlineamt = denominationEntity.getAmountReceived();
			Long onlineamount = denominationEntity.getOnlineAmt();

			Long totalofflineonline = offlineamt + onlineamount;
//			System.out.println("===totalofflineonline==="+totalofflineonline);
			denominationModel.setOnlineOfflineAmt(totalofflineonline);
			List<CustomerEntity> customerentity = customerRepo.findByCustomerId(denominationEntity.getCustomerId());

			customerentity.stream().forEach(customer -> {

				denominationModel.setCustomerName(customer.getName());
			});

			if (type.equals("return")) {
				denominationModel.setR2000(denominationEntity.getC2000());
				denominationModel.setR500(denominationEntity.getC500());
				denominationModel.setR200(denominationEntity.getC200());
				denominationModel.setR100(denominationEntity.getC100());
				denominationModel.setR50(denominationEntity.getC50());
				denominationModel.setR20(denominationEntity.getC20());
				denominationModel.setR10(denominationEntity.getC10());
				denominationModel.setR5(denominationEntity.getC5());
				denominationModel.setR2(denominationEntity.getC2());
				denominationModel.setR1(denominationEntity.getC1());
			} else {
				denominationModel.setR2000(denominationEntity.getR2000());
				denominationModel.setR500(denominationEntity.getR500());
				denominationModel.setR200(denominationEntity.getR200());
				denominationModel.setR100(denominationEntity.getR100());
				denominationModel.setR50(denominationEntity.getR50());
				denominationModel.setR20(denominationEntity.getR20());
				denominationModel.setR10(denominationEntity.getR10());
				denominationModel.setR5(denominationEntity.getR5());
				denominationModel.setR2(denominationEntity.getR2());
				denominationModel.setR1(denominationEntity.getR1());
			}

			System.out.println("type=====" + type + "====" + denominationModel.getR100());

			DenominationModelList.add(denominationModel);
		});

		return DenominationModelList;
	}
	
	

	public List<DenominationSummaryEntity> getDenominationSummaryList( String userName,String denominationdate) {
//		List<DenominationSummaryEntity> denominationsummaryentity = null;
//		System.out.println("getAsondate in denomination list----------" + request.getAsondate().toUpperCase());
		List<DenominationSummaryEntity> denominationsummaryentity = denominationsummaryRepository.findInfoByAgentName(userName,denominationdate);
		
		return denominationsummaryentity;
	}

}
