package util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.StringWriter;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


/***
 * Classe de Utilidade a ser usada para transformar o objeto em XML e vice-versa.
 * Retrição para utilizar apenas em objetos que utilizar a annotation do 
 * JAX-WS ou JAX-RS.
 * @author marcos.pinto
 *
 */
@SuppressWarnings("restriction")
public class XMLUtil  {

	private String path;
	
	public XMLUtil(String path) {
		this.path = path;
	}

	
	/***
	 * Cria um arquivo caso queira salvar em algum lugar
	 * @param object = new Object();
	 * @param clazz = Object.class
	 * @return
	 */
	public <T> boolean createXMLToFile(Object object, Class<T> clazz) {
		try {
			JAXBContext context = JAXBContext.newInstance(clazz);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(object, new File(path));
			File file = new File(path);
			if (file.exists()) {
				return true;
			}
			return false;

		} catch (JAXBException e) {
			e.printStackTrace();
			return false;
		}

	}
	
	
	/***
	 * Cria um XML caso queira o objeto String, passando um Objecto e o seu .class
	 * @param object 
	 * @param clazz 
	 * @return
	 */
	public <T> String createXMLToString(Object object, Class<T> clazz) {
		try {
			JAXBContext context = JAXBContext.newInstance(clazz);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			java.io.StringWriter sw = new StringWriter();
		    marshaller.marshal(object, sw);
		    System.out.println(sw.toString());
		    return sw.toString();

		} catch (JAXBException e) {
			e.printStackTrace();
			return "";
		}

	}
	
	/***
	 * Retorna o XML em Byte caso queira salvar em algum tipo de base de dados
	 * como BLOB ou CLOB, passando o objeto e o seu .class
	 * @param object
	 * @param clazz
	 * @return
	 */
	public <T> byte[] createXMLToByte(Object object, Class<T> clazz) {
		try {
			JAXBContext context = JAXBContext.newInstance(clazz);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			marshaller.marshal(object, new File(path));

			byte[] xmlInByte = os.toByteArray();
			System.out.println(xmlInByte);

			
			return xmlInByte;

		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}

	}

}
