package com.iacg.soap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iacg.soap.client.CalculatorClient;
import com.iacg.soap.wsdl.AddResponse;
import com.iacg.soap.wsdl.DivideResponse;
import com.iacg.soap.wsdl.MultiplyResponse;
import com.iacg.soap.wsdl.SubtractResponse;

/**
 * Clase tipo Controller que contiene los endpoints de la API
 * 
 * @author IACG
 */
@RestController
@RequestMapping("/api/v1/calculator")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class CalculatorController {

	/**
	 * Variable calculatorClient
	 */
	@Autowired
	private CalculatorClient calculatorClient;
	
	/**
	 * Metodo GET que realiza la operacion de suma
	 * @param numberA primer numero
	 * @param numberB segundo numero
	 * @return ResponseEntity<?>
	 */
	@GetMapping("/add")
	public ResponseEntity<?> add(@RequestParam(name = "numberA", required = true) int numberA,
								@RequestParam(name = "numberB", required = true) int numberB){
		//Llamar a cliente
		AddResponse response = calculatorClient.getAddResponse(numberA, numberB);
		//Regresar respuesta
		return ResponseEntity.status(HttpStatus.OK).body(response.getAddResult());
	}
	
	/**
	 * Metodo GET que realiza la operacion de resta
	 * @param numberA primer numero
	 * @param numberB segundo numero
	 * @return ResponseEntity<?>
	 */
	@GetMapping("/subtract")
	public ResponseEntity<?> subtract(@RequestParam(name = "numberA", required = true) int numberA,
								@RequestParam(name = "numberB", required = true) int numberB){
		//Llamar a cliente
		SubtractResponse response = calculatorClient.getSubtractResponse(numberA, numberB);
		//Regresar respuesta
		return ResponseEntity.status(HttpStatus.OK).body(response.getSubtractResult());
	}
	
	/**
	 * Metodo GET que realiza la operacion de multiplicacion
	 * @param numberA primer numero
	 * @param numberB segundo numero
	 * @return ResponseEntity<?>
	 */
	@GetMapping("/multiply")
	public ResponseEntity<?> multiply(@RequestParam(name = "numberA", required = true) int numberA,
								@RequestParam(name = "numberB", required = true) int numberB){
		//Llamar a cliente
		MultiplyResponse response = calculatorClient.getMultiplyResponse(numberA, numberB);
		//Regresar respuesta
		return ResponseEntity.status(HttpStatus.OK).body(response.getMultiplyResult());
	}
	
	/**
	 * Metodo GET que realiza la operacion de division
	 * @param numberA primer numero
	 * @param numberB segundo numero
	 * @return ResponseEntity<?>
	 */
	@GetMapping("/divide")
	public ResponseEntity<?> divide(@RequestParam(name = "numberA", required = true) int numberA,
								@RequestParam(name = "numberB", required = true) int numberB){
		//Llamar a cliente
		DivideResponse response = calculatorClient.getDivideResponse(numberA, numberB);
		//Regresar respuesta
		return ResponseEntity.status(HttpStatus.OK).body(response.getDivideResult());
	}
	
}//Fin de clase