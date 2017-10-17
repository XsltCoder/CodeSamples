package jdbcconnection;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XmlReader {
	
	private static String xmlInputFileName="test.xml";
	private static String XsltBeginning="<xsl:stylesheet version='1.0' xmlns:xsl='http://www.w3.org/1999/XSL/Transform'>";
	
	private static String XsltPartOmitXmlDeclaration="<xsl:output method='text' indent='yes' omit-xml-declaration='yes'/>";
	private static String XsltPart2="<xsl:template match='/'><xsl:value-of select='";
	private static String XsltPart3="'/></xsl:template></xsl:stylesheet>";
	

	public static void main(String[] args) throws Exception {
		transformXml("InvestmentVehicle/Operation/InvestmentVehicleName");
	}
	
	public static void transformXml(String xmlPath) throws Exception{
		String xsltFinal = XsltBeginning+XsltPartOmitXmlDeclaration+XsltPart2+xmlPath+XsltPart3;
		Source xmlSource=new StreamSource(xmlInputFileName);
		Source xsltSource=new StreamSource(new StringReader(xsltFinal));
		
//		System.out.println(xsltFinal);
		
		TransformerFactory transFact=TransformerFactory.newInstance();
		
		Transformer trans=transFact.newTransformer(xsltSource);
		
		StringWriter writer =new StringWriter();
		
		
		trans.transform(xmlSource, new StreamResult(writer));
		
		String output=writer.toString();
		
		System.out.println("output is:"+output);
		
		
		
		
		
	}
	
}
