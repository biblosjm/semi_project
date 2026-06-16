package kr.co.iei.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Component
public class FileUtils {

    @Value("${cloudinary.cloud_name}")
    private String cloudName;

    @Value("${cloudinary.api_key}")
    private String apiKey;

    @Value("${cloudinary.api_secret}")
    private String apiSecret;

    private Cloudinary getCloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
            "cloud_name", cloudName,
            "api_key", apiKey,
            "api_secret", apiSecret,
            "secure", true
        ));
    }

	public String upload(String savepath, MultipartFile file) {
		try {
			// Extract folder name from the savepath to organize in Cloudinary
			String folderName = "default";
			if (savepath != null) {
				if (savepath.contains("editor")) folderName = "editor";
				else if (savepath.contains("member")) folderName = "member";
				else if (savepath.contains("tourItemImg")) folderName = "tourItemImg";
			}

			Map params = ObjectUtils.asMap(
				"folder", folderName,
				"resource_type", "auto"
			);

			Map uploadResult = getCloudinary().uploader().upload(file.getBytes(), params);
			return uploadResult.get("secure_url").toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void deleteFile(String savepath, String fileUrl) {
	    if (fileUrl == null || fileUrl.isEmpty()) {
	        return; // 파일명 없으면 종료
	    }
	    try {
			// fileUrl is full cloudinary url, e.g., https://res.cloudinary.com/.../editor/uuid.jpg
			// We need to extract the public_id, which is "folder/filename" without extension
			String publicId = extractPublicId(fileUrl);
			if (publicId != null) {
				getCloudinary().uploader().destroy(publicId, ObjectUtils.emptyMap());
				System.out.println("Cloudinary 파일 삭제 완료: " + publicId);
			}
		} catch (Exception e) {
			System.out.println("Cloudinary 파일 삭제 실패: " + fileUrl);
			e.printStackTrace();
		}
	}

	private String extractPublicId(String fileUrl) {
		try {
			// Example: https://res.cloudinary.com/diwyn70ji/image/upload/v12345/editor/filename.jpg
			String[] parts = fileUrl.split("/upload/");
			if (parts.length > 1) {
				String path = parts[1]; // "v12345/editor/filename.jpg"
				// Remove version if present (starts with 'v' and numbers)
				if (path.matches("^v\\d+/.*")) {
					path = path.replaceFirst("^v\\d+/", "");
				}
				// Remove extension
				int dotIndex = path.lastIndexOf(".");
				if (dotIndex != -1) {
					path = path.substring(0, dotIndex);
				}
				return path; // "editor/filename"
			}
		} catch (Exception e) {
			// Ignore parsing errors
		}
		return null;
	}
}
