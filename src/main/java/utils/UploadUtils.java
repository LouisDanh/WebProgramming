package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.Part;

public class UploadUtils {
	public static List<String> uploadImg(Collection<Part> files, String uploadPath) {
		List<String> fileNames = new ArrayList<>();
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}

		for (Part part : files) {
			String fileName = getFileName(part);
			if (part.getContentType() != null && part.getContentType().startsWith("image/") && fileName != null
					&& !fileName.isEmpty()) {
				String fileExtension = fileName.substring(fileName.lastIndexOf("."));
				String uniqueFileName = UUID.randomUUID().toString() + fileExtension;
				try {
					part.write(uploadPath + File.separator + uniqueFileName);
					String relativePath = "/resources/static/img/products/" + uniqueFileName;
					fileNames.add(relativePath);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return fileNames;
	}

	private static String getFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] tokens = contentDisp.split(";");
		for (String token : tokens) {
			if (token.trim().startsWith("filename")) {
				return token.substring(token.indexOf("=") + 2, token.length() - 1);
			}
		}
		return null;
	}
}