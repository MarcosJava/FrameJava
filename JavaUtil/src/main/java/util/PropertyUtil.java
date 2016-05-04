package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/***
 * Classe de Utilidade de arquivos de configurações que necessitam de chave=valor,
 * arquivos como config.ini, resource.properties e outros.
 * @author marcos.pinto
 *
 */
public class PropertyUtil {

	
	private String path;
	
	/***
	 * Instancia do Singleton
	 */
	private static PropertyUtil instancePropertyUtil;	
	/***
	 * Contrutores privados Singleton
	 */
	private PropertyUtil() {
		
	}
	private PropertyUtil(String path) {
		this.path = path;
	}
	
	/***
	 * Instancia do Singleton
	 * @param path
	 * @return
	 */
	public static PropertyUtil getInstance(String path){
		
		if(instancePropertyUtil == null){
			instancePropertyUtil  = new PropertyUtil(path);
		}
		return instancePropertyUtil;
	}
	
	
	/***
	 * Recupera o arquivo
	 * @return
	 * @throws Exception
	 */
	public String getPath() throws Exception {		
		if(!isExist()){			
			throw new Exception("Não existe o arquivo de configuração");			
		}
		if(path != null){
			return path;
		}		
		throw new Exception("Error ao ler aquivo INI");		
	}
	
	
	/***
	 * Verifica se o arquivo existe
	 * @return
	 * @throws Exception
	 */
	public boolean isExist() throws Exception{
		if(path == null || path.isEmpty()){			
			throw new Exception("Path não configurado");			
		}
		File file =  new File(path);
		return file.exists(); 
	}
	
	
	/***
	 * Recupera o valor da propriedade do arquivo em String. 
	 * @param key
	 * @return
	 */
	public String getPropertyValue(String key){
		Properties config = new Properties();
		try {
			config.load(new FileInputStream(this.path));
			return config.getProperty(key);					
		} catch (IOException ex) {					
			ex.printStackTrace();
			return null;
		}
	}

	/***
	 * Recupera o valor da propriedade do arquivo em Inteiro 
	 * @param key
	 * @return
	 * @throws NumberFormatException
	 */
	public int getPropertyInt(String key) throws NumberFormatException {
		int retorno = 0;
		
		String propertyValue = getPropertyValue(key);
		if (propertyValue != null && !propertyValue.isEmpty()) {
			try {
				retorno = Integer.parseInt(propertyValue);
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Erro no arquivo: " + path + " da propriedade: " + propertyValue);
			}
			
		} 
		
		return retorno;
	}	
	
}
