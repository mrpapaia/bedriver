package br.com.bedriver.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
@ManagedBean(name = "clienteWS")
@RequestScoped
public class ClientWS {
	private static final Logger logger = LogManager.getLogger(ClientWS.class);
	private List<Historico> historico;
	private Date dataI;
	private Date dataF;
	private String email;
	public  void buscaHist() {
		String datainicio ="";
		String datafim="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
		try {
						
			datainicio = sdf.format(dataI);
			datafim = sdf.format(dataF);
		}catch (Exception e) {
			
			if(dataI==null&&dataF==null) {
				datainicio = null;
				 datafim = null;
				 logger.info("Data de inicio e fim não informados, a busca retorna todos os dados");
			}else if(dataI==null) {
				logger.info("Data de inicio  não informada, a busca retorna todos os dados ate a data final");
				datainicio = null;
				datafim = sdf.format(dataF);
			}
			else if(dataF==null) {
				logger.info("Data de final  não informada, a busca retorna todos os dados aparti da data inicial");
				datainicio = sdf.format(dataI);
				datafim = null;
			}
		}
		
		
		try {
			
			
			// Create SOAP Connection
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();

			// Send SOAP Message to SOAP Server
			String url = "http://localhost:8080/bedriver/webservice/bedriverWS";
			String soapMessage = "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:web='http://webservice.bedriver.com.br/'>"
					+ "<soapenv:Header/>" + " <soapenv:Body>" + "   <web:listaNotas>" + "     <!--Optional:-->"
					+ "    <email>" + email + "</email>" + "    <!--Optional:-->" + "    <de>" + datainicio + "</de>"
					+ "    <!--Optional:-->" + "     <ate>" + datafim + "</ate>" + "  </web:listaNotas>" + "</soapenv:Body>"
					+ " </soapenv:Envelope>";

			SOAPMessage soapResponse = soapConnection.call(getSoapMessageFromString(soapMessage), url);
		

			JAXBContext jaxbContext = JAXBContext.newInstance(Hist.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Hist hist = (Hist) jaxbUnmarshaller.unmarshal(soapResponse.getSOAPBody().extractContentAsDocument());
		
			
			soapConnection.close();
			this.historico=hist.getHistorico();
			logger.info("Requisição feita pelo via WS pelo ClienteWS");
			
		} catch (Exception e) {
			
			logger.error("Error occurred while sending SOAP Request to Server: "+ e.getMessage());
			
		}
	}

	private static SOAPMessage getSoapMessageFromString(String xml) throws SOAPException, IOException {
		MessageFactory factory = MessageFactory.newInstance();
		SOAPMessage message = factory.createMessage(new MimeHeaders(),
				new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF-8"))));
		return message;
	}

	/**
	 * Method used to print the SOAP Response
	 */
	private static void printSOAPResponse(SOAPMessage soapResponse) throws Exception {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		Source sourceContent = soapResponse.getSOAPPart().getContent();
		// System.out.print("\nResponse SOAP Message = ");
		StreamResult result = new StreamResult(System.out);
		transformer.transform(sourceContent, result);
	}

	public List<Historico> getHistorico() {		
		return historico;
	}

	public void setHistorico(List<Historico> historico) {
		this.historico = historico;
	}

	public Date getDataI() {
		
		return dataI;
	}

	public void setDataI(Date dataI) {
		this.dataI = dataI;
	}

	public Date getDataF() {
		
		return dataF;
	}

	public void setDataF(Date dataF) {
		this.dataF = dataF;
	}

	public String getEmail() {
		
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String dateFormat(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		return sdf.format(date);
		
	}
	

}