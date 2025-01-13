package utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Part;

public class UploadUtils {
	public static List<String> uploadImg(Collection<Part> files, String dest) {
		List<String> result = new ArrayList<String>();
		for (Part part : files) {
			try {
				InputStream fileContent = part.getInputStream();
				String uniqueFileName = UUID.randomUUID().toString() + ".jpg";
				File file = new File(dest + "/" + uniqueFileName);
				Files.copy(fileContent, file.toPath());
				result.add(file.getAbsolutePath());
				fileContent.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
