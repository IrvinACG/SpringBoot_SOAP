package com.iacg.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.iacg.soap.config.SoapClientUri;
import com.iacg.soap.wsdl.Add;
import com.iacg.soap.wsdl.AddResponse;
import com.iacg.soap.wsdl.Divide;
import com.iacg.soap.wsdl.DivideResponse;
import com.iacg.soap.wsdl.Multiply;
import com.iacg.soap.wsdl.MultiplyResponse;
import com.iacg.soap.wsdl.Subtract;
import com.iacg.soap.wsdl.SubtractResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * Clase que se encarga de gestionar la logica del Servicio Web.
 * 
 * @author IACG
 */
@Slf4j
public class CalculatorClient extends WebServiceGatewaySupport{

	/**
	 * Metodo que se encarga de sumar dos numeros
	 * @param numberA primer numero
	 * @param numberB segundo numero
	 * @return AddResponse
	 */
	public AddResponse getAddResponse(int numberA, int numberB) {
		//Crea request de SOAP
		Add addRequest = new Add();
		addRequest.setIntA(numberA);
		addRequest.setIntB(numberB);
		log.info("Servicio: CalculatorClient, Operacion: getAddResponse, se crea request");
		//Configura peticion. Obtener targetNamespace + element name
		SoapActionCallback soapActionCallback = new SoapActionCallback("http://tempuri.org/Add");
		//Realiza peticion SOAP
		AddResponse addResponse = (AddResponse) getWebServiceTemplate().marshalSendAndReceive(SoapClientUri.CALCULATOR_CLIENT_URI, addRequest, soapActionCallback);
		log.info("Servicio: CalculatorClient, Operacion: getAddResponse, se crea response");
		//Regresa respuesta
		return addResponse;
	}
	
	/**
	 * Metodo que se encarga de restar dos numeros
	 * @param numberA primer numero
	 * @param numberB segundo numero
	 * @return SubtractResponse
	 */
	public SubtractResponse getSubtractResponse(int numberA, int numberB) {
		//Crea request de SOAP
		Subtract subtractRequest = new Subtract();
		subtractRequest.setIntA(numberA);
		subtractRequest.setIntB(numberB);
		//Configura peticion. Obtener targetNamespace + element name
		SoapActionCallback soapActionCallback = new SoapActionCallback("http://tempuri.org/Subtract");
		//Realiza peticion SOAP
		SubtractResponse subtractResponse = (SubtractResponse) getWebServiceTemplate().marshalSendAndReceive(SoapClientUri.CALCULATOR_CLIENT_URI, subtractRequest, soapActionCallback);
		//Regresa respuesta
		return subtractResponse;
	}
	
	/**
	 * Metodo que se encarga de realizar la multiplicacion de dos numeros
	 * @param numberA primer numero
	 * @param numberB segundo numero
	 * @return MultiplyResponse
	 */
	public MultiplyResponse getMultiplyResponse(int numberA, int numberB) {
		//Crea request de SOAP
		Multiply multiplyRequest = new Multiply();
		multiplyRequest.setIntA(numberA);
		multiplyRequest.setIntB(numberB);
		//Configura peticion. Obtener targetNamespace + element name
		SoapActionCallback soapActionCallback = new SoapActionCallback("http://tempuri.org/Multiply");
		//Realiza peticion SOAP
		MultiplyResponse multiplyResponse = (MultiplyResponse) getWebServiceTemplate().marshalSendAndReceive(SoapClientUri.CALCULATOR_CLIENT_URI, multiplyRequest, soapActionCallback);
		//Regresa respuesta
		return multiplyResponse;
	}
	
	/**
	 * Metodo que se encarga de dividir dos numeros
	 * @param numberA primer numero
	 * @param numberB segundo numero
	 * @return DivideResponse
	 */
	public DivideResponse getDivideResponse(int numberA, int numberB) {
		//Crea request de SOAP
		Divide divideRequest = new Divide();
		divideRequest.setIntA(numberA);
		divideRequest.setIntB(numberB);
		//Configura peticion. Obtener targetNamespace + element name
		SoapActionCallback soapActionCallback = new SoapActionCallback("http://tempuri.org/Divide");
		//Realiza peticion SOAP
		DivideResponse divideResponse = (DivideResponse) getWebServiceTemplate().marshalSendAndReceive(SoapClientUri.CALCULATOR_CLIENT_URI, divideRequest, soapActionCallback);
		//Regresa respuesta
		return divideResponse;
	}
	
}//Fin de clase
