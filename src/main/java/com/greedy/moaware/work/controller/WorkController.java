package com.greedy.moaware.work.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greedy.moaware.common.ResponseDto;
import com.greedy.moaware.common.paging.Pagenation;
import com.greedy.moaware.common.paging.PagingButtonInfo;
import com.greedy.moaware.common.paging.ResponseDtoWithPaging;
import com.greedy.moaware.employee.dto.AuthEmpDto;
import com.greedy.moaware.employee.dto.EmpDto;
import com.greedy.moaware.work.dto.WorkDto;
import com.greedy.moaware.work.dto.WorkEmpDto2;
import com.greedy.moaware.work.dto.WorkPkDto;
import com.greedy.moaware.work.dto.WorkTimeDto;
import com.greedy.moaware.work.service.WorkService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/work")
public class WorkController {

	private final WorkService workService;

	public WorkController(WorkService workService) {
		this.workService = workService;
	}

	/* 자기 근태 현항 조회 */
	@GetMapping("/works/{workDate}")
	public ResponseEntity<ResponseDto> myWorkList(@AuthenticationPrincipal AuthEmpDto emp,
			@PathVariable String workDate, @RequestParam(name = "page", defaultValue = "1") int page) {


		// workDate를 Date 타입으로 파싱
		// 객체에 담아서 보낸게 아닌 문자열 그대로 보냈기 때문에 이렇게 파싱한다.
		Date parsedDate = null;
		try {
			parsedDate = new SimpleDateFormat("yyyy-MM").parse(workDate);
		} catch (ParseException e) {

			e.printStackTrace();

		}

		Page<WorkDto> workDtoList = workService.selectMyWorkList(emp.getEmpCode(), parsedDate, page);
		PagingButtonInfo pageInfo = Pagenation.getPagingButtonInfo(workDtoList);

		ResponseDtoWithPaging responseDtoWithPaging = new ResponseDtoWithPaging();
		responseDtoWithPaging.setPageInfo(pageInfo);
		responseDtoWithPaging.setData(workDtoList.getContent());


		return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "내 근태 현황 조회 완료", responseDtoWithPaging));
	}
	
	/* 자기 근태 현항 일일 조회 */
	@GetMapping("/works/day/{workDate}")
	public ResponseEntity<ResponseDto> myWorkDay(@AuthenticationPrincipal AuthEmpDto emp,
			@PathVariable String workDate) {



		// workDate를 Date 타입으로 파싱
		// 객체에 담아서 보낸게 아닌 문자열 그대로 보냈기 때문에 이렇게 파싱한다.
		Date parsedDate = null;
		try {
			parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(workDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		

		return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "조회 성공", workService.selectMywork(emp.getEmpCode(), parsedDate)/* 반환 된 ReviewDto 객체 담기*/));	
	}

	/* 사원 번호 + 날짜로 조회 */
	@GetMapping("/works/{empCode}/{workDate}")
	public ResponseEntity<ResponseDto> selectWorkList(@PathVariable Integer empCode, @PathVariable String workDate,
			@RequestParam(name = "page", defaultValue = "1") int page) {


		// 객체에 담아서 보낸게 아닌 문자열 그대로 보냈기 때문에 이렇게 파싱한다.
		Date parsedDate = null;
		try {
			parsedDate = new SimpleDateFormat("yyyy-MM").parse(workDate);
		} catch (ParseException e) {

			e.printStackTrace();

		}

		Page<WorkDto> workDtoList = workService.selectWorkList(empCode, parsedDate, page);

		PagingButtonInfo pageInfo = Pagenation.getPagingButtonInfo(workDtoList);

		ResponseDtoWithPaging responseDtoWithPaging = new ResponseDtoWithPaging();
		responseDtoWithPaging.setPageInfo(pageInfo);
		responseDtoWithPaging.setData(workDtoList.getContent());


		return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "조회 성공", responseDtoWithPaging));
	}

	/* 이름으로 출근 정보 조회 */
	@GetMapping("emp/name/{name}/{workDate}")
	public ResponseEntity<ResponseDto> getEmployeeByName(@PathVariable String name, @PathVariable String workDate, @RequestParam(name = "page", defaultValue = "1") int page) {
		
		Date parsedDate = null;
		try {
			parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(workDate);
		} catch (ParseException e) {

			e.printStackTrace();

		}
		
		Page<WorkEmpDto2> workEmpList = workService.findByEmpName(name, page, parsedDate);

		PagingButtonInfo pageInfo = Pagenation.getPagingButtonInfo(workEmpList);

		ResponseDtoWithPaging responseDtoWithPaging = new ResponseDtoWithPaging();
		responseDtoWithPaging.setPageInfo(pageInfo);
		responseDtoWithPaging.setData(workEmpList.getContent());

		return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "이름조회성공", responseDtoWithPaging));

	}

	@GetMapping("emp/name/{name}/{workDate2}/{workDate}")
	public ResponseEntity<ResponseDto> empWorkList(@PathVariable String name, @PathVariable String workDate2,
			@PathVariable String workDate,
			@RequestParam(name = "page", defaultValue = "1") int page) {
		
		Date parsedDate2 = null;
		try {
			parsedDate2 = new SimpleDateFormat("yyyy-MM-dd").parse(workDate2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Date parsedDate = null;
		try {
			parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(workDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		Page<WorkDto> workDtoList = workService.empNameWorkList(name, parsedDate2, parsedDate, page);
		PagingButtonInfo pageInfo = Pagenation.getPagingButtonInfo(workDtoList);
		
		ResponseDtoWithPaging responseDtoWithPaging = new ResponseDtoWithPaging();
		responseDtoWithPaging.setPageInfo(pageInfo);
		responseDtoWithPaging.setData(workDtoList.getContent());
		
		
		return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "직원 월 현황 조회 완료", responseDtoWithPaging));
		
	}
	/* 출근 버튼 클릭시 인서트 */
	@PostMapping("start")
	public ResponseEntity<ResponseDto> insertStart(@AuthenticationPrincipal AuthEmpDto emp,
			@RequestBody String workDate) {

		// 객체에 담아서 보낸게 아닌 문자열 그대로 보냈기 때문에 이렇게 파싱한다.
		Date parsedDate = null;
		try {
			parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(workDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		WorkTimeDto workTimeDto = new WorkTimeDto();

		WorkPkDto workPkDto = new WorkPkDto();
		workPkDto.setEmpCode(emp.getEmpCode());
		workPkDto.setWorkDate(parsedDate);

		workTimeDto.setWorkPk(workPkDto);


		workService.insertStart(workTimeDto);

		return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "출근등록 완료"));
	}

	@PutMapping("quit")
	public ResponseEntity<ResponseDto> timeQuit(@AuthenticationPrincipal AuthEmpDto emp, @RequestBody String quitTime) {

		Date parsedDate = null;
		try {
			parsedDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(quitTime);
		} catch (ParseException e) {

			e.printStackTrace();

		}

		WorkTimeDto workTimeDto = new WorkTimeDto();

		WorkPkDto workPkDto = new WorkPkDto();
		workPkDto.setEmpCode(emp.getEmpCode());
		workTimeDto.setQuitTime(parsedDate);
		workTimeDto.setWorkPk(workPkDto);


		workService.quitTime(workTimeDto);

		return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "퇴근등록 완료"));
	}

	/* 관리자 직원 일일 출근 조회 */
	@GetMapping("admin/{date}")
	public ResponseEntity<ResponseDto> empWorkList(@AuthenticationPrincipal AuthEmpDto emp, @PathVariable String date,
			@RequestParam(name = "page", defaultValue = "1") int page) {

		Date parsedDate = null;
		try {
			parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Page<WorkEmpDto2> workDtoList = workService.empWorkList1(parsedDate, page);
		PagingButtonInfo pageInfo = Pagenation.getPagingButtonInfo(workDtoList);

		ResponseDtoWithPaging responseDtoWithPaging = new ResponseDtoWithPaging();
		responseDtoWithPaging.setPageInfo(pageInfo);
		responseDtoWithPaging.setData(workDtoList.getContent());


		return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "직원 일일 현황 조회 완료", responseDtoWithPaging));

	}
	

	@PutMapping("status/modify")
	public ResponseEntity<ResponseDto> empStatusModify(@RequestBody WorkDto workDto) {


		workService.statusUpdate(workDto);

		return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "출결 변경 완료"));
	}

}
