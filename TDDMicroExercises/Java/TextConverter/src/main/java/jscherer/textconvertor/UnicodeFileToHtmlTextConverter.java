package jscherer.textconvertor;

import org.apache.commons.lang3.StringEscapeUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class UnicodeFileToHtmlTextConverter {

	BufferedReader bufferedReader = null;

	public UnicodeFileToHtmlTextConverter(String fullFilenameWithPath) throws FileNotFoundException {
		this(new BufferedReader(new FileReader(fullFilenameWithPath)));
	}

	/**
	 * Injected not to violate OCP and DIP
	 * 
	 * @param reader
	 */
	public UnicodeFileToHtmlTextConverter(Reader reader) {
		bufferedReader = new BufferedReader(reader);
	}

	public String convertToHtml() throws IOException {
		String line = bufferedReader.readLine();
		String html = "";
		while (line != null) {
			/*
			 * Escapes the characters in a String using HTML entities. For
			 * example: "bread" & "butter" becomes: &quot;bread&quot; &amp;
			 * &quot;butter&quot;.
			 * 
			 * Maybe this should be abstracted (as HtmlUtils) and injected to
			 * not violate OCP and DIP?
			 */
			html += StringEscapeUtils.escapeHtml4(line);
			html += "<br />";
			System.out.println(html);
			line = bufferedReader.readLine();
		}
		return html;
	}
}
