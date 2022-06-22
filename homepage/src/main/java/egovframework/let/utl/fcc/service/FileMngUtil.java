package egovframework.let.utl.fcc.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import egovframework.com.cmm.service.FileVO;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.fdl.property.EgovPropertyService;


//첨부파일 업로드

@Component("fileMngUtil")
public class FileMngUtil {

	public static final int BUFF_SIZE = 2048;

	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;

	@Resource(name = "egovFileIdGnrService")
	private EgovIdGnrService idgenService;

	// 첨부파일에 대한 목록 정보를 취득한다

	public List<FileVO> parseFileInf(Map<String, MultipartFile> files, String KeyStr, int fileKeyParam,
			String atchFileId, String storePath) throws Exception {
//		atchFileId: 있으면 수정 없으면 등록 /storePath: 저장경로

		int fileKey = fileKeyParam;

		// 파일저장경로
		String storePathString = "";
		// 첨부파일ID
		String atchFileIdString = "";

		// 파일 저장경로 여부
		if ("".equals(storePath) || storePath == null) {
			storePathString = propertyService.getString("Globals.fileStorePath");
		} else {
			storePathString = propertyService.getString(storePath);
		}

		// 첨부파일 ID 생성 및 업데이트 여부
		if ("".equals(atchFileId) || atchFileId == null) {
			atchFileIdString = idgenService.getNextStringId();
		} else {
			atchFileIdString = atchFileId;
		}

		// 폴더경로 설정
		File saveFolder = new File(storePathString); //java.io
		if (!saveFolder.exists() || saveFolder.isFile()) {
			saveFolder.mkdirs();	//mkdirs를 이용하여 폴더 생성하는 명령어
		}

		// 파일변수 iterator, entry = java.util
		Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator(); //첨부파일 순환
		MultipartFile file;
		String filePath = "";
		List<FileVO> result = new ArrayList<FileVO>();
		FileVO fvo;

		while (itr.hasNext()) {

			Entry<String, MultipartFile> entry = itr.next();

			file = entry.getValue();	//해당 file 받아옴
			String orginFileName = file.getOriginalFilename(); //원본파일명을 string으로 받아와서 저장함

			// -----------------------------------------
			// 원 파일명이 없는 경우 처리
			// (첨부가 되지 않은 input file type)
			// -----------------------------------------

			if ("".equals(orginFileName)) {
				continue;
			}
				// ------------------------------------------

				// 파일확장자 체크
				int index = orginFileName.lastIndexOf("."); //가장 마지막에 있는 "."을 찾는, 그 뒤에 있는 확장자 세글자를 가지고 오는 로직
				String fileExt = orginFileName.substring(index + 1);

				// 저장파일명(원본파일명과는 별개임)
				String newName = KeyStr + EgovStringUtil.getTimeStamp() + fileKey;

				// 파일사이즈
				long size = file.getSize();

				// 파일저장
				if (!"".equals(orginFileName)) {
					filePath = storePathString + File.separator + newName;	//File.separator: 폴더를 구분해주는 추가적인 값
					file.transferTo(new File(filePath));	//해당 파일 path에 저장
				}
				
				//저장값 set
				fvo = new FileVO();
				fvo.setFileExtsn(fileExt);
				fvo.setFileStreCours(storePathString);
				fvo.setFileMg(Long.toString(size));
				fvo.setOrignlFileNm(orginFileName);
				fvo.setStreFileNm(newName);
				fvo.setAtchFileId(atchFileIdString);
				fvo.setFileSn(String.valueOf(fileKey));

				result.add(fvo);

				fileKey++;
			}

			return result;
		}
	}
