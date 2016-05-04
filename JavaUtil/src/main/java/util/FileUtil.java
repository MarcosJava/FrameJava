package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {

	/***
	 * Move o arquivo de uma pasta para outra pasta.
	 * @param srcPath
	 * @param dstPath
	 * @throws IOException
	 */
	public void moveFile(String srcPath, String dstPath) throws IOException {

		InputStream inStream = null;
		OutputStream outStream = null;
		try {
			File afile = new File(srcPath);
			File bfile = new File(dstPath);
			if(!afile.exists() && !bfile.exists()){
				throw new IOException("Arquivo não existe");
			}
			
			inStream = new FileInputStream(afile);
			outStream = new FileOutputStream(bfile);

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = inStream.read(buffer)) > 0) {
				outStream.write(buffer, 0, length);
			}
			inStream.close();
			outStream.close();

			// delete the original file
			afile.delete();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
