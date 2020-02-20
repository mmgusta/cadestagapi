package com.qintess.cadestag.carga.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.qintess.cadestag.models.Estagiario;
import com.qintess.cadestag.models.SituacaoAtual;
import com.qintess.cadestag.repositories.EstagRepository;

@Service
public class CargaService {
	
	@Autowired
	private EstagRepository estagRepository;
	
	private Map<Integer, String> situacaoAtualMap = new HashMap<Integer, String>();

	public CargaService() {
		situacaoAtualMap.put(1, "Estagio");
		situacaoAtualMap.put(2, "Junior");
		situacaoAtualMap.put(3, "Futuro Contratado");
		situacaoAtualMap.put(4, "Contratado Provisório");
		situacaoAtualMap.put(5, "Transferida");
	}
	
	public boolean realizaCarga() {
		
		System.out.println("inicio da carga batch");
		
		Resource resource = new ClassPathResource("estagscsv.csv");
		
		try {
			File arquivoCsv = resource.getFile();
			
			CSVReader csv = new CSVReader(new FileReader(arquivoCsv));
			
			List<String[]> listaAux = csv.readAll();
			
			for (int i = 0; i < listaAux.size(); i++) {
				
				Estagiario estagiario = new Estagiario();
				
				String[] coluna = listaAux.get(i);
				
		        estagiario.setPendencias(coluna[0]);
		        estagiario.setCliente(coluna[1]);
		        estagiario.setContratoOk(coluna[2]);
		        estagiario.setNome(coluna[3]);
		        estagiario.setDtAdmissao(coluna[5]);
		        estagiario.setDtTerminoCurso(coluna[6]);
		        estagiario.setDtTerminoContrato(coluna[7]);
		        estagiario.setRecesso(coluna[8]);
		        estagiario.setDtDesligEfetivRenov(coluna[9]);
		        estagiario.setPotencial(coluna[10]);
		        estagiario.setParticularidade(coluna[11]);
		        estagiario.setObs(coluna[12]);

		        SituacaoAtual situ = new SituacaoAtual();

		        IntStream situacaoId = situacaoAtualMap.entrySet()
		        								 .stream()
		        								 .filter(x -> x.getValue().equals(coluna[4]))
		        								 .mapToInt(x -> x.getKey());

		        situ.setId(situacaoId.findFirst().getAsInt());

		        estagiario.setSituacaoAtual(situ);
		        
		        estagRepository.save(estagiario);
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
		
		
		
//		try {
//			File arquivoEstags = resource.getFile();
//
//			try(InputStream inp = new FileInputStream(arquivoEstags)) {
//				
//				Workbook wb = WorkbookFactory.create(arquivoEstags);
//				Sheet sheet = wb.getSheetAt(0);
//				
//				//sheet.removeRow(sheet.getRow(0));
//				
//				System.out.println("inicializando carga");
//				
//				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//				
//				sheet.forEach(row -> {
//					
//					Estagiario estagiario = new Estagiario();
//					
//			        estagiario.setPendencias(row.getCell(0).getStringCellValue());
//			        estagiario.setCliente(row.getCell(1).getStringCellValue());
//			        estagiario.setContratoOk(row.getCell(2, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL) != null ? row.getCell(2).getLocalDateTimeCellValue().format(formatter).toString() : "");
//			        estagiario.setNome(row.getCell(3).getStringCellValue());
//			        estagiario.setDtAdmissao(row.getCell(5, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL) != null ? row.getCell(5).getLocalDateTimeCellValue().format(formatter).toString() : "");
//			        estagiario.setDtTerminoCurso(row.getCell(6, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL) != null ? row.getCell(6).getLocalDateTimeCellValue().format(formatter).toString() : "");
//			        estagiario.setDtTerminoContrato(row.getCell(7, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL) != null ? row.getCell(7).getLocalDateTimeCellValue().format(formatter).toString() : "");
//			        estagiario.setRecesso(row.getCell(8).getCellType() == CellType.STRING ? row.getCell(8).getStringCellValue() : String.valueOf(row.getCell(8).getNumericCellValue()));
//			        estagiario.setDtDesligEfetivRenov(row.getCell(9, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL) != null ? row.getCell(9).getLocalDateTimeCellValue().format(formatter).toString() : "");
//			        estagiario.setPotencial(row.getCell(10).getCellType() == CellType.STRING ? row.getCell(10).getStringCellValue() : String.valueOf(row.getCell(10).getNumericCellValue()));
//			        estagiario.setParticularidade(row.getCell(11).getStringCellValue());
//			        estagiario.setObs(row.getCell(12).getCellType() == CellType.STRING ? row.getCell(12).getStringCellValue() : String.valueOf(row.getCell(12).getNumericCellValue()));
//	
//			        SituacaoAtual situ = new SituacaoAtual();
//	
//			        IntStream situacaoId = situacaoAtualMap.entrySet()
//			        								 .stream()
//			        								 .filter(x -> x.getValue().equals(row.getCell(4).getStringCellValue()))
//			        								 .mapToInt(x -> x.getKey());
//	
//			        situ.setId(situacaoId.findFirst().getAsInt());
//	
//			        estagiario.setSituacaoAtual(situ);
//			        
//			        estagRepository.save(estagiario);
//				});
//			}
//			
//			return true;
//		} catch (IOException e) {
//			return false;
//		}
		
		
	}

}
