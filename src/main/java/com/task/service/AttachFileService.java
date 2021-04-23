package com.task.service;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.task.dto.AttachFileDTO;
import com.task.repository.AttachFileRepository;

@Service
public class AttachFileService {
	
	private final AttachFileRepository attachFileRepository;

	public AttachFileService(AttachFileRepository attachFileRepository) {
		this.attachFileRepository = attachFileRepository;
	}
	
	@Transactional
	public String save(MultipartHttpServletRequest multipartRequest, String attachID, String flag) throws Exception {
		
		String attachFileId = "";
		final Map<String, MultipartFile> files = multipartRequest.getFileMap();
		File f = new File("upload");
		
		String uploadPath = f.getAbsoluteFile().toString();

		if (!files.isEmpty()) {
			// 첨부된 파일 개수 체크
			int chkCnt = 0;
			for (Map.Entry<String, MultipartFile> entry : files.entrySet()) {
				String originalName = entry.getValue().getOriginalFilename();
				if (originalName.equals("")) { continue; }
				chkCnt++;
			}
			
			if(chkCnt > 0){
				String filePath = "", fullFilePath = "";
				filePath = getPath(uploadPath, flag);
				fullFilePath = uploadPath + filePath;

				if (attachID.equals("0")) {
					attachFileId = attachFileRepository.maxAttachFileId();
				}else{
					attachFileId = attachID;
				}
				
				int i = 0;
				AttachFileDTO fileDto;
				MultipartFile file;
				for (Map.Entry<String, MultipartFile> entry : files.entrySet()) {
					i = i + 1;
					file = entry.getValue();
					String originalName = file.getOriginalFilename();

					if (originalName.equals("")) {
						continue;
					}

					int index = originalName.lastIndexOf(".");
					String fileExt = originalName.substring(index + 1);
					String aliasName = "1111" + "_" + i;

					file.transferTo(new File(fullFilePath + File.separator + aliasName));

					fileDto = new AttachFileDTO();
					fileDto.setAttachFileId(attachFileId);
					fileDto.setOriginalName(originalName);
					fileDto.setAliasName(aliasName);
					fileDto.setFileExt(fileExt);
					fileDto.setFilePath(filePath);					
					
					attachFileRepository.save(fileDto.toEntity());
				}
			}
		}
		
		return attachFileId;
	}	
	
	// 파일 업로드 경로 생성
	public static String getPath(String path1, String path2) throws Exception {
		Calendar oCalendar = Calendar.getInstance();
		String tempFilePath = File.separator + path2 + File.separator + oCalendar.get(Calendar.YEAR) + File.separator
				+ (oCalendar.get(Calendar.MONTH) + 1) + File.separator + oCalendar.get(Calendar.DAY_OF_MONTH);
		String filePath = tempFilePath.replace("\\", "/");
		String fullFilePath = path1 + filePath;
		File targetDir = new File(fullFilePath);
		
		if (!targetDir.exists()) {
			if (targetDir.mkdirs()) {				
				return filePath;
			} else {
				throw new Exception("업로드 디렉토리 생성 실패! \n 업로드 경로 : " + fullFilePath);
			}
		}
		return filePath;
	}
	
}
