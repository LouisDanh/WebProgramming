package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Part;

public class UploadUtils {
	public static List<String> uploadImg(Collection<Part> files, String dest) {
		List<String> result = new ArrayList<String>();
		for (Part part : files) {
			String uniqueFileName = UUID.randomUUID().toString() + ".jpg";
			File file = new File(dest + "\\" + uniqueFileName);
			try {
				part.write(file.getAbsolutePath());
				result.add(file.getAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
