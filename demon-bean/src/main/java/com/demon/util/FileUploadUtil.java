package com.demon.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

/**   
* <p></p>
* @author junbiao.wang
*/
public class FileUploadUtil {
	
	static String filePath = "D:\\file\\";//上传路径
	
	/**
	 * 单文件上传
	 * @param file
	 * @return 
	 */
	public static String fileSingleUpload (MultipartFile file) {
		if (!file.isEmpty()) {  
            try {  
    			String originalFilename = file.getOriginalFilename();//上传文件原始名称
    			String newFileName = System.currentTimeMillis() +originalFilename.substring(originalFilename.lastIndexOf("."));//新文件名称
            	
                byte[] bytes = file.getBytes();  
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath + newFileName)));  
                stream.write(bytes);  
                stream.close(); 
                
                return newFileName;  
            } catch (Exception e) {  
                return "上传失败 => " + e.getMessage();  
            }  
        } else {  
            return "上传失败，文件为空！";  
        }  
	}

}
