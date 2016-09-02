package jscherer.textconvertor;

import org.apache.commons.lang3.StringEscapeUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UnicodeFileToHtmlTextConverter {
	private String fullFilenameWithPath;
	private BufferedReader reader;

	public UnicodeFileToHtmlTextConverter(String fullFilenameWithPath) {
		this.fullFilenameWithPath = fullFilenameWithPath;
	}

	public UnicodeFileToHtmlTextConverter(BufferedReader reader) {
		this.reader = reader;
	}

	public String convertToHtml() throws IOException {

		if (reader == null) {
			reader = new BufferedReader(new FileReader(fullFilenameWithPath));
		}

		String line = reader.readLine();
		String html = "";
		while (line != null) {
			/*
			 * Escapes the characters in a String using HTML entities. For example:
			 * "bread" & "butter" becomes: &quot;bread&quot; &amp; &quot;butter&quot;.
			 */
			html += StringEscapeUtils.escapeHtml4(line);
			html += "<br />";
//			System.out.println(html);
			line = reader.readLine();
		}
		return html;
	}
}
