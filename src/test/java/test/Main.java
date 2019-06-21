package test;

import java.io.IOException;

import kr.co.torpedo.fileio.config.PropertyLoader;
import kr.co.torpedo.fileio.config.PropertyReader;
import kr.co.torpedo.fileio.factory.SerializerFactory;
import kr.co.torpedo.fileio.parser.Parser;
import kr.co.torpedo.fileio.type.Path;

/**
 * 프로그램 실행시키기 위한 메인 클래스
 * 
 * @author user
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		InitiateData initiateData = new InitiateData();
		PropertyLoader propertyLoader = new PropertyLoader();
		propertyLoader.loadProp(Path.PROPERTY.getName());
		PropertyReader reader = new PropertyReader(propertyLoader.getProperties());
		Parser parser;

		String format = reader.getFileFormat();
		String dir = reader.getDir();
		parser = SerializerFactory.makeSerializer(format, dir);
		initiateData.addEmployeeToList();
		parser.setDataManager(initiateData.getDataManager());
		parser.setSawonPath();
		parser.serializeEmployee();
		parser.deSerializeEmployee();
		parser.getDataManager().showEmployeeList();

		initiateData.addEmployeeToList();
		initiateData.addInternToList();
		parser.setInternPath();
		parser.serializeWithIntern();
		parser.deSrializeWithIntern();
		parser.getDataManager().showEmployeeList();
	}
}
