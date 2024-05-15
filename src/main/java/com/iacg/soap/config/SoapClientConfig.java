package com.iacg.soap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.iacg.soap.client.CalculatorClient;

/**
 * Clase de configuracion de SOAP
 * Se realiza la configuracion de cada cliente SOAP, agregando marshaller.
 * 
 * @author IACG
 */
@Configuration
public class SoapClientConfig {
	
	private final String CONTEXT_PATH_WSDL = "com.iacg.soap.wsdl";
	
	/**
	 * Crea bean marshaller
	 * @return Jaxb2Marshaller
	 */
	@Bean
	Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath(CONTEXT_PATH_WSDL);
		//marshaller.setPackagesToScan(CONTEXT_PATH_WSDL);
		return marshaller;
	}

	/**
	 * Crea bean calculatorClient
	 * @param marshaller
	 * @return CalculatorClient
	 */
	@Bean
	CalculatorClient calculatorClient(Jaxb2Marshaller marshaller) {
		CalculatorClient client = new CalculatorClient();
		client.setDefaultUri(SoapClientUri.CALCULATOR_CLIENT_URI); 
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
	
}//Fin de clase
