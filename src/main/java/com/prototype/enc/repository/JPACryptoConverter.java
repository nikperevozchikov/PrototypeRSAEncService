//package com.example.crypt.repository;
//
//import RSAConfiguration;
//import EncryptionPrototypeService;
//import EncryptionPrototypeServiceImpl;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.persistence.AttributeConverter;
//import javax.persistence.Converter;
//import java.security.KeyPair;
//import java.security.PrivateKey;
//import java.security.PublicKey;

//@Converter
//@Slf4j
//public class JPACryptoConverter implements AttributeConverter<String, String> {
//	private static Logger log = LoggerFactory.getLogger(JPACryptoConverter.class);
//	private EncryptionPrototypeServiceImpl encryptionExampleService;
//
//	private static final String ENCRYPT = "ENCRYPT";
//
//	private static final String DECRYPT = "DECRYPT";
//	private RSAConfiguration RSAConfiguration;
//
//	@Override
//	public String convertToDatabaseColumn(String sensitive) {
//		if (sensitive == null) { // Don't do anything if the value is null
//			return null;
//		}
//
//			return encryptDecryptString(sensitive, ENCRYPT);
//
//	}
//
//	@Override
//	public String convertToEntityAttribute(String sensitive) {
//		if (sensitive == null) {
//			return null;
//		}
//
//
//			return encryptDecryptString(sensitive, DECRYPT);
//
//
//	}
//

//	private String encryptDecryptString(String sensitive, String encryptDecrypt)  {
//
//		try {
//
//			if (encryptionExampleService == null && StringUtils.equalsIgnoreCase(encryptDecrypt, ENCRYPT) ) {
//				//log.info("ENCRYPTION_KEY: " + EnvironmentProperties.ENCRYPTION_KEY);
//encryptionExampleService = (EncryptionPrototypeServiceImpl) RSAConfiguration.getPublicKey();
//				return encryptionExampleService.encryptE(sensitive);
//
//			} else if(encryptionExampleService == null && StringUtils.equalsIgnoreCase(encryptDecrypt, DECRYPT)) {
//
//				//return encryptionExampleService.decryptD(sensitive);
//			}
//		} catch(Exception e) {
//			//log.error("***** Exception: " + e.getMessage());
//			throw new RuntimeException();
//		}
//
//		return null;
//	}
//
//}
