package com.task.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.task.domain.AttachFile;
import com.task.dto.AttachFileDTO;
import com.task.repository.AttachFileRepository;

@Service
public class AttachFileService {
	
	private final AttachFileRepository attachFileRepository;

	public AttachFileService(AttachFileRepository attachFileRepository) {
		this.attachFileRepository = attachFileRepository;
	}
	
	@Transactional
	public Long save(MultipartHttpServletRequest multipartRequest, Long attachID, String flag) {
		
		Long attachFileId = (long) 0;
		final Map<String, MultipartFile> files = multipartRequest.getFileMap();
		File f = new File("upload");

		String uploadPath = f.getAbsoluteFile().toString();
		if (!files.isEmpty()) {
			// 첨부된 파일 개수 체크
			int chkCnt = 0;
			for (Map.Entry<String, MultipartFile> entry : files.entrySet()) {
				chkCnt++;
			}
			
			if(chkCnt > 0){
				String filePath = "", fullFilePath = "";
				filePath = getPath(uploadPath, flag);
				fullFilePath = uploadPath + filePath;

				if (attachID.equals((long)0)) {
					// 첫 데이터인 경우 attachFileId = 1로 지정
					attachFileId = attachFileRepository.count()==0?(long)1:attachFileRepository.maxAttachFileId();
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
					String aliasName = UUID.randomUUID().toString().replaceAll("-", "") + i;

					try {	
						file.transferTo(new File(fullFilePath + File.separator + aliasName));
	
						fileDto = new AttachFileDTO();
						fileDto.setAttachFileId(attachFileId);
						fileDto.setOriginalName(originalName);
						fileDto.setAliasName(aliasName);
						fileDto.setFileExt(fileExt);
						fileDto.setFilePath(filePath);					
						
						attachFileRepository.save(fileDto.toEntity());
					} catch (IOException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return attachFileId;
	}	
	
	// 파일 업로드 경로 생성
	public static String getPath(String path1, String path2) {
		Calendar oCalendar = Calendar.getInstance();
		String tempFilePath = File.separator + path2 + File.separator + oCalendar.get(Calendar.YEAR) + File.separator
				+ (oCalendar.get(Calendar.MONTH) + 1) + File.separator + oCalendar.get(Calendar.DAY_OF_MONTH);
		String filePath = tempFilePath.replace("\\", "/");
		String fullFilePath = path1 + filePath;
		File targetDir = new File(fullFilePath);
		
		if (!targetDir.exists()) {
			if (targetDir.mkdirs()) {				
				return filePath;
			} 
		}
		return filePath;
	}
	
	@Transactional
	public List<AttachFileDTO> fileList(Long attachId) {
		List<AttachFile> fileList = attachFileRepository.findAllByAttachFileId(attachId);
		
		List<AttachFileDTO> fileDtoList = new ArrayList<AttachFileDTO>();
		
		for(AttachFile file : fileList) {
			AttachFileDTO fileDto = AttachFileDTO.builder()
					.id(file.getId())
					.attachFileId(file.getAttachFileId())
					.originalName(file.getOriginalName())
					.aliasName(file.getAliasName())
					.filePath(file.getFilePath())
					.fileExt(file.getFileExt())
					.build();
			
			fileDtoList.add(fileDto);
		}
		
		return fileDtoList;
	}
	
	@Transactional
	public AttachFileDTO getFile(Long id, Long attachFileId) {
		AttachFile file = attachFileRepository.findByIdAndAttachFileId(id, attachFileId);
		
		AttachFileDTO fileDto = AttachFileDTO.builder()
				.id(file.getId())
				.attachFileId(file.getAttachFileId())
				.originalName(file.getOriginalName())
				.aliasName(file.getAliasName())
				.filePath(file.getFilePath())
				.fileExt(file.getFileExt())
				.build();
		
		return fileDto;
	}
	
	@Transactional
	public Map<String, String> fileDelete(AttachFileDTO fileDto) {
		
		Map<String, String> resultMap = new HashMap<String, String>();
		File file = new File("upload");		
		String uploadPath = file.getAbsoluteFile().toString();
		
		file = new File(uploadPath+fileDto.getFilePath()+File.separator+fileDto.getAliasName());
		
		if(file.exists()) {
			boolean fileDelete = file.delete();
			if(fileDelete) {
				attachFileRepository.deleteById(fileDto.getId());
				resultMap.put("message", "파일이 삭제되었습니다.");
				resultMap.put("deleteResult", "true");
			} else {
				resultMap.put("message", "파일삭제 실패하였습니다.");
				resultMap.put("deleteResult", "false");
			}
		} else {	
			resultMap.put("message", "파일이 존재하지 않습니다.");
			resultMap.put("deleteResult", "false");
		}
		
		return resultMap;
	}
}
